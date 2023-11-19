package s1_Schemes;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import ObjectRepository.GoldPlusPlanPage;
import ObjectRepository.LandingPage;
import ObjectRepository.SchemesPage;

public class MultipleSchemesSubscriptionWithNetBankingAllBanksDiffAmountTest extends BaseClass{

	@Test
	public void schemeSubscriptionNetBankingHdfc1000Rupees() throws Exception
	{
		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",1,1);
		  String Months = eUtil.readDataFromExcel("Scheme",2,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",3,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",4,1);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageHdfc1000(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	      
	      
	}
	
	@Test
	public void schemeSubscriptionNetBankingIcici1500Rupees() throws Exception
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
	      gPage.goldPlusPlanPageIcici1500(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	}
	
	
	
	@Test
	public void schemeSubscriptionNetBankingAxis2000Rupees() throws Exception
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
	      gPage.goldPlusPlanPageAxis2000(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	}
	
	@Test
	public void schemeSubscriptionNetBankingKotak2500Rupees() throws Exception
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
	      gPage.goldPlusPlanPageKotak2500(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	}
	
	@Test
	public void schemeSubscriptionNetBankingYes3000Rupees() throws Exception
	{

		  
	      ExcelFileUtility eUtil = new ExcelFileUtility();
		  String SelectAmount = eUtil.readDataFromExcel("Scheme",20,1);
		  String Months = eUtil.readDataFromExcel("Scheme",21,1);
		  String EnterAmount = eUtil.readDataFromExcel("Scheme",22,1);
		  String MobileNumber = eUtil.readDataFromExcel("Scheme",23,1);
		  
		  System.out.println(SelectAmount+" Scheme Subscription Successful");
		  
		  LandingPage lPage = new LandingPage(driver);
	      lPage.clickOnSchemesLnk(driver);
		
	      SchemesPage sPage = new SchemesPage(driver);
		  sPage.subscribeAScheme();
		
	      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
	      gPage.goldPlusPlanPageYes3000(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	}
	
	@Test
	public void schemeSubscriptionNetBankingBOB3500Rupees() throws Exception
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
	      gPage.goldPlusPlanPageBOB3500(driver, SelectAmount, Months, EnterAmount , MobileNumber);//we have to parameterize the below args
	}
	
		
	
	
}