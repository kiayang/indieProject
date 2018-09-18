Kia Yang individual Project

This repository will serve as an example for Madison College's Enterprise Java Class. 

### Problem Statement

For over 20 years, cross-country (XC) ski enthusiasts in the midwest have relied on [SkinnySki.com](https://www.skinnyski.com) as the go-to website for cross-country ski information. The site has information on XC ski races, training, tips and trails.  The trail data includes descriptions, location/driving directions, trail maps, trail type (skate versus classic) and conditions (rolled, tracked, skiied in). While most trail systems have their own websites with this type of information, SkinnySki's benefit is that all the trail information is located in one place.  Even better, users are encouraged to add their own trail reports which means SkinnySki.com tends to be the most current source of information.  

With the growing popularity of winter fat biking (riding bikes with 4.5" or larger tires in the snow), riders have found themselves in need of a site similar to SkinnySki.com to discover and share fat bike trails and conditions. Currently, trail information is found on various social media sites and web sites, or is simply shared in email among those "in the know". I'd like to build a Fat Bike Trail Reports website to serve as the SkinnySki.com for fat biking. 

Screenshots from SkinnySki.com:

![Trail Description](images/MirrorLakeTrailExample.png)

![Trail Report](images/MadisonAreaExample.png)


### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create trail, create trail report, edit data they have entered previously
  * All: anyone can view trail information (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the trails and reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * NOAA for weather conditions at a trail location, including snow depth
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* [Screen Design](DesignDocuments/Screens.md)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development Journal](Journal.md)