package dataProviderForTests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utilities.ReadingExcel;

public class ProvidesData {
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
