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
//		homePage = new HomePageObject(driver);
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

		loginPage = homePage.clickToLoginLink();

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToUsername(invalidEmail);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Exist() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToUsername(notFoundEmail);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();

		System.out.println(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent"));
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.No customer account found");

	}

	@Test
	public void Login_04_With_Email_Existed_And_No_Password() {

//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//			homePage.clickToLogoutLink();
//		}

		loginPage = homePage.clickToLoginLink();
	
		loginPage.inputToUsername(existingEmail);
		loginPage.clickToLoginButton();
		sleepInSecond(2);

		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Email_Existed_And_Wrong_Password() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword("123459");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");

	}

	@Test
	public void Login_06_With_Email_Existed_And_Correct_Password() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword(password);

		homePage =loginPage.clickToLoginButton();
		sleepInSecond(3);

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
