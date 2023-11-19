package s1_Schemes;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import ObjectRepository.GoldPlusPlanPage;
import ObjectRepository.LandingPage;
import ObjectRepository.SchemesPage;

public class MultipleSchemesSubscriptionWithBankingAndBookingAcc extends BaseClass{

	@Test(priority = 1)
	public void schemeSubscription1000Rupees() throws Exception
	{
		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,1);
		  String Months = eUtil.readDataFromExcel("Scheme",2,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",3,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",4,1);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		  
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	      
	}
	
	@Test(priority = 2)
	public void schemeSubscription1500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,1);
		  String Months = eUtil.readDataFromExcel("Scheme",7,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",8,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",9,1);
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 3)
	public void schemeSubscription2000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,1);
		  String Months = eUtil.readDataFromExcel("Scheme",12,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",13,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",14,1);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 4)
	public void schemeSubscription2500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,1);
		  String Months = eUtil.readDataFromExcel("Scheme",17,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",18,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",19,1);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 5)
	public void schemeSubscription3000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,1);
		  String Months = eUtil.readDataFromExcel("Scheme",22,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",23,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",24,1);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 6)
	public void schemeSubscription3500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,4);
		  String Months = eUtil.readDataFromExcel("Scheme",2,4);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",3,4);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",4,4);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 7)
	public void schemeSubscription4000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,4);
		  String Months = eUtil.readDataFromExcel("Scheme",7,4);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",8,4);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",9,4);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 8)
	public void schemeSubscription4500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,4);
		  String Months = eUtil.readDataFromExcel("Scheme",12,4);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",13,4);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",14,4);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 9)
	public void schemeSubscription5000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,4);
		  String Months = eUtil.readDataFromExcel("Scheme",17,4);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",18,4);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",19,4);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 10)
	public void schemeSubscription5500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,4);
		  String Months = eUtil.readDataFromExcel("Scheme",22,4);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",23,4);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",24,4);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 11)
	public void schemeSubscription6000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,7);
		  String Months = eUtil.readDataFromExcel("Scheme",2,7);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",3,7);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",4,7);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 12)
	public void schemeSubscription6500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,7);
		  String Months = eUtil.readDataFromExcel("Scheme",7,7);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",8,7);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",9,7);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 13)
	public void schemeSubscription7000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,7);
		  String Months = eUtil.readDataFromExcel("Scheme",12,7);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",13,7);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",14,7);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 14)
	public void schemeSubscription7500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,7);
		  String Months = eUtil.readDataFromExcel("Scheme",17,7);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",18,7);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",19,7);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 15)
	public void schemeSubscription8000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,7);
		  String Months = eUtil.readDataFromExcel("Scheme",22,7);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",23,7);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",24,7);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 16)
	public void schemeSubscription8500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,10);
		  String Months = eUtil.readDataFromExcel("Scheme",2,10);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",3,10);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",4,10);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 17)
	public void schemeSubscription9000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,10);
		  String Months = eUtil.readDataFromExcel("Scheme",7,10);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",8,10);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",9,10);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test(priority = 18)
	public void schemeSubscription9500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,10);
		  String Months = eUtil.readDataFromExcel("Scheme",12,10);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",13,10);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",14,10);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPage(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
}
