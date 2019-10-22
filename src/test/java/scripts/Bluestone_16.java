package scripts;		//Scenario 24

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;

public class Bluestone_16 extends BaseTest 
{
	@Test
	public void Scenario_24()
	{
		HomePage hp=new HomePage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		SearchResultPage srp=new SearchResultPage(driver);
		srp.clickMoreFilters(wait);
		String prodCount=srp.getMoreFiltersPC("GOLD PURITY", "22k", wait);
		Reporter.log("Total 22K Gold rings are = "+prodCount,true);
	}
}
