package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveScenarios {
	
	/*
	 * Verify that correct first name and last name is displayed on the top right
	 */
	Faker faker = new Faker();
	String email = faker.name().firstName()+"@yahoo.com";
	String name = faker.name().firstName();
	String lastName = faker.name().lastName();
	String pasword = faker.number().digits(7);
	
	
	@Test
	public void loginTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();
		
		
		
		
		String email = faker.name().firstName()+"@yahoo.com";
		driver.findElement(By.xpath("(//input[@type='text'])[2]"))
		.sendKeys(email);
		
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
		
		
		// Perform the click operation that opens new window

	
		Thread.sleep(3000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		   driver.switchTo().window(winHandle);
		}
		

		driver.findElement(By.id("customer_firstname")).sendKeys(name);
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.id("passwd")).sendKeys(pasword);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
	
		driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
		driver.findElement(By.id("city")).sendKeys(faker.address().city());
		
		Select dropdown = new Select(driver.findElement(By.id("id_state")));
		
		dropdown.selectByIndex(faker.number().numberBetween(0, 49));
		driver.findElement(By.id("postcode")).sendKeys(faker.number().digits(5));
		driver.findElement(By.id("phone_mobile")).sendKeys(faker.number().digits(10));
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys(email);
		driver.findElement(By.id("submitAccount")).click();
		
		driver.findElement(By.className("logout")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(pasword);
		driver.findElement(By.id("SubmitLogin")).click();
		
		
		
		
	Assert.assertTrue(driver.findElement(By.className("account")).getText().contains(name+" "+lastName)
		);
		
	

		
		Thread.sleep(5000);
		//driver.quit();
		
	}
	

}
