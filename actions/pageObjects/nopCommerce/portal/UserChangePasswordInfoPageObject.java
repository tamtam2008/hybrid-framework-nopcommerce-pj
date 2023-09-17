package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ChangePasswordPageUI;

public class UserChangePasswordInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public UserChangePasswordInfoPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean getChangePasswordHeader() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_HEADER);
		return isElementDisplayed(driver, ChangePasswordPageUI.CHANGE_PASSWORD_HEADER);
	}

	public void inputForOldPassword(String oldPw) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPw);
		
	}

	public void inputForNewPassword(String newPw) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPw);
		
	}

	public void inputForConfirmPassword(String confirmPw) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmPw);
		
	}

	public void clickToSaveChangePassword() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		
	}

	public boolean getTextSuccessfulMessageChangePassword() {
		waitForElementVisible(driver, ChangePasswordPageUI.SUCCESSFUL_MESSAGE_CHANGE_PASSWORD);
		return isElementDisplayed(driver, ChangePasswordPageUI.SUCCESSFUL_MESSAGE_CHANGE_PASSWORD);
	}

	public void clickToCloseSuccessMessageChangePw() {
		waitForElementVisible(driver, ChangePasswordPageUI.CLOSE_MESSAGE_CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_MESSAGE_CHANGE_PASSWORD_BUTTON);
		
	}
}
