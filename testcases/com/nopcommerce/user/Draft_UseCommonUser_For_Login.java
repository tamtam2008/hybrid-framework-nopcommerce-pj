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
import pageObjects.nopCommerce.portal.UserSearchingPageObject;
import reportConfig.ExtentTestManager;

public class Draft_UseCommonUser_For_Login extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchingPageObject userSearchingPage;
	private String emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		
		emailAddress = Common_01_Register.emailAddress;
		password = Common_01_Register.password;
		
		log.info("Login_Step01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		log.info("Login_Step02: Enter to Email existed and correct password ");
		loginPage.inputToUsername(emailAddress);
		loginPage.inputToPassword(password);
		log.info("Login_Step03: Click to Login button");
		homePage =loginPage.clickToLoginButton();
		sleepInSecond(3);
		log.info("Login_Step04: Verify success message");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		
	}
	
	@Test
	public void Search_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search with empty data");
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Enter empty data in the searching bar >> enter");
		
		homePage.enterDataOnSearchingBar(driver, " ");
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Verify error message");
		Assert.assertTrue(userSearchingPage.isErrorMessageWithEmptyDataDisplayed());
	}
	
	

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
}
