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
import org.testng.annotations.Test;

import GenericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SchemesDebitCardErrorMsgsCapturing {

	@Test
	public void cardNumberErrorCapturing() throws Exception
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
		
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("1231");
		
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("1026");
		
		driver.findElement(By.name("card[name]")).sendKeys("Gvc");
		
		driver.findElement(By.name("card[cvv]")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		
		try 
		{
			String CardNoErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[1]")).getText();
			
			if (CardNoErrorMsg.contains(CardNoErrorMsg))
			{
				System.out.println("Invalid "+CardNoErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String ExpiryDateErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[2]")).getText();
			
			if (ExpiryDateErrorMsg.contains(ExpiryDateErrorMsg)) 
			{
				System.out.println(ExpiryDateErrorMsg+" Please enter valid expiry date");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CardHolderNameErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[3]")).getText();
			
			if (CardHolderNameErrorMsg.contains(CardHolderNameErrorMsg))
			{
				System.out.println("You have entered invalid "+CardHolderNameErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CvvErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[4]")).getText();
			
			if (CvvErrorMsg.contains(CvvErrorMsg))
			{
				System.out.println("You have entered invalid "+CvvErrorMsg+" Please check Onc'e");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		driver.quit();
	}
	
	@Test
	public void expiryDateErrorCapturing() throws Exception
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
		
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("1231 2345 6788");
		
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("1");
		
		driver.findElement(By.name("card[name]")).sendKeys("Gvc");
		
		driver.findElement(By.name("card[cvv]")).sendKeys("654");
		
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		
		try 
		{
			String CardNoErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[1]")).getText();
			
			if (CardNoErrorMsg.contains(CardNoErrorMsg))
			{
				System.out.println("Invalid "+CardNoErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String ExpiryDateErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[2]")).getText();
			
			if (ExpiryDateErrorMsg.contains(ExpiryDateErrorMsg)) 
			{
				System.out.println(ExpiryDateErrorMsg+" Please enter valid expiry date");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CardHolderNameErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[3]")).getText();
			
			if (CardHolderNameErrorMsg.contains(CardHolderNameErrorMsg))
			{
				System.out.println("You have entered invalid "+CardHolderNameErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CvvErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[4]")).getText();
			
			if (CvvErrorMsg.contains(CvvErrorMsg))
			{
				System.out.println("You have entered invalid "+CvvErrorMsg+" Please check Onc'e");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		driver.quit();
	}
	
	@Test
	public void cardHolderNameErrorCapturing() throws Exception
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
		
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("1231 2345 6788");
		
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("1226");
		
		driver.findElement(By.name("card[name]")).sendKeys("1");
		
		driver.findElement(By.name("card[cvv]")).sendKeys("654");
		
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		
		try 
		{
			String CardNoErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[1]")).getText();
			
			if (CardNoErrorMsg.contains(CardNoErrorMsg))
			{
				System.out.println("Invalid "+CardNoErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String ExpiryDateErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[2]")).getText();
			
			if (ExpiryDateErrorMsg.contains(ExpiryDateErrorMsg)) 
			{
				System.out.println(ExpiryDateErrorMsg+" Please enter valid expiry date");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CardHolderNameErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[3]")).getText();
			
			if (CardHolderNameErrorMsg.contains(CardHolderNameErrorMsg))
			{
				System.out.println("You have entered invalid "+CardHolderNameErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CvvErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[4]")).getText();
			
			if (CvvErrorMsg.contains(CvvErrorMsg))
			{
				System.out.println("You have entered invalid "+CvvErrorMsg+" Please check Onc'e");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		driver.quit();
	}
	
	@Test
	public void cvvErrorCapturing() throws Exception
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
		
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		
		driver.findElement(By.xpath("//button[@class='svelte-s8db8t']")).click();
		
		driver.findElement(By.xpath("//div[.='Card']")).click();
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("1231 2345 6788");
		
		driver.findElement(By.xpath("//input[@id='card_expiry']")).sendKeys("1126");
		
		driver.findElement(By.name("card[name]")).sendKeys("Gvc");
		
		driver.findElement(By.name("card[cvv]")).sendKeys("6");
		
		driver.findElement(By.xpath("//button[.='Pay Now']")).click();
		
		try 
		{
			String CardNoErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[1]")).getText();
			
			if (CardNoErrorMsg.contains(CardNoErrorMsg))
			{
				System.out.println("Invalid "+CardNoErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String ExpiryDateErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[2]")).getText();
			
			if (ExpiryDateErrorMsg.contains(ExpiryDateErrorMsg)) 
			{
				System.out.println(ExpiryDateErrorMsg+" Please enter valid expiry date");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CardHolderNameErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[3]")).getText();
			
			if (CardHolderNameErrorMsg.contains(CardHolderNameErrorMsg))
			{
				System.out.println("You have entered invalid "+CardHolderNameErrorMsg);
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(1);
		}
		
		try 
		{
			String CvvErrorMsg = driver.findElement(By.xpath("(//div[@class='elem elem-one-click-checkout add-card-fields-one-cc-wrapper svelte-dau4sx invalid mature'])[4]")).getText();
			
			if (CvvErrorMsg.contains(CvvErrorMsg))
			{
				System.out.println("You have entered invalid "+CvvErrorMsg+" Please check Onc'e");
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		driver.quit();
	}
	
}
