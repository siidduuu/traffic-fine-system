pipeline {
    agent { label 'linux-agent' }

    tools {
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs() // Clear old data to prevent conflict
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Compiling code and running JUnit verification tests...'
                sh 'mvn clean package'
            }
        }
    }
    
    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'Success! Your executable file is ready under Build Artifacts.'
        }
        always {
            cleanWs() // Keeps your server disk space clean
        }
    }
}

