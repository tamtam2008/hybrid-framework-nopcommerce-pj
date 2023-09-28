package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Common_01_Register_Cookie extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);

		emailAddress = "tam.tam" + randomFakeNumber() + "@mailinator.com";
		firstName = "Tam";
		lastName = "Nguyen";
		password = "12345V@t";

		log.info("Register_03 - Step01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register_03 - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_03 - Step03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_03 - Step04: Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//		homePage.clickToLogoutLink();
//		}else {
//			System.out.println("Skipped Logout button");
//		}
		
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to email & password ");
		loginPage.inputToUsername(emailAddress);
		loginPage.inputToPassword(password);
		log.info("Login_Step03: Click to Login button");
		homePage =loginPage.clickToLoginButton();
		sleepInSecond(3);
		log.info("Login_Step04: Verify success message");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		
		loggedCookies = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie at common Class: " + cookie);
		}
		
		driver.quit();
	}


}
