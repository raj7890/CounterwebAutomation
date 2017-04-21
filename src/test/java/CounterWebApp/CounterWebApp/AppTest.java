package CounterWebApp.CounterWebApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	 
	@Test
	public void verifylaunchpage()
	{
		WebDriver driver  = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:9999/HRMSDP");
		
		String eletext = driver.findElement(By.xpath("//h2[contains(.,'Please sign in')]")).getText();
	
		System.out.println(eletext);
		Assert.assertEquals(eletext, "Please sign in");
		driver.close();
		
	}
	
	

}
