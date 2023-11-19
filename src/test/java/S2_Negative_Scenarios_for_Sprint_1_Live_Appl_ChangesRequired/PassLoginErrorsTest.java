package S2_Negative_Scenarios_for_Sprint_1_Live_Appl_ChangesRequired;

import java.time.Duration;
import java.util.Set;
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
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(GenericUtility.ListnersImplementationClass.class)
public class PassLoginErrorsTest  {

	@Test(groups = "Login" , priority = 1)                                 //OTP error
	public void loginByGivingAlreadyRegisteredMobileNumberOTPTest() throws Exception 
	{
		String methodName = "loginByGivingAlreadyRegisteredMobileNumberOTPTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("8686184458",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String OTPErrorMsg = driver.findElement(By.xpath("//div[@class='login-box ng-star-inserted']")).getText();
			System.out.println(OTPErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
			
		} 
		catch (Exception e) 
		{
			Thread.sleep(3000);
		}
		
		driver.quit();
		
	}
	
	@Test(groups = "Login" , priority = 2)                                  //Not Registered mobile number
	public void loginByGivingNotRegisteredMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingNotRegisteredMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("9865421361",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
//		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 3)                                  //1 Number As mobile number
	public void loginByGiving1NumberAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving1NumberAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("9",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 4)                                  //3 Numbers As mobile number
	public void loginByGiving3NumbersAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving3NumbersAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("912",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
//		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 5)                                  //12 Numbers As mobile number
	public void loginByGivingMoreThan12NumbersAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingMoreThan12NumbersAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
	    
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("912345698762",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 6)                                  //14 Numbers As mobile number
	public void loginByGivingMoreThan14NumbersAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingMoreThan14NumbersAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("98765428654123",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 7)                                  //Special Chars As mobile number
	public void loginByGivingSpecialCharsAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingSpecialCharsAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("@%$#E$%&",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
//	@Test                                  //Emojis As mobile number --- WebDriver not supporting
	public void loginByGivingEmojisAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingEmojisAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys("😊😊😊😊😊😊😊😊",Keys.ENTER);
		
		Thread.sleep(5000);
		
		//OTP Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[text()='Email / Mobile Number ']/../preceding-sibling::div//div")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
	
	@Test(groups = "Login" , priority = 8)                                  //Login with Google As 
	public void loginByClickingOnLoginWithGoogleErrorTest() throws Exception 
	{
		String methodName = "loginByClickingOnLoginWithGoogleErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		WebElement LoginWithGoogleBtn = driver.findElement(By.xpath("//button[text()=' Login with Google ']"));
		String Parent = driver.getWindowHandle();
		wUtil.waitForElementToBeClickable(driver, LoginWithGoogleBtn);
		LoginWithGoogleBtn.click();
		Set<String> Childs = driver.getWindowHandles();
		Thread.sleep(5000);
		for(String Child : Childs)
		{
			if(!Child.equals(Parent))
			{
				driver.switchTo().window(Child);
			}
		}
	
		wUtil.takeScreenShot(driver, methodName);
		Assert.fail();
		
		driver.switchTo().window(Parent);
		
		driver.quit();
	
	}
	
	
	@Test(groups = "Login" , priority = 9)                                  //Login with Registered mobile number
	public void loginWithRegisteredMobileNumberPassTest() throws Exception 
	{
		String methodName = "loginWithRegisteredMobileNumberPassTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("liveurl");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("usernamee");
		
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
			System.out.println("Invaid Browser");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Email / mobile number']")).sendKeys(USERNAME,Keys.ENTER);
		
		WebElement Dashboard = driver.findElement(By.xpath("//span[.='Dashboard']"));
		wUtil.waitForElementToBeVisible(driver, Dashboard);
		wUtil.takeScreenShot(driver, methodName);
		
	}
	
}
