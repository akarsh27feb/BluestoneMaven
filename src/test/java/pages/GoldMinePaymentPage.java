package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class GoldMinePaymentPage 
{
	public GoldMinePaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPage(WebDriver driver)
	{
		String title=driver.getTitle();
		if(title.contains("Gold Mine Payment Option"))
			Reporter.log("Payment's page is displayed",true);
		else
		{
			Reporter.log("Payment's page is not displayed",true);
			Assert.fail();
		}
	}
}
