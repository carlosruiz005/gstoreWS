pipeline {

    agent any
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
                sh "mvn -Dmaven.test.failure.ignore=true clean install"
            }
        }

        stage('Test'){
            steps{
                sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class GstoreApplicationTests --reports-dir="reports"'
                junit 'src/reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                sh 'cd src/ ; java App' 
            }
        }
    }

}