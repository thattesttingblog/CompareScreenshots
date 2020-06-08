/**
 * @author kunalmathur
 *
 */

package com.Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utilities.BaseClass;

import org.testng.annotations.AfterClass;


public class Test_Login {
	
		private WebDriver driver;
		
		@BeforeClass
		public void beforeClass() {
		
			//WebDriverManager.chromedriver().setup();
			BaseClass.initiateChromeDriver();
			driver = new ChromeDriver();

		}
		
		
		@AfterClass
		public void teardown() {
			if(driver != null) {
				driver.quit();
			}			
		}
	
@Test
public void testLogin() {
	
	driver.manage().window().maximize();
	 driver.get("https://www.google.com");
	 driver.get("https://demoqa.com/html-contact-form/");
	
}
		
}
		

