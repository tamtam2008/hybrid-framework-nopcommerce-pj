package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import reportConfig.ExtentTestManager;

public class User_02_Login extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	private String emailAddress, password, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;
		
		driver.manage().window().maximize();
		invalidEmail = "123456@$^^$$";
		notFoundEmail = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";


	}

	@Test
	public void Login_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with empty data");
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Click to Login button");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,"ogin_Step03: Verify require messages");
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with Invalid Email");
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Enter to Invalid Email and correct password");
		loginPage.inputToUsername(invalidEmail);
		loginPage.inputToPassword(password);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step04: Verify error message of email");
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_With_Email_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with Email_Not_Exist");
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Enter to Email not exist and correct password");
		loginPage.inputToUsername(notFoundEmail);
		loginPage.inputToPassword(password);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step04: Verify error message");
		System.out.println(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent"));
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.No customer account found");

	}

	@Test
	public void Login_04_With_Email_Existed_And_No_Password(Method method) {

		ExtentTestManager.startTest(method.getName(), "Login with Email_Existed_And_No_Password");
		
//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//			homePage.clickToLogoutLink();
//		}
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Enter to Email existed and no password");
		loginPage.inputToUsername(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		sleepInSecond(2);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step04: Verify error message");
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	}

	@Test
	public void Login_05_With_Email_Existed_And_Wrong_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with Email_Existed_And_Wrong_Password");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Enter to Email existed and wrong password");
		loginPage.inputToUsername(emailAddress);
		loginPage.inputToPassword("123459");
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step03: Click to Login button");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step04: Verify error message");
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");

	}

	@Test
	public void Login_06_With_Email_Existed_And_Correct_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with Email_Existed_And_Correct_Password");
		
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step02: Enter to Email existed and correct password ");
		loginPage.inputToUsername(emailAddress);
		loginPage.inputToPassword(password);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step03: Click to Login button");
		homePage =loginPage.clickToLoginButton();
		sleepInSecond(3);
		ExtentTestManager.getTest().log(Status.INFO,"Login_Step04: Verify success message");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
