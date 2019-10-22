package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class GoldMinePage 
{
	@FindBy(xpath="//input[@value='Start Now']") private WebElement startNow;
	@FindBy(xpath="//li[.='Amount is required']") private WebElement amountError;
	@FindBy(xpath="//li[.='Email is required']") private WebElement emailError;
	@FindBy(xpath="//input[@id='amount']") private WebElement amount;
	@FindBy(xpath="//input[@name='email']") private WebElement emailID;
	
	public GoldMinePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickStartNow()
	{
		startNow.click();
	}
	
	public void verifyAmountError()
	{
		try
		{
			if(amountError.isDisplayed())
				Reporter.log("Amount Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Amount Error message is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyEmailError()
	{
		try
		{
			if(emailError.isDisplayed())
				Reporter.log("Email Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Email Error message is not displayed",true);
			Assert.fail();
		}
	}
	
	public String amount(String amt)
	{
		amount.sendKeys(amt);
		return amt;
	}
	
	public String emailId(String email)
	{
		emailID.sendKeys(email);
		return email;
	}
}
