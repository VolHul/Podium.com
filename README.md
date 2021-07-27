#SETUP
Pull the project and run ***mvn install*** command

##To run whole tests suite
1. Choose which browser you want to run your tests in. Right now framework supports two browsers: safari and chrome. Go to *config.properties* and provide the value you need for browser variable.
2. From command line run: mvn test -Dtest=PodiumSmokeTest (PodiumSmokeTests is a name of the class where tests are stored).


##To run specific test case

From command line run: mvn test -Dtest=PodiumSmokeTest#createAccountTest (createAccountTest is a name of the test method).
