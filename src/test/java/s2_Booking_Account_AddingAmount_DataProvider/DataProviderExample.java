package s2_Booking_Account_AddingAmount_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ConstantsUtility;
import GenericUtility.ExcelFileUtility;

public class DataProviderExample {

	
	@Test(dataProvider = "excelData")
	public void testWithExcelData(String columnValue) throws Exception {
		
		System.out.println(columnValue);
	}
	
	@DataProvider(name = "excelData")
	public Object[][] testData() {
		String[] columnData = ExcelFileUtility.getSingleColumnData(ConstantsUtility.excelfilepath, "SchemesBanksDropdown", 0); //| Replace
																															   // '0'
																															   // with
																															   // the
																															   // desired
																															   // column
																															   // index.
		Object[][] data = new Object[columnData.length][1];
		for (int i = 0; i < columnData.length; i++) 
		{
			data[i][0] = columnData[i];
		}
		return data;
	}
}
