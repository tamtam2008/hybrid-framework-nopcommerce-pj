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
import pageObjects.MyProductReviewsPageObject;
import pageObjects.AddressInfoPageObject;
import pageObjects.ChangePasswordInfoPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_03_Customer_Info extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInfoPageObject customerInfo;
	private AddressInfoPageObject addressInfoPage;
	private ChangePasswordInfoPageObject changePasswordPage;
	private MyProductReviewsPageObject myProductReviewsPage;
	private String email, password, companyName, firstName, lastName, dayOfB, montOfB, yearOfB;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		driver.manage().window().maximize();
		email = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		password = "123456";
		companyName = "One Piece";
		firstName = "Luffy";
		lastName = "Luffyyy";
		dayOfB = "14";
		montOfB = "September";
		yearOfB = "2000";
	}

	@Test
	public void Login_01_Register() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox("Chopper");
		registerPage.inputToLastNameTextbox("Tony");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		//homePage.clickToLogoutLink();

	}

	@Test
	public void Login_02_Login() {
		
//		driver.get("https://demo.nopcommerce.com/");
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToUsername(email);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}


	@Test
	public void User_03_Customer_Infor() {

	customerInfo = homePage.clickToMyAccountLink();
	Assert.assertTrue(customerInfo.isCustomerInfoIsDisplayed());

	//switch page to page
	addressInfoPage = customerInfo.openAddressPage(driver);
	changePasswordPage = addressInfoPage.openChangePasswordPage(driver);
	myProductReviewsPage = changePasswordPage.openMyProductReviewsPage(driver);
	customerInfo = myProductReviewsPage.openCustomerInfoPage(driver);
	
	
	customerInfo.clickToGenderCheckboxCustomerInfo();
	customerInfo.inputToFirstNameCustomerInfo(firstName);
	customerInfo.inputToLastNameCustomerInfo(lastName);
	customerInfo.selectToDayOfBirthCustomerInfo(dayOfB);
	customerInfo.selectToMonthOfBirthCustomerInfo(montOfB);
	customerInfo.selectToYearOfBirthCustomerInfo(yearOfB);
	customerInfo.inputToEmailCustomerInfo(email);
	customerInfo.inputToCompanyNameCustomerInfo(companyName);
	customerInfo.scrollToBottomPage(driver);
	customerInfo.clickToSaveButton();
	
	Assert.assertTrue(customerInfo.isSuccessMessageDisplay());
	
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
