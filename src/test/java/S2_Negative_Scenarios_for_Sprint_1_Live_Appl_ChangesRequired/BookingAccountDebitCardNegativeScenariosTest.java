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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingAccountDebitCardNegativeScenariosTest {

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
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("5000",Keys.ENTER);
		WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
		
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4481");
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("0126");
		driver.findElement(By.xpath("//input[@id='card_name']")).sendKeys("Gvc");
		driver.findElement(By.xpath("//input[@id='card_cvv']")).sendKeys("032");
		driver.findElement(By.xpath("//input[@id='card_number']")).click();
		
		driver.findElement(By.xpath("//span[@class='checkbox svelte-1b61qmd']")).click();
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
		
		
		
	}	
}
