package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{

	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String adminUser) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminUser);
		
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		//return PageGeneratorManager.get
		
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public String getTextDashboard() {
		waitForElementVisible(driver, AdminLoginPageUI.DASHBOARD_TITLE);
		return getElementText(driver, AdminLoginPageUI.DASHBOARD_TITLE);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String adminUser, String adminPassword) {
		inputToUserNameTextbox(adminUser);
		inputToPasswordTextbox(adminPassword);
		return clickToLoginButton();
		
	}
}
