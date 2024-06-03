# Eureka Service

## Problem Statement

Implement the Eureka service that will be used to register and discover services in the system. Register the User Service and Product Service with the Eureka service. Test if the load from Product Service is distributed among the instances of User Service.

## Requirements
#### Eureka Service
1. Refer the documentation: [Introduction to Spring Cloud Netflix – Eureka](https://www.baeldung.com/spring-cloud-netflix-eureka)
2. Add the `spring-cloud-starter-netflix-eureka-server` dependency in the pom.xml file.
3. Add the `@EnableEurekaServer` annotation in the main class to enable the Eureka server.
4. Add the required properties in the application.properties file to disable the Eureka Client as we are not going to register the Eureka Server itself with Eureka Server. Run the Eureka Server at port `8761`
5. To access Eureka Server dashboard : http://localhost:8761/

#### User Service
1. Add the `spring-cloud-starter-netflix-eureka-client` dependency in the pom.xml file.
2. Add the required properties in the application.properties file to register the User Service with Eureka Server, and provide the url of the Eureka Server.
3. Three different instances of the User Service should be running at port `4141`, `4142` and `4143`. Implement this using environment variables and running different configurations of the User Service for each port.
4. Create a sample GET API to get a sample user details by userId.

#### Product Service
1. Add the `spring-cloud-starter-netflix-eureka-client` dependency in the pom.xml file.
2. Add the required properties in the application.properties file to register the Product Service with Eureka Server, and provide the url of the Eureka Server.
3. Only one instance of the Product Service should be running at port `8181`
4. Create a sample GET API to validate the user by userId and get a sample product details by productId.
5. To validate the user, call the UserService API using the RestTemplate. Inorder to distribute the load to UserService instances annotate the RestTemplate with `@LoadBalanced`.
6. To test the load balancing, call the Product Service API multiple times and check the logs of the User Service instances to see if the requests are distributed among the instances of User Service.

#### API Gateway Service
1. Add the following dependencies in the pom.xml file:
   - `spring-cloud-starter-netflix-eureka-client` : To register the API Gateway Service with Eureka Server.
   - `spring-cloud-starter-gateway` : To create the API Gateway Service.
   - `spring-cloud-starter-loadbalancer` : To use the LoadBalancerClient.
2. Add the required properties in the application.properties file to register the API Gateway Service with Eureka Server, and provide the url of the Eureka Server. Run the API Gateway Service at port `5050`
3. Create a sample route to forward the request to the User Service. The route should be `/users/**` and should forward the request to the UserService instances in load balanced manner.
4. To test the load balancing, call the API Gateway Service API multiple times and check the logs of the User Service instances to see if the requests are distributed among the instances of User Service.
