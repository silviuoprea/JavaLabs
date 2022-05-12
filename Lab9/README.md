# JavaLabs Lab 9
[valid 2021-2022]
Persistence
Continue the application from lab 8, creating an object-oriented model and using JPA (Java Persistence API) in order to communicate with the relational database.

The main specifications of the application are:

- [x] Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
  Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- [x] Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
- [x] Create a singleton responsible with the management of an EntityManagerFactory object.
- [x] Define repository clases for your entities (at least one). They must contain the following methods:
-  create - receives an entity and saves it into the database;
-  findById - returns an entity based on its primary key;
-  findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- [x] Test your application.

Homework (2p)
- [x] Create all entity classes and repositories. Implement properly the one-to-many relationships.
- [x] Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
- [x] Insert, using JPA, a large number of cities in the database and log the execution time of your JPQL queries.
- [] (+1p) Assume each city has a new property, its population. Use a constraint solver, such as Choco solver, OptaPlanner or ORTools, in order to find a set of cities having names that start with the same letter, the total sum of their population is between two given bounds and they are from different countries.


Bonus (2p+)

- [] Implement properly the many-to-many sisterhood relationship.
- [] Implement both the JDBC and JPA implementations and use an AbstractFactory in order to create the DAO objects (the repositories).
- [] The application will use JDBC or JPA depending on a parameter given in an initialization file.
- [] You may also use an IoC container in order to inject the DAO implementations.


