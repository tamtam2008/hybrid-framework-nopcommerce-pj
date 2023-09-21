package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserAddressInfoPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordInfoPageObject;
import pageObjects.nopCommerce.portal.UserSubCategoryPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.portal.UserProductDetailsPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserSearchingPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	} 
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	} 
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	} 
	
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	} 
	
	public static UserAddressInfoPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressInfoPageObject(driver);
	} 
	
	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	} 
	
	public static UserChangePasswordInfoPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordInfoPageObject(driver);
	} 
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	} 
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
		
	}
	
	public static UserSubCategoryPageObject getSubCategoryPage(WebDriver driver) {
		return new UserSubCategoryPageObject(driver);
	} 
	
	public static UserProductDetailsPageObject getProductDetailsPage(WebDriver driver) {
		return new UserProductDetailsPageObject(driver);
	} 
	
	public static UserProductReviewsPageObject getProductReviewsPage(WebDriver driver) {
		return new UserProductReviewsPageObject(driver);
	} 
	
	public static UserSearchingPageObject getSearchingPage(WebDriver driver) {
		return new UserSearchingPageObject(driver);
	} 
	
	
}
