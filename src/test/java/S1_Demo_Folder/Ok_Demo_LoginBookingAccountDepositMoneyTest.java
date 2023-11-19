package S1_Demo_Folder;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class Ok_Demo_LoginBookingAccountDepositMoneyTest extends BaseClass {
        
		@Test(groups = "BookingAccount")
		public void addingAmountToWalletTest() throws InterruptedException, Exception 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
			wait.until(ExpectedConditions.visibilityOf(bookingAccount));
			bookingAccount.click();
			
			Thread.sleep(2000);
			
			WebElement BeforeAdding = driver.findElement(By.xpath("//p[contains(text(),'₹')]"));
			wait.until(ExpectedConditions.visibilityOf(BeforeAdding)).click();
			BeforeAdding.getText();
			String BeforeAddingAmount = BeforeAdding.getText();
			System.out.println("Before Adding Amount "+BeforeAddingAmount);
			
			Thread.sleep(2000);
						
			driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("5000",Keys.ENTER);
			
			Thread.sleep(2000);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[.='Netbanking']")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[.='ICICI']")).click();
			
			Thread.sleep(2000);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.className("svelte-s8db8t")).click();
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
			driver.switchTo().alert().accept();
			
			Thread.sleep(2000);
			
			WebElement AfterAdding = driver.findElement(By.xpath("//p[contains(text(),'₹')]"));
			wait.until(ExpectedConditions.visibilityOf(AfterAdding));
			String AfterAddingAmount = AfterAdding.getText();
			System.out.println("After Adding Amount "+AfterAddingAmount);
			
						
			Thread.sleep(2000);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			
			
		}
		
	}