package com.earnest.web.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.earnest.web.components.ConfirmationPage;
import com.earnest.web.components.ProductCatalogPage;

public class AcceptanceTests {
	public WebDriver driver;
	
	
	
	@Before
	public void init(){
	  driver= new FirefoxDriver();
	  driver.get("https://jungle-socks.herokuapp.com/");
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  
	}
	
	//Verifying subtotal
	@Test
	public void verifySubTotalTest(){
		ProductCatalogPage pcp=new ProductCatalogPage(driver);
		pcp.enterQuatity(1,1,1,1);
		pcp.selectState("California");
		pcp.clickOnCheckoutButton();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		//confirmationPage.calculateTotal();
		Assert.assertEquals(85.00, confirmationPage.calculateSubTotal());
		
	}
	
	//verifying taxes 
	@Test
	public void verifyTaxesTest(){
		ProductCatalogPage pcp=new ProductCatalogPage(driver);
		pcp.enterQuatity(1,1,1,1);
		pcp.selectState("California");
		pcp.clickOnCheckoutButton();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		//confirmationPage.calculateTotal();
		Assert.assertEquals(6.80, confirmationPage.calculateTaxes("California"));	
	}
	
	//Verifying total
		@Test
		public void verifyTotalTest(){
			ProductCatalogPage pcp=new ProductCatalogPage(driver);
			pcp.enterQuatity(1,1,1,1);
			pcp.selectState("California");
			pcp.clickOnCheckoutButton();
			ConfirmationPage confirmationPage=new ConfirmationPage(driver);
			Assert.assertEquals(91.8,confirmationPage.calculateTotal());
	}
}