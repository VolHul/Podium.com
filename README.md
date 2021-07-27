#SETUP
Make sure you have Maven installed.(for Mac OS: ***brew install maven***)
Pull the project and run ***mvn clean install*** command. This will trigger all the tests automatically. If you don't want to do so, please add  ***-DskipTests=true*** to your command.

You need to choose which browser you want to run your tests in, default is Chrome. Right now framework supports two browsers: safari and chrome. Go to ***config.properties*** and provide the value you need for 'browser' variable.

##To run whole tests suite
From command line run: ***mvn test***

##To run specific test case
From command line run: ***mvn test -Dtest=PodiumSmokeTest#createAccountTest*** (createAccountTest is a name of the test method).
