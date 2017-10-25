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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Unit test for simple App.
 */
public class verifyMasterPage extends ExtentReportsClass
{
		
	@Test
	public void verifyMasterPage()
	{
		logger = extent.startTest("verifyMasterPage");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Browsers"+File.separator+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.16.3.61:8080/HRMSDP/");
		String eletext = driver.findElement(By.xpath("//h2[contains(.,'Please sign in')]")).getText();	
		
		if (eletext.contains("Please sign in"))
		{
			logger.log(LogStatus.PASS, "HRMSDP Application Launched Succesfully");
		}else{
			logger.log(LogStatus.FAIL, "HRMSDP Application Not Launched");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user.username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user.password']")).sendKeys("12345");
		///driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement ee = driver.findElement(By.xpath("//input[@type='submit']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(ee).build().perform();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		boolean searchIconPresence = driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed();
		if (searchIconPresence==true)
		{
			driver.findElement(By.xpath("//input[@type='submit']")).click();	
		}
		
		
		String StrMasters= driver.findElement(By.xpath("//a[contains(.,'Masters')]")).getText();
	 	if (StrMasters.contains("Masters"))
		{
			logger.log(LogStatus.PASS, "HRMSDP Application Logged in Username: Admin");
		}else{
			logger.log(LogStatus.FAIL, "Unabel to login into HRMSDP Application");
		}    
		driver.findElement(By.xpath("//a[contains(.,'Masters')]")).click();	
		WebElement mySelectElement = driver.findElement(By.xpath("//select[@class='dropdown dropbtn ']"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByValue("EmpTypeDisplay");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		driver.findElement(By.xpath("//input[@value='Add Employee Type']")).click();
		driver.findElement(By.xpath("//input[@name='empf.empTypeId']")).sendKeys("R&D");
		driver.findElement(By.xpath("//input[@name='empf.description']")).sendKeys("Reasearch & Development");
		WebElement ele = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
		String Strusername = driver.findElement(By.xpath("//input[@name='user.username']")).getAttribute("placeholder");
		Assert.assertEquals(Strusername, "Username");
		
		if (Strusername.contains("Username"))
		{
			logger.log(LogStatus.PASS, "HRMSDP Application Logged out Successfully");
		}else{
			logger.log(LogStatus.FAIL, "Unabel to HRMSDP Logged out from Application" );
		}    
		
		driver.quit();
		
	
	}
	
	
	

}
