package scripts;		//Scenario 21

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;

public class Bluestone_13 extends BaseTest 
{
	@Test
	public void Scenario_21()
	{
		HomePage hp=new HomePage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		SearchResultPage srp=new SearchResultPage(driver);
		srp.moveTo("Price", driver, wait);
		String ringsCount=srp.getproductCount("Price", "Below Rs. 10,000", wait);
		Reporter.log("Total Rings count below Rs 10000 = "+ringsCount,true);
	}
}
