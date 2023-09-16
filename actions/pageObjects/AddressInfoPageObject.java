package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressInfoPageObject extends BasePage {

	private WebDriver driver;
	
	public AddressInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
