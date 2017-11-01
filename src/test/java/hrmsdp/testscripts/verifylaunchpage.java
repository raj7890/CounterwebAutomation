package hrmsdp.testscripts;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple App.
 */
public class verifylaunchpage extends ExtentReportsClass
{
	
	@Parameters({ "browser","Environment" })
	@Test
	public void verifylaunchpage(String browser,String Environment)
	{
		logger = extent.startTest("verifylaunchpage");
		WebDriver driver = null;
		//To generate the log when the test case is passed
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Browsers"+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
		}else{
			System.out.println("not yet implemented");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(Environment.equalsIgnoreCase("Dev")){
			driver.get("http://172.16.3.61:8080/HRMSDP/");
		}else{
			System.out.println("not yet implemented");
		}
		
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
