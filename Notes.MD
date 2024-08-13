
Technical Decisions:
====================

	I decided not to use the recomended Helper Library in order to show skills: https://github.com/maartendekker1998/StarWarsAPI

    Generated code moved from /build/ dir to project structure for clarity purposes

	JavaDoc: not required
	
	Docs: Swagger 
	
	DDD: minimum automatically generated from specs, use case very simple. DTO pattern if merits.
	
	Hexagonal: Basic, no further requirements. Models->UseCases->Infrastructure/

    Resillience: Retry + CircuitBreaker will be implemented by resilience4j. Bulkhead if merits via replicas in Deployment

                 Rate limiter implmented in underlying SWAPI dev.

	Test: Only Unit (Junit+Mockito). For integration playwright.dev will be used if required

	Caches: internal in services (Use Case), not Redis required.

    HATEOAS: Not required
	
	Exceptions: wrapping all exceptions into meaningful domain exceptions. 
	
				Only one "Error" component returned in http response

     Cross-Origin Resource Sharing: added just in case


SWAPI:
======

	- https://swapi.dev/
	- Rate limiting is done via IP address and is currently limited to 10,000 API request per day
	- Schemas:  <URL>/api/<resource>/schema


Resources:
==========
		
	https://swapi.dev/api/people/{id}
	https://swapi.dev/api/people/2

	https://swapi.dev/api/planets/{id}
	https://swapi.dev/api/planets/3

	https://swapi.dev/api/starships/{id}
	https://swapi.dev/api/starships/9/

    "people": "https://swapi.dev/api/people/", 
    "planets": "https://swapi.dev/api/planets/", 
    "films": "https://swapi.dev/api/films/", 
    "species": "https://swapi.dev/api/species/", 
    "vehicles": "https://swapi.dev/api/vehicles/", 
    "starships": "https://swapi.dev/api/starships/"

    http://{host}:{port}/swapi-proxy/person-info?name=<search-string>
	http://{host}:{port}/swapi-proxy/person-info?name=Luke%20Skywalker


Models:
======

    Endpoint to get the schemas not available https://swapi.dev/api/<resource>/people/schema/
    
    Derived from endpoint responses and compared against: https://github.com/phalt/swapi/tree/master/resources/schemas 


Search:
=======

	https://swapi.dev/api/<resource>/?search=<search-string>

	







