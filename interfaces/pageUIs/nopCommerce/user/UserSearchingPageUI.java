package pageUIs.nopCommerce.user;

public class UserSearchingPageUI {

	public static final String VERIFY_ERROR_MESSAGE_WITH_EMPTY_DATA = "//div[@class='warning' and text()='Search term minimum length is 3 characters']";
//	public static final String VERIFY_ERROR_MESSAGE_WITH_DATA_NOT_EXIST = "//div[@class='no-result' and text()='No products were found that matched your criteria.']";
	public static final String VERIFY_1ITEM_PRODUCT = "//div[@class='item-grid']/div[%s]";
	public static final String VERIFY_PRODUCT_NAME = "//h2[@class='product-title']/a[contains(text(),'Thinkpad X1 Carbon')]";
	public static final String ADVANCED_SEARCH_CHECKBOX = "//div[@class='basic-search']//input[@type='checkbox']";
	public static final String CATEGORIES_DROPDOWN_LIST = "//label[text()='Category:']/parent::div//select";
	public static final String ADVANCED_SEARCH_BUTTON = "//div[@class='buttons']/button[@type='submit']";
	public static final String VERIFY_ERROR_MESSAGE = "//div[@class='no-result' and text()='%s']";
//	public static final String VERIFY_ERROR_MESSAGE_NO_RESULT_FOUND = "//div[@class='no-result' and text()='No products were found that matched your criteria.']";
	public static final String VERIFY_ITEMS_PRODUCT = "//div[@class='item-box']//h2/a[text()='%s']";
	public static final String AUTO_SEARCH_CHECKBOX = "//label[contains(text(),'Automatically ')]/preceding-sibling::input";
	public static final String MANUFACTURE_DROPDOWN_LIST = "//label[text()='Manufacturer:']/parent::div//select";
}
