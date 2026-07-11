pipeline {
    agent { label 'linux-agent' }
    tools {
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs() 
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
        // SUCCESS runs first, saving your file safely
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'Success! Your executable file is ready under Build Artifacts.'
        }
        // ALWAYS runs dead last, cleaning up the disk space afterwards
        always {
            cleanWs() 
        }
    }
}


