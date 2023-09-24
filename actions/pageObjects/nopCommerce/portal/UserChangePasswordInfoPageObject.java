package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public UserChangePasswordInfoPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean getChangePasswordHeader() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_HEADER);
		return isElementDisplayed(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_HEADER);
	}

	public void inputForOldPassword(String oldPw) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPw);
		
	}

	public void inputForNewPassword(String newPw) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPw);
		
	}

	public void inputForConfirmPassword(String confirmPw) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmPw);
		
	}

	public void clickToSaveChangePassword() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		
	}

	public boolean getTextSuccessfulMessageChangePassword() {
		waitForElementVisible(driver, UserChangePasswordPageUI.SUCCESSFUL_MESSAGE_CHANGE_PASSWORD);
		return isElementDisplayed(driver, UserChangePasswordPageUI.SUCCESSFUL_MESSAGE_CHANGE_PASSWORD);
	}

	public void clickToCloseSuccessMessageChangePw() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CLOSE_MESSAGE_CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_MESSAGE_CHANGE_PASSWORD_BUTTON);
		
	}
}
