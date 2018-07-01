# OrderNowApplication
*App about food delivery - using microservices*

## Getting started

This app has a connection with mysql in a docker image: src/main/resources/docker/mysql
To start docker image, execute the follow command: 'docker-compose up' at the folder above
db user: ordernow
db passwd: ordernow

Tools
* Spring boot
* Mysql (docker)
* JPA
* Hibernate
* BCryptPasswordEncoder
* Authentication
* Gson

Microservices
* Create costumer
* Create restaurant
* Find restaurant by id
* Find all products by id restaurant
* Create order
* Find all orders by id costumer
