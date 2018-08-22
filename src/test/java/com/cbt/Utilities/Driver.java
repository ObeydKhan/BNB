package com.cbt.Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private Driver() {
	}

	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			// Take the browser from the properties file
			// if no browser is passed
			if (browser == null) {
				browser = ConfigurationReader.getProperty("browser");
			}
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			case "remote_firefox":
				try {
					DesiredCapabilities caps = DesiredCapabilities.firefox();
					caps.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(ConfigurationReader.getProperty("grid")), caps);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				break;

			case "remote_chrome":
				try {
					DesiredCapabilities caps = DesiredCapabilities.chrome();
					caps.setPlatform(Platform.WINDOWS);
					driver = new RemoteWebDriver(new URL(ConfigurationReader.getProperty("grid")), caps);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return driver;

	}

	public static WebDriver getDriver() {
		return getDriver(null);
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
