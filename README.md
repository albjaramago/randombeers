# randombeers
Random Beer


Randombeers is a Spring boot application with MVC and JPA.
The application provides an endpoint to manage GET requests and return a Json response with the random beer data.
The application has been created with the MVC pattern including a RestController for GET requests, a Service interface and
its implementation to calculate random ids and a JPA repository for Beer and Brewery entities.
GET requests include a PathVariable param which is the last Beer id in order to not get repeated the same random beer in two 
consecutive requests.

The application includes:

1-Unitary tests.
2-Integration tests.
3-Swagger documentation (http://localhost:8080/swagger-ui.html)
4-Additional functionality: not repeated random beer in two consecutive requests.


Below, the steps to run the application:

1-Run mysql in localhost:3306
2-Create a mysql database named as "randombeer"
3-Execute the sql script which has been included in "randombeer\src\main\resources\randombeer_dumb.sql"
4-Generate the .jar executing "maven install".
5-Execute the generated .jarin tha appliation target folder as "java -jar randombeer-0.0.1-SNAPSHOT.jar"





