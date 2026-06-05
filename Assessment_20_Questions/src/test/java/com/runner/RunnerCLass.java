package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = "src/test/resources/com.features",
glue = {"com.stepdefinitions", "com.hooks"})

public class RunnerCLass extends AbstractTestNGCucumberTests {

}
