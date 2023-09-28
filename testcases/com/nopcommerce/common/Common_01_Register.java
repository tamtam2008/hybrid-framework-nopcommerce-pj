package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Common_01_Register extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

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

		log.info("Pre-Condition_Register - Step01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition_Register - Step02: Input to require fields");
		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition_Register - Step03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition_Register - Step04: Verify success message displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//		homePage.clickToLogoutLink();
//		}else {
//			System.out.println("Skipped Logout button");
//		}
		driver.quit();
	}


}
