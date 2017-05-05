# Distributed Systems project 2016/17
Evaluation tests for Part 2 (P2)


Instructions using Maven
------------------------

You must have uddi-naming and supplier-ws-cli modules installed.

You must start the servers first:
supplier 1, supplier 2, mediator.

To run a simple ping using exec plugin:

    mvn exec:java

To compile and run integration tests:

	mvn verify

To compile and run a specific integration test suite:

	mvn verify -Dit.test=PingIT

(more integration test running options at http://maven.apache.org/surefire/maven-failsafe-plugin/examples/single-test.html)

To configure the Maven project in Eclipse
-----------------------------------------

'File', 'Import...', 'Maven'-'Existing Maven Projects'
'Select root directory' and 'Browse' to the project base folder.
Check that the desired POM is selected and 'Finish'.


---
2017-04-07
leic-sod@disciplinas.tecnico.ulisboa.pt
