package library;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import Reports.ExtentReportsPage;

public class ScreenShot extends ExtentReportsPage {
	WebDriver driver;
	ExtentReportsPage ep=new ExtentReportsPage();
	
	public ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	public void CaptureScreenShot()
	{
		try
		{
			Thread.sleep(2000);
			TakesScreenshot ScrObj= (TakesScreenshot) driver;
			File CaptureImg=ScrObj.getScreenshotAs(OutputType.FILE);
			String TimeStamp=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
			Files.copy(CaptureImg,new File("./Screenshot/"+TimeStamp+"_screenshot.png"));
			driver.navigate().back();
			test5.log(Status.PASS,"Screenshot is captured");
			rep.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error occured while taking screenshot");
		}
	}
}
