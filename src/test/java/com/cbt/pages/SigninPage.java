package com.cbt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.Utilities.Driver;

public class SigninPage {

	private WebDriver driver;
	
	public SigninPage() {
		driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(xpath = "//button[.='sign in']")
	public WebElement signInButton;
	
}
