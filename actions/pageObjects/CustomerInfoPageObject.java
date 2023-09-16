package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoUI;

public class CustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isCustomerInfoIsDisplayed() {
		waitForElementVisible(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
	}

	public void clickToGenderCheckboxCustomerInfo() {
		clickToElement(driver, CustomerInfoUI.GENDER_CHECKBOX);
		
	}

	public void inputToFirstNameCustomerInfo(String firstName) {
		sendkeyToElement(driver, CustomerInfoUI.FIRST_NAME_FIELD, firstName);
		
	}

	public void inputToLastNameCustomerInfo(String lastName) {
		sendkeyToElement(driver, CustomerInfoUI.LAST_NAME_FIELD, lastName);
		
	}

	public void selectToDayOfBirthCustomerInfo(String dayOfBirth) {
		waitForElementVisible(driver, CustomerInfoUI.DAY_OF_BIRTH);
		selectItemInDefaultDropdown(driver, CustomerInfoUI.DAY_OF_BIRTH, dayOfBirth);
		
	}

	public void selectToMonthOfBirthCustomerInfo(String monthOfBirth) {
		waitForElementVisible(driver, CustomerInfoUI.MONTH_OF_BIRTH);
		selectByVisibleTextItemInDefaultDropdown(driver, CustomerInfoUI.MONTH_OF_BIRTH, monthOfBirth);
		
	}

	public void selectToYearOfBirthCustomerInfo(String yearOfBirth) {
		selectByVisibleTextItemInDefaultDropdown(driver, CustomerInfoUI.YEAR_OF_BIRTH, yearOfBirth);
		
	}

	public void inputToEmailCustomerInfo(String email) {
		sendkeyToElement(driver, CustomerInfoUI.EMAIL_FIELD, email);
		
	}

	public void inputToCompanyNameCustomerInfo(String companyName) {
		sendkeyToElement(driver, CustomerInfoUI.COMPANY_NAME_FIELD, companyName);
		
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, CustomerInfoUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoUI.SAVE_BUTTON);
		
	}

	public boolean isSuccessMessageDisplay() {
		waitForElementVisible(driver, CustomerInfoUI.SUCCESS_MESSAGE_UPDATED);
		return isElementDisplayed(driver,CustomerInfoUI.SUCCESS_MESSAGE_UPDATED);
	}
	
}
