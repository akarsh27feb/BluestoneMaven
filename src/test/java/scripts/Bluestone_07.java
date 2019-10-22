package scripts;		//Scenario 15

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_07 extends BaseTest 
{
	@Test
	public void Scenario_15()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Plain Gold Coins", "2 gram");
		wait.until(ExpectedConditions.titleContains("2 gram 24 KT Gold Coin"));
		FWUtils.screenShotPage("Bluestone07_01.jpg", driver);
		cp.verifyCoin("2 gram 24 KT Gold Coin");
	}
}
