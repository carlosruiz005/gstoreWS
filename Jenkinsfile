pipeline {

    agent any
    
    tools {
        maven 'DevOpsMaven'
    }

    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }

    stages {

        stage('Checkout git'){
            steps{
                cleanWs()
                checkout(
                    [
                        $class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extension: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [[credentialsId: 'personalgithub', url: 'https://github.com/carlosruiz005/gstoreWS.git']]
                    ]
                )
            }
        }

        stage('Pruebas unitarias'){
            steps{
                sh "mvn -Dmaven.test.skip=false -U clean test"
            }
        }

        stage('Build'){
            steps{
                sh "mvn clean package"
                
            }
        }

        stage('SonarQube'){
            steps{
                echo "Sonar"
            }
        }

        stage('Crear imagen'){
            steps{
                sh 'docker build -t springio/gs-spring-boot-docker .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Push') {
            steps {
                sh 'docker push springio/gs-spring-boot-docker'
            }
        }
    }

}