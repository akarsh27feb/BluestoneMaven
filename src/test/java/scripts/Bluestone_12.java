package scripts;		//Scenario 20

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_12 extends BaseTest 
{
	@Test
	public void Scenario_20()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Lakshmi Gold Coins", "10 gram");
		wait.until(ExpectedConditions.titleContains("10 gram 24 KT Lakshmi Gold Coin"));
		FWUtils.screenShotPage("Bluestone12_01.jpg", driver);
		cp.verifyCoin("10 gram 24 KT Lakshmi Gold Coin");
	}
}
