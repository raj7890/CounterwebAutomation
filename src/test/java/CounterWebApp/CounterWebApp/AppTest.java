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
		driver.get("http://localhost:9999/CounterWebApp-1.0-SNAPSHOT/");
		String eletext = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(eletext);
		Assert.assertEquals(eletext, "Hello World!");
		driver.close();
		
		
	}
	
	

}
