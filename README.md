# Microservices-Architecture


In this project i have implemented the flow of Microservices using Java And SpringBoot Framework. The Project demonstrates different Microservices and their use cases.
There are 7 different Microservices here:-

1. User Microservice
2. Department Microservice
3. Api-Gateway Microservice
4. Service-Registry Microservice
5. Hystrix Microservice
6. Config-Server Microservice
7. Zipkin Microservice

I have made use of the built-in Database H2 offered by SpringBoot for the User and Department Microservice.

The Department Microservice accepts two Requests

                            /departments
                            /{id}

where id is the primary Key for the Department Microservice Database.

I have made use of Lombok dependency in the the User and Department Microservice as it reduces boilerplate code for model/data objects as well as it generates getters and setters for the respective Objects automatically(@Data Annotation).

Similarly the User Microservice accepts two requests:-

                                  /users
                                  /{id}

where id is the primary Key for the User Microservice Database.

The User Microservice has a Wrapper class as it displays out the respective user with its departmentId. I have made use of a RestTemplate over here as it provides an abstraction for making RESTful HTTP requets.

The APi Gateway Microservice accepts the requests from the Internet and routes it to particular Microservice based on the request(User or Department).The Api-Gateway Microservice is Backed By the Circuit-Breaker(Hystrix),Hystrix watches for failing calls to that method, and, if failures build up to a threshold, Hystrix opens the circuit so that subsequent calls automatically fail.A fallback Method is Implemented on failure of User or Department Microservice in this.The Application.yml file is enabled with Hystrix Configurations and its Stream. The Filters take care for the Circuit-Breaker.

The Service-Registry Microservice is used for registring our Microservice to it.
It uses Eureka Server Dependency for registring the Microservices to it.
All other Microservices should have Eureka Client Dependency for registring itself to the Service-Registry Microservice.The service registry provides a management API and a query API. Service instances are registered with and deregistered from the service registry using the management API. The query API is used by system components to discover available service instances.

This Architecture resembles an example of Distributed System.In distributed system for externalising configuartion of our Microservices we make use of Cloud-Config Server Microservice.Spring Cloud Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content). The server is embeddable in a Spring Boot application, by using the @EnableConfigServer annotation.The Cloud-Config Server fetches the COnfiguration from the GitHub,as our application starts it looks for the configuration in application.yml, here the bootstrap.yml serves in loading the configuration from the GitHub and then applies it to the respective Microservice before it starts.

I have also Implemented a Tracing/Traking System for this Microservice Architecture.
I have made use of Sleuth anmd Zipkin provided By Spring-Cloud for enabling Tracing for the Microservices basically the User And Department Microservice.
By enabling Zipkin we get a span_id along with the trace_id for the particular Microservice, with the help of span_id with trace_id we can debug any problem related to User and Department Microservice.We can also have a log file where we can hold our trace_id and later use that for debugging.Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data.

Architecture:-

![alt-text](https://github.com/Abhishek010397/Microservices-Architecture/blob/main/Spring-Architecture.png)
