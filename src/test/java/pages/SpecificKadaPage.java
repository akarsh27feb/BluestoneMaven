package pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.FWUtils;

public class SpecificKadaPage 
{	
	@FindBy(xpath="//input[@id='buy-now']")
	private WebElement buyNow;
	
	@FindBy(xpath="//div[@class='formErrorContent']")
	private WebElement errorMsg;
	
	@FindBy(xpath="//span[@class='size-box-overlay']")
	private WebElement selectSize;
	
	@FindBy(xpath="//li[@data-key]")
	private List<WebElement> kadaSize;
	
	public SpecificKadaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickBuyNow()
	{
		buyNow.click();
	}
	
	public void verifyErrorMsg(WebDriver driver, int num)
	{
		if(errorMsg.isDisplayed())
		{
			FWUtils.screenShotPage("Bluestone03_"+num+".jpg", driver);
		}
		else
		{
			Assert.fail();
		}
	}
	
	public void clickSelectSize()
	{
		selectSize.click();
	}
	
	public String selectSizeText()
	{
		return selectSize.getText();
	}
	
	public void selectKadaSize(String size)
	{
		for(WebElement ele:kadaSize)
		{
			if(ele.getAttribute("data-key").equals(size))
			{
				ele.click();
			}
		}
	}
}
