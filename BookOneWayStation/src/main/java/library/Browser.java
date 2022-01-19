package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Reports.ExtentReportsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends ExtentReportsPage {

	ExtentReportsPage ep=new ExtentReportsPage();
	static WebDriver driver;
	
	
	public static WebDriver getWebDriver(String browserName) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("chrome"))                  //To use Chrome driver
		{
			WebDriverManager.chromedriver().setup();	   						
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))           //To use Firefox Driver
		{
			WebDriverManager.firefoxdriver().setup();			
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))              //To use Edge Driver
		{
			WebDriverManager.edgedriver().setup();			
			driver=new EdgeDriver();
		}
		else
		{
			driver=null;
			System.out.println("Please provide the browser Name as Chrome/Firefox");
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	 
}
