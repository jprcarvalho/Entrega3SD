This is a Java library to simplify the access to UDDI registries (namely jUDDI).


Instructions using Maven:
------------------------

To compile package:
  mvn package
  (a JAR file is created containing the compiled classes and a generated manifest)

To install package:
  mvn install
  (the JAR is made available in the local maven repository ~/.m2/repository)
  (other projects can now refer to the library as a dependency)

To generate API documentation:
  mvn javadoc:javadoc


To configure the Maven project in Eclipse:
-----------------------------------------

If the Maven pom.xml exists:
    'File', 'Import...', 'Maven'-'Existing Maven Projects'
    'Select root directory' and 'Browse' to the project base folder.
	Check that the desired POM is selected and 'Finish'.

If the Maven pom.xml does not exist:
    'File', 'New...', 'Project...', 'Maven Projects'.
	Check 'Create a simple project (skip architype selection)'.
	Uncheck  'Use default Workspace location' and 'Browse' to the project base folder.
	Fill the fields in 'New Maven Project'.
	Check if everything is OK and 'Finish'.


--
Revision date: 2016-04-25
leic-sod@disciplinas.tecnico.ulisboa.pt
