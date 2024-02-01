# Tournamen Wizard API
## Docker configuration
First of all we need to create the JAR file using maven. Go to the maven action menu and do a "clean" & "install" action. It will generate the JAR file with the artifactId on the "target" folder.  

### Commands

To create an image using the last generated JAR file use: ```docker build -t tournament-wizard-api .```  

Check if the image was created succesfully using: ```docker images```  

To run the container use: ```docker run -p 8000:8080 tournament-wizard-api```  
