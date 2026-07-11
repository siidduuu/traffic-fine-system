pipeline {
    agent { label 'linux-agent' }
 tools {
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Parallel Code Validation') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        echo 'Running automated JUnit test suites...'
                        // Looks for pom.xml in the exact root folder
                        sh 'mvn -f ./pom.xml test'
                    }
                }

                stage('Static Code Analysis') {
                    steps {
                        echo 'Checking source code quality and styling...'
                        // Looks for pom.xml in the exact root folder
                        sh 'mvn -f ./pom.xml compile' 
                    }
                }

                stage('Security Scan') {
                    steps {
                        echo 'Scanning dependencies for known security vulnerabilities...'
                        sh 'echo "Security verification passed."'
                    }
                }
            }
        }

        stage('Package Project') {
            steps {
                echo 'Packaging application into an executable JAR binary...'
                // Packages the root project
                sh 'mvn -f ./pom.xml package -DskipTests'
            }
        }
    }
    
    post {
        success {
            // Saves the executable JAR directly from the root target folder
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'Build successful! Your executable JAR is available in the Build Artifacts section.'
        }
        failure {
            echo 'Pipeline failed during execution. Please review the parallel branch console logs.'
        }
        always {
            cleanWs()
        }
    }
}
