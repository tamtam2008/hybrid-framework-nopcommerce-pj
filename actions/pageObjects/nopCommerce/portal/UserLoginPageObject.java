package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getUsernameErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.USERNAME_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.USERNAME_ERROR_MESSAGE);
	}

	public void inputToUsername(String username) {
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
		
	}

	public void inputToPassword(String password) {
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public String getAttributeUnsuccessLoginErrorMessage(String textAttribute) {
		waitForElementVisible(driver, LoginPageUI.UNSUCESS_LOGIN_ERROR_MESSAGE);
		return getElementAttribute(driver, LoginPageUI.UNSUCESS_LOGIN_ERROR_MESSAGE, textAttribute);
		
	}
	
	public UserHomePageObject loginAsUser(String emailUser, String passwordUser) {
		inputToUsername(emailUser);
		inputToPassword(passwordUser);
		return clickToLoginButton();
	} 
	
}
