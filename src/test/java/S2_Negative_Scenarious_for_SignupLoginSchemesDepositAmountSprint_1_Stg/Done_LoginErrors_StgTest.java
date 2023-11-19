package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.time.Duration;
import java.util.Set;

import javax.security.auth.login.LoginContext;

import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Done_LoginErrors_StgTest {

	@Test(groups = "Login",priority = 1)                                 //OTP error
	public void loginByGivingAlreadyRegisteredMobileNumberOTPTest() throws Exception 
	{
		String methodName = "loginByGivingAlreadyRegisteredMobileNumberOTPTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("8686184458",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//OTP Message 
		try 
		{
			String OTPErrorMsg = driver.findElement(By.xpath("//div[@class='login-box ng-star-inserted']")).getText();
			System.out.println(OTPErrorMsg);
			
			Thread.sleep(2000);
			
			wUtil.takeScreenShot(driver, methodName);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1000);
		}
		
		driver.quit();
		
	}
	
	@Test(groups = "Login" , priority = 2)                           //Not Registered mobile number
	public void loginByGivingNotRegisteredMobileNumberErrorTest() throws Exception 
	{
		JavaUtility jUtil = new JavaUtility();
		String methodName = "loginByGivingNotRegisteredMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("986"+jUtil.getRandomNum(),Keys.ENTER);
		
		Thread.sleep(3000);
		
		//Error Msg 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 3)                                  //1 Number As mobile number
	public void loginByGiving1NumberAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving1NumberAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("9",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//OTP Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 4)                                  //2 Numbers As mobile number
	public void loginByGiving3NumbersAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving3NumbersAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("912",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//3 numbers Error Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		
		driver.quit();
	}
	
	
	@Test(groups = "Login" , priority = 5)                                  //12 Numbers As mobile number
	public void loginByGivingMoreThan12NumbersAsMobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGivingMoreThan12NumbersAsMobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
	    
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("912345698762",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//OTP Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
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
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("98765428654123",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//14 Numbers Error Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
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
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("@%$#E$%&",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//Special chars Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
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
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("😊😊😊😊😊😊😊😊",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//Emojis error Message 
		try 
		{
			String NumberErrorMsg = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']")).getText();
			System.out.println(NumberErrorMsg);
			wUtil.takeScreenShot(driver, methodName);
			Thread.sleep(2000);
			Assert.fail();
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		
		driver.quit();
	}
	
	@Test(groups = "Login" , priority = 8)                                  //Login with Google 
	public void loginByClickingOnLoginWithGoogleErrorTest() throws Exception 
	{
		String methodName = "loginByClickingOnLoginWithGoogleErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		WebElement LoginWithGoogleBtn = driver.findElement(By.xpath("//button[text()=' Login with Google ']"));
		String Parent = driver.getWindowHandle();
		wUtil.waitForElementToBeClickable(driver, LoginWithGoogleBtn);
		
		Thread.sleep(3000);
		
		LoginWithGoogleBtn.click();
		Set<String> Childs = driver.getWindowHandles();
		
		Thread.sleep(2000);
		
		for(String Child : Childs)
		{
			if(!Child.equals(Parent))
			{
				driver.switchTo().window(Child);
			}
		}
		
		Thread.sleep(2000);
		
		wUtil.takeScreenShot(driver, methodName);
		Assert.fail();
		
		driver.switchTo().window(Parent);
		
		
		driver.quit();
	
	}
	
	
	@Test(groups = "Login" , priority = 9)                                  //Login with Registered mobile number Pass
	public void loginByGivingRegisteredMobileNumberPassTest() throws Exception 
	{
		String methodName = "loginByGivingRegisteredMobileNumberPassTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement Dashboard = driver.findElement(By.xpath("//span[.='Dashboard']"));
		wUtil.waitForElementToBeVisible(driver, Dashboard);
		wUtil.takeScreenShot(driver, methodName);
		
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	@Test(groups = "Login" , priority = 10)                                  //10 Numbers As 0 mobile number
	public void loginByGiving10NumbersAs0MobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving10NumbersAs0MobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("0000000000",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//OTP Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
			   System.out.println(NumberErrorMsg);
			   wUtil.takeScreenShot(driver, methodName);
			   Thread.sleep(2000);
			   Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		driver.quit();
	}
	
	@Test(groups = "Login" , priority = 11)                                  //1st Number As 0 mobile number
	public void loginByGiving1stNumberAs0MobileNumberErrorTest() throws Exception 
	{
		String methodName = "loginByGiving1stNumberAs0MobileNumberErrorTest";
		WebDriverUtility wUtil = new WebDriverUtility();
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("stgurl");
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("0868618445",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//OTP Message 
		try 
		{
			WebElement NumberError = driver.findElement(By.xpath("//label[.='Email / Mobile Number']/../..//div[@class='alert alert-danger']"));
			String NumberErrorMsg = NumberError.getText();
			if(NumberError.isDisplayed())
			{
				System.out.println(NumberErrorMsg);
				wUtil.takeScreenShot(driver, methodName);
				Thread.sleep(2000);
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		
		driver.quit();
	}
	
}
