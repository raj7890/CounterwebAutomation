package hrmsdp.testscripts;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple App.
 */
public class verifylaunchpage extends ExtentReportsClass
{
	
	@Parameters({ "browser","Environment","OS"})
	@Test
	public void launchpage(String browser,String Environment,String OS) throws IOException, InterruptedException
	{
		
		
		logger = extent.startTest("verifylaunchpage");
		WebDriver driver = null;
		//To generate the log when the test case is passed
		if(OS.equalsIgnoreCase("linux"))
		{
			
			String command = "chmod 755 " + System.getProperty("user.dir")+File.separator+"Browsers"+File.separator + "chromedriver";
			Runtime.getRuntime().exec("sudo apt-get install libgconf2-4");
			Thread.sleep(5000);
			Runtime.getRuntime().exec(command);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Browsers"+File.separator+"chromedriver");
			driver = new ChromeDriver();
		}	
		else if ((OS.equalsIgnoreCase("windows")))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"Browsers"+File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Browser Initiated");
		}
		else{
			System.out.println("not yet implemented");
		}
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(Environment.equalsIgnoreCase("Dev")){
			driver.get("http://192.168.99.1:9999/HRMSDP/");
		}else if (Environment.equalsIgnoreCase("test"))
		{
			driver.get("http://localhost:9999/HRMSDP/");
			
		}else
			System.out.println("not yet implemented");
		{
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String eletext = driver.findElement(By.xpath("//h2[contains(.,'Please sign in')]")).getText();
		
		Assert.assertEquals(eletext, "Please sign in");
		
		if (eletext.contains("Please sign in"))
		{
			logger.log(LogStatus.PASS, "HRMSDP Application Launched Succesfully");
		}else{
			logger.log(LogStatus.FAIL, "HRMSDP Application Not Launched");
		}
		driver.close();
		driver.quit();
		
	}
	
		
}
