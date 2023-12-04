package S1_Demo_Folder;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.NavigableMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class SchemeSubscriptionWithBankingAndBookingAccTest extends BaseClass{

	@Test(groups = "SchemeBookingBanking" , priority = 3)
	public void createAnAccountLoginCreateSchemeLogoutTest() throws InterruptedException, AWTException, Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Schemes']"))).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		
		Thread.sleep(2000);
		
		WebElement AmountDrpDwn = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		Select s = new Select(AmountDrpDwn);
		s.selectByVisibleText("9500");
		
		
/*		
		Thread.sleep(4000);
		
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("9500");		
		
		Thread.sleep(5000);
		
//		String PayableAmount = driver.findElement(By.xpath("//p[text()=' Payable Amount:']/span[contains(.,'₹')]")).getText();
//		if(!PayableAmount.equals(0))
//		{
//			Thread.sleep(3000);                   //This is to know that payable amount
//			System.out.println(PayableAmount);    //got Reduced based on given amount
//		}
		
		while (true)
		{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		driver.findElement(By.xpath("//button[.='Proceed']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[.='ICICI']")).click();
		
		Thread.sleep(2000);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Pay Now']"))).click();
		
		Thread.sleep(2000);
		
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String childid : childWindow)
		{
			if(!childid.equals(parentWindow))
			{
				driver.switchTo().window(childid);
				driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindow);
        
        wait.until(ExpectedConditions.alertIsPresent());
        
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
		
		//This is Before Completion of modal popup close button ele
//		driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(TextArea));
		TextArea.sendKeys("Good Scheme");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='4-star']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		
		Thread.sleep(2000);
		
		//This is After Completion of modal popup close button ele
		driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
		
		Thread.sleep(2000);
		
		try
		{
			String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(SuccessMsg);
		}
		catch(Exception e)
		{
			System.out.println("Failed");
		}
	*/	
		
	}
}
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click()",ele);
//driver.switchTo().alert().accept();








/*

        WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		
		Thread.sleep(2000);
		
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");

*/
