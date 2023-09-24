package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserProductListPagesObject;
import pageUIs.nopCommerce.user.BasePageUI;

public class User_05_Sort_Display_Paging extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		nameMenu = "Computer";
		subCategoryMenu = "Notebooks";
	}

	@Test
	public void Sort_01_With_Name_From_A_To_Z() {
		log.info("Pre-condition: Sort-Step01: Click any sub-category");
		homePage.hoverMenuHeader(driver, nameMenu);
		productListPagesPLP = homePage.clickSubCategoryMenu(driver, subCategoryMenu);
		
		log.info("Sort-Step02: Click any sub-category");
		productListPagesPLP.selectValueOfSortBy("Name: A to Z");
		sleepInSecond(2);
		
		log.info("Sort-Step03: Verify sort by A -Z");
//		System.out.println(productListPagesPLP.getListItemsProduct().size());
	}


	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
	private UserHomePageObject homePage;
	private UserProductListPagesObject productListPagesPLP;
	private String nameMenu, subCategoryMenu;

}
