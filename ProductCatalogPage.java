package com.earnest.web.components;


import org.openqa.grid.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;


public class ProductCatalogPage {
	
	public WebDriver driver;
	
	public ProductCatalogPage(WebDriver driver){
		this.driver=driver;
	}
	
	private String quantityZ="line_item_quantity_zebra";
	private String quantityL="line_item_quantity_lion";
	private String quantityE="line_item_quantity_elephant";
	private String quantityG="line_item_quantity_giraffe";
	private String shipToState="//select[@name='state']";
	private String checkout="//input[@type='submit']";
	
	
	/*@FindBy(how=How.ID, using="line_item_quantity_zebra")
	WebElement quantityZebra;
	
	@FindBy(how=How.ID, using="line_item_quantity_lion")
	WebElement quantityLion;
	
	@FindBy(how=How.ID, using="line_item_quantity_elephant")
	WebElement quantityElephant;
	
	@FindBy(how=How.ID, using="line_item_quantity_giraffe")
	WebElement quantityGiraffe;
	
	@FindBy(how=How.ID, using="//select[@name='state']")
	WebElement shipToState;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	WebElement checkoutButton; */
	
	
	public void enterQuantityZebra(int zebraSocks){
		
	WebElement quantityZebra=driver.findElement(By.id(quantityZ));
	quantityZebra.sendKeys(Integer.toString(zebraSocks));
	
	}
	
	public void enterQuantityLion(int lionSocks){
		WebElement quantityLion=driver.findElement(By.id(quantityL));
		quantityLion.sendKeys(Integer.toString(lionSocks));
	}

	public void enterQuantityElephant(int elephantSocks){
		WebElement quantityElephant=driver.findElement(By.id(quantityE));
		quantityElephant.sendKeys(Integer.toString(elephantSocks));
	}

	public void enterQuantityGiraffe(int giraffeSocks){
		WebElement quantityGiraffe=driver.findElement(By.id(quantityG));
		quantityGiraffe.sendKeys(Integer.toString(giraffeSocks));
	}
	
	public void selectState(String stateName){
		Select select=new Select(driver.findElement(By.xpath(shipToState)));
		select.selectByVisibleText(stateName);	
	}
	
	public void clickOnCheckoutButton(){
		WebElement checkoutButton=driver.findElement(By.xpath(checkout));
		checkoutButton.click();
	}
	
	public void enterQuatity(int qZebra,int qLion, int qElephant,int qGiraffe){
		enterQuantityZebra(qZebra);
		enterQuantityLion(qLion);
		enterQuantityElephant(qElephant);
		enterQuantityGiraffe(qGiraffe);				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
