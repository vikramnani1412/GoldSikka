package X_GoldSuvidha;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
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
import GenericUtility.ConstantsUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyGoldTest {
	
	@Test
	public void buyGoldTest() throws Exception
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.propertyfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("stgurl");
		String USERNAME = prop.getProperty("usernamee");

		FirefoxOptions options = new FirefoxOptions();

	    // Create a FirefoxProfile to manage preferences
	    FirefoxProfile profile = new FirefoxProfile();

	    // Set a preference to allow or deny location access (false to deny)
	    profile.setPreference("geo.prompt.testing", true);
	    profile.setPreference("geo.prompt.testing.allow", false);

	    // Assign the profile to the FirefoxOptions
	    options.setProfile(profile);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Gold Suvidha']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Buy Gold']"))).click();
        
		String BookingAccBal = driver.findElement(By.xpath("//div[.='Use Booking Account']/..//div[contains(.,'Book Account Balance: ₹')]")).getText();
		System.out.println(BookingAccBal);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("134000",Keys.ENTER);
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@name='contact']")).sendKeys("8686184458",Keys.ENTER);
		
		while(true)
		{
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='Netbanking']"))).click();
			break;
		} catch (Exception e) {

			Thread.sleep(1000);
		}}
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='HDFC']"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='HDFC']")).click();
		String ParentWin = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();;
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
		   if(!Child.equals(ParentWin))
		   {
		       driver.switchTo().window(Child);
		       driver.findElement(By.xpath("//button[.='Success']")).click();
		   }
		}
		driver.switchTo().window(ParentWin);
	
//		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-dialog margin-centered'])[1]"))).getText();
		
		Thread.sleep(6000);
		
	    WebElement ModalPopup = driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']"));
	    
	    wait.until(ExpectedConditions.visibilityOf(ModalPopup)).sendKeys("Good Product");
	    
		driver.findElement(By.xpath("//label[contains(.,'4')]")).click();
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		
		driver.findElement(By.xpath("(//button[.=' X '])[2]")).click();
		
		String successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		
		System.out.println(successMsg);
		
		
		
		
			
				
    }
	
}
