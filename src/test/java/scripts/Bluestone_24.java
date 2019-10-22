package scripts;		//Scenario 33

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.SearchResultPage;
import pages.SpecificRingPage;

public class Bluestone_24 extends BaseTest	 
{
	@Test
	public void Sceanrio_33()
	{
		HomePage hp=new HomePage(driver);
		SearchResultPage srp=new SearchResultPage(driver);
		SpecificRingPage sring=new SpecificRingPage(driver);
		hp.searchProduct("Rings");
		hp.clickSearch();
		srp.clickProduct(1);		
		wait.until(ExpectedConditions.visibilityOf(sring.ringName()));
		sring.verifyPrice();
	}
}
