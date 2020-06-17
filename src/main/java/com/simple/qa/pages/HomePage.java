package com.simple.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

		//Used as FF didnt work without this scroll 
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", Pictures);

    	//Actions steps, had to include pause for FF
    	Actions actions = new Actions(driver);
    	actions.moveToElement(Pictures).pause(1000);
    	actions.click().pause(1000).build().perform();
     	TestUtil.waitForLoad(driver);
		return true;
	}
	
	public String validateCartAdded() {
		String myTest = PopUp.getText();
		return myTest;
	}
	
}
