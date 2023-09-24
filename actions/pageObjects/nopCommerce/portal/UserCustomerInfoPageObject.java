package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCustomerInfoUI;

public class UserCustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isCustomerInfoIsDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
	}

	public void clickToGenderCheckboxCustomerInfo() {
		clickToElement(driver, UserCustomerInfoUI.GENDER_CHECKBOX);
		
	}

	public void inputToFirstNameCustomerInfo(String firstName) {
		sendkeyToElement(driver, UserCustomerInfoUI.FIRST_NAME_FIELD, firstName);
		
	}

	public void inputToLastNameCustomerInfo(String lastName) {
		sendkeyToElement(driver, UserCustomerInfoUI.LAST_NAME_FIELD, lastName);
		
	}

	public void selectToDayOfBirthCustomerInfo(String dayOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoUI.DAY_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoUI.DAY_OF_BIRTH, dayOfBirth);
		
	}

	public void selectToMonthOfBirthCustomerInfo(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoUI.MONTH_OF_BIRTH);
		selectByVisibleTextItemInDefaultDropdown(driver, UserCustomerInfoUI.MONTH_OF_BIRTH, monthOfBirth);
		
	}

	public void selectToYearOfBirthCustomerInfo(String yearOfBirth) {
		selectByVisibleTextItemInDefaultDropdown(driver, UserCustomerInfoUI.YEAR_OF_BIRTH, yearOfBirth);
		
	}

	public void inputToEmailCustomerInfo(String email) {
		sendkeyToElement(driver, UserCustomerInfoUI.EMAIL_FIELD, email);
		
	}

	public void inputToCompanyNameCustomerInfo(String companyName) {
		sendkeyToElement(driver, UserCustomerInfoUI.COMPANY_NAME_FIELD, companyName);
		
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, UserCustomerInfoUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoUI.SAVE_BUTTON);
		
	}

	public boolean isSuccessMessageDisplay() {
		waitForElementVisible(driver, UserCustomerInfoUI.SUCCESS_MESSAGE_UPDATED);
		return isElementDisplayed(driver,UserCustomerInfoUI.SUCCESS_MESSAGE_UPDATED);
	}

	public boolean isGenderCheckboxSelected() {
		waitForElementVisible(driver, UserCustomerInfoUI.GENDER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInfoUI.GENDER_CHECKBOX);
	}

	public String getFirstNameCustomerInfo(String value) {
		waitForElementVisible(driver, UserCustomerInfoUI.FIRST_NAME_FIELD);
		return getElementAttribute(driver, UserCustomerInfoUI.FIRST_NAME_FIELD, "value");
	}

	public String getLastNameCustomerInfo(String value) {
		waitForElementVisible(driver, UserCustomerInfoUI.LAST_NAME_FIELD);
		return getElementAttribute(driver, UserCustomerInfoUI.LAST_NAME_FIELD, "value");
	}

	public String getDayOfBirthCustomerInfo(String value) {
		waitForElementVisible(driver, UserCustomerInfoUI.DAY_OF_BIRTH);
		return getElementAttribute(driver, UserCustomerInfoUI.DAY_OF_BIRTH, "value");
	}

	public Boolean isMonthOfBirthCustomerInfoDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoUI.VERIFY_MONTH_OF_BIRTH);
		return isElementDisplayed(driver, UserCustomerInfoUI.VERIFY_MONTH_OF_BIRTH);
	}

	public Boolean isYearOfBirthCustomerInfoDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoUI.VERIFY_YEAR_OF_BIRTH);
		return isElementDisplayed(driver, UserCustomerInfoUI.VERIFY_YEAR_OF_BIRTH);
	}

	public String getEmailCustomerInfo(String value) {
		waitForElementVisible(driver, UserCustomerInfoUI.EMAIL_FIELD);
		return getElementAttribute(driver, UserCustomerInfoUI.EMAIL_FIELD, "value");
	}

	public String getCompanyNameCustomerInfo(String value) {
		waitForElementVisible(driver, UserCustomerInfoUI.COMPANY_NAME_FIELD);
		return getElementAttribute(driver, UserCustomerInfoUI.COMPANY_NAME_FIELD, "value");
	}
	
}
