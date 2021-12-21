# Mirea Renewal - Parsing Address part

## Description
Developing API Server of parsing Korean address into an object

## Technologies 
* Java 16
* Apache Maven 3.8.3
* JUnit
* Spring Boot
* REST
* JPA
* JDBC
* Mysql
* Regular expression
* docker

## Features
Clients rest call the server.
It takes an address as a whole phrase, parses it into each of the segments, and returns it to the client.

## Getting Started
mvn spring-boot:run

or

docker build -t dnbnsvr .

docker run --restart unless-stopped -d -p 8089:8089 --name dnbnsvr -t dnbnsvr

## Usage

![Alt text](relative/path/to/img.jpg?raw=true "Title")
cjs
