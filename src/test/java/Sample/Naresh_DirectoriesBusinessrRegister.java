package Sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Naresh_DirectoriesBusinessrRegister {

		public static void main(String[] args) throws AWTException, Exception {
			
//			WebDriver driver = new FirefoxDriver();
			
			WebDriverManager.chromedriver().setup();
	    	WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://stg-fms.goldsikka.com/");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("admin@goldsikka.com",Keys.TAB,"GTX123123",Keys.ENTER);
			WebElement ele = driver.findElement(By.xpath("//span[.='Events']"));
			
			
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().perform();
			
			int scrollCount=3;
			Robot r = new Robot();
			for (int i = 0; i < scrollCount; i++) 
			{
				try
				{
					driver.findElement(By.xpath("//span[.='Directories']")).click();
				}
				catch(Exception exe)
				{
					r.keyPress(KeyEvent.VK_PAGE_DOWN);
				}
			}
			
			Thread.sleep(2000);
			
			try
			{
				driver.findElement(By.xpath("//span[.='Business Register']")).click();
			}
			catch(Exception exe)
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@placeholder='Email']")).click();
			
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			
			
			WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
			
			WebDriverUtility wUtil = new WebDriverUtility();
			wUtil.clickOnWebElement(driver, element);
			
	        r.keyPress(KeyEvent.VK_CONTROL);
	        r.delay(1000);
	        StringSelection ss = new StringSelection("C:\\Users\\admin\\Desktop\\Loyalty\\Images\\Images1");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			
			
			
		
		}

	}
