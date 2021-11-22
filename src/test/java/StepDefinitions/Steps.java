package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Proxy;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.*;

public class Steps {
	
	public static WebDriver driver;

	String LandingPageTitle = "//span[contains(text(),'How much can I borrow?')]";
	String CustomerApplicationType = "//li[@class='selected']/child::label[contains(text(),'Single')]";
	String NumberOfDependants ="//select[@title='Number of dependants']";
	String PropertyType = "//li[@class='selected']/child::label[contains(text(),'Home to live in')]";
	String CustomerIncome = "(//label[contains(text(),'Your income (before tax)')]/following::div/input)[1]" ;
	String CustomerOtherIncome="(//label[contains(text(),'Your other income')]/following::div/input)[1]";
	String CustomerLivingExpense="(//label[contains(text(),'Living expenses')]/following::div/input)[1]";
	String CustomerOtherLoanRepayments="(//label[contains(text(),'Other loan repayments')]/following::div/input)[1]";
	String CustomerOtherCreditCardLimits="(//label[contains(text(),'Total credit card limits')]/following::div/input)[1]";
	String CustomerLoanEligibiltyButton="//button[contains(text(),'Work out how much I could borrow')]";
	String EstimatedBorrowAmountEligibilty="//span[@id='borrowResultTextAmount']";
	String StartOverButton ="(//button[@class='start-over'])[1]";
	
	public static void SendkeysExpliciteWait(WebDriver driver , String locator , int timeOut, String value) {
		
		String locatorVal = locator;
		WebElement element = driver.findElement(By.xpath(locatorVal));
		WebDriverWait WW = new WebDriverWait(driver ,timeOut);
		WW.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	

	@Given("^Enter Living Expenses Only$")
	public void Loan_Eligibility_OnLivingExpenses_Only() throws InterruptedException, IOException 
	{
		String txt_msg="";
		SendkeysExpliciteWait(driver, CustomerLivingExpense, 5, "1");
		Click_button(CustomerLoanEligibiltyButton,"LoanEligibiltyButton");
		txt_msg="Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641.";
		System.out.println(txt_msg);
	}
	@Given("^Click On StartOver Button$")
	public void Click_StartOverButton() 
	{
		
		String txt_msg = "";
		String locatorvalue = this.StartOverButton;
		String LocatorName = "StartOverButton";
		try
		{
			
			boolean button_isDisplayed;
			boolean button_isEnabled;
			
			button_isEnabled = driver.findElement((By.xpath(locatorvalue))).isEnabled();
			button_isDisplayed = driver.findElement((By.xpath(locatorvalue))).isDisplayed();
					
					if(button_isDisplayed && button_isEnabled)
					{
						driver.findElement((By.xpath(locatorvalue))).click();
						txt_msg = "Button Found, Clicked Button and Clears the form " ;
						System.out.println(LocatorName + " " + txt_msg);
					}
					
					Thread.sleep(1000);
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			txt_msg = "*************** EXCEPTION ****************";
			System.out.println(LocatorName + " " + txt_msg);
		
	}
	}
	@Given("^Customer Launch Browser$")
	public void Launch_Browser() throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");	
	}
	
