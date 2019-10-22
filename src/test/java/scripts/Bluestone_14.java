package scripts;		//Scenario 22

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;

public class Bluestone_14 extends BaseTest 
{
	@Test
	public void Scenario_22()
	{
		HomePage hp=new HomePage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		SearchResultPage srp=new SearchResultPage(driver);
		srp.moveTo("Delivery Time", driver, wait);
		String ringsCount=srp.getproductCount("Delivery Time", "Next Day Delivery", wait);
		Reporter.log("Total Rings count of Next Day Delivery = "+ringsCount,true);
	}
}
