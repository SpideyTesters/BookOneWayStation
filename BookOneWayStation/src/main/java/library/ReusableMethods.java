package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Reports.ExtentReportsPage;

public class ReusableMethods extends ExtentReportsPage
{

	WebDriver driver;
	ExtentReportsPage ep=new ExtentReportsPage();
	public ReusableMethods(WebDriver driver)
	{
		this.driver=driver;
	}

	public void launchApplication() throws InterruptedException              //To Launch the Make My Trip Application
	{
		driver.get(UseProperties.getUrl());
		Thread.sleep(1000);

		String PageTitle=driver.getTitle();

		if(PageTitle.contains("MakeMyTrip - #1 Travel Website"))
		{
			System.out.println("Entered Application is Make My Trip ");    		   
		}
		else
		{
			System.out.println("Error occured while opening application");
		}
	    test2.log(Status.PASS,"Entered the Make My Trip Application");
		rep.flush();
        
	}
	

	public String[] readExcelData(String sheetName) throws IOException {    //Reads data from Excel sheet
		File file=new File("./Properties/MMT.xlsx");
		FileInputStream fileip=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fileip);
		XSSFSheet sheet=wb.getSheet(sheetName);
		String[] Details=null;

		if(sheetName=="CabsSheet") 
		{                                                              
			Details=new String[2];
			XSSFRow row2=sheet.getRow(1);

			for(int i=0;i<2;i++)
			{
				XSSFCell cell=row2.getCell(i);
				Details[i]=row2.getCell(i).toString();
			}
		}
		else if(sheetName=="GiftcardsSheet")
		{
			Details=new String[7];
			XSSFRow row2=sheet.getRow(1);
			for(int i=0;i<7;i++)
			{
				XSSFCell cell=row2.getCell(i);
				CellType type=cell.getCellType();
				if(type.equals("NUMERIC"))
				{				
					Details[i]=row2.getCell(i).getNumericCellValue()+"";
				}
				else
				{
					Details[i]=row2.getCell(i).toString();
				}
			}
		}
		else 
		{
			System.out.println("Sheet does not exist");
		}
		return Details;

	}

	public void closeApplication()                              //To close the Make My Trip Application
	{
		driver.quit();              
	}
}

