package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;




import org.apache.logging.log4j.Logger;



public class BaseTest {
	 public static WebDriver Driver;
	 public  Logger logger = LogManager.getLogger(this.getClass());
	 public  Properties prperties;
	 
	@BeforeTest (groups={"Sanity,Regression","Master"})
	@Parameters({"os","browser"})
	
	void setup(String ops,String br) throws IOException, InterruptedException
	{
		
		//LOAD  CONFIG PROPERTIES FILE
		
		FileReader file=new FileReader("./src//test//resources//config.properties"); //Locate Config File  using Filereader
		
		prperties= new Properties(); //create Object Of Properties 
		
		prperties.load(file); //load file into properties object
		
		/////
		
		//logger //? why this method
		
		DesiredCapabilities capb= new DesiredCapabilities();
		
		if (prperties.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			
			
			//OS 
			if(ops.equalsIgnoreCase("windows"))
			{
				capb.setPlatform(Platform.WIN11);
			}
			else if(ops.equalsIgnoreCase("mac"))
			{
				capb.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("no matching os");
				return;
			}
			
			//BROWSE
			
				switch(br.toLowerCase())
				{
				case "chrome":Driver= new ChromeDriver();break;
				case "edge":Driver= new EdgeDriver();break;
				default:System.out.println("No valid browser found"); return;
				}
			Driver= new RemoteWebDriver(new URL("http://10.180.173.12:4444"),capb);
			
		}
		
		if(prperties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome":Driver= new ChromeDriver();break;
			case "edge":Driver= new EdgeDriver();break;
			default:System.out.println("No valid browser found"); return;
			}
		}
	
		
		
		
		
		
		//Driver= new RemoteWebDriver(new URL(properties.),capb);
		
		
		Driver.get(prperties.getProperty("appURL")); ///through get proerty method dynamically acccess URL from configuration file
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		Driver.manage().window().maximize();
		
	}
	@AfterTest (groups={"Sanity,Regression","Master"})
	void tearDown() throws InterruptedException
	{
		
		  if (Driver != null) {
		        Driver.quit();
		    }
		  Thread.sleep(2000);
	}
	
	public String randomString()
	{
		String ranstring=RandomStringUtils.randomAlphabetic(5);
		return ranstring;
		
	}
	public String randomNumber()
	{
		String rannumber=RandomStringUtils.randomAlphanumeric(10);
		return rannumber;
		
	}
	public String randomStringNumber()
	{
		String ranstring=RandomStringUtils.randomAlphabetic(3);
		String rannumber=RandomStringUtils.randomAlphanumeric(3);
		return ranstring+rannumber;
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) Driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
