package S3_StgSettingsPositiveScenarios;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class KycUpdationTest extends BaseClass {

	@Test(groups = "KycUpdation" , priority = 1)
	public void kycUpdation1() throws Exception
	{
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String FatherName = eUtil.readDataFromExcel("Settings",6,6);
		String SpouseName = eUtil.readDataFromExcel("Settings",7,6);
		String AltPhNo = eUtil.readDataFromExcel("Settings",8,6);
		String PanNo = eUtil.readDataFromExcel("Settings",9,6);
		String AadharNo = eUtil.readDataFromExcel("Settings",10,6);
		                                                                        //  Base class added Want to check when server is stable		
		for(;;)
		{
			Thread.sleep(3000);
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
		
		driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
		
		
		Thread.sleep(3000);
		
		WebElement SposeNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
		SposeNameEdt.clear();
		SposeNameEdt.sendKeys(SpouseName);
		
		Thread.sleep(3000);
		
		WebElement AlternatePhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
		AlternatePhoneNoEdt.clear();
		AlternatePhoneNoEdt.sendKeys(AltPhNo);
		
		Thread.sleep(3000);
		
		WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
		PanNoEdt.clear();
		PanNoEdt.sendKeys(PanNo);
		
		Thread.sleep(3000);
		
		WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
		AadharNoEdt.clear();
		AadharNoEdt.sendKeys(AadharNo);
		
		Thread.sleep(3000);
		
		WebElement MaleRadioBtn = driver.findElement(By.xpath("//input[@value='M']"));
		MaleRadioBtn.click();
		
		Thread.sleep(3000);
		
//		WebElement FemaleRadioBtn = driver.findElement(By.xpath("//input[@value='F']"));
		
		WebElement FatherNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
		FatherNameEdt.clear();
		FatherNameEdt.sendKeys(FatherName+jUtil.getRandomNum());
		System.out.println(FatherName+jUtil.getRandomNum());
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		driver.navigate().refresh();
		
		try
		{
			WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String successMsg = SuccessMsg.getText();
			System.out.println(successMsg);
		}
		catch(Exception e)
		{
			WebElement DangerMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			String dangerMsg = DangerMsg.getText();
			System.out.println(dangerMsg);
			Assert.fail();
		}
		
	}
	
	@Test(groups = "KycUpdation" , priority = 2)
	public void kycUpdation2() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String FatherName = eUtil.readDataFromExcel("Settings",6,7);
		String SpouseName = eUtil.readDataFromExcel("Settings",7,7);
		String AltPhNo = eUtil.readDataFromExcel("Settings",8,7);
		String PanNo = eUtil.readDataFromExcel("Settings",9,7);
		String AadharNo = eUtil.readDataFromExcel("Settings",10,7);
				
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
		
		driver.findElement(By.xpath("//a[@routerlink='/settings/kyc']")).click();
		
		driver.findElement(By.xpath("//button[.=' Update Kyc ']")).click();
		
		WebElement FatherNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Father Name']"));
		FatherNameEdt.clear();
		FatherNameEdt.sendKeys(FatherName);
		
		Thread.sleep(3000);
		
		WebElement SposeNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Spouse Name']"));
		SposeNameEdt.clear();
		SposeNameEdt.sendKeys(SpouseName);
		
		Thread.sleep(3000);
		
		WebElement AlternatePhoneNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Alternate Phone No']"));
		AlternatePhoneNoEdt.clear();
		AlternatePhoneNoEdt.sendKeys(AltPhNo);
		
		Thread.sleep(3000);
		
		WebElement PanNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter PAN No']"));
		PanNoEdt.clear();
		PanNoEdt.sendKeys(PanNo);
		
		Thread.sleep(3000);
		
		WebElement AadharNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar No']"));
		AadharNoEdt.clear();
		AadharNoEdt.sendKeys(AadharNo);
		
		Thread.sleep(3000);
		
		WebElement MaleRadioBtn = driver.findElement(By.xpath("//input[@value='M']"));
		MaleRadioBtn.click();
		
		Thread.sleep(3000);
		
//		WebElement FemaleRadioBtn = driver.findElement(By.xpath("//input[@value='F']"));
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		try
		{
			WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String successMsg = SuccessMsg.getText();
			System.out.println(successMsg);
		}
		catch(Exception e)
		{
			WebElement DangerMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			String dangerMsg = DangerMsg.getText();
			System.out.println(dangerMsg);
			Assert.fail();
		}
		
	}
	
	
}
