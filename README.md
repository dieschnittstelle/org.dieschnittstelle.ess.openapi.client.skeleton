# org.dieschnittstelle.ess.openapi.client.skeleton

This project can be used to generate client-side code for accessing
a web api that provides an OpenAPI description. Proceed as follows:

1. Access the description and place it as api.yaml in apispec. Alternatively, you may change the name of the yaml file in the &lt;inputSpec&gt; parameter in pom.xml
2. Run mvn clean install to generate and compile the client-side classes for accessing the api
3. Implement access to the api in AccessOpenAPIRestService  
