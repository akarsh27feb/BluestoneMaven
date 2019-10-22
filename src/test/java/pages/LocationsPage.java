package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationsPage 
{
	@FindBy(xpath="//div[@class='store-location']") private List<WebElement> locations;
	
	
	public LocationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int totalStores()
	{
		return locations.size();
	}
}
