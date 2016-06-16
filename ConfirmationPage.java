package com.earnest.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	public WebDriver driver;
	
	public ConfirmationPage(WebDriver driver){
		this.driver=driver;
	}
	
	private String qZebra="//table[2]/tbody/tr[2]/td[3]";
	private String zebraUPrice="//table[2]/tbody/tr[2]/td[2]";
	private String qLion="//table[2]/tbody/tr[3]/td[3]";
	private String lionUPrice="//table[2]/tbody/tr[3]/td[2]";
	private String qElephant="//table[2]/tbody/tr[4]/td[3]";
	private String elephantUPrice="//table[2]/tbody/tr[4]/td[2]";
	private String qGiraffe="//table[2]/tbody/tr[5]/td[3]";
	private String giraffeUPrice="//table[2]/tbody/tr[5]/td[2]";
	private String subTotal="//table[2]/tbody/tr[7]/td[2]";
	private String taxes="//table[2]/tbody/tr[8]/td[2]";
	private String total="//table[2]/tbody/tr[9]/td[2]";

	
	/*@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[2]/td[3]")
	WebElement quantityZebra;
	
	@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[2]/td[2]")
	WebElement zebraUnitPrice;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[3]/td[3]")
	WebElement private String;
	
	@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[3]/td[2]")
	WebElement lionUnitPrice;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[4]/td[3]")
	WebElement quantityElephant;
	
	@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[4]/td[2]")
	WebElement elephantUnitPrice;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[5]/td[3]")
	WebElement quantityGiraffe;
	
	@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[5]/td[2]")
	WebElement giraffeUnitPrice;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[7]/td[2]")
	WebElement subTotal;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[8]/td[2]")
	WebElement taxes;
	
	@FindBy(how=How.XPATH, using="/table[2]/tbody/tr[9]/td[2]")
	WebElement total;*/
	
	
	public int calculatePriceforZebraSocks(){
		
		WebElement quantityZebra=driver.findElement(By.xpath(qZebra));
		WebElement zebraUnitPrice=driver.findElement(By.xpath(zebraUPrice));
		int unitPriceForZebraSocks=Integer.parseInt(zebraUnitPrice.getText());
		int quantity=Integer.parseInt(quantityZebra.getText());
		return unitPriceForZebraSocks*quantity;
				
	}
	
	public int calculatePriceforLionSocks(){	
		WebElement lionUnitPrice=driver.findElement(By.xpath(lionUPrice));
		WebElement quantityLion =driver.findElement(By.xpath(qLion));
		int unitPriceForlionSocks=Integer.parseInt(lionUnitPrice.getText());
		int quantity=Integer.parseInt(quantityLion.getText());
		return unitPriceForlionSocks*quantity;
				
	}
	
	public int  totalPriceForElephantSocks(){		
		WebElement elephantUnitPrice=driver.findElement(By.xpath(elephantUPrice));
		WebElement quantityElephant =driver.findElement(By.xpath(qElephant));
		int unitPriceForElephantSocks=Integer.parseInt(elephantUnitPrice.getText());
		int quantity=Integer.parseInt(quantityElephant.getText());
		return unitPriceForElephantSocks*quantity;
				
	}
	
	public int  totalPriceForGiraffeSocks(){		
		WebElement giraffUnitPrice=driver.findElement(By.xpath(giraffeUPrice));
		WebElement quantityGiraffe =driver.findElement(By.xpath(qGiraffe));
		int unitPriceForGiraffeSocks=Integer.parseInt(giraffUnitPrice.getText());
		int quantity=Integer.parseInt(quantityGiraffe.getText());
		return unitPriceForGiraffeSocks*quantity;
				
	}
	
	public double calculateSubTotal(){
			
		double totalPriceForZebraSocks=calculatePriceforZebraSocks();
		double totalPriceForLionSocks=calculatePriceforLionSocks();
		double totalPriceForElephantSocks=totalPriceForElephantSocks();
		double totalPriceForGiraffeSocks=totalPriceForGiraffeSocks();
		
		double subTotal=totalPriceForZebraSocks+totalPriceForLionSocks+totalPriceForElephantSocks
				+totalPriceForGiraffeSocks;
		return subTotal;
	}
	
	public double calculateTaxes(String state){
		double subtotal=calculateSubTotal();
		double taxes;
		if(state=="California"){
			taxes=0.08 * subtotal;
		}else if(state=="New York"){
			taxes=0.06 * subtotal;
		}else
			taxes=0.0;
		
		return taxes;
		
	}
	
	public double calculateTotal(){
		double subTotal=calculateSubTotal();
		double tax=calculateTaxes("California");
		double total= subTotal +tax;
		return total;
		
	}
	
	
	
	
}
