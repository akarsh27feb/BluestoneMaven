package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SpecificRingPage 
{
	@FindBy(xpath="//span[@id='discountedPriceSpan']") private WebElement discountedPrice;
	@FindBy(xpath="//span[@id='our_price_display']") private WebElement actualPrice;
	@FindBy(xpath="//h1[@class='title-5']") private WebElement ringTitle;
	
	public SpecificRingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPrice()
	{
		try
		{
			String dp=discountedPrice.getText();
			Reporter.log("Discounted Price = "+dp,true);
			try
			{
				String ap=actualPrice.getText();
				Reporter.log("Actual Price = "+ap,true);
			}
			catch(Exception e)
			{
				Reporter.log("Actual Price is not displayed",true);
			}
		}
		catch(Exception e)
		{
			Reporter.log("Discounted price is not displayed",true);
		}
	}
	
	public WebElement ringName()
	{
		return ringTitle;
	}
}
