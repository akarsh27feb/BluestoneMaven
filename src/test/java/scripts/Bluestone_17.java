package scripts;		//Scenario 25

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;

public class Bluestone_17 extends BaseTest 
{
	@Test
	public void Scenario_25()
	{
		HomePage hp=new HomePage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		SearchResultPage srp=new SearchResultPage(driver);
		srp.moveTo("gender", driver, wait);
		String prodCount=srp.getproductCount("Gender", "Women", wait);
		Reporter.log("Total Women Rings = "+prodCount,true);
	}
}
