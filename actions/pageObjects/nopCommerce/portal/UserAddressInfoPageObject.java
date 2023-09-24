package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressInfoPageUI;

public class UserAddressInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public UserAddressInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressInfoHeaderDisplayed() {
		waitForElementVisible(driver, UserAddressInfoPageUI.ADDRESS_INFO_HEADER);
		return isElementDisplayed(driver, UserAddressInfoPageUI.ADDRESS_INFO_HEADER);
	}

	public void clickToNewAddressButton() {
		waitForElementVisible(driver, UserAddressInfoPageUI.NEW_ADDRESS_BUTTON);
		clickToElement(driver, UserAddressInfoPageUI.NEW_ADDRESS_BUTTON);
		
	}

	public void inputToFirstNameOfAddressInfo(String firstName) {
		sendkeyToElement(driver, UserAddressInfoPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstName);
		
	}

	public void inputToLastNameOfAddressInfo(String lastName) {
		sendkeyToElement(driver, UserAddressInfoPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastName);
		
	}

	public void inputToEmailOfAddressInfo(String emailAddress) {
		sendkeyToElement(driver, UserAddressInfoPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void selectToCountryOfAddressInfo(String country) {
		waitForElementVisible(driver, UserAddressInfoPageUI.COUNTRY_ADDRESS_DROPDOWN);
		selectByVisibleTextItemInDefaultDropdown(driver, UserAddressInfoPageUI.COUNTRY_ADDRESS_DROPDOWN, country);
	}

	public void inputToCityOfAddressInfo(String city) {
		sendkeyToElement(driver, UserAddressInfoPageUI.CITY_ADDRESS_TEXTBOX, city);
		
	}

	public void inputToAddress1OfAddressInfo(String address) {
		sendkeyToElement(driver, UserAddressInfoPageUI.ADDRESS1_TEXTBOX, address);
		
	}

	public void inputToZipPostalCodeOfAddressInfo(String postCode) {
		sendkeyToElement(driver, UserAddressInfoPageUI.ZIP_POSTCODE_ADDRESS_TEXTBOX, postCode);
		
	}

	public void inputToPhoneNumberOfAddressInfo(String phoneNumber) {
		sendkeyToElement(driver, UserAddressInfoPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, phoneNumber);
		
	}

	public void clickToSaveAddressButton() {
		scrollToBottomPage(driver);
		waitForElementVisible(driver, UserAddressInfoPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, UserAddressInfoPageUI.SAVE_ADDRESS_BUTTON);
		
	}

	public boolean isSuccessfulMessageCreatedAddressDisplayed() {
		waitForElementVisible(driver, UserAddressInfoPageUI.SUCCESSFUL_MESSAGE_CREATED_ADDRESS);
		return isElementDisplayed(driver, UserAddressInfoPageUI.SUCCESSFUL_MESSAGE_CREATED_ADDRESS);
	}

	public String getFullNameAddress() {
		waitForElementVisible(driver, UserAddressInfoPageUI.FULL_NAME_ADDRESS_VERIFY);
		return getElementText(driver, UserAddressInfoPageUI.FULL_NAME_ADDRESS_VERIFY);
	}

	public String getEmailAddress() {
		waitForElementVisible(driver, UserAddressInfoPageUI.EMAIL_ADDRESS_VERIFY);
		return getElementText(driver, UserAddressInfoPageUI.EMAIL_ADDRESS_VERIFY);
	}

	public String getPhoneNumberAddress() {
		return getElementText(driver, UserAddressInfoPageUI.PHONE_ADDRESS_VERIFY);
	}

	public String getCountryAddress() {
		return getElementText(driver, UserAddressInfoPageUI.COUNTRY_ADDRESS_VERIFY);
	}
}
