Kia Yang individual Project

### Problem Statement

Our funerals are very costly due to religious belief and cultural rituals that have to be perform when a person dies. The cost averages about 30 to 40 thousand per funeral.  Due to this huge expense, the Yang Family have a funeral hardship contribution membership where the families who join in the contribution are required to contribute $15 person to help with funeral expenses. 

In the past keeping track of family members have been with a word document and with over 400 members it is a little bit hard to keep track of the members in the program.  We have to keep track of things like who died and who is still living as well has payments that have been made. Tallying up the contributions have always been done by hands and sending notifications to members are time consuming. On top of that members are located all over the states and keeping track of all members in the different states is hard and have to be done manually.

As a result I like to build a Family Hardship Contribution website to do the following:

1. Have family membership guidelines and rules online so everyone can have access to it in one place.  Updates and adjustment to the guidelines and rules are easier.
2. Adding or updating members can be achieved online and by the members or administrator
3. Easy reporting of member locations, status and updates

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create report, edit data they have entered previously
  * Must login or register 
* Database
  * MySQL
  * Store users and roles
  * Store all data for members and events
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
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
