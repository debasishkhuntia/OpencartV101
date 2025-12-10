package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Data Provider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility exceluitlity= new ExcelUtility(path);
		
		int maxrow=exceluitlity.getRowCount("sheet1");
		
	     System.out.println(maxrow);
		int maxcol=exceluitlity.getCellCount("sheet1", 1);
		
		System.out.println(maxcol);
		
		String logindata[][]=new String [maxrow][maxcol]; //created two string array to store data
		
		for(int row=1;row<maxrow;row++)
		{
			for(int col=0;col<maxcol;col++)
			{
				logindata[row-1][col]= exceluitlity.getCellData("sheet1", row, col);//a
			}
			
			
		}
		return logindata;
		
		
	}
	//Data Provider 2
	
	//You can  N number of add data provider
}
