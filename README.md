# Spring Boot Microservices
This project is in fulfilment of my interview at the great IntelliSoft Kenya as a Software development intern.

I take pride to present my work. 😊

## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker run -p 8585:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.2 start-dev` to run the keycloak container on docker.
3. Open `http://localhost:8080` if it doesn't open automatically. Create a realm '''hosdocs-microservices-realm''' and add website '''http://localhost:4200''' to allow the microservices to be accessed from the React Frontend
4. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker

1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.

