package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class LoginPage  extends BasePage{

	public LoginPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//input[@id='input-email']")
WebElement txtInEmail;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtInPassword;
@FindBy(xpath="//input[@value='Login']")
WebElement clkLoginBtn;

public void InEmail(String email)
{
	txtInEmail.sendKeys(email);
}
public void InPasswd(String paswd)
{
	txtInPassword.sendKeys(paswd);
}

public void clkLogin()
{
	clkLoginBtn.click();
}

}
