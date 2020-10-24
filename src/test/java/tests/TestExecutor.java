package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.ObjectRepository;
import utilities.ReadingExcel;

public class TestExecutor {
	WebDriver driver;

	// reference
	ObjectRepository objectRepository;


	@BeforeSuite
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "Data Provider")
	public void testGoogleImage(String language) {
		driver.get("https://www.google.co.in/");

		// object
		objectRepository = new ObjectRepository(driver);


		objectRepository.searchInputBox.sendKeys(language);
		objectRepository.googleSearchButton.click();
		Assert.assertEquals(objectRepository.googleImg.isDisplayed(), true);
		objectRepository.googleImg.click();
	}
	
	@Test (dataProvider = "Data Provider")
	public void testYahooTitlePage(String language)
	{
		driver.get("https://in.yahoo.com/");
		//object
		objectRepository = new ObjectRepository(driver);
		
		objectRepository.searchInputBox.sendKeys(language);
		Assert.assertEquals(driver.getTitle(), "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment");
	} 

	@AfterSuite
	public void closeBroswer() {
		driver.close();
	}
	
	@DataProvider(name = "Data Provider")
	public Object[][] getData(Method methodName) throws IOException {
		ReadingExcel readingexcel = new ReadingExcel();
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Excels/";
		if (methodName.getName().equalsIgnoreCase("testGoogleImage")) {

			return readingexcel.readExcel(filePath, "DataDrivenFramework.xlsx", "google");
		} else {
			return readingexcel.readExcel(filePath, "DataDrivenFramework.xlsx", "yahoo");

		}
	}
}
