package com.test.sanjay.akbari.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.test.sanjay.akbari.stepdefinitions"},
        plugin = {"pretty", "html:/build/cucumber.html"}
)
public class CucumberRunner {

}
