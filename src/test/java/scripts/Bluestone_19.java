package scripts;		//Scenario 27

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.GoldMinePage;
import pages.HomePage;

public class Bluestone_19 extends BaseTest
{
	@Test
	public void Scenario_27()
	{
		HomePage hp=new HomePage(driver);
		GoldMinePage gmp=new GoldMinePage(driver);
		hp.clickGoldMine();
		wait.until(ExpectedConditions.titleContains("Gold Mine 10+1"));
		gmp.clickStartNow();
		gmp.verifyAmountError();
		gmp.verifyEmailError();
	}
}
