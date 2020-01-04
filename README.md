# Crime Familes from the Sopranos and relationships between them.
## Spring Boot app based on Neo4j Graph database.

The main assumption of the project is to present a model of mafia families operating in the US in New Jersey.

The prototype of the main idea was to present the structure of the real (actual) structure of mafia families, but due to the lack of detailed materials on relationships between families, a detailed division of roles, activities, etc., I decided to present a model of the structure of fictitious families, using characters / events from TV series "Soprano Family".

### Reasons for choosing a graph database model:
* ease of understanding base semantics,
* extended possibilities of implementing relations between objects,
* easy transfer of "family trees" to graphs,
* visualization of data pleasant to the eye,
* focus on data extraction due to connections between nodes (in my project these are rankings),
* ease of adding new objects to others by REST-API,
* related objects, without affecting the existing data network,
* speed of data processing by analyzing associations, instead of performing "overlapping" data on itself.

### Database specific properties (advanced):
* implementation of REST-API in Java using the Bolt driver (1),
* Interface Record - extracting information from a single record (2),
* transactivity and session management (3),
* passing parameters (variables) to queries in order to transfer the limit of received data and sorting method (4).

Within the framework of the project, simple CRUD operations are available, as well as more complex queries to extract information on e.g. the most brutal family :)

### Technologies
* Java 8
* Spring Boot 2
* Maven
* Neo4j with Bold driver

## Endpoints
### Person
* /api/persons, GET (1)/(3)
* /api/persons/{id}, GET (1)/(3)
* /api/persons, POST (1)/(3)
* /api/persons/{id}, PUT (1)/(3)
* /api/persons/rank/bestKillers, GET (1)/(2)/(3)/(4)
* /api/persons/rank/bestVictims, GET (1)/(2)/(3)/(4)
### Family
* /api/families, GET (1)/(3)
* /api/families/{id}, GET (1)/(3)
* /api/families, POST (1)/(3)
* /api/families/{id}, PUT (1)/(3)
* /api/families/rank/wars, GET (1)/(2)/(3)
* /api/families/rank/mostBrutal, GET (1)/(2)/(3)
* /api/families/rank/mostEffective, GET (1)/(2)/(3)
### Main
* /api/deleteAll, POST (1)/(3)
## Relationships
* FAMILY_MEMBER, Person-FAMILY_MEMBER->FAMILY
* HAS_POSITION, Person-HAS_POSITION->POSITION (Founter/Boss/Underboss/Consigliere/Caporegime/Soldier/Associate)
* IS, Person-IS->STATUS                       (At large, In prison, Dead)
* KILLED_BY, Person-KILLED_BY->Person
* ALLIANCE_WITH, Family-ALLIANCE_WITH->Family

![graph](/../master/src/main/resources/static/images/graph.png?raw=true "graph")
