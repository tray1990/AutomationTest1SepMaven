package start;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.DriverWorks;
import utils.ExtentReportsClass;
import utils.Reporting;
import utils.Utility;

public class StartingAutomation extends Reporting{


	DriverWorks driverWorks = new DriverWorks();
//	ExtentReportsClass extendReportsStart = new ExtentReportsClass();
	public static String sStartTime =Utility.returnCurrentDateTime();
	Reporting reporting  = new Reporting();
	
	@Test
	public void start() throws IOException {
		System.out.println("Hello StartingAutomation"+ "Time: " +Utility.returnCurrentDateTime());
		driverWorks.initFFDriver();
		driverWorks.maximizeBrowser();
		reporting.setUp();
		System.out.println("Time sec: "+Utility.sCurrentDateTimeSec);
		
		test = extent.createTest("Start");
	}
	
	@AfterMethod
	public void actions (ITestResult result) throws Exception {
		if(result.getStatus() == ITestResult.SUCCESS) {
//			driverWorks.takeSnapShot(true, returnMethodName(arg0.getTestMethod()));		
//			driverWorks.takeSnapShot(true, "");	
			System.out.println("Method is passing");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
//			driverWorks.takeSnapShot(true, returnMethodName(arg0.getTestMethod()));		
//			driverWorks.takeSnapShot(true, "this");
			System.out.println("Method is Failing.");
		}
		
//		System.out.println("Executed Method Name: "+returnMethodName(arg0.getTestMethod()));	
	}
	
	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

	    return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}
}
