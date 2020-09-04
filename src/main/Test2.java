package main;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import utils.ExtentReportsClass;

public class Test2 {
	
	ExtentReportsClass extendReportsTest2 = new ExtentReportsClass();
	
	@Test (priority = 1)
	public void Test1() throws InterruptedException, IOException {
		Thread.sleep(5000);

		extendReportsTest2.startReport();
		extendReportsTest2.passTest("Test1");
		extendReportsTest2.endReport();

	}
	@Test (priority = 2)
	public void Test2() throws InterruptedException, IOException {
		Thread.sleep(5000);

		extendReportsTest2.startReport();
		extendReportsTest2.passTest("Test2");
		extendReportsTest2.endReport();

//		extendReports.passTest("searchItem");
	}

}
