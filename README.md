The project produces ear file which has got a 'jar' and a ejb componcents
- Interfaces are defines in 'spec' project and pom file produces a 'spec' jar
- EJB components are just the implemetation of spec annotated with EJB tags
- EJB application needs to define 'application.xml' and it should list the ejb components
- If the spec's are packaged in way that ejb components dont see them in an ear file, then ear will not be deployed in gf server.
- All the dependencies like spec and any 3rd prty jars should go in ear/lib folder
- Please carefully observe the server log for any errors


This example is run in the following environment

- JDK 1.7
- Apache Maven 3.0.5
- 3.1.2.2 (build 5)

