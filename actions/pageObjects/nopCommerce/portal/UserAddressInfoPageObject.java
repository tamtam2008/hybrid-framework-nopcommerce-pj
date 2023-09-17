package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressInfoPageUI;

public class UserAddressInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public UserAddressInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddressInfoHeaderDisplayed() {
		waitForElementVisible(driver, AddressInfoPageUI.ADDRESS_INFO_HEADER);
		return isElementDisplayed(driver, AddressInfoPageUI.ADDRESS_INFO_HEADER);
	}

	public void clickToNewAddressButton() {
		waitForElementVisible(driver, AddressInfoPageUI.NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressInfoPageUI.NEW_ADDRESS_BUTTON);
		
	}

	public void inputToFirstNameOfAddressInfo(String firstName) {
		sendkeyToElement(driver, AddressInfoPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstName);
		
	}

	public void inputToLastNameOfAddressInfo(String lastName) {
		sendkeyToElement(driver, AddressInfoPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastName);
		
	}

	public void inputToEmailOfAddressInfo(String emailAddress) {
		sendkeyToElement(driver, AddressInfoPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void selectToCountryOfAddressInfo(String country) {
		waitForElementVisible(driver, AddressInfoPageUI.COUNTRY_ADDRESS_DROPDOWN);
		selectByVisibleTextItemInDefaultDropdown(driver, AddressInfoPageUI.COUNTRY_ADDRESS_DROPDOWN, country);
	}

	public void inputToCityOfAddressInfo(String city) {
		sendkeyToElement(driver, AddressInfoPageUI.CITY_ADDRESS_TEXTBOX, city);
		
	}

	public void inputToAddress1OfAddressInfo(String address) {
		sendkeyToElement(driver, AddressInfoPageUI.ADDRESS1_TEXTBOX, address);
		
	}

	public void inputToZipPostalCodeOfAddressInfo(String postCode) {
		sendkeyToElement(driver, AddressInfoPageUI.ZIP_POSTCODE_ADDRESS_TEXTBOX, postCode);
		
	}

	public void inputToPhoneNumberOfAddressInfo(String phoneNumber) {
		sendkeyToElement(driver, AddressInfoPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, phoneNumber);
		
	}

	public void clickToSaveAddressButton() {
		scrollToBottomPage(driver);
		waitForElementVisible(driver, AddressInfoPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressInfoPageUI.SAVE_ADDRESS_BUTTON);
		
	}

	public boolean isSuccessfulMessageCreatedAddressDisplayed() {
		waitForElementVisible(driver, AddressInfoPageUI.SUCCESSFUL_MESSAGE_CREATED_ADDRESS);
		return isElementDisplayed(driver, AddressInfoPageUI.SUCCESSFUL_MESSAGE_CREATED_ADDRESS);
	}

	public String getFullNameAddress() {
		waitForElementVisible(driver, AddressInfoPageUI.FULL_NAME_ADDRESS_VERIFY);
		return getElementText(driver, AddressInfoPageUI.FULL_NAME_ADDRESS_VERIFY);
	}

	public String getEmailAddress() {
		waitForElementVisible(driver, AddressInfoPageUI.EMAIL_ADDRESS_VERIFY);
		return getElementText(driver, AddressInfoPageUI.EMAIL_ADDRESS_VERIFY);
	}

	public String getPhoneNumberAddress() {
		return getElementText(driver, AddressInfoPageUI.PHONE_ADDRESS_VERIFY);
	}

	public String getCountryAddress() {
		return getElementText(driver, AddressInfoPageUI.COUNTRY_ADDRESS_VERIFY);
	}
}
