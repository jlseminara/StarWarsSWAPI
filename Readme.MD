
Technical Notes
===============

	- Refere to Notes.MD file


Considerations
==============

    - https://swapi.co works no more, using clone https://swapi.dev

    - Data on https://swapi.dev is not the same as in https://swapi.co


Project
=======

    - building: gradlew clean build

    - fast build: (if model created previously) gradlew clean build -Pnoapibuild -x test 

    - running: gradlew bootRun

    - artifacts: <project_root>/build/lib

QA Reports
==========

        - build/reports/jacoco/test/html
		
		
		- if using SonarQube use:  build/jacoco/test.exec


API Documentation
=================

		Swagger UI: <host>:<port>/swagger-ui/
		
		Api Doc: <host>:<port>/docs/


Deployment
==========

    - Health: <host>:<port>/actuator/health

    - Docker: 
                docker build -t swapi-service .
                docker run -p 8080:8080 swapi-service

    - Upload image to repo:

                docker login
                docker build -t swapi-service:latest .
                docker tag swapi-service:latest <<REPO-NAME>>/swapi-service:latest
                docker push <<REPO-NAME>>/swapi-service:latest

    - Kubernetes:
	
                WARNING:    Only tested locally with https://rancherdesktop.io/ 
                            No namespace for deployment and changed port to 32000


                1) Modify manifesto to point to proper <<REPO-NAME>>
				
                2) kubectl apply -f deployment.yml

                4) Check status:    kubectl get deployment
                                    kubectl get pods

                3) Test:    curl -get localhost:32000/actuator/health
                            curl -get localhost:32000/swapi-proxy/person-info?name=han

                4) Release resources: kubectl delete -f deployment.yml


