# location-api

The goal of this project is to create a simple API in order to create and retrieve Locations.

I have implemented 3 endpoints under the LocationController and reacheble through the path '/locations':

* using a POST Http method we can create a new location;

* using a GET Http method we can retrieve a list of locations using as a filter the locationType (STANDARD or PREMIUM);

* exposed at 'locations/search' using a GET Http method we can retrieve a list of locations filtered by locationType, two coordinate points (which represented together a rectangle aerea) and limit in order to obtain just a certain number of resources in response.

The application is runnable through the execution of the 'LocationAPITestApplication' class annotated with @SpringBootApplication.

In the file data.sql there are some inserts in order to create a first simple DB.

Under the directory src/test/resource there is a postman collection with some calls for testing purpose.




