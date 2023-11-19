package S2_Negative_Scenarios_for_Sprint_1_Live_Appl_ChangesRequired;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class SchemesErrorsCapturing extends BaseClass{

	@Test
	public void enteringInvalidCouponCodeErrorCapturing() throws Exception
	{
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
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Schemes']"))).click();
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		
		Robot r = new Robot();
		
		try 
		{
			WebElement AgreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
            AgreeCheckBox.click();
		} 
// wait.until(ExpectedConditions.elementToBeClickable(AgreeCheckBox));
		catch (Exception e) 
		{

			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Enter coupon code']")).sendKeys("ghfhjv56354");
		
		driver.findElement(By.xpath("//button[.='Apply']")).click();
		Assert.fail();
				
		//div[@class='alert alert-danger']
		while (true)
		{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		
		try {
			String CouponAlertMsg = driver.findElement(By.xpath("//p[text()='Amount']/../following-sibling::div//div[.=' This field is required ']")).getText();
			System.out.println("You have to enter Amount "+CouponAlertMsg);
			
		} catch (Exception e) {
			Thread.sleep(1);
		}
	}
	
	
	@Test
	public void withOutGivingAmountErrorCapturing() throws Exception
	{
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
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Schemes']"))).click();
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
//		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
//		amount.click();
//		Select s = new Select(amount);
//		s.selectByValue("9500");
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		
		Robot r = new Robot();
		
		try {
			WebElement AgreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
            AgreeCheckBox.click();
		} catch (Exception e) {
			// wait.until(ExpectedConditions.elementToBeClickable(AgreeCheckBox));
			
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
		while (true)
		{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		
		try {
			String withoutEnterAmountError = driver.findElement(By.xpath("//p[text()='Amount']/../following-sibling::div//div[.=' This field is required ']")).getText();
			System.out.println("You have to enter Amount "+withoutEnterAmountError);
			
		} catch (Exception e) {
			Thread.sleep(1);
		}
	}
	
	@Test
	public void withOutCheckingIagreeCheckBoxErrorCapturing() throws Exception
	{
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
		
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME,Keys.ENTER);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Schemes']"))).click();
		
		driver.findElement(By.xpath("//img[@src='../../../assets/imgs/goldplus.png']")).click();
		WebElement amount = driver.findElement(By.xpath("//select[@formcontrolname='amount']"));
		amount.click();
		Select s = new Select(amount);
		s.selectByValue("9500");
		WebElement months = driver.findElement(By.xpath("//select[@placeholder='Months']"));
		months.click();
		Select s1 = new Select(months);
		s1.selectByVisibleText("12 Months");
		
		Robot r = new Robot();
		
//		try {
//			WebElement AgreeCheckBox = driver.findElement(By.xpath("//p[.='I Agree to Terms & Conditions']/../..//input[@type='checkbox']"));
//            AgreeCheckBox.click();
//		} catch (Exception e) {
//			// wait.until(ExpectedConditions.elementToBeClickable(AgreeCheckBox));
//			
//			r.keyPress(KeyEvent.VK_PAGE_DOWN);
//			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		}
		
		while (true)
		{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']"))).click();
			break;
		} 
		catch (Exception e) 
		{
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
		}
		}
		
		try {
			String TermsAndConditionsError = driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::div[@class='invalid-feedback ng-star-inserted']")).getText();
			System.out.println("You have not accepted terms and conditions "+TermsAndConditionsError);
			
		} catch (Exception e) {
			Thread.sleep(1);
			System.out.println("Not getting terms and conditions error");
		}
	}
}
