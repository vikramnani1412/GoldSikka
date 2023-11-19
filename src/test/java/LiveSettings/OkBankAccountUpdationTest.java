package LiveSettings;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.collections4.functors.WhileClosure;
import org.apache.commons.collections4.sequence.DeleteCommand;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OkBankAccountUpdationTest {

	@Test(priority = 1)
	public void accountUpdation() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",30,1);
		String AcNo = eUtil.readDataFromExcel("Settings",31,1);
		String BankName = eUtil.readDataFromExcel("Settings",32,1);
		String Branch = eUtil.readDataFromExcel("Settings",33,1);
		String IfscCode = eUtil.readDataFromExcel("Settings",34,1);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts/add']")).click();
        
		driver.findElement(By.xpath("//input[@placeholder='Enter Name on the Account']")).sendKeys(Name);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']")).sendKeys(AcNo);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Bank Name']")).sendKeys(BankName);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']")).sendKeys(Branch);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter IFSC Code']")).sendKeys(IfscCode);
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
        
		Thread.sleep(5000);
		
		try
		{
			String FrstName = driver.findElement(By.xpath("(//a[@href='/settings/bankAccounts/add']/following-sibling::div/div/div/div/h5[contains(text(),' ')])[1]")).getText();
		    if(FrstName.contains(Name))
		    {
		    	System.out.println("Successfully Added Account");
		    }
		}
		catch(Exception e)
		{
			String DangerMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			System.out.println(DangerMsg);
			Assert.fail();
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
	}	
	
	
	@Test(priority = 2)
	public void editBankAccountDetails() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",30,1);
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(9);
		
		String EditName = eUtil.readDataFromExcel("Settings",30,2);
		String EditAcNo = eUtil.readDataFromExcel("Settings",31,2);
		String EditBankName = eUtil.readDataFromExcel("Settings",32,2);
		String EditBranch = eUtil.readDataFromExcel("Settings",33,2);
		String EditIfscCode = eUtil.readDataFromExcel("Settings",34,2);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		
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
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
	    
		while(true)
		{
		try {
			driver.findElement(By.xpath("//a[.=' Primary']")).click();
			Thread.sleep(2000);
			break;
			
		} catch (Exception e) {
			driver.navigate().refresh();
		}}
		
		WebElement DeletingBank = driver.findElement(By.xpath("//h5[.=' "+Name+"']/../following-sibling::div//i[@class='far fa-edit']"));
		wait.until(ExpectedConditions.visibilityOf(DeletingBank));
		DeletingBank.click();
		
        WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name on the Account']"));
        NameEdt.clear();
        NameEdt.sendKeys(EditName);
		
        WebElement AccountNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']"));
        AccountNoEdt.clear();
        AccountNoEdt.sendKeys(EditAcNo);
		
        WebElement BankNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Bank Name']"));
        BankNameEdt.clear();
        BankNameEdt.sendKeys(EditBankName);
		
        WebElement BranchNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']"));
        BranchNameEdt.clear();
        BranchNameEdt.sendKeys(EditBranch);
		
		WebElement IfscCodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter IFSC Code']"));
		IfscCodeEdt.clear();
		IfscCodeEdt.sendKeys(EditIfscCode);
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
		String SuccessMsg = driver.findElement(By.xpath("(//h5[@class='title mb-4'])[1]")).getText();
		if(SuccessMsg.contains(EditName))
		{
			System.out.println(Name+" Account Editted Successfully to "+EditName);
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
		
	}
	
	
//	@Test
	public void makingPrimaryAccount() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();		
		String EditName = eUtil.readDataFromExcel("Settings",30,2);
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		
		//Here name we have to make dynamic to access multiple values
		driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.='Set Default']")).click();
        
		String PrimaryConformationMsg = driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.=' Primary']")).getText();
		
		if(PrimaryConformationMsg.contains("Primary"))
		{
			System.out.println(EditName+" Set as "+PrimaryConformationMsg+" Bank");
		}
		else
		{
			System.out.println(EditName+" Not Set As Primary Bank");
		}
		
		driver.findElement(By.xpath("//span[.='Logout ']")).click();
		driver.switchTo().alert().accept();
		
	}
	
	
		@Test(priority = 3)
		public void deleteBankAccountDetails() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();		
			String EditName = eUtil.readDataFromExcel("Settings",30,2);
			
			PropertyFileUtility pUtil = new PropertyFileUtility();
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
			String URL = pUtil.readDataFromPropertyFile("liveurl");
			
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
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			
			driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
			
			while(true)
			{
			try {
				driver.findElement(By.xpath("//h5[.=' Vicky']/../following-sibling::div[.=' Primary']")).click();
				Thread.sleep(2000);
				break;
				
			} catch (Exception e) {
				driver.navigate().refresh();
			}}
			
//          driver.switchTo().alert().accept();   //To delete Deleting
//			driver.switchTo().alert().dismiss();  //To Cancel Deleting
			
			while(true)
			{
		    try 
		    {
		    	driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.='Set Default']/..//i[@class='fas fa-trash-alt']")).click();
		    	driver.switchTo().alert().accept();
		    	break;
			} 
		    catch (Exception e) 
		    {
				WebElement DeleteError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
//				WebElement deleteBtn = driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.='Set Default']/..//i[@class='fas fa-trash-alt']"));
				if(DeleteError.isDisplayed())
				{
					System.out.println(DeleteError.getText());
				}
			}}
			
			Thread.sleep(5000);
		    
			try
			{
				WebElement Success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				String SuccessMsg = Success.getText();
			    if(SuccessMsg.contains("Success"))
			    {
			       System.out.println(SuccessMsg);
		     	}
			}
			catch(Exception e)
			{
				WebElement Delete = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
				String DeleteMsg = Delete.getText();
				System.out.println(DeleteMsg);
				Assert.fail();
			}
			
			driver.findElement(By.xpath("//span[.='Logout ']")).click();
			driver.switchTo().alert().accept();
		
		
	}
}
