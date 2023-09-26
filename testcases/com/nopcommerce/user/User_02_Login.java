package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class User_02_Login extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private String existingEmail, password, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		invalidEmail = "123456@$^^$$";
		existingEmail = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		notFoundEmail = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		password = "123456";

		// Pre-condition
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox("tam");
		registerPage.inputToLastNameTextbox("nguyen");
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		sleepInSecond(2);
		//homePage.clickToLogoutLink();

	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Click to Login button");
		loginPage.clickToLoginButton();
		log.info("Login_Step03: Verify require messages");
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Invalid Email and correct password");
		loginPage.inputToUsername(invalidEmail);
		loginPage.inputToPassword(password);
		log.info("Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		log.info("Login_Step04: Verify error message of email");
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Exist() {
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Email not exist and correct password");
		loginPage.inputToUsername(notFoundEmail);
		loginPage.inputToPassword(password);
		log.info("Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		log.info("Login_Step04: Verify error message");
		System.out.println(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent"));
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"1Login was unsuccessful. Please correct the errors and try again.No customer account found");

	}

	@Test
	public void Login_04_With_Email_Existed_And_No_Password() {

//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//			homePage.clickToLogoutLink();
//		}
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Email existed and no password");
		loginPage.inputToUsername(existingEmail);
		log.info("Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		sleepInSecond(2);
		log.info("Login_Step04: Verify error message");
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Email_Existed_And_Wrong_Password() {
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Email existed and wrong password");
		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword("123459");
		log.info("Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		log.info("Login_Step04: Verify error message");
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");

	}

	@Test
	public void Login_06_With_Email_Existed_And_Correct_Password() {
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Email existed and correct password ");
		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword(password);
		log.info("Login_Step03: Click to Login button");
		homePage =loginPage.clickToLoginButton();
		sleepInSecond(3);
		log.info("Login_Step04: Verify success message");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
