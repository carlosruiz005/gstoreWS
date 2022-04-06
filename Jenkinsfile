pipeline {

    agent any
    
    tools {
        maven 'DevOpsMaven'
    }

    stages {

        stage('Checkout Codebase'){
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

        stage('Build'){
            steps{
                sh "mvn clean test package"
                
            }
        }

        stage('Test'){
            steps{
                sh "mvn test"
            }
        }

        stage('Deploy'){
            steps{
                sh 'mvn install' 
            }
        }
    }

}