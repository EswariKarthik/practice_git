package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadInput implements IAutoConstants
{
	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet s1;
	private XSSFRow r1;
	private int rows, columns;
	private  DataFormatter formatter= new DataFormatter();
	
	@DataProvider
	public Object[][] readInputData(String testCaseName) throws IOException
	{
			fis = new FileInputStream(new File(INPUT_DATA_PATH));
			wb = new XSSFWorkbook(fis);
			System.out.println(testCaseName);
			s1 = wb.getSheet(testCaseName);
			r1 = s1.getRow(0);
			rows = s1.getPhysicalNumberOfRows();
			columns = r1.getPhysicalNumberOfCells();
			XSSFRow row;
			XSSFCell cell;
			
			Object data[][] = new Object[rows-1][columns];
			for(int i=0; i<rows-1; i++)
			{
				row = s1.getRow(i+1);
				for(int j=0;j<columns; j++)
				{
					if (row == null)
					{
						data[i][j] = "";
					}
					else
					{
						cell = row.getCell(j);
						if(cell == null)
						{
							data[i][j] = "";
						}
						else
						{
							String value = formatter.formatCellValue(cell);
							data[i][j] = value;
						}
					}
				}
			}
			
			return data;
	}

}
