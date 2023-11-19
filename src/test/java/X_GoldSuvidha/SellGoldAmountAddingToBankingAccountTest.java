package X_GoldSuvidha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import GenericUtility.ConstantsUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SellGoldAmountAddingToBankingAccountTest {

	@Test
	public void sellGoldAmountAddingToBankingAccount() throws Exception   {
	FileInputStream fis = new FileInputStream(ConstantsUtility.propertyfilepath);
	Properties prop = new Properties();
	prop.load(fis);
	String URL = prop.getProperty("stgurl");
	String USERNAME = prop.getProperty("usernamee");

	FirefoxOptions options = new FirefoxOptions();

    // Create a FirefoxProfile to manage preferences
    FirefoxProfile profile = new FirefoxProfile();

    // Set a preference to allow or deny location access (false to deny)
    profile.setPreference("geo.prompt.testing", true);
    profile.setPreference("geo.prompt.testing.allow", false);

    // Assign the profile to the FirefoxOptions
    options.setProfile(profile);
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(URL);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME, Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Gold Suvidha']"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Sell Gold']"))).click();
	
	
	
	driver.findElement(By.xpath("//input[@placeholder='Enter grams']")).sendKeys("2");    // This element is for Banking account transfer
	
//	driver.findElement(By.xpath("//input[@formcontrolname='grams']")).sendKeys("2");      // This element is for booking account transfer
    
	
	// This is for transfering amount to bank accounts
	
	
	WebElement selectAccount = driver.findElement(By.xpath("//select[@formcontrolname='transferTo']"));
	wait.until(ExpectedConditions.elementToBeClickable(selectAccount)).click();
	Select s = new Select(selectAccount);
	Thread.sleep(1000);
	s.selectByVisibleText("Bank Amount");
	
	String lastFourNumbersOfbankAccountNo = driver.findElement(By.xpath("//option[contains(text(),'1244')]")).getText();
	System.out.println(lastFourNumbersOfbankAccountNo);
	WebElement selectBank = driver.findElement(By.xpath("//select[@formcontrolname='bankId']"));
	wait.until(ExpectedConditions.elementToBeClickable(selectBank)).click();
	Select s1 = new Select(selectBank);
	Thread.sleep(1000);
	s1.selectByVisibleText(lastFourNumbersOfbankAccountNo);
	driver.findElement(By.xpath("//div[.='Continue']")).click();
    
	try 
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-success mb-4 pl-5 pt-5 pb-5']")));
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='imagemodal'])[1]")));
	    
	    driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Product");
		
		driver.findElement(By.xpath("//label[contains(.,'4')]")).click();
		
		driver.findElement(By.xpath("//button[.=' submit ']")).click();
		
		driver.findElement(By.xpath("//button[.=' X ']")).click();
		
		String SuccessAlertMsg = driver.findElement(By.xpath("//div[@class='alert alert-success mb-4 pl-5 pt-5 pb-5']")).getText();
		
		System.out.println(SuccessAlertMsg);
	} 
	catch (Exception e) 
	{
		String ErrorAlertMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    if(ErrorAlertMsg.contains("invalid"))
	    {
	    	System.out.println(ErrorAlertMsg);
	    	Assertion a = new Assertion();
			a.fail();
	    }
	    else if(ErrorAlertMsg.contains("wait"))
	    {
	    	System.out.println(ErrorAlertMsg);
	    	Assertion a = new Assertion();
			a.fail();
	    }
	}	
  }
}
