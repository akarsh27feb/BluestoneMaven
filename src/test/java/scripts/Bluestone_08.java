package scripts;		//Scenario 16

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_08 extends BaseTest 
{
	@Test
	public void Scenario_16()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Plain Gold Coins", "20 gram");
		wait.until(ExpectedConditions.titleContains("20 gram 24 KT Gold Coin"));
		FWUtils.screenShotPage("Bluestone08_01.jpg", driver);
		cp.verifyCoin("20 gram 24 KT Gold Coin");
	}
}
