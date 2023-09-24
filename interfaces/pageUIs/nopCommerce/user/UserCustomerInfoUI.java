package pageUIs.nopCommerce.user;

public class UserCustomerInfoUI {

	public static final String CUSTOMER_INFO_HEADER = "//div[@class='page-title']/h1[text()='My account - Customer info']";
	public static final String GENDER_CHECKBOX = "//input[@id='gender-female']";
	public static final String FIRST_NAME_FIELD = "//input[@id='FirstName']";
	public static final String LAST_NAME_FIELD = "//input[@id='LastName']";
	public static final String DAY_OF_BIRTH = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTH = "//select[@name='DateOfBirthMonth']";
	public static final String VERIFY_MONTH_OF_BIRTH = "//select[@name='DateOfBirthMonth']/option[text()='September']";
	public static final String YEAR_OF_BIRTH = "//select[@name='DateOfBirthYear']";
	public static final String VERIFY_YEAR_OF_BIRTH = "//select[@name='DateOfBirthYear']/option[text()='2000']";
	public static final String EMAIL_FIELD = "//input[@id='Email']";
	public static final String COMPANY_NAME_FIELD = "//input[@id='Company']";
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
	public static final String SUCCESS_MESSAGE_UPDATED = "//p[text()='The customer info has been updated successfully.']";
}
