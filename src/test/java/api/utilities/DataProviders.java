package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "//UserData.xlsx";
		
		ExcelUtility excel = new ExcelUtility(path);
		
		int rowCount = excel.getRowCount("Sheet1");
		int colCount = excel.getCellCount("Sheet1", 1);
		
		String data[][] = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				data[i-1][j] = excel.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path = System.getProperty("user.dir") + "//UserData.xlsx";
		ExcelUtility excel = new ExcelUtility(path);
		int rowCount = excel.getRowCount("Sheet1");
		String data[] = new String[rowCount];
		for(int i=1; i<=rowCount; i++)
		{
			data[i-1] = excel.getCellData("Sheet1", i, 1);
		}
		return data;
	}

}
