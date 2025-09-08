pipeline {
    agent any
    stages {
        stage('Checkout') { steps { echo 'Checkout code' } }
        stage('Build') { steps { sh 'mvn -B -DskipTests clean package' } }
        stage('Test') { steps { sh 'mvn -DskipTests=false test' } }
        stage('Archive') { steps { archiveArtifacts artifacts: 'reports/**', fingerprint: true } }
    }
}
