package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class KadasPage 
{
	@FindBy(xpath="//div[@class='p-image']")
	private List<WebElement> kadas;
	
	public KadasPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickKada(int index)
	{
		try
		{
			kadas.get(index).click();
		}
		catch(Exception e)
		{
			Reporter.log("Please enter index between 0 and "+kadas.size());
		}
	}
}
