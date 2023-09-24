package pageObjects.nopCommerce.portal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserProductListPagesUI;

public class UserProductListPagesObject extends BasePage {

	WebDriver driver;

	public UserProductListPagesObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void selectValueOfSortBy(String valueSortBy) {
		waitForElementClickable(driver, UserProductListPagesUI.SORT_BY, valueSortBy);
		selectByVisibleTextItemInDefaultDropdown(driver, UserProductListPagesUI.SORT_BY, valueSortBy);

	}

}
