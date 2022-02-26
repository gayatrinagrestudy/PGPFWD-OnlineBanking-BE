package com.simplilearn.capstone.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


class OnlineBankingHomePageTest {
	
	public static void main(String[] args) {
		
	String siteUrl = "http://localhost:4200/";
	String driverPath = "C:\\springBootWrkSp\\online-banking-app\\drivers\\chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver", driverPath);
    WebDriver driver = new ChromeDriver();
    
    driver.get(siteUrl);
    
    String expectedTitle = "IcinOnline";
    String actualTitle = driver.getTitle();
    if(expectedTitle.equals(actualTitle)) {
    	System.out.println("Test is passed for Application Title.");
    } else {
    	System.out.println("Test is failed for Application Title.");
    }
    
    WebElement tagName = driver.findElement(By.className("bootstrap-wrapper"));
    System.out.println("tagName " +tagName.getClass().getName());
    if(tagName.equals("bootstrap-wrapper")) {
    	System.out.println("Test is passed for css class name.");
    }else {
    	System.out.println("Test is failed for css class name.");
    }
   driver.close();
	}
}
