package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(generic.TestListners.class)
public class BaseTest implements IAUTOCONSTANT 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	static
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void openApp(@Optional("chrome") String browser)
	{
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, ETO);
			js=(JavascriptExecutor)driver;
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, ETO);
			js=(JavascriptExecutor)driver;
		}
	}
		
	@AfterMethod
	public void closeApp() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
