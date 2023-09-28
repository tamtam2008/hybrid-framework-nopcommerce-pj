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
import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserSearchingPageObject;
import reportConfig.ExtentTestManager;

public class Draft_UseCommonUserCookie_For_Login2 extends BaseTest {

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
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		sleepInSecond(3);
		loginPage.refresh(driver);
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
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		closeBrowserDriver();
	}
}
