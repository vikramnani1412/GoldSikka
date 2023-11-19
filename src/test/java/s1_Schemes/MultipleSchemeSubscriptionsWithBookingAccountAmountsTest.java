package s1_Schemes;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import ObjectRepository.GoldPlusPlanPage;
import ObjectRepository.LandingPage;
import ObjectRepository.SchemesPage;

public class MultipleSchemeSubscriptionsWithBookingAccountAmountsTest extends BaseClass {

	@Test(priority = 1)
	public void schemeSubscriptionWithBookingAccountAmount1000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,1);
		  String Months = eUtil.readDataFromExcel("Scheme",2,1);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",16,10);
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1000(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 2)
	public void schemeSubscriptionWithBookingAccountAmount1500Rupees() throws Exception	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,1);
		  String Months = eUtil.readDataFromExcel("Scheme",7,1);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",17,10);
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 3)
	public void schemeSubscriptionWithBookingAccountAmount2000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,1);
		  String Months = eUtil.readDataFromExcel("Scheme",12,1);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",18,10);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount2000(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	
	//Here
	@Test(priority = 4)
	public void schemeSubscriptionWithBookingAccountAmount2500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,1);
		  String Months = eUtil.readDataFromExcel("Scheme",17,1);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",19,10);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount2500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 5)
	public void schemeSubscriptionWithBookingAccountAmount3000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,1);
		  String Months = eUtil.readDataFromExcel("Scheme",22,1);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",20,10);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount3000(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 6)
	public void schemeSubscriptionWithBookingAccountAmount3500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,4);
		  String Months = eUtil.readDataFromExcel("Scheme",2,4);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",21,10);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount3500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 7)
	public void schemeSubscriptionWithBookingAccountAmount4000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,4);
		  String Months = eUtil.readDataFromExcel("Scheme",7,4);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",16,11);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount4000(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 8)
	public void schemeSubscriptionWithBookingAccountAmount4500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,4);
		  String Months = eUtil.readDataFromExcel("Scheme",12,4);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",16,11);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount4500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 9)
	public void schemeSubscriptionWithBookingAccountAmount5000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,4);
		  String Months = eUtil.readDataFromExcel("Scheme",17,4);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",16,11);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 10)
	public void schemeSubscriptionWithBookingAccountAmount5500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,4);
		  String Months = eUtil.readDataFromExcel("Scheme",22,4);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",16,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 11)
	public void schemeSubscriptionWithBookingAccountAmount6000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,7);
		  String Months = eUtil.readDataFromExcel("Scheme",2,7);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",17,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 12)
	public void schemeSubscriptionWithBookingAccountAmount6500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,7);
		  String Months = eUtil.readDataFromExcel("Scheme",7,7);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",18,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 13)
	public void schemeSubscriptionWithBookingAccountAmount7000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,7);
		  String Months = eUtil.readDataFromExcel("Scheme",12,7);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",19,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 14)
	public void schemeSubscriptionWithBookingAccountAmount7500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",16,7);
		  String Months = eUtil.readDataFromExcel("Scheme",17,7);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",20,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 15)
	public void schemeSubscriptionWithBookingAccountAmount8000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",21,7);
		  String Months = eUtil.readDataFromExcel("Scheme",22,7);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",21,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 16)
	public void schemeSubscriptionWithBookingAccountAmount8500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,10);
		  String Months = eUtil.readDataFromExcel("Scheme",2,10);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",22,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount1500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 17)
	public void schemeSubscriptionWithBookingAccountAmount9000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",6,10);
		  String Months = eUtil.readDataFromExcel("Scheme",7,10);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",13,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount9000(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
	}
	
	@Test(priority = 18)
	public void schemeSubscriptionWithBookingAccountAmount9500Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",11,10);
		  String Months = eUtil.readDataFromExcel("Scheme",12,10);
		  String TotalPayableAmount = eUtil.readDataFromExcel("Scheme",24,12);
		  
		  
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageBookingAccount9500(driver, SelectAmount, Months, TotalPayableAmount);//we have to parameterize the below args
}
}