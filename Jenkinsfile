pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
            dir('dutchauction_backend'){
                bat 'mvn clean verify'
                }
            }
        }
    }
}
