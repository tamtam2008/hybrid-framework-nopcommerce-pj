package pageUIs.nopCommerce.user;

public class BasePageUI {

	public static final String ADDRESS_LINK = "//div[contains(@class, 'account-navigation')]//a[text()='Addresses']";
	public static final String CHANGE_PASSWORD_LINK = "//li[contains(@class, 'change-password')]//a[text()='Change password']";
	public static final String CUSTOMER_INFO_LINK = "//li[contains(@class, 'customer-info')]//a[text()='Customer info']";
	public static final String PRODUCT_REVIEW_LINK = "//li[contains(@class, 'customer-reviews')]//a[text()='My product reviews']";
	
	public static final String LOGOUT_LINK_USER = "//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN = "//div[@id='navbarText']//a[text()='Logout']";
	
	public static final String SEARCH_FIELD = "css=input#small-searchterms";
	public static final String SEARCH_BUTTON_ON_SEARCHING_BAR = "//form[@id='small-search-box-form']//button[@type='submit']";
	
	public static final String NAME_MENU_HEADER= "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String NAME_SUB_MENU_HEADER= "//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[contains(text(),'%s')]";
	
	//Pattern Object
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "//div[contains(@class, 'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID= "";
	public static final String DYNAMIC_BUTTON_BY_TEXT= "";
	public static final String DYNAMIC_DROPDOWN_BY_NAME= "";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL= "";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL= "";
	
}
