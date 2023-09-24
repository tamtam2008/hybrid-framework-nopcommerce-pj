package pageUIs.nopCommerce.user;

public class UserProductReviewsPageUI {

	public static final String INPUT_TITLE_REVIEW_TEXTBOX = "css=input#AddProductReview_Title";
	public static final String INPUT_DESCRIPTION_REVIEW_TEXTBOX = "css=textarea#AddProductReview_ReviewText";
	public static final String INPUT_RATING_CHECKBOX = "//div[@class='rating-options']/input[%s]";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[@name='add-review']";
	public static final String SUCCESS_MESSAGE_REVIEW = "//div[@class='result']";
	public static final String VERIFY_TITLE_REVIEW = "//div[@class='product-review-item'][1]//strong";
	public static final String VERIFY_DESCRIPTION_REVIEW = "//div[@class='product-review-item'][1]//div[@class='text-body']";
}
