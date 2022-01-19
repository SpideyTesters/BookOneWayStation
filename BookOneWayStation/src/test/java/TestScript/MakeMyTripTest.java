package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import Reports.ExtentReportsPage;
import library.Browser;
import library.ReusableMethods;
import library.ScreenShot;
import library.UseProperties;
import pages.CabsPage;
import pages.GiftCardsPage;
import pages.HotelsPage;

public class MakeMyTripTest {
	static WebDriver driver;
	ReusableMethods objRMethod;
	ExtentReportsPage ep=new ExtentReportsPage();
	
	@BeforeSuite(groups= {"smoke","Regression"})
	public void BrowserCall() throws InterruptedException
	{				
		driver=Browser.getWebDriver(UseProperties.getBrowser());

	}
	@Test(priority = 1,groups= {"smoke","Regression"})
	public void extentReportFile()
	{
		ep.extentReport();
	}
	
	@Test(priority = 2,groups = {"smoke","Regression"})
	public void LaunchApp() throws InterruptedException
	{
	
		ReusableMethods objRMethod=new ReusableMethods(driver);
		objRMethod.launchApplication();
	}

	@Test(priority = 3,groups = {"smoke","Regression"})
	public void Cabs() throws InterruptedException
	{	
		CabsPage cab=new CabsPage(driver);
		
		cab.Alert();
		
		cab.clickcablogo();
		
	}
	
	
	@Test(priority = 4,groups = {"Regression"})
	public void Cabs1() throws Exception
	{
		CabsPage cab=new CabsPage(driver);
		
		cab.readDetailsSheet();
		
		cab.From();
		
		cab.FromCity();
		
		cab.ToCity();
		
		cab.Date();
		
		cab.Time();
	}
	
	@Test(priority = 5,groups = {"smoke","Regression"})
	public void search()
	{
		CabsPage cab=new CabsPage(driver);
		
		cab.Search();
	}
	
	@Test(priority = 6,groups = {"Regression"})
	public void cabType() throws InterruptedException
	{
		CabsPage cab=new CabsPage(driver);
		
		cab.CarType();
		
		cab.price();
		
	}
	
	@Test(priority = 7,groups = {"smoke","Regression"})
	public void GiftCards() throws InterruptedException
	{		
		GiftCardsPage gc=new GiftCardsPage(driver);
		
		gc.MoreOption();
		
		gc.GiftCards();
	}
	
	@Test(priority = 8,groups = {"Regression"})
	public void GiftCards1() throws Exception
	{
		GiftCardsPage gc=new GiftCardsPage(driver);
		gc.readDetailsSheet();
		
		gc.CorporateGift();
		
		gc.MailSelection();
		
		gc.Name();
		
		gc.SenderName();
		
		gc.MobileNo();
		
		gc.SenderMobileNo();
		
		gc.EmailId();
		
		gc.SenderEmailId();
		
		gc.GiftMessage();
		
		gc.BuyNow();		
		
	}
	@Test(priority = 9,groups = {"Regression"})
	public void Screenshot()
	{
		ScreenShot scrshot=new ScreenShot(driver);

		scrshot.CaptureScreenShot(); 
	}
	
	@Test(priority = 10,groups = {"smoke","Regression"})
    public void navigation()
    {
    	for(int i=0;i<=2;i++)
    	{
    		driver.navigate().back();	
    	}
    	
    	
    }
	
	@Test(priority = 11,groups = {"smoke","Regression"})
	public void Hotels()
	{
		HotelsPage hp=new HotelsPage(driver);
		
		hp.Hotels();
	}
	@Test(priority = 12,groups = {"Regression"})
	public void Hotels1()
	{
		HotelsPage hp=new HotelsPage(driver);
		
		hp.guest();
		
	}
	
	@AfterSuite(groups= {"smoke","Regression"})
	public void CloseBrowser()
	{
		ReusableMethods objRMethod=new ReusableMethods(driver);
		objRMethod.closeApplication(); 
	}
	
}
