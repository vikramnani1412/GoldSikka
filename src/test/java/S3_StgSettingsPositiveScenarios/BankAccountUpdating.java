package S3_StgSettingsPositiveScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.WebDriverUtility;

@Listeners(GenericUtility.ListnersImplementationClass.class)
public class BankAccountUpdating extends BaseClass{

	@Test(groups = "BankAcUpdation" , priority = 1 )
	public void accountUpdation1() throws Exception
	{		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",30,1);
		String AcNo1 = eUtil.readDataFromExcel("Settings",31,1);
		String BankName = eUtil.readDataFromExcel("Settings",32,1);
		String Branch = eUtil.readDataFromExcel("Settings",33,1);
		String IfscCode = eUtil.readDataFromExcel("Settings",34,1);
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts/add']")).click();
        
		driver.findElement(By.xpath("//input[@placeholder='Full name as per bank details']")).sendKeys(Name);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']")).sendKeys(AcNo1);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Bank Name']")).sendKeys(BankName);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']")).sendKeys(Branch);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter IFSC Code']")).sendKeys(IfscCode);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);		
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	
	    WebElement BankAccountsPage = driver.findElement(By.xpath("//section[contains(@class,'page d')]"));
	    WebElement NewlyAddedBank = driver.findElement(By.xpath("//h5[text()=' "+Name+"']/../p[.='"+AcNo1+"']/following-sibling::p[contains(.,'"+BankName+"')]/following-sibling::p[.='"+IfscCode+"']"));
	    String NewlyAddedBankMsg = NewlyAddedBank.getText();
		wait.until(ExpectedConditions.visibilityOf(BankAccountsPage));
		if(BankAccountsPage.isDisplayed())
		{
			if(NewlyAddedBank.isEnabled())
			{
				System.out.println(NewlyAddedBankMsg+"Successfully Added");
			}
		}
		else 
		{
			System.out.println(NewlyAddedBankMsg+"Bank Account Not Added");
			Assert.fail();
		}
				
		
	}	
	
	
	@Test(groups = "BankAcUpdation" , priority = 2 )
	public void accountUpdation2() throws Exception
	{		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",30,1);
		String AcNo2 = eUtil.readDataFromExcel("Settings",31,3);
		String BankName = eUtil.readDataFromExcel("Settings",32,1);
		String Branch = eUtil.readDataFromExcel("Settings",33,1);
		String IfscCode = eUtil.readDataFromExcel("Settings",34,1);
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts/add']")).click();
        
		driver.findElement(By.xpath("//input[@placeholder='Full name as per bank details']")).sendKeys(Name);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']")).sendKeys(AcNo2);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Bank Name']")).sendKeys(BankName);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']")).sendKeys(Branch);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter IFSC Code']")).sendKeys(IfscCode);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);		
		
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		
		WebElement BankAccountsPage = driver.findElement(By.xpath("//section[contains(@class,'page d')]"));
	    WebElement NewlyAddedBank = driver.findElement(By.xpath("//h5[text()=' "+Name+"']/../p[.='"+AcNo2+"']/following-sibling::p[contains(.,'"+BankName+"')]/following-sibling::p[.='"+IfscCode+"']"));
	    String NewlyAddedBankMsg = NewlyAddedBank.getText();
		wait.until(ExpectedConditions.visibilityOf(BankAccountsPage));
		if(BankAccountsPage.isDisplayed())
		{
			if(NewlyAddedBank.isEnabled())
			{
				System.out.println(NewlyAddedBankMsg+"Successfully Added");
			}
		}
		else 
		{
			System.out.println(NewlyAddedBankMsg+"Bank Account Not Added");
			Assert.fail();
		}
