package scripts;		//Scenario 23

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;

public class Bluestone_15 extends BaseTest 
{
	@Test
	public void Scenario_23()
	{
		HomePage hp=new HomePage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		SearchResultPage srp=new SearchResultPage(driver);
		srp.moveTo("Metal", driver, wait);
		String ringsCount=srp.getproductCount("Metal", "Platinum", wait);
		Reporter.log("Total Rings count of Platinum rings = "+ringsCount,true);
	}
}
