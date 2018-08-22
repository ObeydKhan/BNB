package com.cbt.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.cbt.Utilities.Driver;

import cucumber.api.java.en.Given;

public class SettingUPGrid {
	@Given("^the user is on google page$")
	public void the_user_is_on_google_page() throws Throwable {
	   Driver.getDriver().get("https://www.google.com");
	}

	@Given("^the user searches for \"([^\"]*)\"$")
	public void the_user_searches_for(String param) throws Throwable {
	    Driver.getDriver().findElement(By.id("lst-ib")).sendKeys(param+Keys.ENTER);
	    assertTrue(Driver.getDriver().getTitle().contains("Java"));
	}
}
