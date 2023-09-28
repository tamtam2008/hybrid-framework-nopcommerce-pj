package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserSearchingPageObject;

public class User_04_Searching_And_Advanced_Search extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataNotExist = "Macbook Pro 2050";
		productName1 = "Lenovo";
		productName2 = "ThinkPad X1 Carbon";
		parentCategories = "Apple Macbook Pro";
		categoryDropList = "Computers";
	}

	@Test
	public void Search_01_Empty_Data() {
		log.info("Search_Step01: Enter empty data in the searching bar >> enter");
		homePage.enterDataOnSearchingBar(driver, " ");
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		log.info("Search_Step02: Verify error message");
		verifyTrue(userSearchingPage.isErrorMessageWithEmptyDataDisplayed());
	}

	@Test
	public void Search_02_Data_Not_Exist() {
		PageGeneratorManager.getSearchingPage(driver);

		log.info("Search_Step01: Enter data not exist on searching >> enter");
		userSearchingPage.enterDataOnSearchingBar(driver, dataNotExist);
		userSearchingPage.clickSearchButtonOnSearchingBar(driver);

		log.info("Search_Step02: Verify error message");
		Assert.assertTrue(userSearchingPage.isErrorMessageDisplayed("...No products were found that matched your criteria."));

	}

	@Test
	public void Search_03_With_Product_Name_01() {
		userSearchingPage.refresh(driver);

		log.info("Search_Step01: Enter product name >> enter");
		userSearchingPage.enterDataOnSearchingBar(driver, productName1);
		userSearchingPage.clickSearchButtonOnSearchingBar(driver);

		log.info("Search_Step02: Verify the item product displayed");
		userSearchingPage.scrollToBottomPage(driver);
		verifyTrue(userSearchingPage.isItemsProductDisplayed("Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(userSearchingPage.isItemsProductDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_04_With_Product_Name_02() {
		userSearchingPage.refresh(driver);

		log.info("Search_Step01: Enter product name >> enter");
		userSearchingPage.enterDataOnSearchingBar(driver, productName2);
		userSearchingPage.clickSearchButtonOnSearchingBar(driver);

		log.info("Search_Step02: Verify the item product displayed");
		userSearchingPage.scrollToBottomPage(driver);
		verifyTrue(userSearchingPage.isItemProductDisplayed("1"));
		verifyTrue(userSearchingPage.isProductNameDisplayed());
	}

	@Test
	public void Advanced_Search_05_With_Parent_Categories() {
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Advanced Search_Step01: Enter parent categories >> enter");
		homePage.enterDataOnSearchingBar(driver, parentCategories);
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		log.info("Advanced Search_Step02: Tick Advanced checkbox and select categories dropdown");
		userSearchingPage.clickToAdvancedSearchCheckbox();
		userSearchingPage.selectToCategoryInDropdownList(categoryDropList);
		log.info("Advanced Search_Step03: Click advanced search");
		userSearchingPage.clickToSearchAdvancedButton();
		log.info("Advanced Search_Step04: Verify message no result found");
		verifyTrue(userSearchingPage.isErrorMessageDisplayed("No products were found that matched your criteria."));

	}

	@Test
	public void Advanced_Search_06_With_Sub_Categories() {
		log.info("Advanced Search_Step01: Enter parent categories >> enter");
		homePage.enterDataOnSearchingBar(driver, parentCategories);
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		log.info("Advanced Search_Step02: Tick Advanced checkbox and select categories dropdown");
		userSearchingPage.clickToAdvancedSearchCheckbox();
		userSearchingPage.selectToCategoryInDropdownList(categoryDropList);
		userSearchingPage.clickToAutomationSearchCheckbox();
		log.info("Advanced Search_Step03: Click advanced search");
		userSearchingPage.clickToSearchAdvancedButton();
		log.info("Advanced Search_Step04: Verify message no result found");
		verifyTrue(userSearchingPage.isItemsProductDisplayed("Apple MacBook Pro 13-inch"));

	}

	@Test
	public void Advanced_Search_07_With_Incorrect_Manufacturer() {
		log.info("Advanced Search_Step01: Enter parent categories >> enter");
		homePage.enterDataOnSearchingBar(driver, parentCategories);
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		log.info("Advanced Search_Step02: Tick Advanced checkbox and select categories, incorrect manufacture");
		userSearchingPage.clickToAdvancedSearchCheckbox();
		userSearchingPage.selectToCategoryInDropdownList(categoryDropList);
		userSearchingPage.clickToAutomationSearchCheckbox();
		userSearchingPage.selectToManufacturerDropdownList("HP");
		log.info("Advanced Search_Step03: Click advanced search");
		userSearchingPage.clickToSearchAdvancedButton();
		log.info("Advanced Search_Step04: Verify message no result found");
		verifyTrue(userSearchingPage.isErrorMessageDisplayed("No products were found that matched your criteria."));
	}

	@Test
	public void Advanced_Search_08_With_Correct_Manufacturer() {
		log.info("Advanced Search_Step01: Enter parent categories >> enter");
		homePage.enterDataOnSearchingBar(driver, parentCategories);
		userSearchingPage = homePage.clickSearchButtonOnSearchingBar(driver);

		log.info("Advanced Search_Step02: Tick Advanced checkbox and select categories, correct manufacture");
		userSearchingPage.clickToAdvancedSearchCheckbox();
		userSearchingPage.selectToCategoryInDropdownList(categoryDropList);
		userSearchingPage.clickToAutomationSearchCheckbox();
		userSearchingPage.selectToManufacturerDropdownList("Apple");
		log.info("Advanced Search_Step03: Click advanced search");
		userSearchingPage.clickToSearchAdvancedButton();
		log.info("Advanced Search_Step04: Verify item displayed");
		verifyTrue(userSearchingPage.isItemsProductDisplayed("Apple MacBook Pro 13-inch"));
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	private UserHomePageObject homePage;
	private UserSearchingPageObject userSearchingPage;
	private String dataNotExist, productName1, productName2, parentCategories, categoryDropList;
	
}
