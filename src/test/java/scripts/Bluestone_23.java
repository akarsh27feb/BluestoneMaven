package scripts;		//Sceanario 32

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.LocationsPage;

public class Bluestone_23 extends BaseTest 
{
	@Test
	public void Sceanrio_32()
	{
		HomePage hp=new HomePage(driver);
		LocationsPage lp=new LocationsPage(driver);
		hp.clickStores();
		wait.until(ExpectedConditions.titleContains("Stores"));
		Integer locations=lp.totalStores();
		Reporter.log("Total locations of bluestone stores = "+locations.toString(),true);
	}
}
