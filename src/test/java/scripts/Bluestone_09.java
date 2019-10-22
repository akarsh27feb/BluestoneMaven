package scripts;		//Scenario 17

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtils;
import pages.CoinsPage;
import pages.HomePage;

public class Bluestone_09 extends BaseTest 
{
	@Test
	public void Scenario_17()
	{
		HomePage hp=new HomePage(driver);
		CoinsPage cp=new CoinsPage(driver);
		hp.moveTo(driver, "Coins");
		hp.clickCoin("Plain Gold Coins", "50 gram");
		wait.until(ExpectedConditions.titleContains("50 gram 24 KT Gold Coin"));
		FWUtils.screenShotPage("Bluestone09_01.jpg", driver);
		cp.verifyCoin("50 gram 24 KT Gold Coin");
	}
}
