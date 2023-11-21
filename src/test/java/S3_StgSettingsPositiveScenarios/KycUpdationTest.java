package S3_StgSettingsPositiveScenarios;

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

public class KycUpdationTest {

	@Test(groups = "Kyc" , priority = 1)
	public void kycUpdation1() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String FatherName = eUtil.readDataFromExcel("Settings",6,6);
		String SpouseName = eUtil.readDataFromExcel("Settings",7,6);
		String AltPhNo = eUtil.readDataFromExcel("Settings",8,6);
		String PanNo = eUtil.readDataFromExcel("Settings",9,6);
		String AadharNo = eUtil.readDataFromExcel("Settings",10,6);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("stgurl");
		
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
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
		
		driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
		
		WebElement FatherNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
		FatherNameEdt.clear();
		FatherNameEdt.sendKeys(FatherName);
		
		Thread.sleep(3000);
		
		WebElement SposeNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
		SposeNameEdt.clear();
		SposeNameEdt.sendKeys(SpouseName);
		
		Thread.sleep(3000);
		
		WebElement AlternatePhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
		AlternatePhoneNoEdt.clear();
		AlternatePhoneNoEdt.sendKeys(AltPhNo);
		
		Thread.sleep(3000);
		
		WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
		PanNoEdt.clear();
		PanNoEdt.sendKeys(PanNo);
		
		Thread.sleep(3000);
		
		WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
		AadharNoEdt.clear();
		AadharNoEdt.sendKeys(AadharNo);
		
		Thread.sleep(3000);
		
		WebElement MaleRadioBtn = driver.findElement(By.xpath("//input[@value='M']"));
		MaleRadioBtn.click();
		
		Thread.sleep(3000);
		
//		WebElement FemaleRadioBtn = driver.findElement(By.xpath("//input[@value='F']"));
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
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
		
	}
	
	@Test(groups = "Kyc" , priority = 2)
	public void kycUpdation2() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String FatherName = eUtil.readDataFromExcel("Settings",6,7);
		String SpouseName = eUtil.readDataFromExcel("Settings",7,7);
		String AltPhNo = eUtil.readDataFromExcel("Settings",8,7);
		String PanNo = eUtil.readDataFromExcel("Settings",9,7);
		String AadharNo = eUtil.readDataFromExcel("Settings",10,7);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("stgurl");
		
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
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
		
		driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
		
		WebElement FatherNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
		FatherNameEdt.clear();
		FatherNameEdt.sendKeys(FatherName);
		
		Thread.sleep(3000);
		
		WebElement SposeNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
		SposeNameEdt.clear();
		SposeNameEdt.sendKeys(SpouseName);
		
		Thread.sleep(3000);
		
		WebElement AlternatePhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
		AlternatePhoneNoEdt.clear();
		AlternatePhoneNoEdt.sendKeys(AltPhNo);
		
		Thread.sleep(3000);
		
		WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
		PanNoEdt.clear();
		PanNoEdt.sendKeys(PanNo);
		
		Thread.sleep(3000);
		
		WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
		AadharNoEdt.clear();
		AadharNoEdt.sendKeys(AadharNo);
		
		Thread.sleep(3000);
		
		WebElement MaleRadioBtn = driver.findElement(By.xpath("//input[@value='M']"));
		MaleRadioBtn.click();
		
		Thread.sleep(3000);
		
//		WebElement FemaleRadioBtn = driver.findElement(By.xpath("//input[@value='F']"));
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
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
		
	}
	
	
}
