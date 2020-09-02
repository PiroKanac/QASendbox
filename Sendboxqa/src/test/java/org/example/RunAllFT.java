package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "classpath:features",
	glue = { "org.example.steps" },
	plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" },
	tags = { "not @Ignore"})
public class RunAllFT
{
}