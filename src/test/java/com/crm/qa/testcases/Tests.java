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
		homePage.clickOnFirstItem();
		String productName = homePage.pageTitle(); 
		Assert.assertEquals(productName, "Faded Short Sleeve T-shirts - My Store","Invalid item match");				
		itemPage.addToChart();
		String itemAdded = itemPage.validateItemTitle();
		Assert.assertEquals(itemAdded, "Product successfully added to your shopping cart","Product Not Added");	
		itemPage.clickCross();
		String addedItem = itemPage.CheckCart();
		Assert.assertEquals(addedItem, "Faded Short Sleeve T-shirts","Invalid item added");				
		String cart = cartPage.pageTitle(); 
		Assert.assertEquals(cart, "Order - My Store","CardPage");	
		String check = cartPage.checkItem();
		Assert.assertEquals(check, "Faded Short Sleeve T-shirts","Order Choice Invalid");			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
