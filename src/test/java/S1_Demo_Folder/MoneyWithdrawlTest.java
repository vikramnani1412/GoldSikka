package S1_Demo_Folder;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import GenericUtility.BaseClass;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class MoneyWithdrawlTest extends BaseClass{

	@Test(groups = "Withdraw")
	public void TransferToBankAccountFromWallet() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath("//button[.='Withdraw']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("10000");
		
		Thread.sleep(2000);
		
		WebElement bankDrpDwnElement = driver.findElement(By.xpath("//select[@formcontrolname='bank_id']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(bankDrpDwnElement));
		bankDrpDwnElement.click();
		
		Thread.sleep(2000);
		
		String Value = driver.findElement(By.xpath("//option[contains(text(),'7015')]")).getText();
		
		Thread.sleep(2000);
		
		Select s = new Select(bankDrpDwnElement);
		s.selectByVisibleText(Value);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		
		Thread.sleep(2000);
		
		Assertion a = new Assertion();
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-success mb-4 pl-5 pt-5 pb-5']")));
			String SuccessAlertMsg = driver.findElement(By.xpath("//div[@class='alert alert-success mb-4 pl-5 pt-5 pb-5']")).getText();
			System.out.println(SuccessAlertMsg);
			if(SuccessAlertMsg.contains("Success"))
			{
				a.fail();
			}
		}
		catch (Exception e) 
		{
			String DangerAlertMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			System.out.println(DangerAlertMsg);
		    if(DangerAlertMsg.contains("You need to wait"))
		    {
				a.fail();
		    }
						
		}
		
		
		
	}
}
