package pageUIs.nopCommerce.user;

public class UserChangePasswordPageUI {

	public static final String CHANGE_PASSWORD_HEADER = "//div[contains(@class,'change-password-page')]//h1[text()='My account - Change password']";
	public static final String OLD_PASSWORD_TEXTBOX= "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD_TEXTBOX= "//input[@id='NewPassword']";
	public static final String CONFIRM_NEW_PASSWORD_TEXTBOX= "//input[@id='ConfirmNewPassword']";
	public static final String CHANGE_PASSWORD_BUTTON= "//button[contains(@class,'change-password-button')]";
	public static final String SUCCESSFUL_MESSAGE_CHANGE_PASSWORD= "//div[contains(@class,'success')]/p[text()='Password was changed']";
	public static final String CLOSE_MESSAGE_CHANGE_PASSWORD_BUTTON= "//span[@class='close']";
	
}
