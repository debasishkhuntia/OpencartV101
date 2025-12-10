package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC001_accountRegisterTestCase extends BaseTest {
	

	@Test(groups={"Regression","Master"})
	void accountRegisterTest()
	{
		try {
			//Home Page
		logger.info("***TC001_accountRegisterTestCase Started***");
		HomePage hp= new HomePage(Driver);
		hp.myaccountClick();
		
		logger.info("***Click on Register Page***");
		hp.registerClick();
		
		AccountRegistrationPage arp= new AccountRegistrationPage(Driver);
		
		
		arp.setlastname(randomString());
		arp.setfirstname(randomString());
		arp.setemail(randomString()+"@gmail.com");
		
		arp.settelephone(randomNumber());
		
		String psswrd=randomString();
		
		arp.setpassword(psswrd);
		arp.setinputConfirm(psswrd);
		
		arp.setagree();
		arp.setcoclickOnRegisternt();
		//System.out.println(arp.vaidation());
		
		logger.info("***Validation Started***");
		String confmsg=arp.vaidation();
		
		System.out.println("Passowrd is: "+psswrd);
		
		if ("Your Account Has Been Created!".equals(confmsg))
		{
			Assert.assertTrue(true);
			
		}
		else {
			logger.error("Test Failed");
			Assert.assertTrue(false);
		}
		
		
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail("Exception occurred: " + e.getMessage());
		}
		
		logger.info("***Finished***");
		
	}
	


}
