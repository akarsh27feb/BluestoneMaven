package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiamondRingsPage
{
	@FindBy(xpath="//span[@class='new-price']")
	private List<WebElement> priceList;
	
	@FindBy(xpath="//span[@class='view-by-wrap title style-outline i-right']")
	private WebElement sortBy;
	
	@FindBy(xpath="//a[.='Price Low to High ']")
	private WebElement lowToHigh;
	
	@FindBy(xpath="//span[.='Price']")
	private WebElement price;
	
	@FindBy(xpath="//span[.='Metal']")
	private WebElement metal;
	
	@FindBy(xpath="//span[.='Gold Purity']")
	private WebElement goldPurity;
	
	@FindBy(xpath="//span[.='Gender']")
	private WebElement gender;
	
	@FindBy(xpath="//span[.='Offers']")
	private WebElement offers;
	
	@FindBy(xpath="//span[.='Delivery Time']")
	private WebElement deliveryTime;
	
	public DiamondRingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveTo(WebDriver driver, String element)
	{
		Actions act=new Actions(driver);
		if(element.equalsIgnoreCase("Sort By"))
			act.moveToElement(sortBy).perform();
		else if(element.equalsIgnoreCase("Price"))
			act.moveToElement(price).perform();
		else if(element.equalsIgnoreCase("Metal"))
			act.moveToElement(metal).perform();
		else if(element.equalsIgnoreCase("Gold Purity"))
			act.moveToElement(goldPurity).perform();
		else if(element.equalsIgnoreCase("Gender"))
			act.moveToElement(gender).perform();
		else if(element.equalsIgnoreCase("Offers"))
			act.moveToElement(offers).perform();
		else if(element.equalsIgnoreCase("Delivery Time"))
			act.moveToElement(deliveryTime).perform();
	}
	
	public void clickSortMethod(String element)
	{
		if(element.equalsIgnoreCase("low to high"))
			lowToHigh.click();
	}
	
	public ArrayList<String> getPriceList()
	{
		ArrayList<String> l1=new ArrayList<String>();
		for(WebElement p1:priceList)
		{
			l1.add(p1.getText());
		}
		return l1;
	}
}
