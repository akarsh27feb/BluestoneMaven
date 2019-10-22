package scripts;		// Scenario 8

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.CartPage;
import pages.HomePage;
import pages.KadasPage;
import pages.SpecificKadaPage;

public class Bluestone_04 extends BaseTest
{
	@Test
	public void Scenario_08() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		KadasPage kp=new KadasPage(driver);
		SpecificKadaPage skp=new SpecificKadaPage(driver);
		CartPage cp=new CartPage(driver);
		hp.moveTo(driver, "All Jwellery");
		hp.clickAllJwellery("Kada");
		wait.until(ExpectedConditions.titleContains("Bangles"));
		kp.clickKada(1);
		wait.until(ExpectedConditions.titleContains("Kada"));
		skp.clickSelectSize();
		skp.selectKadaSize("08");
		String selected=skp.selectSizeText();
		FWUtils.screenShotPage("Bluestone04_01.jpg", driver);
		skp.clickBuyNow();
		wait.until(ExpectedConditions.titleContains("Shopping Bag"));
		FWUtils.screenShotPage("Bluestone04_02.jpg", driver);
		String displayedSize=cp.size();
		Assert.assertEquals(selected, displayedSize);
	}
}
