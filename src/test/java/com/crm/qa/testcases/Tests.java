package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;
import com.simple.qa.base.TestBase;
import com.simple.qa.pages.CartPage;
import com.simple.qa.pages.HomePage;
import com.simple.qa.pages.ItemPage;

public class Tests extends TestBase {
	ItemPage itemPage;
	HomePage homePage;
	TestUtil testUtil;
	CartPage cartPage;
	
	public Tests() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();			
		itemPage = new ItemPage();	
		cartPage = new CartPage();
	}
			
	@Test(priority=1)
	public void clickItemandValidate() {
		//Click on first item and validate 
		homePage.clickOnFirstItem();
		String productName = homePage.pageTitle(); 
		Assert.assertEquals(productName, "Faded Short Sleeve T-shirts - My Store","Invalid item match");				
		
		// Add to cart and validate
		itemPage.addToChart();
		String itemAdded = itemPage.validateItemTitle();
		Assert.assertEquals(itemAdded, "Product successfully added to your shopping cart","Product Not Added");	
		
		//Close popup and validate dropdown cart has added item and go to cart page
		itemPage.clickCross();
		String addedItem = itemPage.CheckCart();
		Assert.assertEquals(addedItem, "Faded Short Sleeve T-shirts","Invalid item added");				
		
		//Validate chart page has the item ordered 
		String cart = cartPage.pageTitle(); 
		Assert.assertEquals(cart, "Order - My Store","CardPage");	
		String check = cartPage.checkItem();
		Assert.assertEquals(check, "Faded Short Sleeve T-shirts","Order Choice Invalid");
		
		//Can add more tests to validate checkout processes 
		//Can update to make more generic and add exactly which item you want to add instead of first item 
		//Can use search bar and find item wanted and add 
		
		//Improve code: 
		//Better reporting and screenshots on errors
		//Ability to run in parallel (command line) 
		
	}
	
	@Test(priority=1)
	public void negclickItemandValidate() {
		//Click on first item and validate 
		homePage.clickOnFirstItem();
		String productName = homePage.pageTitle(); 
		Assert.assertEquals(productName, "Other","Invalid item match");			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
