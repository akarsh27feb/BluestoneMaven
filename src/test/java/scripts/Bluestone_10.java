package scripts;		//Scenario 18

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_10 extends BaseTest 
{
	@Test
	public void Scenario_18()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Lakshmi Gold Coins", "2 gram");
		wait.until(ExpectedConditions.titleContains("2 gram 24 KT Lakshmi Gold Coin"));
		FWUtils.screenShotPage("Bluestone10_01.jpg", driver);
		cp.verifyCoin("2 gram 24 KT Lakshmi Gold Coin");
	}
}
