package S3_StgSettingsPositive_2;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NomineeDetailsUpdationTest {

	@Test(groups = "SettingsPositive" , priority = 1)
	public void accountUpdation() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",13,6);
		String PhoneNo = eUtil.readDataFromExcel("Settings",14,6);
		String Address = eUtil.readDataFromExcel("Settings",15,6);
		String City = eUtil.readDataFromExcel("Settings",16,6);
		String State = eUtil.readDataFromExcel("Settings",17,6);
		String Country = eUtil.readDataFromExcel("Settings",18,6);
		String Pincode = eUtil.readDataFromExcel("Settings",19,6);
		String Relation = eUtil.readDataFromExcel("Settings",20,6);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("stgurl");
		
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/nominees']")).click();
		
       //To Delete a Nominee
       
		try 
		{
			WebElement DeleteNomineeBtn = driver.findElement(By.xpath("//i[@class='far fa-trash-alt']"));
			DeleteNomineeBtn.click();
			driver.switchTo().alert().accept();
			WebElement NomineeDeleteConformationMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String nomineeDeleteConformationMsg = NomineeDeleteConformationMsg.getText();
			System.out.println(nomineeDeleteConformationMsg);
		} 
		catch (Exception e) 
		{
			
			driver.findElement(By.xpath("//a[@href='/settings/nominees/add']")).click();
			
			WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
			NameEdt.clear();
			NameEdt.sendKeys(Name);
			
			WebElement PhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Number']"));
			PhoneNoEdt.clear();
			PhoneNoEdt.sendKeys(PhoneNo);
			
			Thread.sleep(1000);
			
			WebElement AddressEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Address']"));
			AddressEdt.clear();
			AddressEdt.sendKeys(Address);
			
			Thread.sleep(1000);
			
			WebElement CityEdt = driver.findElement(By.xpath("//input[@placeholder='Enter City']"));
			CityEdt.clear();
			CityEdt.sendKeys(City);
			
			Thread.sleep(1000);
			
			WebElement StateDrpDwn = driver.findElement(By.xpath("//select[@formcontrolname='state_id']"));
			Select s = new Select(StateDrpDwn);
			s.selectByVisibleText(State);
			
			
			Thread.sleep(1000);
			
			WebElement CountryDrpDwn = driver.findElement(By.xpath("//select[@formcontrolname='country_id']"));
			Select s1 = new Select(CountryDrpDwn);
			s1.selectByVisibleText(Country);
			
			Thread.sleep(1000);
			
			WebElement PincodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Pincode']"));
			PincodeEdt.clear();
			PincodeEdt.sendKeys(Pincode);
			
			WebElement RelationDrpDwn = driver.findElement(By.xpath("//select[@formcontrolname='relation']"));
			Select s2 = new Select(RelationDrpDwn);
			s2.selectByVisibleText(Relation);
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//button[.='Submit']")).click();
			
			String ActualResult = driver.findElement(By.xpath("//b[.=' Name : ']/../../../following-sibling::div//span[contains(.,'"+Name+"')]")).getText();
			try 
			{
				if(ActualResult.contains(Name))
				{
					System.out.println("Nominee Added Successfully");
				}
			}
			catch(Exception ee)
			{
				Assert.assertEquals(ActualResult, Name);
			}
			Thread.sleep(5000);
			
			WebElement DeleteNomineeBtn = driver.findElement(By.xpath("//span[.='"+Name+"']/../../../../preceding-sibling::div//i[@class='far fa-trash-alt']"));
			DeleteNomineeBtn.click();
			driver.switchTo().alert().accept();
			WebElement NomineeDeleteConformationMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String nomineeDeleteConformationMsg = NomineeDeleteConformationMsg.getText();
			System.out.println(nomineeDeleteConformationMsg);
			
		}
		
	        
        		
	}

}
