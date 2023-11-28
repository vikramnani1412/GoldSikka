package Xs2_Booking_Account_AddingAmount;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;

import GenericUtility.PropertyFileUtility;
import ObjectRepository.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class Demo_LoginBookingAccountDepositMoney {
        
		@Test
		public void addingAmountToWallet() throws InterruptedException, Exception {
			
			PropertyFileUtility pUtil = new PropertyFileUtility();
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
				System.out.println("Invalid Browser");
			}
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
			Thread.sleep(3000);
			WebElement bookingAccount = driver.findElement(By.xpath("//span[.='Booking Account']"));
			wait.until(ExpectedConditions.visibilityOf(bookingAccount));
			bookingAccount.click();
			
			WebElement BeforeAdding = driver.findElement(By.xpath("//p[contains(text(),'₹')]"));
			wait.until(ExpectedConditions.visibilityOf(BeforeAdding)).click();
			BeforeAdding.getText();
			String BeforeAddingAmount = BeforeAdding.getText();
			System.out.println("Before Adding Amount to wallet "+BeforeAddingAmount);
						
			driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("5000",Keys.ENTER);
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[.='Netbanking']")).click();
			driver.findElement(By.xpath("//div[.='ICICI']")).click();
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.className("svelte-s8db8t")).click();
			Set<String> childWindow = driver.getWindowHandles();
			
			for(String childid : childWindow)
			{
				if(!childid.equals(parentWindow))
				{
					driver.switchTo().window(childid);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
	        
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			driver.switchTo().alert().accept();
			
			Thread.sleep(1000);
			WebElement AfterAdding = driver.findElement(By.xpath("//p[contains(text(),'₹')]"));
			wait.until(ExpectedConditions.visibilityOf(AfterAdding));
			String AfterAddingAmount = AfterAdding.getText();
			System.out.println("After Adding Amount to wallet "+AfterAddingAmount);
			
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			
			DashboardPage dPage = new DashboardPage(driver);
			dPage.logoutOfApplication(driver);
			
		}
		
	}