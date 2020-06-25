pipeline {
    agent any

    stages {
        stage('Build Backend & SonarQube Report') {
            steps {
            script {
                scannerHome = tool 'SonarScanner';
            }
            withSonarQubeEnv('SonarQube-Server') {
            dir('dutchauction_backend'){
                bat 'mvn clean verify sonar:sonar'
                bat 'mvn install'
                    }
                }
            }
        }
        stage('Setup/Install Backend for Deployment') {
            steps{
            dir('dutchauction_backend'){
                    bat 'npm install'
                }
            }
        }
        stage('Setup/Install Frontend for Deployment') {
            steps{
            dir('dutchauction-vue'){
                    bat 'npm install'
                }
            }
        }
    }
}
