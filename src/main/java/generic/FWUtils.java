package generic;		//Scenario 05

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class FWUtils implements IAUTOCONSTANT 
{
	static Workbook wb;
	static FileInputStream fis;	

	public static String readData(String fileName, String sheet, int row, int cell)
	{
		String value="";
		try
		{
			fis=new FileInputStream(XLPATH+fileName);
			wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheet);
			Row r=sh.getRow(row);
			if(sh.getRow(row)==null)
			{
				r=sh.createRow(row);
			}
			Cell c=r.getCell(cell,MissingCellPolicy.CREATE_NULL_AS_BLANK);
			value=c.toString();
		}
		catch(Exception e)
		{
			Reporter.log("XL File Path is invalid",true);
		}
		return value;
	}
	
	public static void writeData(String fileName, String sheet, int row, int cell, String data)
	{
		try
		{
			fis = new FileInputStream(XLPATH+fileName);
			Workbook wb=WorkbookFactory.create(fis);
			Row r=wb.getSheet(sheet).getRow(row);
			if(r==null)
			{
				r=wb.getSheet(sheet).createRow(row);
			}
			Cell c=r.createCell(cell);
			c.setCellValue(data);
			wb.write(new FileOutputStream(XLPATH+fileName));
		}
		catch(Exception e)
		{
			Reporter.log("XL File Path is invalid",true);
		}
	}
	
	public static int rowCount(String fileName, String sheet)
	{
		int rowCount=0;
		try 
		{
			fis=new FileInputStream(XLPATH+fileName);
			wb=WorkbookFactory.create(fis);
			rowCount=wb.getSheet(sheet).getLastRowNum()+1;
		}
		catch(Exception e)
		{
			Reporter.log("XL File does not exist",true);
		}
		return rowCount;
	}
	
	public static void screenShotPage(String fileName, WebDriver driver)
	{
		File src, dst;
		TakesScreenshot ts=(TakesScreenshot)driver;
		try
		{
			src=ts.getScreenshotAs(OutputType.FILE);
			dst=new File(PHOTOPATH+fileName);
			FileUtils.copyFile(src, dst);
		}
		catch(Exception e)
		{
			Reporter.log("JPG File Path does not exist",true);
		}
	}
	
	public static void screenShotElement(String fileName, WebDriver driver, String xpath) throws IOException
	{
		File src=driver.findElement(By.xpath(xpath)).getScreenshotAs(OutputType.FILE);
		File dst=new File(PHOTOPATH+fileName);
		FileUtils.copyFile(src, dst);
	}
}
