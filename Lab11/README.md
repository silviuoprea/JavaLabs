Lab 11
[valid 2021-2022]
REST Services
Continue the application created at the previous lab integrating the following functionalities:

Implement REST services needed to comunicate with the social network data (CRUD).
The main specifications of the application are:

Compulsory (1p)

- [x] Create a Spring Boot project containing the REST services for comunicating with the database.
- [x] Create a REST controller containing methods for:
  obtaining the list of the persons, via a HTTP GET request.
  adding a new person, via a HTTP POST request.
  modifying the name of a person, via a HTTP PUT request.
  deleting a person, via a HTTP DELETE request.
- [x] Test your services using the browser and/or Postman.

Homework (2p)
- [] Create REST services for inserting and reading relationships.
- [] Create a service for determining the first k most popular persons in the network.
- [] Create a simple client application that invokes the services above, using the support offered by Spring Boot.
- [] Document your services using Swagger or a similar tool.
- [] (+1p) Secure your services using the HTTPS protocol and JSON Web Tokens


Bonus (2p+)

- [] Write a service that determines in linear time all persons who are so important to the social network such that, if one of them were eliminated, the network would become disconnected.
- [] Create a simple desktop application that sends multiple concurrent invocations to the service above, in order to determine how many API requests per minute your service can handle.
  You may also monitor other performance metrics, using your own implementation or Spring support.
