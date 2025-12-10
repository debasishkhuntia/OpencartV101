package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_loginDDT extends BaseTest{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	
	public void validTest(String email,String pwd,String exp) throws InterruptedException {
		
		try {
	logger.info("***TC003_loginDDT Started***");
	HomePage hp= new HomePage(Driver);
	hp.myaccountClick();
	
	hp.loginClick();
	
	logger.info("***Click on Login Page***");
	
	
	
	
	logger.info("***User Data Entry from Configuration file into Login Page***");
	
	LoginPage lp= new LoginPage(Driver);
	
	lp.InEmail(email);
	
	lp.InPasswd(pwd);
	
	lp.clkLogin();
	
	MyAccountPage map= new MyAccountPage(Driver);
	
	 boolean mypageExist=map.myActPageExist();
	 
	 /*Data is Valid - login success test pass logout
	  *                login failed -- test fail
	  * 
	  *                
	  * Data is Invalid -login pass    test pass logout
	  *                                
	  *                  login failed test pass
	  * 
	  */
	 
	 if(exp.equalsIgnoreCase("Valid"))
	 {
		 if(mypageExist == true)
		 {
			 map.clickLogout();
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
		 
	 }
	 if(exp.equalsIgnoreCase("Invalid"))
	 {
		 if(mypageExist == true)
		 {
			 map.clickLogout();
			 Assert.assertTrue(false);
		 }
		 else
		 {
			 Assert.assertTrue(true);
		 }
		 
	 }
	 
	
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(2000);;
	 logger.info("TC003_loginDDT Ended");
	
	}
}
	


