# Automation-Practice

This is a Selenium-Java coding practise project.

# Software/Tools Used

#### JAVA 8
#### Selenium
#### Cucumber
#### JUnit
#### Gradle
#### ChromeDriver.exe

# How to build the project or Task execution

As Gradle is the build tool used, use gradlew clean build command to build the project.

# How to execute the tests

There are multiple ways tests can be run:
##### Can be run as gradlew build command
##### Can run from Cucumber Runner File where junit is Testing Engine 
##### Tests can be directly run from the feature files by clicking on the respective scenarios.

# Generating the test report

Reports will be available under build folder as Cucumber.html file after the execution of tests.

# About the Project Structure

Project is following standard folder structure. All the code files are available under src/test/ folder and gradle files are available under root project.

###### Directory src/test/java/com.test.sanjay.akbari

# 1. DriverManager

DriverManager class is created to initialise the WebDriver instance. For this exercise chrome browser is used.

# 2. PageObjects

Page classes are created to follow the page object factory model in accordance with UI pages.

### HomePage

Methods added for actions performed on Home Page 

### OrderPage

Methods added for actions performed on Order Page

### SignInPage

Methods added for actions performed on SignIn Page

# 3. Runners

In this Runners package, CucumberRunner.java class is created to run Cucumber Tests with CucumberOptions.

# 4. Stepdefinitions

Implementation of feature file's steps has been achieved here.

# 5. Utils

A utility to read data from properties file has been added here.

# 6. Resources

ALl the resource files used for this project has been added under this folder.

## Features

Feature file to achieve BDD Behavior is available under this folder.

## Properties

Properties used throughout the project has been mentioned here.

## Drivers

ChromeDriver to execute tests on Chrome is available here.