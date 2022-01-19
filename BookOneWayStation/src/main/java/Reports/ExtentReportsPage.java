package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsPage {
	public static ExtentHtmlReporter reporter;
	public static ExtentReports rep;
	public static ExtentTest test1,test2,test3,test4,test5,test6;

	public void extentReport()                     //To create the Extent Report
	 {
		try
		{
		  reporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "./Reports/ExtentReport_MakeMyTrip.html");
		  rep=new ExtentReports();
		  rep.attachReporter(reporter);
		  
		  reporter.config().setDocumentTitle("MakeMyTrip");
		  reporter.config().setReportName("MakeMyTrip_Module");
		  
		  rep.setSystemInfo("OS", "Windows 10 Enterprise");
		  rep.setSystemInfo("Environment", "MakeMyTrip");
		  rep.setSystemInfo("Version", "95");
		  rep.setSystemInfo("Browser","Chrome");
		 
		  test1=rep.createTest("Browser");
		  test2=rep.createTest("Reusable Methods");
		  test3=rep.createTest("CabsPage");
		  test4=rep.createTest("Giftcards Page");
		  test5=rep.createTest("ScreenShot");
		  test6=rep.createTest("Hotels Page");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while printing the Extent Report");
		}
		  
	 }
}
