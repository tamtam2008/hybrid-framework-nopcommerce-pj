package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
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
	
	
}
