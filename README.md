<h1> Objected Oriented Analysis and Design Project </h1>
<h2> Checkers Palooza! </h2>


<h3> Alex Tzinov - Jacob Brauchler - Kyle Wiese </h3>

<h3> Update Log </h3>
- [April 4-5](#apr4_5)


<h3> Row-Column Convention </h3>
Adding this here so that we have an established order for how we represent our grid, how we print coordinates, how we retrieve pieces, how we construct Move objects, etc.
A 2x3 Matrix implies 2 rows and 3 columns such as:

[ ] [^] [ ] <br>
[ ] [ ] [$] <br>
Therefore, we first reference the row number, and then the column number when providing a coordinate pair. Aka, (1,2) will point to the box above that has the $ while (0,1) references the box that has the ^



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




<h3> April 4-5 <a id="apr4_5"></a></h3>

> Created <b> utilities </b> package/folder that will contain various classes for helper functions that we will frequently call across our entire app. This includes printing several types of boards for debugging, converting types, and storing constants in a single file <br>
>
> Removed any hard-coded values of grid sizes and color constants (BLACK=0, etc) and stored them in our one constants file. Now if we ever want to change our checkers grid we only have to change one value <br>
>
> Established the (row,col) convention across the entire app including how we print the board and its coordinates, how we construct Move objects, how we reference individual pieces from the piecesGrid, etc <br>
>
> Made our <b>BoardLogic</b> a singleton class. This made more sense to me with our analogy of our BoardLogic class being a car wash and our <b> Board </b> instance being a car. We have a single car wash to which we repeatedly pass in a Board instance to have it be modified, updated, etc <br>
>
> Made both of our utilities classes singletons as well. They are similar to the loggers in her singleton examples, a single instance of a helper that will be used across the whole app. No point in generating multiple instances <br>
>
> Created a super useful <b>BoardPrinter</b> class that is responsible for printing various different boards including empty boards, boards with coordinates, and most importantly boards that reflect the state of our logical <b>piecesGrid</b>. Will be super useful when debugging how moves are made, how jumps are made, etc before we have our visual Swing layer completed. Code is a mess and super fragile so don't mess around with it, just accept the fact that it draws pretty graphs :smile: :+1:

