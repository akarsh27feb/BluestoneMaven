package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class GoldMinePDPage 
{
	@FindBy(xpath="//input[@id='email']") private WebElement emailID;
	@FindBy(xpath="//div[@name='subscriptionAmount']") private WebElement subscriptionAmount;
	@FindBy(xpath="//input[@id='contactNumber']") private WebElement contactNumber;
	@FindBy(xpath="//input[@id='fullname']") private WebElement fullName;
	@FindBy(xpath="//textarea[@id='address']") private WebElement address;
	@FindBy(xpath="//input[@id='postcode_delivery']") private WebElement pincode;
	@FindBy(xpath="//input[@type='submit']") private WebElement next;
	@FindBy(xpath="//li[.='Please enter valid mobile number']") private WebElement mblNoErr;
	@FindBy(xpath="//li[.='Name is required']") private WebElement nameErr;
	@FindBy(xpath="//li[.='Your address is required']") private WebElement addressErr;
	@FindBy(xpath="//li[.='Enter Valid Pincode']") private WebElement pincodeErr;
	
	public GoldMinePDPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String displayedEmailId()
	{
		return emailID.getAttribute("value");
	}
	
	public String displayedAmount()
	{
		String amount=subscriptionAmount.getText();
		String []arr=amount.split(",");
		String dispAmt="";
		for(int i=0; i<arr.length; i++)
		{
			dispAmt=dispAmt+arr[i];
		}
		return dispAmt;
	}
	
	public boolean verifyAmount(String expected, String actual)
	{
		return actual.contains(expected);			
	}
	
	public boolean verifyEmail(String expected, String actual)
	{
		return actual.equals(expected);
	}
	
	public void verifyMblNoErr()
	{
		try
		{
			if(mblNoErr.isDisplayed())
				Reporter.log("Mobile Number Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Mobile Number Error message is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyNameErr()
	{
		try
		{
			if(nameErr.isDisplayed())
				Reporter.log("Name Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Name Error message is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyAddressErr()
	{
		try
		{
			if(addressErr.isDisplayed())
				Reporter.log("Address Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Address Error message is not displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyPincodeErr()
	{
		try
		{
			if(pincodeErr.isDisplayed())
				Reporter.log("Pin code Error message is displayed",true);
		}
		catch(Exception e)
		{
			Reporter.log("Pin code Error message is not displayed",true);
			Assert.fail();
		}
	}	
	
	public void contactNum(String num, String operation) 
	{
		if(operation.equalsIgnoreCase("clear"))
			contactNumber.clear();
		else if(operation.equalsIgnoreCase("set"))
			contactNumber.sendKeys(num);
	}
	
	public void fullName(String name, String operation)
	{
		if(operation.equalsIgnoreCase("clear"))
			fullName.clear();
		else if(operation.equalsIgnoreCase("set"))
			fullName.sendKeys(name);
	}
	
	public void address(String add, String operation)
	{
		if(operation.equalsIgnoreCase("clear"))
			address.clear();
		else if(operation.equalsIgnoreCase("set"))
			address.sendKeys(add);
	}
	
	public void pincode(String pin, String operation)
	{
		if(operation.equalsIgnoreCase("clear"))
			pincode.clear();
		else if(operation.equalsIgnoreCase("set"))
			pincode.sendKeys(pin);
	}
	
	public void clickNext()
	{
		next.submit();
	}
}
