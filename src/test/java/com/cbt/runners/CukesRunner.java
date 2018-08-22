package com.cbt.runners;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"json:target/cucumber_report.json",
				"pretty"
			},
	tags="@temp",
	features="src/test/resources/features",
	glue="com.cbt.step_definitions"
//			,dryRun=true
	
		)
public class CukesRunner{

}
