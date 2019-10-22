package generic;
import java.time.LocalDate;
import java.time.LocalTime;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestListners implements ITestListener,IAUTOCONSTANT
{
	int Day=LocalDate.now().getDayOfMonth();
	int Month=LocalDate.now().getMonthValue();
	int Year=LocalDate.now().getYear();
	String date=Day+"-"+Month+"-"+Year;
	int hour=LocalTime.now().getHour();
	int min=LocalTime.now().getMinute();
	String name=date+"_"+hour+"h"+min+"m.html";
	ExtentHtmlReporter reporter=new ExtentHtmlReporter(REPORTPATH+name);
	ExtentReports reports=new ExtentReports();
	ExtentTest test;
	
	public void onStart(ITestContext context) 
	{
		reporter.config().setDocumentTitle("Framework Doc");
		reporter.config().setReportName("Hybrid FW Report");
		reports.attachReporter(reporter);
		reports.setSystemInfo("environment","test");
		reports.setSystemInfo("Build","10.36.2");
		reports.setSystemInfo("OS","Windows 10");
		reports.setSystemInfo("Test Engg.","Akarsh");
	}

	public void onTestStart(ITestResult result) 
	{
		test=reports.createTest(result.getName());
		test.log(Status.INFO, "Test Case Started");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String s1=result.getTestClass().getName();
		String []s2=s1.split("\\.");
		int l=s2.length-1;
		test.log(Status.PASS, s2[l]+":"+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) 
	{
		String s1=result.getTestClass().getName();
		String []s2=s1.split("\\.");
		int l=s2.length-1;
		test.log(Status.FAIL, s2[l]+":"+result.getMethod().getMethodName());
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		String s1=result.getTestClass().getName();
		String []s2=s1.split("\\.");
		int l=s2.length-1;
		test.log(Status.SKIP, s2[l]+":"+result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) 
	{
		reports.flush();
	}
}
