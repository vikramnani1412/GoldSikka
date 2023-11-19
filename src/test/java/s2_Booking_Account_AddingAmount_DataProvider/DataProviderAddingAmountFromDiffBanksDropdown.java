package s2_Booking_Account_AddingAmount_DataProvider;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ConstantsUtility;
import GenericUtility.ExcelFileUtility;
import ObjectRepository.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderAddingAmountFromDiffBanksDropdown {

	
	@Test(dataProvider = "excelData")
	public void testWithExcelData(String columnValue) throws Exception {
		
		FileInputStream fis = new FileInputStream(ConstantsUtility.propertyfilepath);
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("stgurl");
		String USERNAME = prop.getProperty("usernamee");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys(USERNAME, Keys.ENTER);
        
		WebElement BookingAccount = driver.findElement(By.xpath("//a[@href='/money-wallet']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(BookingAccount));
		BookingAccount.click();

		String BeforeAddingAmountToBookingAccount = driver.findElement(By.xpath("//p[contains(.,'₹ ')]")).getText();
		System.out.println("BeforeAddingAmountToBookingAccount= " + BeforeAddingAmountToBookingAccount);

		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).sendKeys("100000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='razorpay-checkout-frame']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8686184458");
		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
        
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='Netbanking']")).click();
		
		driver.findElement(By.xpath("//button[.='Select a different bank']")).click();
		
		while(true)
		{
		try
		{
			WebElement bank = driver.findElement(By.xpath("//img[contains(@alt,'"+columnValue+"')]"));
			bank.click();
			System.out.println(columnValue);
			break;
		}
		catch (Exception e) 
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
		}}
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.className("svelte-s8db8t")).click();
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

		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(15));
		        
		wait1.until(ExpectedConditions.alertIsPresent());

		String AlertMsg = driver.switchTo().alert().getText();
		System.out.println(AlertMsg);


		if(AlertMsg.contains("Successfully added Rs"))
		{
			System.out.println("Amount Added Successfully");
		}
		else
		{
			System.out.println("Amount Not Added Successfully");
		}
		driver.switchTo().alert().accept();

		DashboardPage dPage = new DashboardPage(driver);
		dPage.logoutOfApplication(driver);
		
}
		 //Pom Using
		
//		LandingPage lPage = new LandingPage(driver);
//		System.out.println("Before adding amount to booking account");
//		lPage.clickOnBookingAccountLnk(driver);
//
////			lPage.viewBookingAccountBalance(driver);
//
//		BookingAccountPage bap = new BookingAccountPage(driver);
//		bap.depositMoneyInBookingAccount(driver);
//
//		WebElement element = driver.findElement(By.xpath("//iframe[contains(@style,'op')]"));
//		driver.switchTo().frame(element);
//
//		BookingAccountPhNoFramePage bapnofp = new BookingAccountPhNoFramePage(driver);
//		bapnofp.enterPhoneNumberAndClickOnProceed(driver);
//
//		WebElement bank = driver.findElement(By.xpath("//div[contains(@id,'bank-item-" + columnValue + "')]"));
//		bank.click();
//
//		String parentWindow = driver.getWindowHandle();
//		driver.findElement(By.xpath("//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")).click();
//
//		BookingAccountPhNoFramePage b = new BookingAccountPhNoFramePage(driver);
//
//		Set<String> childWindow = driver.getWindowHandles();
//
//		for (String childids : childWindow) {
//			if (!childids.equals(parentWindow)) {
//				driver.switchTo().window(childids);
//				driver.findElement(By.xpath("//button[.='Success']")).click();
//			}
//		}
//		Thread.sleep(5000);
//		driver.switchTo().window(parentWindow);
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		wait.until(ExpectedConditions.alertIsPresent());
//
//		String AlertMsg = driver.switchTo().alert().getText();
////			System.out.println(AlertMsg+" from "+columnValue+" Bank");
//
//		if (AlertMsg.contains("Successfully added Rs")) {
//			System.out.println(AlertMsg + " from " + columnValue + " Bank");
//		} else {
//			System.out.println("Amount Not Added Successfully");
//		}
//		driver.switchTo().alert().accept();
//
//		System.out.println("After adding amount to booking account");
//		lPage.clickOnBookingAccountLnk(driver);
	
	
	@DataProvider(name = "excelData")
	public Object[][] testData() 
	{
		String[] columnData = ExcelFileUtility.getSingleColumnData(ConstantsUtility.excelfilepath, "SchemesBanksDropdown", 0); // Replace
																															// '0'
																															// with
																															// the
																															// desired
	                 																										// index.
		Object[][] data = new Object[columnData.length][1];
		for (int i = 0; i < columnData.length; i++) 
		{
			data[i][0] = columnData[i];
		}
		return data;
	}
	
}
