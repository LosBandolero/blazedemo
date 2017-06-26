# blazedemo spring boot api 

This is simple API create with support of Spring Boot, Gradle and Java.

### To run application follow this steps:
 1. Install MySQL (if you have it already ignore this step)
 2. Create database BlazeDemo
 3. In file src/main/resources/application.yml fill in username and password with credentials of your DB
 4. Execute src/main/resources/add_tables.sql file to create tables with test data
 5. In command line cd to checkout repo and execute:
    
    5.1. *nix systems - ./gradlew build
   
    5.2. windows systems gradlew.bat build
 6. Execute from command line via java -jar build/libs/blaze-demo-api-1.0.jar command
 
 
### To run tests follow this steps:
 1. Open terminal
 2. Execute ./gradlew test (*nix systems) or gradlew.bat (windows systems)