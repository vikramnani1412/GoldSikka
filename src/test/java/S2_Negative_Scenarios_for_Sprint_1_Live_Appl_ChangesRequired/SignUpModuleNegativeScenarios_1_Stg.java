package S2_Negative_Scenarios_for_Sprint_1_Live_Appl_ChangesRequired;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class SignUpModuleNegativeScenarios_1_Stg {

//	@Test                             //All Scenarios 1st one
	 public void WhileSignIntoApplicationEmailErrorTest() throws Exception
	 {
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
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
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		//Email
		try 
		{
			String EmailNotGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Email ']//following-sibling::div[.='This field is required ']")).getText();
			System.out.println("You have not entered E-mail "+EmailNotGivenErrorMsg);
//			wUtil.takeScreenShot(driver, methodName);
		}			
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String EmailGivenErrorMsg = driver.findElement(By.xpath("//label[contains(.,'Email ')]//following-sibling::div[.='The email has already been taken.']")).getText();
			System.out.println(EmailGivenErrorMsg);
//			wUtil.takeScreenShot(driver, methodName);
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		//Phone Num
		try
		{
	       String PhoneNoNotGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='This field is required ']")).getText();
		   System.out.println("You have not entered Phone number "+PhoneNoNotGivenErrorMsg);
//		   wUtil.takeScreenShot(driver, methodName);
		}			
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try
		{
		   String PhoneNumGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='The mobile has already been taken.']")).getText();
		   System.out.println(PhoneNumGivenErrorMsg);
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(5000);
		
		//Referral code
		try
		{
		   String WrongReferralCode = driver.findElement(By.xpath("//div[text()='Wrong Referral Code']")).getText();
		   System.out.println(WrongReferralCode);
//		   wUtil.takeScreenShot(driver, methodName);
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
		
	}
	
	
	@Test(groups = "Signup")                                  //Giving already Existing email error
	 public void whileSignIntoApplicationEmailErrorTest() throws Exception
	 {		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
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
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8331827873");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(5000);
		
		//Email
		try 
		{
			String EmailNotGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Email ']//following-sibling::div[.='This field is required ']")).getText();
			System.out.println("You have not entered E-mail "+EmailNotGivenErrorMsg);
			Assert.fail();
		}			
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String EmailGivenErrorMsg = driver.findElement(By.xpath("//label[contains(.,'Email ')]//following-sibling::div[.='The email has already been taken.']")).getText();
			System.out.println(EmailGivenErrorMsg);
			Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
		
	}
	
	@Test(groups = "Signup")                                 //Given existing phone number error
	 public void whileSignIntoApplicationPhoneNumberGivenErrorTest() throws Exception
	 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(5000);
		
		//Phone Num
		try
		{
	       String PhoneNoNotGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='This field is required ']")).getText(); 
		   System.out.println("You have not entered Phone number "+PhoneNoNotGivenErrorMsg);
		   Assert.fail();
		}			
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try
		{
		   String PhoneNumGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='The mobile has already been taken.']")).getText();
		   System.out.println(PhoneNumGivenErrorMsg);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
	    
		driver.quit();
		
	}
	
	@Test(groups = "Signup")                                  //Skipped phone number error
	 public void whileSignIntoApplicationPhoneNumberNotGivenErrorTest() throws Exception
	 {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
//		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(5000);
		
		//Phone Num
		try
		{
	       String PhoneNoNotGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='This field is required ']")).getText();
	       System.out.println("You have not entered Phone number "+PhoneNoNotGivenErrorMsg);
		   Assert.fail();
		}			
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try
		{
		   String PhoneNumGivenErrorMsg = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='The mobile has already been taken.']")).getText();
		   System.out.println(PhoneNumGivenErrorMsg);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
	    
		driver.quit();
		
	}
	
	@Test(groups = "Signup")                                 //Wrong Referral Code
	 public void whileSignIntoApplicationGivenWrongReferralCodeError() throws Exception
	 {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8331827873");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		Thread.sleep(5000);
		
		//Referral code
		try
		{
		   String WrongReferralCode = driver.findElement(By.xpath("//div[text()='Wrong Referral Code']")).getText();
		   System.out.println(WrongReferralCode);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	@Test(groups = "Signup")                                 //Skip Name Error
	 public void whileSignIntoApplicationSkipNameError() throws Exception
	 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
//		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8331827873");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(1000);
		
				
		//Referral code
		try
		{
			
		   String SkipNameError = driver.findElement(By.xpath("//label[text()='Name ']/following-sibling::div[.='This field is required ']")).getText();
		   System.out.println(SkipNameError);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
//		driver.quit();
		
	}
	
	
	
	@Test(groups = "Signup")                                 //Skip Heard About Us DropDwn Value Error
	 public void whileSignIntoApplicationSkipHeardAboutUsDropDwnValueError() throws Exception
	 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8331827873");
//		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
//		Select ss = new Select(ele);
//		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		Thread.sleep(5000);
		
		//Referral code
		try
		{
		   String SkipHeardAboutUsError = driver.findElement(By.xpath("//label[text()='Heard About Us ']/following-sibling::div[.='This field is required ']")).getText();
		   System.out.println("You did not select how you heard about us You have to select a Value from drop down"+SkipHeardAboutUsError);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	@Test(groups = "Signup")                                 //More Than 10 Numbers In Mobile Num
	 public void whileSignIntoApplicationEnterMoreThan10NumbersInMobileNumTextFieldErrorTest() throws Exception
	 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stg-new-wallet.goldsikka.com/");
		driver.findElement(By.xpath("//a[.='Sign Up']")).click();
		WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
		Select s = new Select(AccType);
		s.selectByVisibleText("Personal Account");
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("9906293668709");
		WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
		Select ss = new Select(ele);
		ss.selectByVisibleText("Social Media Add");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
		Thread.sleep(5000);
		
		//Referral code
		try
		{
		   String enteringMoreThan10NumbersInStringMobileNumberField = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']/following-sibling::div[.='Please Enter 10 digits number ']")).getText();
		   System.out.println(enteringMoreThan10NumbersInStringMobileNumberField);
		   Assert.fail();
		}
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
}
