package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressInfoPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordInfoPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class User_03_Customer_Info extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		email = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		emailAddress = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		password = "123456";
		companyName = "One Piece";
		firstName = "Luffy";
		lastName = "Luffyyy";
		dayOfB = "14";
		montOfB = "September";
		yearOfB = "2000";
		country = "Canada";
		city = "Toronto";
		address = "8 Silverbell Grv";
		postCode = "A1B 2C3";
		phoneNo = "0996899999";
		newPw = "0996899999AF#";

		// pre-condition
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox("Chopper");
		registerPage.inputToLastNameTextbox("Tony");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		homePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToUsername(email);
		loginPage.inputToPassword(password);

		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}

	@Test
	public void MyAccount_01_Customer_Infor() {

		customerInfo = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfo.isCustomerInfoIsDisplayed());

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
		Assert.assertTrue(customerInfo.isGenderCheckboxSelected());
		Assert.assertEquals(customerInfo.getFirstNameCustomerInfo("value"), firstName);
		Assert.assertEquals(customerInfo.getLastNameCustomerInfo("value"), lastName);
		Assert.assertEquals(customerInfo.getDayOfBirthCustomerInfo("value"), dayOfB);
		Assert.assertTrue(customerInfo.isMonthOfBirthCustomerInfoDisplayed());
		Assert.assertTrue(customerInfo.isYearOfBirthCustomerInfoDisplayed());
		Assert.assertEquals(customerInfo.getEmailCustomerInfo("value"), email);
		Assert.assertEquals(customerInfo.getCompanyNameCustomerInfo("value"), companyName);

	}

	@Test
	public void MyAccount_02_Address_Infor() {
		addressInfoPage = customerInfo.openAddressPage(driver);

		Assert.assertTrue(addressInfoPage.isAddressInfoHeaderDisplayed());
		addressInfoPage.clickToNewAddressButton();

		addressInfoPage.inputToFirstNameOfAddressInfo(firstName);
		addressInfoPage.inputToLastNameOfAddressInfo(lastName);
		addressInfoPage.inputToEmailOfAddressInfo(emailAddress);
		addressInfoPage.selectToCountryOfAddressInfo(country);
		addressInfoPage.inputToCityOfAddressInfo(city);
		addressInfoPage.inputToAddress1OfAddressInfo(address);
		addressInfoPage.inputToZipPostalCodeOfAddressInfo(postCode);
		addressInfoPage.inputToPhoneNumberOfAddressInfo(phoneNo);
		
		addressInfoPage.clickToSaveAddressButton();
		Assert.assertTrue(addressInfoPage.isSuccessfulMessageCreatedAddressDisplayed());
		Assert.assertEquals(addressInfoPage.getFullNameAddress(), firstName+" "+lastName);
		String emailVerify = addressInfoPage.getEmailAddress();
		String phoneVerify = addressInfoPage.getPhoneNumberAddress();
		Assert.assertTrue(emailVerify.contains(emailAddress));
		Assert.assertTrue(phoneVerify.contains(phoneNo));
		Assert.assertEquals(addressInfoPage.getCountryAddress(), country);
	}

	@Test
	public void MyAccount_03_Change_Password() {
		changePasswordPage = addressInfoPage.openChangePasswordPage(driver);
		Assert.assertTrue(changePasswordPage.getChangePasswordHeader());
		
		changePasswordPage.inputForOldPassword(password);
		changePasswordPage.inputForNewPassword(newPw);
		changePasswordPage.inputForConfirmPassword(newPw);
		changePasswordPage.clickToSaveChangePassword();
		Assert.assertTrue(changePasswordPage.getTextSuccessfulMessageChangePassword());
	
		changePasswordPage.clickToCloseSuccessMessageChangePw();
		sleepInSecond(2);
		homePage = changePasswordPage.openUserHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToUsername(email);
		loginPage.inputToPassword(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
				"Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
		
		loginPage.inputToPassword(newPw);
		loginPage.clickToLoginButton();
	} 
	
	@Test
	public void MyAccount_04_My_Product_Reviews() {
		
		homePage.clickToMyAccountLink();
		
		
		
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

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInfo;
	private UserAddressInfoPageObject addressInfoPage;
	private UserChangePasswordInfoPageObject changePasswordPage;
	private UserMyProductReviewsPageObject myProductReviewsPage;
	private String email, password, companyName, firstName, lastName, dayOfB, montOfB, yearOfB, emailAddress, country,
			city, address, postCode, phoneNo, newPw;
}
