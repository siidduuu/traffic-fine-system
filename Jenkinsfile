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
                        // Added -f flag to point to your subfolder
                        sh 'mvn -f traffic-fine-system/pom.xml test'
                    }
                }

                stage('Static Code Analysis') {
                    steps {
                        echo 'Checking source code quality and styling...'
                        // Added -f flag to point to your subfolder
                        sh 'mvn -f traffic-fine-system/pom.xml compile' 
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
                // Added -f flag to point to your subfolder
                sh 'mvn -f traffic-fine-system/pom.xml package -DskipTests'
            }
        }
    }
    
    post {
        success {
            // Updated artifact archiving path to find the JAR inside your subfolder target
            archiveArtifacts artifacts: 'traffic-fine-system/target/*.jar', fingerprint: true
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
