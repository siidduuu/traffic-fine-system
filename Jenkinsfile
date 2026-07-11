pipeline {
    agent any

    tools {
        maven 'Maven' 
    }

    stages {
        stage('Checkout') {
            steps {
                cleanWs() // Cleans the workspace safely BEFORE the build starts
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
            // Saves your file directly to the Jenkins UI dashboard
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            echo 'Success! Your executable file is ready under Build Artifacts.'
        }
    }
}
