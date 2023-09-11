package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.security.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02__Register_Page_Object {
	
	private WebDriver driver;
	private String emailAddress, firstName, lastName, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		emailAddress = "tam.tam" + randomFakeNumber() + "@mailinator.com";
		firstName="Tam";
		lastName="Nguyen";
		password="12345V@t";
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Home Page - Step02: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step03: Verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register Page - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("999@789!@#$");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register Page - Step03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step04: Verify Email invalid");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		
		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register Page - Step03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void TC_04_Existing_Email() {

		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();
		
		System.out.println("Register Page - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		System.out.println("Register Page - Step03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step04: Verify Email invalid");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
		
	}

	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		
		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		
		System.out.println("Register Page - Step03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step04: Verify error message password");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		
		System.out.println("Home Page - Step01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("78999V@t");
		
		System.out.println("Register Page - Step03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step04: Verify error message password");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
