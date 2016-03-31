<h1> Objected Oriented Analysis and Design Project </h1>
<h2> Checkers Palooza! </h2>


<h3> Alex Tzinov - Jacob Brauchler - Kyle Wiese </h3>



<h3> Code Organization </h3> 
We used <b> Maven </b> as our build tool as well as a basis for code organization. Unlike similar tools such as <b>ant</b>, Maven enforces a rigid code structure which helped enforce a consistent organization across all 3 team members

<h4> /src/ </h4>
This directory is divided into <b>/main</b> and a <b>/test</b> where main contains all of our project source code and test contains test suites written with <b> JUnit</b>.  

<h4> pom.xml (Project Object Model) </h4>
This is the vital file for any maven project. It contains information about the project and configuration details used by Maven to build the project. While we are keeping this project IDE-independent, meaning we are not containing any Eclipse/IntelliJ config files in the repo, we have enforced that the project gets built using Maven, meaning we MUST include this pom.xml file

<h3> Useful Tasks (Command Line) </h3>

<h4> To clean project </h4>

Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```mvn clean```</b>
This will remove the <b>/target</b> directory

<h4> To compile java files</h4>
Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```mvn compile```</b>
This will create <b>.class</b> files under the target directory

<h4> To compile java test files</h4>
Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```mvn test-compile```</b>

<h4> To Run Tests </h4>
Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```mvn test```</b>

<h4> To Create JAR File </h4>
Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```mvn install```</b>

<h3> To Run Program </h3>
Go to the root of the project (the directory that contains the <b>pom.xml</b> file) and run: <b>```java -jar target/checkers-0.0.1-SNAPSHOT.jar```</b>
