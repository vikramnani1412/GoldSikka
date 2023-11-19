package LiveSettings;

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

public class OkNomineeDetailsUpdationTest {

	@Test
	public void nomineeUpdationTest() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",13,1);
		String PhoneNo = eUtil.readDataFromExcel("Settings",14,1);
		String Address = eUtil.readDataFromExcel("Settings",15,1);
		String City = eUtil.readDataFromExcel("Settings",16,1);
		String State = eUtil.readDataFromExcel("Settings",17,1);
		String Country = eUtil.readDataFromExcel("Settings",18,1);
		String Pincode = eUtil.readDataFromExcel("Settings",19,1);
		String Relation = eUtil.readDataFromExcel("Settings",20,1);
		
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/nominees']")).click();
		
        //To Delete a Nominee
		WebElement DeleteNomineeBtn = driver.findElement(By.xpath("//i[@class='far fa-trash-alt']"));
		DeleteNomineeBtn.click();
		driver.switchTo().alert().accept();
		WebElement NomineeDeleteConformationMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String nomineeDeleteConformationMsg = NomineeDeleteConformationMsg.getText();
		System.out.println(nomineeDeleteConformationMsg);
		
		driver.findElement(By.xpath("//a[@href='/settings/nominees/add']")).click();
		
		WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
		NameEdt.clear();
		NameEdt.sendKeys(Name);
		
		WebElement PhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Phone No']"));
		PhoneNoEdt.clear();
		PhoneNoEdt.sendKeys(PhoneNo);
		
		Thread.sleep(1000);
		
		WebElement AddressEdt = driver.findElement(By.xpath("//textarea[@placeholder='Enter Address']"));
		AddressEdt.clear();
		AddressEdt.sendKeys(Address);
		
		Thread.sleep(1000);
		
		WebElement CityEdt = driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
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
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
		Robot r = new Robot();
		for(int i=0;i<=12;i++)
		{
			Thread.sleep(500);
		   r.keyPress(KeyEvent.VK_TAB);
		   r.keyRelease(KeyEvent.VK_TAB);
		}
		
		r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
		
	    String ResultName = driver.findElement(By.xpath("(//li[contains(.,'')])[34]")).getText();
	    if(ResultName.contains(Name))
	    {
	    	System.out.println("Nominee Added Successfully");
	    }
	    else 
	    {
	    	System.out.println("Nominee Not Added Successfully");
	    }
		
        
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}
