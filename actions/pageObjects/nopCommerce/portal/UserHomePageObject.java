package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUI;
import pageUIs.nopCommerce.user.UserSubCategoryPageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
		
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public void hoverToMenuHeader(String nameMenu) {
		waitForElementClickable(driver, UserHomePageUI.MENU_HEADER, nameMenu);
		hoverMouseToElement(driver, UserHomePageUI.MENU_HEADER, nameMenu);

	}

	public UserSubCategoryPageObject clickToSubCategory(String nameSubMenu) {
		waitForElementVisible(driver, UserHomePageUI.SUB_MENU_HEADER,nameSubMenu);
		clickToElement(driver, UserHomePageUI.SUB_MENU_HEADER,nameSubMenu);
		return PageGeneratorManager.getSubCategoryPage(driver);
	}

}
