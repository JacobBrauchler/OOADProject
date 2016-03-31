<h1> Objected Oriented Analysis and Design Project </h1>
<h2> Checkers Palooza! </h2>


<h3> Alex Tzinov - Jacob Brauchler - Kyle Wiese </h3>



<h3> Code Organization </h3> 
We used <b> Maven </b> as our build tool as well as a basis for code organization. Unlike similar tools such as <b>ant</b>, Maven enforces a rigid code structure which helped enforce a consistent organization across all 3 team members

<h3> Installing Maven on MacOS </h3>
```brew install homebrew/versions/maven30```


<h4> /src/ </h4>
This directory is divided into <b>/main</b> and a <b>/test</b> where main contains all of our project source code and test contains test suites written with <b> JUnit</b>.  

<h4> pom.xml (Project Object Model) </h4>
This is the vital file for any maven project. It contains information about the project and configuration details used by Maven to build the project. While we are keeping this project IDE-independent, meaning we are not containing any Eclipse/IntelliJ config files in the repo, we have enforced that the project gets built using Maven, meaning we MUST include this pom.xml file


<h2> Importing This Into Eclipse </h2>
First, pull the latest version of this repository with ```git pull origin master``` <br>
Then, open Eclipse, go to <b> File -> Import </b> Select the <b> Maven </b> Folder, then select <b> Existing Maven Projects </b> and click <b> Next </b> <br>
Select <b> Browse... </b> and select the location of where you cloned this repo. MAKE SURE YOU SELECT THE FOLDER THAT CONTAINS THE POM.XML FILE, NOT ANY SUBFOLDERS SUCH AS SRC <br>
Press <b> Select All </b> and then select <b> Finish </b> and project will be imported!


<h3> Ensuring Eclipse is working with the project </h3>
Right click on the <b> pom.xml </b> file in the Package Explorer (to open the Package Explorer go to <b> Window -> Show View -> Project Explorer</b>) and select <b> Run As -> Maven Test </b>. This should should result in a BUILD SUCCESS message alongside a test report indicating that one test was run with 0 failures <br>

Now right click on the root folder of the project in the Package Explorer (should be called checkers) and select <b> Run As -> Java Application </b>. From the resulting pop-up menu select <b> App - com.ooadproject.kja.checkers </b>. This is telling Eclipse what the entry point of our application is. Click <b> Ok </b> and "Hello World!" should get printed in the console. You're golden!

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
