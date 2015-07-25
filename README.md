# Demo Foursquare Integration

# Dependencies (to run)
1. Java 8+
2. Maven

# How to run this project
To run this project you just need to execute this in the command line:
"mvn clean spring-boot:run"

This will run Spring boot's context and start an embedded application server to make possible to serve the web.
It's not necessary to deploy anything anywhere.

# Stack
1. Java 1.8
2. Spring Boot
3. Google Maps API
4. Bootstrap
5. AngularJS

# The Implementation
The application consists on an integration with Foursquare's REST API through a small server made in Java.

The website is an AngularJS single page application which connects to the server through AJAX, making all the requests without refreshing.

All the specific details and credentials to connect to 4sq API are in the application.properties file, easier to change.

The results are populated on a Google Maps view, and all the elements are clickable to display the name. Every time we search, the map will focus on the new results 
at the necessary zoom level.

Since the app is quite simple, there are only a few example of tests, covering all the cases of conversion and utilities developed for this matter.