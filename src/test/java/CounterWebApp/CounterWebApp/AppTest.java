package CounterWebApp.CounterWebApp;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

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
	
	@Test
	public void verifylogin()
	{
		WebDriver driver  = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:9999/HRMSDP");
		String eletext = driver.findElement(By.xpath("//h2[contains(.,'Please sign in')]")).getText();
		Assert.assertEquals(eletext, "Please sign in");
		//driver.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user.username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user.password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		String StrMasters= driver.findElement(By.xpath("//a[contains(.,'Masters')]")).getText();
		Assert.assertEquals(StrMasters, "Masters");
		WebElement ele = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
		String Strusername = driver.findElement(By.xpath("//input[@name='user.username']")).getAttribute("placeholder");
		Assert.assertEquals(Strusername, "Username");
		
	
	}
	
	
	@Test
	public void verifyMasterPage()
	{
		WebDriver driver  = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:9999/HRMSDP");
		String eletext = driver.findElement(By.xpath("//h2[contains(.,'Please sign in')]")).getText();
		Assert.assertEquals(eletext, "Please sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user.username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user.password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		String StrMasters= driver.findElement(By.xpath("//a[contains(.,'Masters')]")).getText();
		Assert.assertEquals(StrMasters, "Masters");
		driver.findElement(By.xpath("//a[contains(.,'Masters')]")).click();	
		WebElement mySelectElement = driver.findElement(By.xpath("//select[@class='dropdown dropbtn ']"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByValue("EmpTypeDisplay");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		driver.findElement(By.xpath("//input[@value='Add Employee Type']")).click();
		driver.findElement(By.xpath("//input[@name='empf.empTypeId']")).sendKeys("R&D");
		driver.findElement(By.xpath("//input[@name='empf.description']")).sendKeys("Reasearch & Development");
		WebElement ele = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
		String Strusername = driver.findElement(By.xpath("//input[@name='user.username']")).getAttribute("placeholder");
		Assert.assertEquals(Strusername, "Username");
		
	
	}
	
	
	

}
