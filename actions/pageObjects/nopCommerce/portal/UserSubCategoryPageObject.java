package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserSubCategoryPageUI;

public class UserSubCategoryPageObject extends BasePage{
	WebDriver driver;

	public UserSubCategoryPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public UserProductDetailsPageObject clickToSubLevel1ItemProduct(String nameSub1Item) {
		waitForElementVisible(driver, UserSubCategoryPageUI.ITEM_SUB1_PRODUCT_LINK,nameSub1Item);
		clickToElement(driver, UserSubCategoryPageUI.ITEM_SUB1_PRODUCT_LINK,nameSub1Item);
		return PageGeneratorManager.getProductDetailsPage(driver);
	} 
}
