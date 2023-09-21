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
import pageObjects.nopCommerce.portal.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserProductDetailsPageObject;
import pageObjects.nopCommerce.portal.UserProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserSubCategoryPageObject;

public class User_03_My_Account extends BaseTest {

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
		nameMenu = "Computers";
		nameSubMenu = "Software";
		nameSub1Item = "Photoshop";
		titleReview = "Test title review";
		descrtReview = "This sample review is for the Adobe Photoshop CS4. I've been waiting for this product to be available. It is priced just right.";

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
		log.info("MyAccount_Step01: Click to Menu Header");
		homePage.hoverToMenuHeader(nameMenu);
		subCaegoryPage = homePage.clickToSubCategory(nameSubMenu);
		
		log.info("MyAccount_Step02: Click to Sub_Menu >> Item ");
		productDetailsPage = subCaegoryPage.clickToSubLevel1ItemProduct(nameSub1Item);
		log.info("MyAccount_Step03: Click to Review link ");
		productReviewsPage = productDetailsPage.clickToAddYourReviewLink();
		log.info("MyAccount_Step04: Enter info your review ");
		productReviewsPage.enterToTitleReview(titleReview);
		productReviewsPage.enterToDescriptionReview(descrtReview);
		productReviewsPage.clickToRatingReview("5");
		log.info("MyAccount_Step05: Submit your review");
		productReviewsPage.clickToReviewButton();
		log.info("MyAccount_Step05: Verify all info your review");
		verifyEquals(productReviewsPage.verifySuccessMessage(), "Product review is successfully added.");
		verifyEquals(productReviewsPage.verifyTitleReview(), titleReview);
		verifyEquals(productReviewsPage.verifyDescriptionReview(), descrtReview);
		
		log.info("MyAccount_Step06: Verify your review in My Product Review in My Account");
		customerInfo = productReviewsPage.clickToMyAccountLink();
		customerInfo.openPagesAtMyAccountPageByName(driver, "My product reviews");
		
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
	private UserSubCategoryPageObject subCaegoryPage;
	private UserProductDetailsPageObject productDetailsPage;
	private UserProductReviewsPageObject productReviewsPage;
	private UserMyProductReviewsPageObject myProductReviewsPage;
	private String nameMenu, nameSubMenu, nameSub1Item, titleReview, descrtReview;
	private String email, password, companyName, firstName, lastName, dayOfB, montOfB, yearOfB, emailAddress, country,
			city, address, postCode, phoneNo, newPw;
}
