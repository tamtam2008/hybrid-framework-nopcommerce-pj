package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.ProductReviewsPageUI;

public class UserProductReviewsPageObject extends BasePage{

	WebDriver driver;

	public UserProductReviewsPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToTitleReview(String textTitle) {
		waitForElementVisible(driver,ProductReviewsPageUI.INPUT_TITLE_REVIEW_TEXTBOX, textTitle);
		sendkeyToElement(driver, ProductReviewsPageUI.INPUT_TITLE_REVIEW_TEXTBOX, textTitle);
	}

	public void enterToDescriptionReview(String textDescription) {
		waitForElementVisible(driver, ProductReviewsPageUI.INPUT_DESCRIPTION_REVIEW_TEXTBOX,textDescription);
		sendkeyToElement(driver, ProductReviewsPageUI.INPUT_DESCRIPTION_REVIEW_TEXTBOX, textDescription);
	}

	public void clickToRatingReview(String value) {
		waitForElementClickable(driver, ProductReviewsPageUI.INPUT_RATING_CHECKBOX, value);
		clickToElement(driver, ProductReviewsPageUI.INPUT_RATING_CHECKBOX, value);
	}

	public void clickToReviewButton() {
		waitForElementClickable(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public String verifySuccessMessage() {
		waitForElementVisible(driver, ProductReviewsPageUI.SUCCESS_MESSAGE_REVIEW);
		return getElementText(driver, ProductReviewsPageUI.SUCCESS_MESSAGE_REVIEW).trim();
	}

	public String verifyTitleReview() {
		waitForElementVisible(driver, ProductReviewsPageUI.VERIFY_TITLE_REVIEW);
		return getElementText(driver, ProductReviewsPageUI.VERIFY_TITLE_REVIEW).trim();
	}

	public String verifyDescriptionReview() {
		waitForElementVisible(driver, ProductReviewsPageUI.VERIFY_DESCRIPTION_REVIEW);
		return getElementText(driver, ProductReviewsPageUI.VERIFY_DESCRIPTION_REVIEW).trim();
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
