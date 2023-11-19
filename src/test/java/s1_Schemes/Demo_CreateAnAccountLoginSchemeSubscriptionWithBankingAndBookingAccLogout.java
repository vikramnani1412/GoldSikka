package s1_Schemes;
 
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
import org.testng.annotations.Test;

import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_CreateAnAccountLoginSchemeSubscriptionWithBankingAndBookingAccLogout {

	@Test
	public void createAnAccountLoginCreateSchemeLogout() throws InterruptedException, AWTException, Exception
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();

	        // Create a FirefoxProfile to manage preferences
	        FirefoxProfile profile = new FirefoxProfile();

	        // Set a preference to allow or deny location access (false to deny)
	        profile.setPreference("geo.prompt.testing", true);
	        profile.setPreference("geo.prompt.testing.allow", false);

	        // Assign the profile to the FirefoxOptions
	        options.setProfile(profile);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}
		else 
		{
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Schemes']"))).click();
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		
		Robot r = new Robot();
		try 
		{
			driver.findElement(By.xpath("//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")).click();
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		
//		driver.findElement(By.xpath("//input[@formcontrolname='enteredWalletAmount']")).sendKeys("9500");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"))).click();
		
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
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
		
		driver.findElement(By.xpath("//div[.='ICICI']")).click();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Pay Now']"))).click();
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String childid : childWindow)
		{
			if(!childid.equals(parentWindow))
			{
				driver.switchTo().window(childid);
				driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		driver.switchTo().window(parentWindow);
        
        wait.until(ExpectedConditions.alertIsPresent());
        
		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);
		driver.switchTo().alert().accept();
		
		WebElement TextArea = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
		
		//This is Before Completion of modal popup close button ele
//		driver.findElement(By.xpath("//div[.='Feedback']/following-sibling::div/button[.=' X ']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(TextArea));
		TextArea.sendKeys("Good Scheme");
		driver.findElement(By.xpath("//label[@for='4-star']")).click();
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		
		//This is After Completion of modal popup close button ele
		driver.findElement(By.xpath("//div[.=' Thank for your Feedback']/following-sibling::div/button[.=' X ']")).click();
		
		try
		{
			String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			System.out.println(SuccessMsg);
		}
		catch(Exception e)
		{
			System.out.println("Failed");
		}
		
		DashboardPage dPage = new DashboardPage(driver);
		dPage.logoutOfApplication(driver);
		
		
		
	}
}
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click()",ele);
//driver.switchTo().alert().accept();
