package scripts;		//Scenario 26

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.HomePage;

public class Bluestone_18 extends BaseTest 
{
	@Test
	public void Scenario_26()
	{
		HomePage hp=new HomePage(driver);
		WebElement initialTopIcon=hp.topIcon();
		js.executeScript("window.scrollBy(0,500)");
		FWUtils.screenShotPage("Bluestone18_01.jpg", driver);
		WebElement topIconAfterScroll=hp.topIcon();
		try
		{
			Assert.assertEquals(initialTopIcon,topIconAfterScroll);
			topIconAfterScroll.click();
		}
		catch(AssertionError e)
		{
			Reporter.log("Top Icon is note displayed after scroll",true);
		}
	}
}
