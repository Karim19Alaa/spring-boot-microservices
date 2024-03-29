# spring-boot-microservices
In this project, multiple microservices communicate with each other to provide the backend services of a minimalistic/sample movie rating application similar to IMDB.

Base Code From: https://github.com/yigiterinc/spring-boot-microservices

## Technologies

- Spring Boot
- Spring Cloud Eureka (Service Discovery)
- Spring Cloud Hystrix (Dashboard, Circuit Breaker pattern, Bulkhead pattern)
- Spring io.grpc
- Mysql
- MongoDB
- ProtoBuf

## Summary

*  __MovieInfoService__ provides the movie info by sending requests to __TheMovieDB API__. 
* __RatingsDataService__ provides the user's ratings for movies.
* __MovieCatalogService__ acts as an accumulator that gets data from __RatingsDataService__ and __MovieInfoService__ to present it.
* __TrendingMoviesService__ provides movies with highest average rating.
* __DiscoveryServer__ is the Eureka server for service discovery.

![Microservices](https://github.com/Karim19Alaa/spring-boot-microservices/assets/89037036/3b204d0d-0f96-4f2c-afd8-889339447add)


## Running

1. Configure Mysql connection details in `application.properties` in __RatingsDataService__ and __TrendingMoviesService__.
2. Configure MongoDB connection details in `application.properties` in __MovieInfoService__.
3. You can run each project either using your IDE or *mvn spring-boot:run* starting from __DiscoveryServer__. Projects will run on the following endpoints:

* Discovery Server - http://localhost:8761
* Movie Catalog - http://localhost:8081/catalog/{userId}
* Movie Info - http://localhost:8082/movies/{movieId}
* Ratings Data - http://localhost:8083/ratings/{userId}
* Trending Movies - gRPC: 8085-8086
* Hystrix Dashboard - Go to http://localhost:8081/hystrix. Then enter *https://localhost:8081/actuator/hystrix.stream* to the inputbox.
