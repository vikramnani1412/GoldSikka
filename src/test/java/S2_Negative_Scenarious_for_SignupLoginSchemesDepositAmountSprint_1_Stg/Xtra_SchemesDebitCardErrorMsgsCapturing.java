package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

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
public class Xtra_SchemesDebitCardErrorMsgsCapturing extends BaseClass{

	
	@Test                                                           //Card number error
	public void cardNumberErrorCapturing() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4017");
		
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}

	}
	
	@Test                                                        //Expiry date error
	public void giving1NumToExpiryDateErrorCapturing() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4017040048445000");
		
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		
	}
	
	@Test                                                        //Card holder name Error
	public void cardHolderNameErrorCapturing() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4017040048445000");
		
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		
	}
	
	@Test                                                       //Cvv error capturing
	public void cvvErrorCapturing() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		
		driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4017040048445000");
		
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
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
				Assert.fail();
			}
		} 
		catch (Exception e) 
		{
			Thread.sleep(5000);
		}
	    
		
	}
	
}
