FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/HRMDSP.jar /usr/share/tag/HRMDSP.jar

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/HRMDSP.jar", "org.testng.TestNG", "-testclass", "hrmsdp.testscripts"]