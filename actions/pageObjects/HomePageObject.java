package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}

//	public String getTitleHomepage() {
//		return getTitle(driver);
//	}



}
