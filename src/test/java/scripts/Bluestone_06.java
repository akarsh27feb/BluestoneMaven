package scripts;		//Scenario 14

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_06 extends BaseTest 
{
	@Test
	public void Scenario_14()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Plain Gold Coins", "1 gram");
		wait.until(ExpectedConditions.titleContains("1 gram 24 KT Gold Coin"));
		FWUtils.screenShotPage("Bluestone06_01.jpg", driver);
		cp.verifyCoin("1 gram 24 KT Gold Coin");
	}
}
