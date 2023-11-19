package s1_Schemes;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.ConstantsUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.GoldPlusPlanPage;
import ObjectRepository.LandingPage;
import ObjectRepository.SchemesPage;

public class PomExampleScriptScheme extends BaseClass {

	  @Test
	  public void createScheme() throws Exception  {
      
	  LandingPage lPage = new LandingPage(driver);
	  	  
      lPage.clickOnSchemesLnk(driver);
	
      SchemesPage sPage = new SchemesPage(driver);
	  sPage.subscribeAScheme();
	
      GoldPlusPlanPage gPage = new GoldPlusPlanPage(driver);
      gPage.goldPlusPlanWithCoupons(driver);//we have to parameterize the below args
	 
    
      
	
	}
	
}



