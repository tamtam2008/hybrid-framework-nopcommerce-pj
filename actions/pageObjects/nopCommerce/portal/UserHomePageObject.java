package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.UserSubCategoryPageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
		
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public void hoverToMenuHeader(String nameMenu) {
		waitForElementClickable(driver, HomePageUI.MENU_HEADER, nameMenu);
		hoverMouseToElement(driver, HomePageUI.MENU_HEADER, nameMenu);

	}

	public UserSubCategoryPageObject clickToSubCategory(String nameSubMenu) {
		waitForElementVisible(driver, HomePageUI.SUB_MENU_HEADER,nameSubMenu);
		clickToElement(driver, HomePageUI.SUB_MENU_HEADER,nameSubMenu);
		return PageGeneratorManager.getSubCategoryPage(driver);
	}

}
