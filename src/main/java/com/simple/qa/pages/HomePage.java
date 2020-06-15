package com.simple.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.simple.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = "[title^='Add to cart']")
	WebElement Items;
	
	@FindBy(css = "[class=product-name][title^='Faded']")
	WebElement Pictures;
	
	@FindBy(css ="[id='add_to_cart']")
	WebElement AddtoCart;
	
	@FindBy(css = "[id='layer_cart_product_title']")
	WebElement PopUp;
	
	WebDriverWait wait; 

		
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	public boolean clickOnFirstItem(){
		Actions actions = new Actions(driver);
		
		//Used as FF didnt work without this scroll 
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", Pictures);
		
    	actions.moveToElement(Pictures);
     	actions.click().build().perform();
     	//added as firefox setup doesnt 
//     	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
     	TestUtil.waitForLoad(driver);
		
	

		return true;
	}
	
		public String validateCartAdded() {
		String myTest = PopUp.getText();
		return myTest;
	}
	

	
}
