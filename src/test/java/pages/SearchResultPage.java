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

public class SearchResultPage 
{
	@FindBy(xpath="//h1[@class='page-title title-14']") private WebElement heading;	
	@FindBy(xpath="//span[.='Offers']")	private WebElement offers;	
	@FindBy(xpath="//span[.='Price']") private WebElement price;	
	@FindBy(xpath="//span[.='Type']") private WebElement type;	
	@FindBy(xpath="//span[.='Metal']") private WebElement metal;	
	@FindBy(xpath="//span[.='Gender']") private WebElement gender;	
	@FindBy(xpath="(//span[.='Delivery Time'])[1]") private WebElement deliveryTime;	
	@FindBy(xpath="//span[.='Price']/ancestor::section//div[@class='form-item ']/span[@data-displayname]") private List<WebElement> priceCatList;
	@FindBy(xpath="//span[.='Price']/ancestor::section//div[@class='form-item ']//span[@class='items-count']") private List<WebElement> priceProductCountList;
	@FindBy(xpath="//span[.='Type']/ancestor::section//div[@class='form-item ']/span[@data-displayname]") private List<WebElement> typeCatList;	
	@FindBy(xpath="//span[.='Type']/ancestor::section//div[@class='form-item ']//span[@class='items-count']") private List<WebElement> typeProductCountList;
	@FindBy(xpath="//span[.='Metal']/ancestor::section//div[@class='form-item ']/span[@data-displayname]") private List<WebElement> metalCatList;
	@FindBy(xpath="//span[.='Metal']/ancestor::section//div[@class='form-item ']//span[@class='items-count']") private List<WebElement> metalProductCountList;
	@FindBy(xpath="//span[.='Gender']/ancestor::section//div[@class='form-item ']/span[@data-displayname]") private List<WebElement> genderCatList;
	@FindBy(xpath="//span[.='Gender']/ancestor::section//div[@class='form-item ']//span[@class='items-count']")	private List<WebElement> genderProductCountList;
	@FindBy(xpath="//span[.='Delivery Time']/ancestor::section//div[@class='form-item ']/span[@data-displayname]") private List<WebElement> deliveryTimeCatList;
	@FindBy(xpath="//span[.='Delivery Time']/ancestor::section//div[@class='form-item ']//span[@class='items-count']") private List<WebElement> deliveryTimeProductCountList;
	@FindBy(xpath="//span[.='More Filters']") private WebElement moreFilters;	
	@FindBy(xpath="//div[@id='top-filter-hover']//span[@class='title']/span") private List<WebElement> moreFiltersTitleList;	
	@FindBy(xpath="//div[@id='top-filter-hover']//div[contains(@class,'form-item ')]/span")	private List<WebElement> moreFilterCatList;	
	@FindBy(xpath="//div[@id='top-filter-hover']//div[contains(@class,'form-item ')]//span[@class='items-count']") private List<WebElement> moreFiltersPCList;
	@FindBy(xpath="//span[@class='p-wrap']/a") private List<WebElement> productList;
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveTo(String element, WebDriver driver, WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOf(heading));
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
	
	public String getproductCount(String filter, String category, WebDriverWait wait)
	{
		String productCount="";
		if(filter.equalsIgnoreCase("price"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(priceProductCountList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:priceCatList)
			{
				l1.add(ele.getText());
			}
			for(String priceList:l1)
			{
				if(priceList.contains(category))
				{
					int index=l1.indexOf(priceList);
					productCount=priceProductCountList.get(index).getText();
				}
			}
		}
		
		else if(filter.equalsIgnoreCase("type"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(typeProductCountList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:typeCatList)
			{
				l1.add(ele.getText());
			}
			for(String typeList:l1)
			{
				if(typeList.contains(category))
				{
					int index=l1.indexOf(typeList);
					productCount=typeProductCountList.get(index).getText();
				}
			}
		}
		
		else if(filter.equalsIgnoreCase("metal"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(metalProductCountList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:metalCatList)
			{
				l1.add(ele.getText());
			}
			for(String metalList:l1)
			{
				if(metalList.contains(category))
				{
					int index=l1.indexOf(metalList);
					productCount=metalProductCountList.get(index).getText();
				}
			}
		}
		
		else if(filter.equalsIgnoreCase("gender"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(genderProductCountList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:genderCatList)
			{
				l1.add(ele.getText());
			}
			for(String genderList:l1)
			{
				if(genderList.contains(category))
				{
					int index=l1.indexOf(genderList);
					productCount=genderProductCountList.get(index).getText();
				}
			}
		}
		
		else if(filter.equalsIgnoreCase("Delivery Time"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(deliveryTimeProductCountList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:deliveryTimeCatList)
			{
				l1.add(ele.getText());
			}
			for(String deliveryTimeList:l1)
			{
				if(deliveryTimeList.contains(category))
				{
					int index=l1.indexOf(deliveryTimeList);
					productCount=deliveryTimeProductCountList.get(index).getText();
				}
			}
		}
		return productCount;
	}
	
	public void clickMoreFilters(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOf(heading));
		moreFilters.click();
	}
	
	public String getMoreFiltersPC(String filter, String category, WebDriverWait wait)
	{
		String productCount="";
		ArrayList<String> titleList=new ArrayList<String>();
		for(WebElement ele:moreFiltersTitleList)
		{
			titleList.add(ele.getText());
		}
		System.out.println(titleList);
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(moreFiltersTitleList));
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:moreFilterCatList)
			{
				l1.add(ele.getText());
			}
			for(String catList:l1)
			{
				if(catList.contains(category))
				{
					int index=l1.indexOf(catList);
					productCount=moreFiltersPCList.get(index).getText();
				}
			}
		}
		return productCount;
	}
	
	public void clickProduct(int index)
	{
		productList.get(index).click();
	}
}
