# OrderNowApplication
*Small project about food delivery features - with Spring Boot + Spark Framework*

## Getting started

It is necessary to have docker installed on your OS.

### Instructions

This project has a connection with **Mysql** in a **Docker** image.
After cloning it, go to folder *..src/main/resources/docker/mysql* and run the following command to initialize the database:
* *docker-compose up*

To access the database, run the following command in another terminal window:
* *docker exec -it ordernow_mysql bash*

**Then**

* *mysql -u ordernow -p*

The password can be found at *docker-compose.yml*

### Run the application

To initialize the application, run the class *OrderNowApplication.java* as Java application

### Tools
* Spring Boot
* Spark Framework (for microservices)
* Docker
* Mysql
* JPA
* Hibernate
* Gson
* BCryptPasswordEncoder
* Authentication
* JUnit
* MockMvc

### Features (still developing...)
* Create costumer
* Create restaurant
* Find restaurant by id
* Find all products by id restaurant
* Create order
* Find all orders by id costumer
