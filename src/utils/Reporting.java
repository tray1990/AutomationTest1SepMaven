package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import start.StartingAutomation;

public class Reporting {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	Utility utils = new Utility();
	DriverWorks dw = new DriverWorks();

	@BeforeSuite
	public void setUp() throws IOException {

		utils.currentDate();
		utils.currentDateNHour();
		utils.currentDateTime();

		String sPathToWrite = System.getProperty("user.dir") + "\\AutoGenOutput\\" + utils.sCurrentDate
				+ "\\Reporting\\";
		Files.createDirectories(Paths.get(sPathToWrite));

		System.out.println("ExtentReport path is : " + sPathToWrite);
		System.out.println(sPathToWrite + "ExtentReport_" + StartingAutomation.sStartTime);

		htmlReporter = new ExtentHtmlReporter(sPathToWrite + "ExtentReport_" + StartingAutomation.sStartTime + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test");
		extent.setSystemInfo("User Name", "Tarit Ray");

		htmlReporter.config().setDocumentTitle("Automation Test" + utils.sCurrentDate);
		htmlReporter.config().setReportName("Smoke Test" + utils.sCurrentDate);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		String sMethodName = "";
		Long lExecutionTime;
		sMethodName = result.getMethod().getMethodName().toString();
		lExecutionTime = (result.getEndMillis() - result.getStartMillis()) / 1000;
		System.out.println(sMethodName + " execution Time is : " + lExecutionTime + " sec.");
		if (result.getStatus() == ITestResult.FAILURE)

		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.info("Execution Time is : " + lExecutionTime + " sec.");
			dw.takeSnapShot(false, "" + sMethodName);
			System.out.println("ss path folder: " + utils.sCaptureSSPath);
			System.out.println("Method is failing: " + result.getMethod());
			test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(utils.sCaptureSSPath));
			test.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			test.info("Execution Time is : " + lExecutionTime + " sec.");
			dw.takeSnapShot(true, "" + sMethodName);
			System.out.println("ss path folder: " + utils.sCaptureSSPath);
			System.out.println("Method is passing: " + result.getMethod());
			test.log(Status.PASS, "Snapshot below: " + test.addScreenCaptureFromPath(utils.sCaptureSSPath));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.info("Execution Time is : " + lExecutionTime + " sec.");
			dw.takeSnapShot(true, "" + sMethodName);
			System.out.println("ss path folder: " + utils.sCaptureSSPath);
			test.log(Status.SKIP, "Snapshot below: " + test.addScreenCaptureFromPath(utils.sCaptureSSPath));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}