package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	public static WebDriver driver;	
	
	@FindBy(xpath = "//span[contains(text(),'How much can I borrow?')]")
	WebElement LandingPageTitletext;
	WebElement Locatorvalue = LandingPageTitletext;
	
	
}
