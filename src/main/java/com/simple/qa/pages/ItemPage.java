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

public class ItemPage extends TestBase{
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement AddToCart;

	@FindBy(css= "[id=layer_cart]>div>div>h2")
	WebElement Header;

	@FindBy(css = "[class='icon-ok']")
	WebElement Tick;
	
	@FindBy(css = "[title='Close window']")
	WebElement Cross; 
	
	@FindBy(css = "[title='View my shopping cart']")
	WebElement ShoppingCart; 
	
	@FindBy(css = "[class='cart_block_product_name']")
	WebElement CartBlock;
	
	public ItemPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateItemTitle(){				
		return Header.getText();
	}
	
	public void addToChart () {
		//Wait to be clickable
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(AddToCart));
		
		// Demo of using javascript executor 
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", AddToCart);
		TestUtil.waitForLoad(driver);
		
		//have to wait for popup so include this 
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Tick));
		
	}
	
	public void clickCross() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Cross));
		Cross.click();
	}
	
	
	public String CheckCart() {
		String addedITem = CartBlock.getAttribute("title");
		ShoppingCart.click();
		return addedITem;
	}

}
