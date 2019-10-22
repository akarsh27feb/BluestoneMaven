package scripts;		//Scenario 30

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.GoldMinePDPage;
import pages.GoldMinePage;
import pages.HomePage;

public class Bluestone_21 extends BaseTest
{
	@Test
	public void Scenario_30()
	{
		HomePage hp=new HomePage(driver);
		GoldMinePage gmp=new GoldMinePage(driver);
		GoldMinePDPage gmpd=new GoldMinePDPage(driver);
		hp.clickGoldMine();
		wait.until(ExpectedConditions.titleContains("Gold Mine 10+1"));
		gmp.amount("1000");
		gmp.emailId("abc@gmail.com");
		gmp.clickStartNow();
		wait.until(ExpectedConditions.titleContains("Gold Mine Personal Detail"));
		gmpd.contactNum("", "clear");
		gmpd.fullName("", "clear");
		gmpd.address("", "clear");
		gmpd.pincode("", "clear");
		gmpd.clickNext();
		gmpd.verifyMblNoErr();
		gmpd.verifyNameErr();
		gmpd.verifyAddressErr();
		gmpd.verifyPincodeErr();
	}
}
