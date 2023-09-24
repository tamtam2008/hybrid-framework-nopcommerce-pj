package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUI;
import pageUIs.nopCommerce.user.UserProductReviewsPageUI;

public class UserProductReviewsPageObject extends BasePage{

	WebDriver driver;

	public UserProductReviewsPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToTitleReview(String textTitle) {
		waitForElementVisible(driver,UserProductReviewsPageUI.INPUT_TITLE_REVIEW_TEXTBOX, textTitle);
		sendkeyToElement(driver, UserProductReviewsPageUI.INPUT_TITLE_REVIEW_TEXTBOX, textTitle);
	}

	public void enterToDescriptionReview(String textDescription) {
		waitForElementVisible(driver, UserProductReviewsPageUI.INPUT_DESCRIPTION_REVIEW_TEXTBOX,textDescription);
		sendkeyToElement(driver, UserProductReviewsPageUI.INPUT_DESCRIPTION_REVIEW_TEXTBOX, textDescription);
	}

	public void clickToRatingReview(String value) {
		waitForElementClickable(driver, UserProductReviewsPageUI.INPUT_RATING_CHECKBOX, value);
		clickToElement(driver, UserProductReviewsPageUI.INPUT_RATING_CHECKBOX, value);
	}

	public void clickToReviewButton() {
		waitForElementClickable(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public String verifySuccessMessage() {
		waitForElementVisible(driver, UserProductReviewsPageUI.SUCCESS_MESSAGE_REVIEW);
		return getElementText(driver, UserProductReviewsPageUI.SUCCESS_MESSAGE_REVIEW).trim();
	}

	public String verifyTitleReview() {
		waitForElementVisible(driver, UserProductReviewsPageUI.VERIFY_TITLE_REVIEW);
		return getElementText(driver, UserProductReviewsPageUI.VERIFY_TITLE_REVIEW).trim();
	}

	public String verifyDescriptionReview() {
		waitForElementVisible(driver, UserProductReviewsPageUI.VERIFY_DESCRIPTION_REVIEW);
		return getElementText(driver, UserProductReviewsPageUI.VERIFY_DESCRIPTION_REVIEW).trim();
	}

	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
