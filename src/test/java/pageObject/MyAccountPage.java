package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends BasePage{

	public MyAccountPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")// My account Page
	WebElement myActPage;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clkLogout;
	
	public boolean myActPageExist()
	{
		try {
			return myActPage.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		clkLogout.click();
	}


	


}
