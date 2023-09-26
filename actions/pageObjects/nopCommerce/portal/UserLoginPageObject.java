package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getUsernameErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.USERNAME_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.USERNAME_ERROR_MESSAGE);
	}

	public void inputToUsername(String username) {
		sendkeyToElement(driver, UserLoginPageUI.USERNAME_TEXTBOX, username);
		
	}

	public void inputToPassword(String password) {
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public String getAttributeUnsuccessLoginErrorMessage(String textAttribute) {
		waitForElementVisible(driver, UserLoginPageUI.UNSUCESS_LOGIN_ERROR_MESSAGE);
		return getElementAttribute(driver, UserLoginPageUI.UNSUCESS_LOGIN_ERROR_MESSAGE, textAttribute);
		
	}
	
	public UserHomePageObject loginAsUser(String emailUser, String passwordUser) {
		inputToUsername(emailUser);
		inputToPassword(passwordUser);
		return clickToLoginButton();
	} 
	
}
