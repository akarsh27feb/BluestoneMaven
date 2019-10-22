package scripts;		//Scenario 6

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pages.DiamondRingsPage;
import pages.HomePage;

public class Bluestone_02 extends BaseTest
{
	@Test
	public void Scenario06()
	{
		HomePage hp=new HomePage(driver);
		DiamondRingsPage drp=new DiamondRingsPage(driver);
		hp.moveTo(driver, "Rings");
		hp.clickRings("diamond");
		wait.until(ExpectedConditions.titleContains("Diamond Rings"));
		drp.moveTo(driver, "sort by");
		drp.clickSortMethod("low to high");
		ArrayList<String> l1=drp.getPriceList();
		
		List<Integer> testList=new ArrayList<Integer>();
		String [] s=new String[l1.size()];		
		for(int i=0; i<l1.size(); i++)
		{
			s[i]=l1.get(i);
			String[] s1=s[i].split("\\s+");
			if(s1.length==2)
			{
				String []t1=s1[1].split(",");
				int num=Integer.parseInt(t1[0]+t1[1]);
				testList.add(num);
			}
			else
			{
				String []s2=s1[0].split("\\.");
				String []t2=s2[1].split(",");
				int num=Integer.parseInt(t2[0]+t2[1]);
				testList.add(num);
			}
		}		
		List<Integer> compareList=new ArrayList<Integer>();
		compareList.addAll(testList);
		Collections.sort(compareList);
		try
		{
			Assert.assertEquals(testList, compareList);
		}
		catch(AssertionError e)
		{
			Assert.fail();
		}		
	}
}
