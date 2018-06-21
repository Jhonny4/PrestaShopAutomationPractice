package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeScenarios {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Ignore
	@Test
	public void wrongCredentialsTest() {

		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();

		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]"))
				.sendKeys("guadronjonathan@yahoo.com");
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]"))
				.sendKeys("Jhonny4");
		driver.findElement(By.id("SubmitLogin")).click();
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Authentication
		// failed. ");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger'] //li")).getText()
				.contains("Authentication failed."));

	}

	@Test
	public void invalidEmailTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();

		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]"))
				.sendKeys("guadronjonathan");
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]"))
				.sendKeys("Jhonny4");
		driver.findElement(By.id("SubmitLogin")).click();
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Authentication
		// failed. ");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger'] //li")).getText()
				.contains("Invalid email address."));

	}
	@Test
	public void blankEmailTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();

		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]"))
				.sendKeys("");
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]"))
				.sendKeys("Jhonny4");
		driver.findElement(By.id("SubmitLogin")).click();
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Authentication
		// failed. ");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger'] //li")).getText()
				.contains("An email address required."));

	}
	@Test
	public void blankPasswordTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();

		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[2]"))
				.sendKeys("guadronjonathan@yahoo.com");
		driver.findElement(By.xpath("(//input[@class='is_required validate account_input form-control'])[3]"))
				.sendKeys("");
		driver.findElement(By.id("SubmitLogin")).click();
		// driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText().contains("Authentication
		// failed. ");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger'] //li")).getText()
				.contains("Password is required."));

	}
	
	
	@AfterMethod
	
	public void setquit() {
		driver.quit();
	}
	

}