/*		
		try
		{
			WebElement Success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			wait.until(ExpectedConditions.visibilityOf(Success));
			String SuccessMsg = Success.getText();
			if(SuccessMsg.contains("Success"))
			{
			   System.out.println(SuccessMsg);
			}
		}
		catch(Exception e)
		{
			WebElement Danger = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			wait.until(ExpectedConditions.visibilityOf(Danger));
			String DangerMsg = Danger.getText();
			System.out.println(DangerMsg);
			Assert.fail();
		}
*/
	}	
	
	
	@Test(groups = "BankAcUpdation" , priority = 3)
	public void editBankAccountDetails() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String Name = eUtil.readDataFromExcel("Settings",30,1);
		String EditName = eUtil.readDataFromExcel("Settings",30,2);
		String EditAcNo = eUtil.readDataFromExcel("Settings",31,2);
		String EditBankName = eUtil.readDataFromExcel("Settings",32,2);
		String EditBranch = eUtil.readDataFromExcel("Settings",33,2);
		String EditIfscCode = eUtil.readDataFromExcel("Settings",34,2);
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		driver.findElement(By.xpath("(//h5[.=' "+Name+"'])[last()]/../following-sibling::div//i[@class='far fa-edit']")).click();
		
        WebElement NameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Name on the Account']"));
        NameEdt.clear();
        NameEdt.sendKeys(EditName);
		
        WebElement AccountNoEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Account Number']"));
        AccountNoEdt.clear();
        AccountNoEdt.sendKeys(EditAcNo);
		
        WebElement BankNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Bank Name']"));
        BankNameEdt.clear();
        BankNameEdt.sendKeys(EditBankName);
		
        WebElement BranchNameEdt = driver.findElement(By.xpath("//input[@placeholder='Enter Branch Name']"));
        BranchNameEdt.clear();
        BranchNameEdt.sendKeys(EditBranch);
		
		WebElement IfscCodeEdt = driver.findElement(By.xpath("//input[@placeholder='Enter IFSC Code']"));
		IfscCodeEdt.clear();
		IfscCodeEdt.sendKeys(EditIfscCode);
		
		driver.findElement(By.xpath("//button[.=' Submit ']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));	
		
		WebElement BankAccountsPage = driver.findElement(By.xpath("//section[contains(@class,'page d')]"));
	    WebElement NewlyAddedBank = driver.findElement(By.xpath("//h5[text()=' "+EditName+"']/../p[.='"+EditAcNo+"']/following-sibling::p[contains(.,'"+EditBankName+"')]/following-sibling::p[.='"+EditIfscCode+"']"));
	    String NewlyAddedBankMsg = NewlyAddedBank.getText();
		wait.until(ExpectedConditions.visibilityOf(BankAccountsPage));
		if(BankAccountsPage.isDisplayed())
		{
			if(NewlyAddedBank.isEnabled())
			{
				System.out.println(NewlyAddedBankMsg+"Successfully Added");
			}
		}
		else 
		{
			System.out.println(NewlyAddedBankMsg+"Bank Account Not Added");
			Assert.fail();
		}
		
/*		
		try
		{
			WebElement Success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			wait.until(ExpectedConditions.visibilityOf(Success));
			String SuccessMsg = Success.getText();
			if(SuccessMsg.contains("Success"))
			{
			   System.out.println(SuccessMsg);
			}
		}
		catch(Exception e)
		{
			WebElement Danger = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
			wait.until(ExpectedConditions.visibilityOf(Danger));
			String DangerMsg = Danger.getText();
			System.out.println(DangerMsg);
			Assert.fail();
		}
*/		
	}
	
	
	@Test(groups = "BankAcUpdation" , priority = 4)
	public void makingPrimaryAccount() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();		
		String EditName = eUtil.readDataFromExcel("Settings",30,2);
		
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
		
		driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
		
		
		//Here name we have to make dynamic to access multiple values
		driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.='Set Default']")).click();
        
		String PrimaryConformationMsg = driver.findElement(By.xpath("//h5[.=' "+EditName+"']/../following-sibling::div//a[.=' Primary']")).getText();
		
		if(PrimaryConformationMsg.contains("Primary"))
		{
			System.out.println(EditName+" Set as "+PrimaryConformationMsg+" Bank");
		}
		else
		{
			System.out.println(EditName+" Not Set As Primary Bank");
		}
		
	}
	
	
		@Test(groups = "BankAcUpdation" , priority = 5)
		public void deleteBankAccountDetails() throws Exception
		{
			ExcelFileUtility eUtil = new ExcelFileUtility();		
			String Name = eUtil.readDataFromExcel("Settings",30,1);
			
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
			
			driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
			
			driver.findElement(By.xpath("(//h5[.=' "+Name+"'])[last()]/../following-sibling::div//i[@class='fas fa-trash-alt']")).click();
		    
			driver.switchTo().alert().accept();   //To delete Deleting
			
//			driver.switchTo().alert().dismiss();  //To Cancel Deleting
		    			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
			
			try
			{
				WebElement Success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				wait.until(ExpectedConditions.visibilityOf(Success));
				String SuccessMsg = Success.getText();
				if(SuccessMsg.contains("Success"))
				{
				   System.out.println(SuccessMsg);
				}
			}
			catch(Exception e)
			{
				WebElement Danger = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
				wait.until(ExpectedConditions.visibilityOf(Danger));
				String DangerMsg = Danger.getText();
				System.out.println(DangerMsg);
				Assert.fail();
			}
			
	    }
		
		
		   @Test
		   public void makingPrimaryAccountToClearExistingDataForNextExecution() throws EncryptedDocumentException, IOException, AWTException
		   {
			    ExcelFileUtility eUtil = new ExcelFileUtility();		
				String EditName = "Suryavanshi shivshankar";
				
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
				
				driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
				
				
				//Here name we have to make dynamic to access multiple values
				driver.findElement(By.xpath("//h5[text()=' Suryavanshi shivshankar']/..//p[.='342212707015']/../following-sibling::div/div/a[.='Set Default']")).click();
		        
				String PrimaryConformationMsg = driver.findElement(By.xpath("//h5[text()=' Suryavanshi shivshankar']/../following-sibling::div/div/a[text()=' Primary']")).getText();
				
				if(PrimaryConformationMsg.contains("Primary"))
				{
					System.out.println(EditName+" Set as "+PrimaryConformationMsg+" Bank");
				}
				else
				{
					System.out.println(EditName+" Not Set As Primary Bank");
				}
		   }
		   
		   
		   @Test(groups = "BankAcUpdation" , priority = 5)
			public void deleteingExistingNotEditedBankAccountForNextExecutionDetails() throws Exception
			{
				ExcelFileUtility eUtil = new ExcelFileUtility();		
				String EditName = eUtil.readDataFromExcel("Settings",30,2);
				
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
				
				driver.findElement(By.xpath("//a[@href='/settings/bankAccounts']")).click();
				
				driver.findElement(By.xpath("(//h5[.=' "+EditName+"'])[last()]/../following-sibling::div//i[@class='fas fa-trash-alt']")).click();
			    
				driver.switchTo().alert().accept();   //To delete Deleting
				
//				driver.switchTo().alert().dismiss();  //To Cancel Deleting
			    			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
				
				try
				{
					WebElement Success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
					wait.until(ExpectedConditions.visibilityOf(Success));
					String SuccessMsg = Success.getText();
					if(SuccessMsg.contains("Success"))
					{
					   System.out.println(SuccessMsg);
					}
				}
				catch(Exception e)
				{
					WebElement Danger = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
					wait.until(ExpectedConditions.visibilityOf(Danger));
					String DangerMsg = Danger.getText();
					System.out.println(DangerMsg);
					Assert.fail();
				}
				
		    }
}
