package S3_StgSettingsNegativeScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class EnteringInvalidDataInAllKycFeilds_11_ extends BaseClass{

	@Test(groups = "SettingsNegative2", priority = 11)        // Entering Invalid Data In All Kyc Feilds and click on submit
	  public void enteringInvalidDataInAllKycFeildsErrorTest()throws Exception
	  {
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String FatherName = eUtil.readDataFromExcel("Settings", 46, 1);
		String SpouseName = eUtil.readDataFromExcel("Settings", 47, 1);
		String AlternatePhNo = eUtil.readDataFromExcel("Settings", 48, 1);
		String PanNo = eUtil.readDataFromExcel("Settings", 49, 1);
		String AadhaarNo = eUtil.readDataFromExcel("Settings", 50, 1);
			
		driver.findElement(By.xpath("//span[.='Schemes']")).click();
		
		for(;;)
		{
		try 
		{
			driver.findElement(By.xpath("//span[.='Settings']")).click();
			break;
		}
		catch(Exception e)
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}}
		
		driver.findElement(By.xpath("//span[.='Settings']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/kyc']")).click();
		
		Thread.sleep(3000);
					
		driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
		
		Thread.sleep(3000);
		
		WebElement FathernameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
		FathernameEdt.clear();
		FathernameEdt.sendKeys(FatherName);
		Thread.sleep(2000);
					
		WebElement SpouseNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
		SpouseNameEdt.clear();
		SpouseNameEdt.sendKeys(SpouseName);
		Thread.sleep(2000);
		
		WebElement AltPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
		AltPhoneNo.clear();
		AltPhoneNo.sendKeys(AlternatePhNo);
		Thread.sleep(2000);
		
		WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
		PanNoEdt.clear();
		PanNoEdt.sendKeys(PanNo);
		Thread.sleep(2000);
		
		WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
		AadharNoEdt.clear();
		AadharNoEdt.sendKeys(AadhaarNo);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='M']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		Thread.sleep(3000);
	    
		String SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(SuccessMsg);
		
		
	}
	
}
