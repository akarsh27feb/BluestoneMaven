package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GoldMineNomineePage 
{
	@FindBy(xpath="//input[@id='nomineeName']") private WebElement nomineeName;
	@FindBy(xpath="//select[@id='nomineeRelationship']") private WebElement relationship;
	@FindBy(xpath="//select[@id='nomineeNationality']") private WebElement nationality;
	@FindBy(xpath="//input[@value='Next']") private WebElement nextButton;
	
	public GoldMineNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void nomineeName(String nominee, String operation)
	{
		if(operation.equalsIgnoreCase("clear"))
			nomineeName.clear();
		else if(operation.equalsIgnoreCase("set"))
			nomineeName.sendKeys(nominee);
	}
	
	public void relationship(String value)
	{
		Select rel=new Select(relationship);
		rel.selectByValue(value);
	}
	
	public void nationality(String nation)
	{
		Select nat=new Select(nationality);
		nat.selectByValue(nation);
	}
	
	public void clickNext()
	{
		nextButton.submit();
	}
}
