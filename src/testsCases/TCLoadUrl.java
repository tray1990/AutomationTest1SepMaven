package testsCases;

import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import classes.CommonMethods;
import classes.FilterApply;
import classes.HomePage;
import utils.ConstantValues;
import utils.DriverWorks;
import utils.ReadExcelFile;
import utils.Reporting;

public class TCLoadUrl extends Reporting {

	DriverWorks driverWorks = new DriverWorks();
	HomePage homePage = new HomePage();
	ReadExcelFile ref = new ReadExcelFile(); 

	@Test
	public void urlLunch() throws Exception {
		System.out.println("Hello urlLunch");
		driverWorks.implicitWait(2);
		test = extent.createTest("UrlLunch");
		driverWorks.loadUrl(ref.readFromExcel(ConstantValues.sExcelPath, ConstantValues.sExcelSheetName, 1, 1));
		driverWorks.implicitWait(3);
//		driverWorks.takeSnapShot(true, "urlLunch");

	}
	
	@Test (priority = 2)
	public void afterPopUpClose() {
		System.out.println("Hello afterPopUpClose");
		test = extent.createTest("AfterPopUpClose");
		homePage.closePopUp(ConstantValues.sClosePopXpath);
//		driverWorks.takeSnapShot(true, "closePopUp");
	}
	
	@Test (priority = 3)
	public void searchItem() throws Exception {
		System.out.println("Hello searchItem");
		homePage.searchItem(ConstantValues.sSearchItemXpath, ConstantValues.sSearchItemName);
		driverWorks.implicitWait(4);
//		driverWorks.takeSnapShot(true, "searchItem");
		
		test = extent.createTest("searchItem");
	}
}
