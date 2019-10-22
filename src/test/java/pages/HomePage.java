package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	@FindBy(xpath="//span[@class='logo-icon']") private WebElement topIcon;	
	@FindBy(xpath="//a[.='Rings ']") public WebElement rings;	
	@FindBy(xpath="//a[.='Diamond' and @title='Diamond Rings']") private WebElement diamondRings;	
	@FindBy(xpath="//a[.='Offers ']") private WebElement offers;	
	@FindBy(xpath="//a[.='Next Day Delivery ']") private WebElement nextDayDelivery;	
	@FindBy(xpath="//a[.='Earrings ']")	private WebElement earrings;	
	@FindBy(xpath="//a[.='All Jewellery ']") private WebElement allJwellery;
	@FindBy(xpath="//a[.='Kadas']")	private WebElement kadas;	
	@FindBy(xpath="//span[contains(.,'Making')]") private List<WebElement> offersList;	
	@FindBy(xpath="//a[.='Coins ']") private WebElement coins;	
	@FindBy(xpath="//span[.='Plain Gold Coins']/parent::div/parent::div/ul/li/span") private List<WebElement> plainGoldCoins;	
	@FindBy(xpath="//a[.='10 gram']") private WebElement plain10GmCoin;	
	@FindBy(xpath="//span[.='Lakshmi Gold Coins']/parent::div/parent::div/ul/li/span") private List<WebElement> lakshmiGoldCoins;	
	@FindBy(xpath="//span[.='Silver Coins']/parent::div/parent::div/ul/li/span") private List<WebElement> silverCoins;	
	@FindBy(xpath="//input[@id='search_query_top_elastic_search']") private WebElement searchBox;	
	@FindBy(xpath="//input[@name='submit_search']") private WebElement searchButton;
	@FindBy(xpath="//a[@href='/goldmine.html']") private WebElement goldMine;
	@FindBy(xpath="//a[.='KNOW MORE']") private WebElement stores;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement topIcon()
	{
		return topIcon;
	}
	public void moveTo(WebDriver driver, String element)
	{
		Actions act=new Actions(driver);
		if(element.equalsIgnoreCase("Rings"))
			act.moveToElement(rings).perform();
		else if(element.equalsIgnoreCase("Offers"))
			act.moveToElement(offers).perform();
		else if(element.equalsIgnoreCase("Delivery"))
			act.moveToElement(nextDayDelivery).perform();
		else if(element.equalsIgnoreCase("Earrings"))
			act.moveToElement(earrings).perform();
		else if(element.equalsIgnoreCase("All Jwellery"))
			act.moveToElement(allJwellery).perform();
		else if(element.equalsIgnoreCase("Coins"))
			act.moveToElement(coins).perform();
	}
	
	public void clickRings(String element)
	{
		if(element.equalsIgnoreCase("Diamond"))
			diamondRings.click();
	}
	
	public void clickAllJwellery(String element)
	{
		if(element.equalsIgnoreCase("Kada"))
			kadas.click();
	}
	
	public void clickOffer(String off)
	{
		ArrayList<String> l1=new ArrayList<String>();
		for(WebElement ele:offersList)
		{
			l1.add(ele.getText());
		}
		
		for(String s:l1)
		{
			if(s.contains(off))
			{
				int index=l1.indexOf(s);
				offersList.get(index).click();
			}
		}
	}
	
	public void clickCoin(String element, String coin)
	{
		if(element.equalsIgnoreCase("Plain Gold Coins"))
		{
			if(coin.equals("10 gram"))
				plain10GmCoin.click();
			else
			{
				ArrayList<String> l1=new ArrayList<String>();
				for(WebElement ele:plainGoldCoins)
				{
					l1.add(ele.getText());
				}
				for(String s:l1)
				{
					if(s.contains(coin))
					{
						int index=l1.indexOf(s);
						plainGoldCoins.get(index).click();
					}
				}
			}
		}
		else if(element.equalsIgnoreCase("Lakshmi Gold Coins"))
		{
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:lakshmiGoldCoins)
			{
				l1.add(ele.getText());
			}
			for(String s:l1)
			{
				if(s.contains(coin))
				{
					int index=l1.indexOf(s);
					lakshmiGoldCoins.get(index).click();
				}
			}
		}
		else if(element.equalsIgnoreCase("Silver Coins"))
		{
			ArrayList<String> l1=new ArrayList<String>();
			for(WebElement ele:silverCoins)
			{
				l1.add(ele.getText());
			}
			for(String s:l1)
			{
				if(s.contains(coin))
				{
					int index=l1.indexOf(s);
					silverCoins.get(index).click();
				}
			}
		}
	}
	
	public void searchProduct(String product)
	{
		searchBox.sendKeys(product);
	}
	
	public void clickSearch()
	{
		searchButton.submit();
	}
	
	public void clickGoldMine()
	{
		goldMine.click();
	}	

	public void clickStores() 
	{
		stores.click();
	}
}
