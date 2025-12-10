package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_loginTestCase  extends BaseTest{
	
	
	@Test(groups={"Master","Sanity"})

	void loginTest()
	{
		//Home Page
		
		try {
		logger.info("***TC002_accountRegisterTestCase Started***");
		
		System.out.println("Driver="+Driver);
		
		HomePage hp= new HomePage(Driver);
		hp.myaccountClick();
		
		hp.loginClick();
		
		logger.info("***Click on Login Page***");
		
		
		
		
		logger.info("***User Data Entry from Configuration file into Login Page***");
		
		LoginPage lp= new LoginPage(Driver);
		
		lp.InEmail(prperties.getProperty("email"));
		
		lp.InPasswd(prperties.getProperty("password"));
		
		lp.clkLogin();
		
		
		MyAccountPage map= new MyAccountPage(Driver);
		
		 boolean mypageExist=map.myActPageExist();
		 
		 map.clickLogout();
		 Assert.assertTrue(mypageExist);//Assert.assertEquals(mypageExist,true,"Test Fail");
		}
		catch(Exception e)
		{
			 e.printStackTrace();   // Debug
			 Assert.fail("FAILED due to: " + e.getClass() + " - " + e.getMessage());
		}
		
		
	}

}
