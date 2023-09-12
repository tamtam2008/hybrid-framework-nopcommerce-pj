package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_02_Login {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String username, password;
	private String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		username = "automationfc" + randomFakeNumber() + ".vn@gmail.com";
		password="123456";
		
	}
	
	@Test
	public void TC_01_Login_Empty_Data() {
		
		homePage.clickToLoginLink();
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Please enter your email");
	} 
	
	@Test
	public void TC_02_Invalid_Email() {
		homePage.clickToLoginLink();
		
		loginPage.inputToUsername("123456@$^^$$");
		loginPage.inputToPassword(password);
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Wrong email");
	} 
	
	@Test
	public void TC_03_Login_With_Email_Not_Exist() {
		homePage.clickToLoginLink();
		
		loginPage.inputToUsername("tam.nguyen1234@mailinator.com");
		loginPage.inputToPassword(password);
		
		loginPage.clickToLoginButton();
		
		System.out.println(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent"));
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(), "Login was unsuccessful. Please correct the errors and try again.No customer account found");
		
	} 
	
	@Test
	//recheck- neet to extends acc created of User_01__Register_Page_Object
	public void TC_04_Login_With_Email_Existed_And_No_Password() {
		//create acc (just temporate)
		homePage.clickToRegisterLink();

		registerPage.clickToGender();
		registerPage.inputToFirstnameTextbox("tam");
		registerPage.inputToLastNameTextbox("nguyen");
		registerPage.inputToEmailTextbox(username);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		sleepInSecond(2);
		
//		if (driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed()) {
//			homePage.clickToLogoutLink();
//		}
		
		
		//login
		homePage.clickToLoginLink();
		sleepInSecond(1);
		loginPage.inputToUsername(username);
		sleepInSecond(1);
		loginPage.clickToLoginButton();
		sleepInSecond(2);

		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(), "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
	} 
	
	@Test
	public void TC_05_Login_With_Email_Existed_And_Wrong_Password() {

		homePage.clickToLoginLink();
		
		loginPage.inputToUsername(username);
		loginPage.inputToPassword("123459");
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getAttributeUnsuccessLoginErrorMessage("textContent").trim(), "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");
		
	} 
	
	@Test
	public void TC_06_Login_With_Email_Existed_And_Correct_Password() {
		
		homePage.clickToLoginLink();
		
		loginPage.inputToUsername(username);
		loginPage.inputToPassword(password);
		
		loginPage.clickToLoginButton();
		sleepInSecond(3);

		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
	} 
	
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
