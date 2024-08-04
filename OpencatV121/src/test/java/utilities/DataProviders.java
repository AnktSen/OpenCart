package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path = "C:\\Users\\hp\\OneDrive\\OpenCart_LoginData.xlsx";
		
		ExcelUtiliy xlutil = new ExcelUtiliy(path);
		int totalRow = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1",1);
		
		String logindata [][] = new String[totalRow][totalCols];
		for(int i=1; i<=totalRow;i++) {
			for(int j=0; j<totalCols; j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
	}

}
