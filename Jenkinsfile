pipeline {
   agent any

   stages {
      stage('Git checkout') {
         steps {
            git credentialsId: 'nitish_github', url: 'https://github.com/nitishv9/Selenium_TestNG_Framework'
         }
      }
      stage('Start Container') {
      	steps
			{
			script{
			
			    try{		        
			        bat "docker stop chrome_container"
			    } catch(error){
			        echo "Was not able to stop the chrome container, will continue."
			    } 
			    
			    try{
			        bat "docker rm chrome_container"
                }catch(error){
                    echo "Was not able to remove the chrome container, will continue."
                 }
			    
                bat "docker run -d --name chrome_container -p 4445:4444 selenium/standalone-chrome"
                echo "Chrome container started"
                
			}
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
