package com.simple.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simple.qa.base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(css = "[id='layer_cart_product_title']")
	WebElement PopUp;
	
	@FindBy(css = "[class='cart_item last_item first_item address_0 odd']>[class='cart_description']>p>a")
	WebElement LastIn;
	
	// Initializing the Page Object:
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String pageTitle(){
		return driver.getTitle();
	}
	
	public String checkItem () {
		return LastIn.getText();		
	}
	
	
}

