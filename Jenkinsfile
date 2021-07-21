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
			        bat "docker stop firefox_container"
			    } catch(error){
			        echo "Was not able to stop the browser container, will continue."
			    } 
			    
			    try{
			        bat "docker rm chrome_container"
			        bat "docker rm firefox_container"
                }catch(error){
                    echo "Was not able to remove the browser container, will continue."
                 }
			    
                bat "docker run -d --name chrome_container -p 4445:4444 selenium/standalone-chrome"
                bat "docker run -d --name firefox_container -p 4446:4444 selenium/standalone-firefox"
                echo "Browser containers started"
                
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
