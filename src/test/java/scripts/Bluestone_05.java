package scripts;		//Scenario 11

import org.testng.annotations.Test;
import generic.BaseTest;
import pages.HomePage;
import pages.OffersPage;

public class Bluestone_05 extends BaseTest
{
	@Test
	public void Scenario_11()
	{
		HomePage hp=new HomePage(driver);
		hp.moveTo(driver, "Offers");
		hp.clickOffer("0% Making");
		OffersPage op=new OffersPage(driver);
		op.verifyProducts2(wait);
	}
}
