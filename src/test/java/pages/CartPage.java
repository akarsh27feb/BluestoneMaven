package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	@FindBy(xpath="//span[@class='size-box-overlay']")
	private WebElement size;
	
	public String size()
	{
		return size.getText();
	}
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
