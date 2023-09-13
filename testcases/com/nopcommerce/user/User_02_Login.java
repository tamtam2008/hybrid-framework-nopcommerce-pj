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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_02_Login extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String existingEmail, password, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		driver.manage().window().maximize();
		invalidEmail = "123456@$^^$$";
		existingEmail = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		notFoundEmail = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		password = "123456";

		// Pre-condition
		// create acc (just temporate)
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
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

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToUsername(invalidEmail);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Exist() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToUsername(notFoundEmail);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();

		System.out.println(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent"));
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.No customer account found");

	}

	@Test
	// recheck- neet to extends acc created of User_01__Register_Page_Object
	public void Login_04_With_Email_Existed_And_No_Password() {

//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//			homePage.clickToLogoutLink();
//		}

		// login
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
	
		loginPage.inputToUsername(existingEmail);
		loginPage.clickToLoginButton();
		sleepInSecond(2);

		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Email_Existed_And_Wrong_Password() {

		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword("123459");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");

	}

	@Test
	public void Login_06_With_Email_Existed_And_Correct_Password() {

		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToUsername(existingEmail);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();
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
