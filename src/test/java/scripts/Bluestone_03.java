package scripts;		//scenario 7

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.HomePage;
import pages.KadasPage;
import pages.SpecificKadaPage;

public class Bluestone_03 extends BaseTest
{
	@Test
	public void Scenario_07()
	{
		HomePage hp=new HomePage(driver);
		KadasPage kp=new KadasPage(driver);
		SpecificKadaPage skp=new SpecificKadaPage(driver);
		hp.moveTo(driver, "All Jwellery");
		hp.clickAllJwellery("Kada");
		wait.until(ExpectedConditions.titleContains("Bangles"));
		kp.clickKada(1);
		wait.until(ExpectedConditions.titleContains("Kada"));
		skp.clickBuyNow();
		skp.verifyErrorMsg(driver, 01);
	}
}
