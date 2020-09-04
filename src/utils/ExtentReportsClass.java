package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import start.StartingAutomation;

public class ExtentReportsClass {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	Utility utils = new Utility();
	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void startReport() throws IOException{
		utils.currentDate();
		utils.currentDateNHour();
		utils.currentDateTime();
		
		String sPathToWrite = System.getProperty("user.dir") + "\\AutoGenOutput\\" + utils.sCurrentDate + "\\Reporting\\";		
		Files.createDirectories(Paths.get(sPathToWrite));

		System.out.println("ExtentReport path is : "+sPathToWrite);
		System.out.println(sPathToWrite+"ExtentReport_"+ StartingAutomation.sStartTime);

		htmlReporter = new ExtentHtmlReporter(sPathToWrite+"ExtentReport_"+ StartingAutomation.sStartTime +".html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test");
		extent.setSystemInfo("User Name", "Tarit Ray");
		
		htmlReporter.config().setDocumentTitle("Automation Test"+utils.sCurrentDate );
		htmlReporter.config().setReportName("Smoke Test"+ utils.sCurrentDate);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
			
	@Test
	public void passTest(String sTestName){
		logger = extent.createTest(sTestName);
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel(sTestName+": has passed", ExtentColor.GREEN));
	}
	
	@Test
	public void failTest(String sTestName){
		logger = extent.createTest("failTest");
		Assert.assertTrue(false);
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		logger.log(Status.PASS, MarkupHelper.createLabel(sTestName+": has failed", ExtentColor.GREEN));
	}
	
	@Test
	public void skipTest(String sTestName){
		logger = extent.createTest("skipTest");
		throw new SkipException(sTestName+": Skipping the test case");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
		}
	}
	@AfterTest
	public void endReport(){
		extent.flush();
    }
}