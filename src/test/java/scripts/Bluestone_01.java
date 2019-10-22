package scripts;

import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.DiamondRingsPage;
import pages.HomePage;

public class Bluestone_01 extends BaseTest 
{
	@Test
	public void scenario05()
	{
		HomePage hp=new HomePage(driver);
		DiamondRingsPage drp=new DiamondRingsPage(driver);
		hp.moveTo(driver, "Rings");
		hp.clickRings("diamond");
		wait.until(ExpectedConditions.titleContains("Diamond Rings"));
		ArrayList<String> l1=drp.getPriceList();
		drp.moveTo(driver, "sort by");
		drp.clickSortMethod("low to high");
		ArrayList<String> l2=drp.getPriceList();
		FWUtils.writeData("Scenario_05.xlsx", "Sheet1", 0, 0, "Default Price");
		for(int i=0; i<l1.size(); i++)
		{
			FWUtils.writeData("Scenario_05.xlsx", "Sheet1", i, 0, l1.get(i));
		}
		FWUtils.writeData("Scenario_05.xlsx", "Sheet1", 0, 1, "Sorted price Price");
		for(int i=0; i<l2.size(); i++)
		{
			FWUtils.writeData("Scenario_05.xlsx", "Sheet1", i, 1, l2.get(i));
		}
		
		if(l1.containsAll(l2))
			Assert.fail();
		else
			Reporter.log("Passed",true);
	}
}
