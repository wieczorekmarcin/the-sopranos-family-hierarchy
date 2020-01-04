# The Sopranos Family Hierarchy
Spring Boot app based on Neo4j Graph database

The project is based on the world of the Soprano Family :)
During database initialization, the entire database model is created, including information on Mafine Families, Gangsters, links between them and much more.

Within the framework of the project, simple CRUD operations are available, as well as more complex queries to extract information on e.g. the most brutal family :)

## Technologies
* Java 8
* Spring Boot 2
* Maven
* Neo4j with Bold driver

## Endpoints
### Person
* /api/persons, GET
* /api/persons/{id}, GET
* /api/persons, POST
* /api/persons/{id}, PUT
* /api/persons/rank/bestKillers, GET
* /api/persons/rank/bestVictims, GET
### Family
* /api/families, GET
* /api/families/{id}, GET
* /api/families, POST
* /api/families/{id}, PUT
* /api/families/rank/wars, GET
* /api/families/rank/mostBrutal, GET
* /api/families/rank/mostEffective, GET
### Main
* /api/deleteAll, POST

![graph](https://github.com/wieczorekmarcin/the-sopranos-family-hierarchy/tree/master/src/main/resources/static/images/graph.svg)
