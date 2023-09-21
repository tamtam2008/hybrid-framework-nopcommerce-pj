package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressInfoPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordInfoPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;

public class Draft_Switch_Role extends BaseTest {

//	@Parameters({"browser", "evironment"})
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		driver.manage().window().maximize();
		emailUser = "tamnguyen" + randomFakeNumber() + ".vn@gmail.com";
		passwordUser = "123456";
		adminUser = "admin@yourstore.com";
		adminPassword = "admin";
		

		// Pre-condition
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.clickToGender();
		userRegisterPage.inputToFirstnameTextbox("tam");
		userRegisterPage.inputToLastNameTextbox("nguyen");
		userRegisterPage.inputToEmailTextbox(emailUser);
		userRegisterPage.inputToPasswordTextbox(passwordUser);
		userRegisterPage.inputToConfirmPasswordTextbox(passwordUser);
		userRegisterPage.clickToRegisterButton();
		sleepInSecond(2);
		// homePage.clickToLogoutLink();
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();

		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		
		userCustomerInfo = userHomePage.clickToMyAccountLink();
		userHomePage = userCustomerInfo.openUserHomePage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminUser, adminPassword);
		Assert.assertEquals(adminLoginPage.getTextDashboard().trim(), "Dashboard");
		sleepInSecond(2);
		adminLoginPage = adminDashboardPage.openAdminLoginPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		userHomePage.openPageUrl(driver,GlobalConstants.PORTAL_PAGE_URL);
		userHomePage.clickToRegisterLink();
		PageGeneratorManager.getUserRegisterPage(driver);
		
		adminLoginPage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminLoginPage.loginAsAdmin(adminUser, adminPassword);
		sleepInSecond(2);
		adminLoginPage = adminDashboardPage.openAdminLoginPage(driver);
	}
	
	@Test
	public void User_03_Dynamic_Page_01() {
		userHomePage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(emailUser, passwordUser);
		userCustomerInfo = userHomePage.clickToMyAccountLink();
		//
		userAddressInfoPage = (UserAddressInfoPageObject) userCustomerInfo.openPagesAtMyAccountPageByName(driver, "Addresses");
		userChangePasswordInfoPage = (UserChangePasswordInfoPageObject) userAddressInfoPage.openPagesAtMyAccountPageByName(driver, "Change password");
		userMyProductReviewsPageObject = (UserMyProductReviewsPageObject) userChangePasswordInfoPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		userCustomerInfo = (UserCustomerInfoPageObject) userMyProductReviewsPageObject.openPagesAtMyAccountPageByName(driver, "Customer info");
	} 
	
	@Test
	public void User_04_Dynamic_Page_02() {
		userCustomerInfo.openPagesAtMyAccountPageByName(driver, "Change password");
		userChangePasswordInfoPage = PageGeneratorManager.getUserChangePasswordPage(driver);
		
		userChangePasswordInfoPage.openPagesAtMyAccountPageByName(driver, "Addresses");
		userAddressInfoPage = PageGeneratorManager.getUserAddressPage(driver);
		
		userAddressInfoPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		userMyProductReviewsPageObject = PageGeneratorManager.getUserMyProductReviewsPage(driver);
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
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfo;
	private UserAddressInfoPageObject userAddressInfoPage;
	private UserChangePasswordInfoPageObject userChangePasswordInfoPage;
	private UserMyProductReviewsPageObject userMyProductReviewsPageObject;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String emailUser, passwordUser, adminUser, adminPassword;
}
