package LiveSettings;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OkAddressDetailsUpdationDeletionMakingPrimaryTest {

	
	
	@Test(priority = 1)
	public void addressUpdation() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Title = eUtil.readDataFromExcel("Settings",23,1);
		String Address = eUtil.readDataFromExcel("Settings",24,1);
		String City = eUtil.readDataFromExcel("Settings",25,1);
		String StateValue = eUtil.readDataFromExcel("Settings",26,1);
		String PinCode = eUtil.readDataFromExcel("Settings",27,1);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");//input[@placeholder='Email / mobile number']
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-Notifications=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
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
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses/add']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).sendKeys(Title);
		
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Address']")).sendKeys(Address);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter city']")).sendKeys(City);
		Thread.sleep(1000);
		
		WebElement State = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
		
		Select s = new Select(State);
		s.selectByVisibleText(StateValue);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']")).sendKeys(PinCode);
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
		String RecentlyAddedAddress = driver.findElement(By.xpath("//h5[contains(.,'"+Title+"')]")).getText();
		                                                               //We Have to add title variable here
		if(RecentlyAddedAddress.contains(Title))
		{                      //We Have to add title variable here
			System.out.println("Address Added Successfully");
		}
		else
		{
			System.out.println("Address Not Added Successfully");
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
		driver.quit();
		
	}
	
		
//	@Test
	public void settingPrimaryAddress() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Title = eUtil.readDataFromExcel("Settings",23,1);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");//input[@placeholder='Email / mobile number']
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-Notifications=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
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
		
		driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		
		driver.findElement(By.xpath("//h5[.=' "+Title+" ']/../following-sibling::div[@class='col-lg-6']//a[.='Set As Primary']")).click();
		
		String AfterSettingPrimaryConformationMsg = driver.findElement(By.xpath("//h5[.=' "+Title+" '] /../following-sibling::div//a[.=' Primary']")).getText();
		
		if(AfterSettingPrimaryConformationMsg.equalsIgnoreCase("Primary"))
		{
			System.out.println(Title+" Address setted as Primary Address");
		}
		else
		{
			System.out.println(Title+" Address not setted as Primary Address");
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
		driver.quit();
		
	}
	
	
		@Test(priority = 2)
		public void edtingExistingAddress() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Title = eUtil.readDataFromExcel("Settings",23,1);
			
			String EditTitle = eUtil.readDataFromExcel("Settings",23,2);
			String EditAddress = eUtil.readDataFromExcel("Settings",24,2);
			String EditCity = eUtil.readDataFromExcel("Settings",25,2);
			String EditStateValue = eUtil.readDataFromExcel("Settings",26,2);
			String EditPinCode = eUtil.readDataFromExcel("Settings",27,2);
			
			PropertyFileUtility pUtil = new PropertyFileUtility();
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
			String URL = pUtil.readDataFromPropertyFile("liveurl");//input[@placeholder='Email / mobile number']
			
			WebDriver driver = null;
			
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-Notifications=*");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);
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
			
			driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
		    
			driver.findElement(By.xpath("//h5[.=' "+Title+" ']/../following-sibling::div//i[@class='far fa-edit']")).click();
			                                                  
			WebElement TitleEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Title']"));
			TitleEdt.clear();
			TitleEdt.sendKeys(EditTitle);
			
			WebElement AddressEdt = driver.findElement(By.xpath("//textarea[@placeholder='Enter Address']"));
			AddressEdt.clear();
			AddressEdt.sendKeys(EditAddress);
			driver.findElement(By.xpath("//input[@placeholder='Enter city']")).sendKeys(EditCity);
			
			WebElement State = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			
			Select s = new Select(State);
			s.selectByVisibleText(EditStateValue);
			
			WebElement PincodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']"));
			PincodeEdt.clear();
			PincodeEdt.sendKeys(EditPinCode);
			
			driver.findElement(By.xpath("//button[.=' Submit ']")).click();
			
			try
			{
				String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
				System.out.println(SuccessMsg);
			}
			catch(Exception e)
			{
				System.out.println("Address Not Updated Successfully");
				Assert.fail();
			}
			
			driver.findElement(By.xpath("//span[.='Logout ']")).click();
			driver.switchTo().alert().accept();
			
			driver.quit();

    	}
		
		
		@Test(priority = 3)
		public void addressDeletion() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();
			String Title = eUtil.readDataFromExcel("Settings",23,1);
			
			PropertyFileUtility pUtil = new PropertyFileUtility();
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
			String URL = pUtil.readDataFromPropertyFile("liveurl");
			
			WebDriver driver = null;
			
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-Notifications=*");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);
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
			
			driver.findElement(By.xpath("//a[@href='/settings/addresses']")).click();
			
			while(true)
			{
			try {
				driver.findElement(By.xpath("//a[.=' Primary']")).click();
				Thread.sleep(2000);
				break;
				
			} catch (Exception e) {
				driver.navigate().refresh();
			}}
			
			//div[.='Set As Primary']/div/button)[1]
			WebElement DeleteBtn = driver.findElement(By.xpath("(//div[.='Set As Primary']/div/button)[1]"));
			//h5[.=' "+Title+" ']/../following-sibling::div[@class='col-lg-6']//button/i[@class='far fa-trash-alt']
			
			Thread.sleep(3000);
			DeleteBtn.click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
					
			try
			{
				String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
				System.out.println(SuccessMsg);
			}
			catch(Exception e)
			{
				System.out.println("Not Deleted");
				Assert.fail();
			}
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[.='Logout ']")).click();
			driver.switchTo().alert().accept();
			
			driver.quit();
			
		}
		
		
}
