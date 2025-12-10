package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver Driver) {
		super(Driver);
		// TODO Auto-generated constructor stub
	}


@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtlastname;
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtfirstname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtinputConfirm;
@FindBy(xpath="//input[@value='0']")
WebElement clkvalue;
@FindBy(xpath="//input[@name='agree']")
WebElement btnagree;
@FindBy(xpath="//input[@value='Continue']")
WebElement btnclickOnRegister;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement result;

public void setfirstname(String fname)
   {
	txtfirstname.sendKeys(fname);
	}
public void setlastname(String lname)
   {
	txtlastname.sendKeys(lname);
	}

public void setemail(String emal)
{
	txtemail.sendKeys(emal);
	}

public void settelephone(String telphn)
{
	txttelephone.sendKeys(telphn);
	}
public void setpassword(String paswd)
{
	txtpassword.sendKeys(paswd);
	}
public void setinputConfirm(String iconfrm)
{
	txtinputConfirm.sendKeys(iconfrm);
	}
public void setagree()
{
	btnagree.click();
	}

public void setcoclickOnRegisternt()
{
	btnclickOnRegister.click();
	}

public String vaidation()
{
	try {
		return (result.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
	}

}
