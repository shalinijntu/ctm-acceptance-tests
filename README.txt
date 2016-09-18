The project ctm-acceptance tests has been written using below tools on Ubuntu but should work on windows too
IntelliJ IDEA 15.0.4
Java 1.8
and the remaining tools can be seen in pom.xml

The browser I used for testing is Chromium Web browser V.51

In order to run the tests:
Please make sure IntelliJ and Java(7+) are installed on your computer.
Install chrome browser/firefox browser(comment chrome code and uncomment firefox code)
Import the project and dependencies from IntelliJ
Add plugin cucumber for Java
Change the path of chrome browser in the getDriver method
Run the runTestSuite
