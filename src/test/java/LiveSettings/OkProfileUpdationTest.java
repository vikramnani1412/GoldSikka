package LiveSettings;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OkProfileUpdationTest {
	
	@Test
	public void profileUpdationTest() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",1,1);
		String Mail = eUtil.readDataFromExcel("Settings",2,1);
		String PhNo = eUtil.readDataFromExcel("Settings",3,1);
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");//input[@placeholder='Email / mobile number']
		
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
			System.out.println("Invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys(USERNAME,Keys.ENTER);
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//span[.='Settings']")).click();
			break;
		}
		catch(Exception e)
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}}
		
		driver.findElement(By.xpath("//a[.=' Account']")).click();
		
		WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		NameEdt.clear();
		NameEdt.sendKeys(Name);
		
		WebElement EmailEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
		EmailEdt.clear();
		EmailEdt.sendKeys(Mail);
		
		WebElement MobileNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile No']"));
		MobileNoEdt.clear();
		MobileNoEdt.sendKeys(PhNo);
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
		try
		{
			WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String successMsg = SuccessMsg.getText();
			System.out.println(successMsg);
		}
		catch(Exception e)
		{
			WebElement DangerMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			String dangerMsg = DangerMsg.getText();
			System.out.println(dangerMsg);
			Assert.fail();
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
	}
	
}
