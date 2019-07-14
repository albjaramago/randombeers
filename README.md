# randombeers
Random Beer


Randombeers is a Spring boot application with MVC and JPA.
The application provides an endpoint to manage GET requests and return a Json response with the random beer data.
The application has been created with the MVC pattern including a RestController for GET requests, a Service interface and
its implementation to calculate random ids and a JPA repository for Beer and Brewery entities.
GET requests include a PathVariable param which is the last Beer id in order to not get repeated the same random beer in two 
consecutive requests.

The application includes:

-Unitary tests.
-Integration tests.
-Swagger documentation (http://localhost:8080/swagger-ui.html)
-Additional funcionality: not repeated random beer in two consecutive requests.


Below, the steps to run the application:

-Run mysql in localhost:3306
-Create a mysql database named as "randombeer"
-Execute the sql script which has been included in "randombeer\src\main\resources\randombeer_dumb.sql"
-Generate the .jar executing "maven install".
-Execute the generated .jarin tha appliation target folder as "java -jar randombeer-0.0.1-SNAPSHOT.jar"





