package scripts;		//Scenario 28

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.GoldMinePDPage;
import pages.GoldMinePage;
import pages.HomePage;

public class Bluestone_20 extends BaseTest
{
	@Test
	public void Scenario_28()
	{
		HomePage hp=new HomePage(driver);
		GoldMinePage gmp=new GoldMinePage(driver);
		GoldMinePDPage gmpd=new GoldMinePDPage(driver);
		hp.clickGoldMine();
		wait.until(ExpectedConditions.titleContains("Gold Mine 10+1"));
		String enteredAmt=gmp.amount("1000");
		String enteredEmail=gmp.emailId("abc@gmail.com");
		gmp.clickStartNow();
		wait.until(ExpectedConditions.titleContains("Gold Mine Personal Detail"));
		String dispAmt=gmpd.displayedAmount();
		String dispEmail=gmpd.displayedEmailId();
		if((gmpd.verifyAmount(enteredAmt, dispAmt)==true) && (gmpd.verifyEmail(enteredEmail, dispEmail)==true))
			Reporter.log("Amount and Email is matching with entered amount");
		else
			Assert.fail();
	}
}
