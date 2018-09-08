package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;



public class ReadExcel 
{
	@Test
	public void runner() throws Exception
	{
		Workbook wb = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"./TestData/datapool"+".xls"));

		Sheet sheet = wb.getSheet("datapool_1XF");
		String drow="US";
		int totlcol = sheet.getColumns();
		
		int totlrow=sheet.getRows();
		
		//ArrayList to get the row
		ArrayList<String> arl= new ArrayList<String>();
		System.out.println("Total Col: "+totlcol+" "+"Total Rows"+totlrow);
		
		System.out.println(sheet.getCell(1,1).getContents());
		int row=0;
		
		for(int i=0;i<totlrow;i++)
		{
			arl.add(sheet.getCell(0, i).getContents().trim());
			if(sheet.getCell(0,i).getContents().trim().equalsIgnoreCase(drow.trim()))
			{
				row=i;
			}
			
		}
		System.out.println(arl);
		System.out.println("Selected Row is: "+row);
		
		//ArrayList for the headers
		
		ArrayList<String> headers = new ArrayList<String>();
		
		for(int i=0;i<totlcol;i++)
		{
			headers.add(sheet.getCell(i, 0).getContents().trim());
		}
		System.out.println(headers);
		//Adding row in form of Key value pair
		
		HashMap<String, String> currentRowData= new HashMap<String, String>();
		
		for(int i=0;i<totlcol;i++)
		{
			currentRowData.put(headers.get(i), sheet.getCell(i, row).getContents().trim());
		}
		
		System.out.println("Map Contents: "+currentRowData);
		
		System.out.println("Getting Specific Data: "+currentRowData.get("Company_Code"));
	}
}