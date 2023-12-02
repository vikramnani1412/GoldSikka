package GenericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public JavaUtility jUtility=new JavaUtility();
	public WebDriverUtility wUtility=new WebDriverUtility();
	public ExcelFileUtility eUtility=new ExcelFileUtility();
	public PropertyFileUtility pUtility=new PropertyFileUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	    @BeforeSuite(alwaysRun = true)
		public void bsConfig()
		{
			System.out.println("---Database Connection Successfully---");
		}
		
	    @BeforeClass (groups={"Signup","Login","Schemes","BookingAccount","expSchemes","expBookingAccount","Scheme","Deposit","Withdrawl" })
		public void bcConfig() throws IOException
		{  
			String BROWSER = pUtility.readDataFromPropertyFile("browser");
			String URL = pUtility.readDataFromPropertyFile("stgurl");
			
			
			
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				System.out.println("Chrome Browser Launched Successfully");
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
				driver=new FirefoxDriver(options); 
				System.out.println("Firefox Browser Launched Successfully");
			}
			else if(BROWSER.equalsIgnoreCase("Edge"))
			{
				EdgeOptions options = new EdgeOptions();
		        options.addArguments("--disable-settings-window");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(options);
				System.out.println("Edge Browser Launched Successfully");
			}
			else 
			{
				System.out.println("Invalid Browser");
			}
			sDriver=driver;   //To Take ScreenShot
			wUtility.maximizeTheWindow(driver);
			wUtility.waitUntilPageLoad(driver);
			driver.get(URL);
		}
		
	@BeforeMethod(groups={"Signup","Login","Schemes","BookingAccount","expSchemes","expBookingAccount","Scheme","Deposit","Withdrawl" })
		public void bmConfig() throws IOException, Exception
		{
		    String USERNAME = pUtility.readDataFromPropertyFile("loginnum");
			LoginPage lPage=new LoginPage(driver);
			lPage.loginToApplication(USERNAME);
			System.out.println("---Login successfully---");
		}
        
	@AfterMethod(groups={"Signup","Login","Schemes","BookingAccount","expSchemes","expBookingAccount","Scheme","Deposit","Withdrawl" })
		public void amConfig() throws Exception
		{
//		    DashboardPage dPage = new DashboardPage(driver);
//		    dPage.logoutOfApplication(driver);
//		    System.out.println("Logout Successfully");
		}
        
	@AfterClass(groups={"Signup","Login","Schemes","BookingAccount","expSchemes","expBookingAccount","Scheme","Deposit","Withdrawl" })
		public void acConfig()
		{
//		    driver.quit();
//			System.out.println("Browser Closed Successfully");
		}
        
	@AfterSuite(groups={"Signup","Login","Schemes","BookingAccount","expSchemes","expBookingAccount","Scheme","Deposit","Withdrawl" })
		public void asConfig()
		{
		   System.out.println("---Database Closed Successful---");
		}


	
	
	

}
