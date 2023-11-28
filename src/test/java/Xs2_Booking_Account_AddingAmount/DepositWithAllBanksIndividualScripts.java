package Xs2_Booking_Account_AddingAmount;

	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;
	import GenericUtility.BaseClass;
	import ObjectRepository.BookingAccountPage;
	import ObjectRepository.BookingAccountPhNoFramePage;
	import ObjectRepository.LandingPage;

	public class DepositWithAllBanksIndividualScripts extends BaseClass {

		@Test(priority = 1)
		public void hdfcBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndHdfcBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully from HDFC Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
		}
		
		@Test(priority = 2)
		public void iciciBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndIciciBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully From ICICI Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
			
			lPage.clickOnBookingAccountLnk(driver);
		}
		
		@Test(priority = 3)
		public void axisBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndAxisBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully From Axis Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
		}
		
		@Test(priority = 4)
		public void KotakBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndKotakBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully From Kotak Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
		}
		
		@Test(priority = 5)
		public void yesBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndYesBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully From Yes Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
		}
		
		@Test(priority = 6)
		public void bobBankDeposit() throws InterruptedException
		{
			LandingPage lPage = new LandingPage(driver);
			System.out.println("Before adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
	        
//			lPage.viewBookingAccountBalance(driver);
			
			BookingAccountPage bap = new BookingAccountPage(driver);
			bap.depositMoneyInBookingAccount(driver);
			
			WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
			driver.switchTo().frame(element);
			
			BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
			bapnofp.enterPhoneNumberAndBOBBankBtnClickOnProceed(driver);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
			
			BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
			
			Set<String> childWindow = driver.getWindowHandles();
					
			for(String childids : childWindow)
			{
				if(!childids.equals(parentWindow))
				{
					driver.switchTo().window(childids);
					driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			driver.switchTo().window(parentWindow);
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	                
	        wait.until(ExpectedConditions.alertIsPresent());
	        
			String AlertMsg = driver.switchTo().alert().getText();
			System.out.println(AlertMsg);
			
			if(AlertMsg.contains("Successfully added Rs"))
			{
				System.out.println("Amount Added Successfully From BOB Bank");
			}
			else
			{
				System.out.println("Amount Not Added Successfully");
			}
			driver.switchTo().alert().accept();
			

			System.out.println("After adding amount to booking account");
			lPage.clickOnBookingAccountLnk(driver);
		}
		
	
}
