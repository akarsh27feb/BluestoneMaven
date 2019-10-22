package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CoinsPage 
{
	@FindBy(xpath="//h1[@class='title-5']")
	private WebElement title;
	
	
	public CoinsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCoin(String compare)
	{
		Assert.assertEquals(title.getText(), compare);
	}
}
