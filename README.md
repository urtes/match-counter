# Match Counter

Match Counter is a command line application that generates pairs of numbers from user input and counts matches between the paired numbers.
Current version (v1.0) generates one million pairs of numbers and determines the match by comparing 8 last bits of their binary representations. 

The application is developed in Java, using Maven.

## Build

From parent rum `mvn clean install`.

## Installation

To run the application download match-counter-v1.0-RELEASE.jar file from Releases.

## Usage

The Application takes two command line arguments that will be used as the initial values for generating pairs of numbers.
Valid values for arguments are whole numbers.

Match counting result will be printed to console.
 
To start the application go to the directory where match-counter-v1.0-RELEASE.jar file is located and execute `java -jar match-counter-v1.0-RELEASE.jar` followed by command line arguments.

