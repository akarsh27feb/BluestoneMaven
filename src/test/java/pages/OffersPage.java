package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OffersPage 
{
	@FindBy(xpath="//span[@class='filterDisplayName']")	private WebElement filter;	
	@FindBy(xpath="//span[@class='total-designs']")	private WebElement designs;			
	@FindBy(xpath="//span[@class='new-price']")	private List<WebElement> productList;	
	@FindBy(xpath="//span[.='0% making charge']") private List<WebElement> productWith0charge;
	@FindBy(xpath="//section[@id='Offers-form']") private WebElement offers;	
	@FindBy(xpath="//span[.='Price']") private WebElement price;
	@FindBy(xpath="//span[.='Type']") private WebElement type;	
	@FindBy(xpath="//span[.='Metal']") private WebElement metal;	
	@FindBy(xpath="//span[.='Gender']")	private WebElement gender;	
	@FindBy(xpath="//span[.='Delivery Time']") private WebElement deliveryTime;
	@FindBy(xpath="//section[@id='Offers-form']//div[contains(@class,'form-item ')]/span") private List<WebElement> offersCatList;
	@FindBy(xpath="//section[@id='Offers-form']//div//span[@class='items-count']")	private List<WebElement> offersProductCountList;
	
	public OffersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveTo(String element, WebDriver driver, WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOf(filter));
		Actions act=new Actions(driver);
		if(element.equalsIgnoreCase("Offers"))
			act.moveToElement(offers).perform();
		else if(element.equalsIgnoreCase("Price"))
			act.moveToElement(price).perform();
		else if(element.equalsIgnoreCase("Type"))
			act.moveToElement(type).perform();
		else if(element.equalsIgnoreCase("Metal"))
			act.moveToElement(metal).perform();
		else if(element.equalsIgnoreCase("Gender"))
			act.moveToElement(gender).perform();
		else if(element.equalsIgnoreCase("Delivery Time"))
			act.moveToElement(deliveryTime).perform();
	}
	
	public void verifyProducts1(String category,WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(offersCatList));
		String expected = "("+designs.getText().split("\\s")[0]+")";
		String actual="";
		ArrayList<String> l1=new ArrayList<String>();
		for(WebElement ele:offersCatList)
		{
			l1.add(ele.getText());
		}
		for(String s:l1)
		{
			if(s.contains(category))
			{
				int index=l1.indexOf(s);
				actual=offersProductCountList.get(index).getText();
			}				
		}
		Assert.assertEquals(actual, expected);
	}
	
	public void verifyProducts2(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOf(filter));
		Assert.assertEquals(productWith0charge.size(), productList.size());
	}
}
