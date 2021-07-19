pipeline {
   agent any

   stages {
      stage('Git checkout') {
         steps {
            git credentialsId: 'nitish_github', url: 'https://github.com/nitishv9/Selenium_TestNG_Framework'
         }
      }
      stage('Run Test') {
         steps {
            bat 'mvn test'
         }
      }
   }
   post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
}
}
