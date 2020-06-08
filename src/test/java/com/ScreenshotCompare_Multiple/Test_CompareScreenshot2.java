package com.ScreenshotCompare_Multiple;

import java.awt.image.BufferedImage;
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

import com.PageObjects.Pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Test_CompareScreenshot2 {
	
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
	public void CompareScreenshots() throws InterruptedException, IOException {
		
		try {
			
			//login
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			
			for (int i=1;i<=4;i++) {
				
				int row = i;
				int col = 0;
				
				Pageobjects.getTestData(row, col);
				
				System.out.println("reading test data:");
				System.out.println("URL: '" + Pageobjects.url
						+ "' XPath: '" + Pageobjects.xpath
						+ "' Image: " + Pageobjects.image + "'");
				
				driver.get(Pageobjects.url);
				
				BufferedImage expectedImage = ImageIO.read(new File("./test-output/images/"+Pageobjects.image));
				
				
				WebElement ImageElement = driver.findElement(By.xpath(Pageobjects.xpath));
				Screenshot screenshot = new AShot().takeScreenshot(driver,ImageElement);
				BufferedImage actualImage = screenshot.getImage();
			
				ImageDiffer imgDiff = new ImageDiffer();
				ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
				
				if(diff.hasDiff()==true) {
					System.out.println("Images are not same");
					
				}
				else {
					System.out.println("Images are same");
				}
				
			}
		}
		
		catch(Exception e) {
			e.getMessage();
		}
	}
		
	

}
