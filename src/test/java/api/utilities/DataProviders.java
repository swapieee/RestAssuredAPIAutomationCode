package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "AllData")
	public String[][] AllDataProvider() {
		
		String filename = System.getProperty("user.dir") + "//Test Data//Test_Data.xlsx";
		
		int rowcnt = ReadExcelFile.getRowCount(filename, "Sheet1");
		int colcount = ReadExcelFile.getColCount(filename, "Sheet1");

		String userData[][] = new String[rowcnt-1][colcount];
		
		// Loop for Row - starting from 2nd row as Data is present from 2nd row onwards

		for(int r=1;r<rowcnt;r++) {
			// Loop for Column
			for(int c=0;c<colcount;c++) {
				
				userData[r-1][c] = ReadExcelFile.getCellValue(filename, "Sheet1", r, c);
			}
		}
		return userData;
	}
	
	
	@DataProvider(name = "UserNamesData")
	public String[] UserNameProvider() {
		
		String filename = System.getProperty("user.dir") + "//Test Data//Test_Data.xlsx";
		
		int rowcnt = ReadExcelFile.getRowCount(filename, "Sheet1");
//		int colcount = ReadExcelFile.getColCount(filename, "Sheet1");

		String userNamesData[] = new String[rowcnt-1];
		
		// Loop for Row - starting from 2nd row as Data is present from 2nd row onwards
		for(int r=1;r<rowcnt;r++) {
			userNamesData[r-1] = ReadExcelFile.getCellValue(filename, "Sheet1", r, 1);
		}
		return userNamesData;
	}

}
