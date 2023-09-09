package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.security.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		emailAddress = "tam.tam" + randomFakeNumber() + "@mailinator.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Tam");
		driver.findElement(By.id("LastName")).sendKeys("Nguyen");
		driver.findElement(By.id("Email")).sendKeys("999@789!@#$");
		driver.findElement(By.id("Password")).sendKeys("12345V@t");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("12345V@t");

		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Tam");
		driver.findElement(By.id("LastName")).sendKeys("Nam");
		String emailTcs03 = emailAddress;
		driver.findElement(By.id("Email")).sendKeys(emailTcs03);
		driver.findElement(By.id("Password")).sendKeys("12345V@t");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("12345V@t");

		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}

	@Test
	public void TC_04_Existing_Email() {
		sleepInSecond(2);
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Tam");
		driver.findElement(By.id("LastName")).sendKeys("Nam");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("12345V@t");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("12345V@t");

		driver.findElement(By.id("register-button")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error")).getText(), "The specified email already exists");
	}

	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		sleepInSecond(2);
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Mat");
		driver.findElement(By.id("LastName")).sendKeys("Mat");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123");

		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		sleepInSecond(2);
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Mat");
		driver.findElement(By.id("LastName")).sendKeys("Mat");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("12345V@t");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("78999V@t");

		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
