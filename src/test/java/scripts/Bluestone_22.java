package scripts;		//Scenario 31

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.GoldMineNomineePage;
import pages.GoldMinePDPage;
import pages.GoldMinePage;
import pages.GoldMinePaymentPage;
import pages.HomePage;

public class Bluestone_22 extends BaseTest
{
	@Test
	public void Scenario_31()
	{
		HomePage hp=new HomePage(driver);
		GoldMinePage gmp=new GoldMinePage(driver);
		GoldMinePDPage gmpd=new GoldMinePDPage(driver);
		GoldMineNomineePage gmnp=new GoldMineNomineePage(driver);
		GoldMinePaymentPage gmpp=new GoldMinePaymentPage(driver); 
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
		gmpd.contactNum("9876543210", "set");
		gmpd.fullName("Ajay", "set");
		gmpd.address("Bangalore Thidlu", "set");
		gmpd.pincode("560097", "set");
		gmpd.clickNext();
		wait.until(ExpectedConditions.titleContains("Gold Mine Nominee Detail"));
		gmnp.nomineeName("", "clear");
		gmnp.nomineeName("Anjali", "set");
		gmnp.relationship("Spouse");
		gmnp.nationality("Indian");
		gmnp.clickNext();
		wait.until(ExpectedConditions.titleContains("Gold Mine Payment Option"));
		gmpp.verifyPage(driver);
	}
}
