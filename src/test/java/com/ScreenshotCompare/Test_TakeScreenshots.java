package com.ScreenshotCompare;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Test_TakeScreenshots {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
		
	}
	
	@Test
	public void TakeScreenshots() throws InterruptedException, IOException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//WebElement logoImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		WebElement logoImage = driver.findElement(By.xpath(""));
		
		
		Screenshot screenshot = new AShot().takeScreenshot(driver,logoImage);
		ImageIO.write(screenshot.getImage(),"png", new File("./images/orangehrmpage.png"));
		
		
		File f = new File("./test-output/images/orangehrmlogo.png");
		if(f.exists()) {
			System.out.println("Image captured");
		}
		else {
			System.out.println("Image not captured");
		}
		
	}


	

}
