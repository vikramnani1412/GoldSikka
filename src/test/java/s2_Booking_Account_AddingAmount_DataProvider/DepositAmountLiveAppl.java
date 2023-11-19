package s2_Booking_Account_AddingAmount_DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;

import GenericUtility.BaseClass;
import GenericUtility.ConstantsUtility;
import ObjectRepository.BookingAccountPage;
import ObjectRepository.BookingAccountPhNoFramePage;
import ObjectRepository.LandingPage;
import freemarker.template.utility.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DepositAmountLiveAppl {

	@Test(priority = 1)
	public void yesBankDeposit() throws InterruptedException, Exception, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.propertyfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("liveurl");
		String USERNAME=prop.getProperty("usernamee");
		
		FirefoxOptions options = new FirefoxOptions();

        // Create a FirefoxProfile to manage preferences
        FirefoxProfile profile = new FirefoxProfile();

        // Set a preference to allow or deny location access (false to deny)
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", false);

        // Assign the profile to the FirefoxOptions
        options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
    	WebDriver driver = new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		driver.findElement(By.xpath("//span[.='Booking Account']")).click();
		String BeforeAddingAmountToBookingAccount = driver.findElement(By.xpath("//p[contains(.,'₹ ')]")).getText();
		System.out.println(BeforeAddingAmountToBookingAccount);
		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).sendKeys("100000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
//		WebElement bank = driver.findElement(By.xpath("//div[contains(@id,'bank-item-"+columnValue+"')]"));
		driver.findElement(By.xpath("//div[.='HDFC']")).click();
		String ParentWin = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
//		WebElement SuccessMsg = driver.findElement(By.xpath("//button[.='Success']"));
//		String Msg = SuccessMsg.getText();
		Set<String> ChildWins = driver.getWindowHandles();
		for(String Child : ChildWins)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		WebElement WindowSuccessBtn = driver.findElement(By.xpath("//button[.='Success']"));
		System.out.println("Subscribed "+WindowSuccessBtn+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		
	}
}