	@When("^Customer Landing page$")
	public void title_of_Landing_page() 
	{
		String title =driver.getTitle();
		System.out.println(title);
	}
	@Then("^Landing Page text should be \"([^\"]*)\" Page$")
	public void Text_On_Landing_Page(String LandingPageTitletext) throws InterruptedException 
	{
		Thread.sleep(5000);
		String Locator = this.LandingPageTitle;
		String Locatortext = driver.findElement(By.xpath(Locator)).getText();
		System.out.println("Landing Page Displayed text"+ " " +Locatortext);
		String Actualtext = Locatortext;		
		
	}
	@And("^Enters Input to Personal Info for Loan eligibility$")
	public void Enter_Customer_Info() throws InterruptedException, IOException
	{
		String txt_msg = "";
		String Dependants= this.NumberOfDependants;
		String DependantsValue = "0";
		
		try
		{
			String CustomerApp  = this.CustomerApplicationType;
			boolean Application_status = driver.findElement(By.xpath(CustomerApp)).isEnabled();
			
			if (Application_status==true)
			{
				txt_msg = "PASSED : Customer Application Type Single exist as true on Landing page ";
				System.out.println(txt_msg);
			}
			else 
			{
				txt_msg = "FAILED: Customer Application Type WebElement is not exist";
				System.out.println(txt_msg);
			}
			
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		try
		{
				
			 if (!driver.findElements(By.xpath("//select[@title='Number of dependants']")).isEmpty())
				{
					Select listbox = new Select(driver.findElement(By.xpath(Dependants)));
			        listbox.selectByIndex(0);
			        txt_msg = "Selected Number of Dependants";
					System.out.println(txt_msg);
				}
			else 
			{
				txt_msg = "WebElement is not exist";
				System.out.println(txt_msg);
			}
			
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		
		
		try
		{
			String PropertyTypeText =this.PropertyType;	
			boolean PropertyType_HomeToLive = driver.findElement(By.xpath(PropertyTypeText)).isEnabled();
			
			if (PropertyType_HomeToLive==true)
			{
				txt_msg = "PASSED:Property Type Selected as Home To Live is exist as true on Landing Page";
				System.out.println(txt_msg);
			}
			else 
			{
				txt_msg = "FAILED:Property Type Selected as Home To Live is not exist as true on Landing Page ";
				System.out.println(txt_msg);
			}
			
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		
		SendkeysExpliciteWait(driver, CustomerIncome, 5, "80000");
		SendkeysExpliciteWait(driver, CustomerOtherIncome, 5, "10000");
		SendkeysExpliciteWait(driver, CustomerLivingExpense, 5, "500");
		SendkeysExpliciteWait(driver, CustomerOtherLoanRepayments, 5, "100");
		SendkeysExpliciteWait(driver, CustomerOtherCreditCardLimits, 5, "10000");
		Click_button(CustomerLoanEligibiltyButton,"LoanEligibiltyButton");
		Validate_text("$479,000", EstimatedBorrowAmountEligibilty);
	
	}
	
	
	public void Validate_text(String ExpectedText , String ElementToCheck) 
	{
		String txt_msg="";
		String Locatortext = driver.findElement(By.xpath(ElementToCheck)).getText();
		String Actualtext = Locatortext;
		
		if (Actualtext.equals(ExpectedText))
		{
			txt_msg = "PASSED:Loan amount matches with estimated amount";
			System.out.println(ExpectedText+ " " + txt_msg+ " "+ Actualtext);
		}
		else
		{
			txt_msg = "FAILED:Loan amount does not matches with estimated amount";
			System.out.println(ExpectedText+ " " + txt_msg+ " "+ Actualtext);
		}
	}
	
public void Click_button(String locatorvalue , String LocatorName) throws InterruptedException, IOException {
		
		String txt_msg = "";
		locatorvalue = this.CustomerLoanEligibiltyButton;
		try
		{
			
			boolean button_isDisplayed;
			boolean button_isEnabled;
			
			button_isEnabled = driver.findElement((By.xpath(locatorvalue))).isEnabled();
			button_isDisplayed = driver.findElement((By.xpath(locatorvalue))).isDisplayed();
					
					if(button_isDisplayed && button_isEnabled)
					{
						driver.findElement((By.xpath(locatorvalue))).click();
						txt_msg = "PASSED : *************** Button Found and Clicked Button ****************";
						System.out.println(LocatorName + " " + txt_msg);
					}
					
					Thread.sleep(1000);
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			txt_msg = "*************** EXCEPTION ****************";
			System.out.println(LocatorName + " " + txt_msg);
			
			
		
	}
}
	
}
