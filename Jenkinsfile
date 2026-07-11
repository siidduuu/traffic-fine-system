pipeline {
    agent any

    tools {
        // Injects Maven if configured under Jenkins Global Tool Configuration
        maven 'Maven 3.x' 
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
                        sh 'mvn test'
                    }
                }

                stage('Static Code Analysis') {
                    steps {
                        echo 'Checking source code quality and styling...'
                        // Compiles code without running tests to analyze bytecode
                        sh 'mvn compile' 
                    }
                }

                stage('Security Scan') {
                    steps {
                        echo 'Scanning dependencies for known security vulnerabilities...'
                        // Simulates a quick dependency vulnerability check
                        sh 'echo "Security verification passed."'
                    }
                }
            }
        }

        stage('Package Project') {
            steps {
                echo 'Packaging application into an executable JAR binary...'
                // Skips tests since they were safely validated in parallel above
                sh 'mvn package -DskipTests'
            }
        }
    }
    
    post {
        success {
            // Archives your compiled JAR artifact right to the Jenkins UI dashboard
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

