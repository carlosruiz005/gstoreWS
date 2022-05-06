pipeline {

    agent any
    
    tools {
        maven 'DevOpsMaven'
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
            echo "Creando la imagen docker... "
            dir('gstoreWS'){
                sh './mvnw spring-boot:build-image'
            }
        }
    }

}