Project contains best practices of usage OOP and PageObject/PageFactory patterns for Java/WebDriver/TestNG project.
How to run tests from this project:
1.Install JDK 1.8 or above corresponding to your OS
2.Install Maven command line utility corresponding to your OS
3.Make sure that following command line commands mvn -version and java -version give you information on mvn and java installed in your OS. Otherwise go back to #1 and #2 and google for proper installation guides.
4.Clone repository with source code via Git
5.In command line to cd to project root folder
6.To run test from command line use following command:
mvn clean install -DTest=search-test.xml
 where search-test.xml is a name of specific TestNG xml file with tests.