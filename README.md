# FetchRewards
## Problem Statement
Accept two strings and return a response indicating if the first string is before, after, or equal to the second string

###Expectation
Examples
1.0.0 is "before" 1.0.1
2.0 is "after" 1.0.0

###Assumptions
1) The input parameter "1.0" and "1.0.0" is considerd to be equal
2) The input parameter ".01" is considered to be invalid

###Approach
1) Created a Spring Boot MVC arhcitecture using Java as my technology language
2) Validation of input parameter is writter in a separate class
3) Comparing of two strings are handled in a separate file
4) In this appraoch I am using a pointer method to traverse input parameter till we get a dot(.) and calculate the value integer. If the received integer value is less than second string parameter then we return result

####Time complexity and Space complexity
The time complexity of the code on a avergae case runs till maximum length between 2 inputs and Memory Usage is 39 MB

#### Other implemention
We can also a use split method and traverse each charcater to check if first string is before, after or equal than second input

####Steps to run to on IDE
1) Insall IDE (preferrably [Eclipse](https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-developers))
2) Clone the repository using [http](https://github.com/ajaymohandas89/FetchRewards.git) or [ssh](git@github.com:ajaymohandas89/FetchRewards.git)
3) Open the spring project in the IDE
5) Run project as "Spring Boot App"

####Steps to run to on command line
1) Install maven ```https://maven.apache.org/download.cgi```
2) Open command line in windows or terminal on Ubuntu mvn clean install
3) Find .jar file on the target folder created after building the project in FetchRewards_Backend_SWE\target
4) Execute ```java -jar FetchRewards_Backend_SWE-0.0.1-SNAPSHOT.jar```

####Steps to run unit test cases
1) Run the project as JUnit test cases by right click and run as "JUnit test cases"
2) By command line use  ```mvn test```

