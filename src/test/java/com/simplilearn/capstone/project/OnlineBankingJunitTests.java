/* package com.simplilearn.capstone.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineBankingJunitTests {

	String siteUrl = "http://localhost:4200/";
	String driverPath = "C:\\springBootWrkSp\\online-banking-app\\drivers\\chromedriver.exe";
	 WebDriver driver;
	
	@BeforeEach
	public void beforeEach() {
	    System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver(); 
	    driver.get(siteUrl);
	}
	
	@AfterEach
	public void afterEach() {
		  driver.close();
	}
	
	@Test
	public void HomePage() {
		
	    String expectedTitle = "IcinOnline";
	    String actualTitle = driver.getTitle();
	    Assertions.assertEquals(expectedTitle, actualTitle);
	    
		}
	
	@Test
	public void LoginInput() {
	    WebElement username = driver.findElement(By.name("username"));
	    username.sendKeys("gayatri");
	    WebElement pwd = driver.findElement(By.name("password"));
	    pwd.sendKeys("gayatri123");
	    username.submit();
	    pwd.submit();
		}
	
	} */

