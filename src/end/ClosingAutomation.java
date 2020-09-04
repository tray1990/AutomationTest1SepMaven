package end;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.DriverWorks;
import utils.ExtentReportsClass;
import utils.Reporting;

public class ClosingAutomation extends Reporting {

	DriverWorks driverWorks = new DriverWorks();
//	ExtentReportsClass extendReports = new ExtentReportsClass();

	@Test(enabled = false)
	public void close() {
		System.out.println("Hello close.");
		driverWorks.close();
	}

	@Test(enabled = true)
	public void quit() throws IOException {
		System.out.println("Hello quit.");

		test = extent.createTest("Closing.");
		driverWorks.close();
		driverWorks.quitDriver();
	}
	
	
}
