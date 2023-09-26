package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductDetailsPageUI;

public class UserProductDetailsPageObject extends BasePage{
	WebDriver driver;

	public UserProductDetailsPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserProductReviewsPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, UserProductDetailsPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductDetailsPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewsPage(driver);
	}
	
}
