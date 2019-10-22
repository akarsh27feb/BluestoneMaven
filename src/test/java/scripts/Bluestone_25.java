package scripts;		//Scenario 12

import org.testng.annotations.Test;
import generic.BaseTest;
import pages.HomePage;
import pages.OffersPage;

public class Bluestone_25 extends BaseTest
{
	@Test
	public void Scenario_12()
	{
		HomePage hp=new HomePage(driver);
		hp.moveTo(driver, "Offers");
		hp.clickOffer("25%");
		OffersPage op=new OffersPage(driver);
		op.moveTo("Offers", driver, wait);
		op.verifyProducts1("25%",wait);
	}
}
