package com.ScreenshotCompare;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Test_CompareScreenshot {
	
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
	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		BufferedImage expectedImage = ImageIO.read(new File("./images/orangehrmpage.png"));
		
		
		WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='content']"));
		//WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		//WebElement logoImageElement = driver.findElement(By.xpath("//*[name()='circle' and contains(@fill,'url(#f)')]"));
		
		Screenshot screenshot = new AShot().takeScreenshot(driver,logoImageElement);
		
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
