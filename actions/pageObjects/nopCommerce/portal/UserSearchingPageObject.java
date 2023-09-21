package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.UserSearchingPageUI;

public class UserSearchingPageObject extends BasePage {

	WebDriver driver;

	public UserSearchingPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isErrorMessageWithEmptyDataDisplayed() {
		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE_WITH_EMPTY_DATA);
		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE_WITH_EMPTY_DATA);
	}

	public boolean isErrorMessageDisplayed(String textErrorMessage) {
		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE,textErrorMessage);
		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE,textErrorMessage);
	}

	public boolean isItemProductDisplayed(String itemNoProduct) {
		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_1ITEM_PRODUCT,itemNoProduct);
		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_1ITEM_PRODUCT,itemNoProduct);
	}

	public boolean isProductNameDisplayed() {
		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_PRODUCT_NAME);
		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_PRODUCT_NAME);
	}

	public void clickToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, UserSearchingPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElement(driver, UserSearchingPageUI.ADVANCED_SEARCH_CHECKBOX);
		
	}

	public void selectToCategoryInDropdownList(String valueCategory) {
		waitForElementClickable(driver, UserSearchingPageUI.CATEGORIES_DROPDOWN_LIST);
		selectByVisibleTextItemInDefaultDropdown(driver, UserSearchingPageUI.CATEGORIES_DROPDOWN_LIST, valueCategory);
		
	}

	public void clickToSearchAdvancedButton() {
		waitForElementClickable(driver, UserSearchingPageUI.ADVANCED_SEARCH_BUTTON);
		clickToElement(driver, UserSearchingPageUI.ADVANCED_SEARCH_BUTTON);
		
	}

//	public boolean isErrorMessageNoResultFoundDisplayed() {
//		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE_NO_RESULT_FOUND);
//		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_ERROR_MESSAGE_NO_RESULT_FOUND);
//	}

	public boolean isItemsProductDisplayed(String nameItems) {
		waitForElementVisible(driver, UserSearchingPageUI.VERIFY_ITEMS_PRODUCT, nameItems);
		return isElementDisplayed(driver, UserSearchingPageUI.VERIFY_ITEMS_PRODUCT, nameItems);
	}

	public void clickToAutomationSearchCheckbox() {
		waitForElementClickable(driver, UserSearchingPageUI.AUTO_SEARCH_CHECKBOX);
		clickToElement(driver, UserSearchingPageUI.AUTO_SEARCH_CHECKBOX);
	}

	public void selectToManufacturerDropdownList(String valueManufacture) {
		waitForElementClickable(driver, UserSearchingPageUI.MANUFACTURE_DROPDOWN_LIST);
		selectByVisibleTextItemInDefaultDropdown(driver, UserSearchingPageUI.MANUFACTURE_DROPDOWN_LIST, valueManufacture);
		
	}
	
	
}
