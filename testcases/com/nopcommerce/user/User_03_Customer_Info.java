package com.nopcommerce.user;

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
		verifyTrue(homePage.isMyAccountLinkDisplay());
	}

	@Test
	public void MyAccount_01_Customer_Infor() {

		customerInfo = homePage.clickToMyAccountLink();
		verifyTrue(customerInfo.isCustomerInfoIsDisplayed());

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

		verifyTrue(customerInfo.isSuccessMessageDisplay());
		verifyTrue(customerInfo.isGenderCheckboxSelected());
		verifyEquals(customerInfo.getFirstNameCustomerInfo("value"), firstName);
		verifyEquals(customerInfo.getLastNameCustomerInfo("value"), lastName);
		verifyEquals(customerInfo.getDayOfBirthCustomerInfo("value"), dayOfB);
		verifyTrue(customerInfo.isMonthOfBirthCustomerInfoDisplayed());
		verifyTrue(customerInfo.isYearOfBirthCustomerInfoDisplayed());
		verifyEquals(customerInfo.getEmailCustomerInfo("value"), email);
		verifyEquals(customerInfo.getCompanyNameCustomerInfo("value"), companyName);

	}

	@Test
	public void MyAccount_02_Address_Infor() {
		addressInfoPage = customerInfo.openAddressPage(driver);

		verifyTrue(addressInfoPage.isAddressInfoHeaderDisplayed());
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
		verifyTrue(addressInfoPage.isSuccessfulMessageCreatedAddressDisplayed());
		verifyEquals(addressInfoPage.getFullNameAddress(), firstName+" "+lastName);
		String emailVerify = addressInfoPage.getEmailAddress();
		String phoneVerify = addressInfoPage.getPhoneNumberAddress();
		verifyTrue(emailVerify.contains(emailAddress));
		verifyTrue(phoneVerify.contains(phoneNo));
		verifyEquals(addressInfoPage.getCountryAddress(), country);
	}

	@Test
	public void MyAccount_03_Change_Password() {
		changePasswordPage = addressInfoPage.openChangePasswordPage(driver);
		verifyTrue(changePasswordPage.getChangePasswordHeader());
		
		changePasswordPage.inputForOldPassword(password);
		changePasswordPage.inputForNewPassword(newPw);
		changePasswordPage.inputForConfirmPassword(newPw);
		changePasswordPage.clickToSaveChangePassword();
		verifyTrue(changePasswordPage.getTextSuccessfulMessageChangePassword());
	
		changePasswordPage.clickToCloseSuccessMessageChangePw();
		sleepInSecond(2);
		homePage = changePasswordPage.openUserHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToUsername(email);
		loginPage.inputToPassword(password);
		loginPage.clickToLoginButton();
		verifyEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(),
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

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInfo;
	private UserAddressInfoPageObject addressInfoPage;
	private UserChangePasswordInfoPageObject changePasswordPage;
	private String email, password, companyName, firstName, lastName, dayOfB, montOfB, yearOfB, emailAddress, country,
			city, address, postCode, phoneNo, newPw;
}
