package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	
	//constructor

	public HomePage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
		 PageFactory.initElements(Driver, this); 
	}
	
	//Locate element

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement login;
	
/*	WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
	WebElement login = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")));*/
		
	//action
	
	public void myaccountClick() {
		myAccount.click();
	}
	public void registerClick() {
		register.click();
	}
	
	public void loginClick() {
		login.click();
	}
	
	

}
