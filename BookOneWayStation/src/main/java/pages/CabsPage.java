package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Reports.ExtentReportsPage;
import library.ReusableMethods;

public class CabsPage extends ExtentReportsPage {
	static WebDriver driver;
	static String[] details=new String[10];
	ReusableMethods rm=new ReusableMethods(driver);
	ExtentReportsPage ep=new ExtentReportsPage();

	@FindBy(partialLinkText = "Cabs")
	WebElement cablogo;
	@FindBy(id =  "fromCity")
	WebElement from;	                 
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromCity;	
	@FindBy(xpath = "//input[@placeholder='To']" )
	WebElement toCity;                 
	@FindBy(xpath = " //*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[7]" )
	WebElement date;	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/ul/li[14]") 
	WebElement pickUpTime;
	@FindBy(linkText = "SEARCH")
	WebElement search;
	@FindBy(xpath = "//label[normalize-space()='SUV']" )
	WebElement carType;
	@FindBy(xpath = "//*[@id=\"List\"]/div[1]/div[1]/div[3]/div/div[2]/div/p[1]")
	WebElement price;


	public CabsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void readDetailsSheet() throws Exception              //To read excel data from Cabssheet
	{
		details=rm.readExcelData("CabsSheet");            

	}
	
    public void Alert()
    {
    	driver.findElement(By.xpath("//div[@data-cy='landingContainer']")).click();	   
    }
    
	public void clickcablogo() throws InterruptedException       //To click the CabLogo
	{
		try 
		{
		Thread.sleep(2000);
		cablogo.click();
		Thread.sleep(3000);
		test3.log(Status.PASS, "Cabs logo container is selected");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting the cabs logo container");
		}
	}
	public void From()                                         //To select from city
	{
		try
		{
		from.click();
		test3.log(Status.PASS, "From text box is selected");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting from text box");
		}
		
	}
	public void FromCity() throws InterruptedException       //Enter From City details
	{
		try
		{
		Thread.sleep(2000);
		fromCity.sendKeys(details[0]);
		Thread.sleep(2000);
		fromCity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		fromCity.sendKeys(Keys.ENTER);
		test3.log(Status.PASS, "From City data is entered");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while entering data in the from text box");
		}
		
	} 
	public void ToCity() throws InterruptedException        //Enter To city details 
	{
		try
		{
		toCity.sendKeys(details[1]);
		Thread.sleep(2000);
		toCity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		toCity.sendKeys(Keys.ENTER);
		test3.log(Status.PASS, "To City data is entered");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while entering data in the to text box");
		}
		
	}
	public void Date()                                    //To select the Date
	{
        try
        {
		date.click();
		test3.log(Status.PASS, "Departure date is selected");
        }
        catch(Exception e)
		{
			System.out.println("Error occured while selecting the date");
		}
        
	}
	public void Time()                                 //To select the Time 
	{
		try
		{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", pickUpTime);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", pickUpTime);
		test3.log(Status.PASS,"Pick up time is selected");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting the pick up time");
		}
		
	}
	public void Search()                              //To click the Search icon
	{
		try
		{
		search.click();
		test3.log(Status.PASS, "Search Button is clicked");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while clicking the search button");
		}
		
	}
	public void CarType() throws InterruptedException                   //To select the car Type
	{
		try
		{
		Thread.sleep(5000);
		carType.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		test3.log(Status.PASS, "CarType is selected");
		}
		catch(Exception e)
		{
			System.out.println("Error occured while selecting the car Type");
		}
		
	}
	public void price()                                     //To display the price
	{
		try
		{
		System.out.println("Lowest Charge: "+price.getText());
		test3.log(Status.PASS, "lowest charge for cab is returned");
		rep.flush();
		}
		catch(Exception e)
		{
			System.out.println("Error occured while returning the lowest charge for cab");
		}
		
	}	

}
