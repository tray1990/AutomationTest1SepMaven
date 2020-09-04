package testsCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class TcApplyFilter extends Reporting {

	DriverWorks driverWorks = new DriverWorks();
	HomePage homePage = new HomePage();
	CommonMethods comMethods = new CommonMethods();
	FilterApply filterApp = new FilterApply();

	@Test(priority = 1)
	public void selectMinRangeFilter() throws InterruptedException {

		CommonMethods comMethods = new CommonMethods();
		FilterApply filterApp = new FilterApply();
		System.out.println("Hello SelectMaxRangeFilter");
		comMethods.waitForElementVisible(ConstantValues.sPriceDDXpath, 10);
		comMethods.waitForElementClickable(ConstantValues.sPriceDDXpath);
		test = extent.createTest("selectMinRangeFilter");
		filterApp.selectRangeDD(ConstantValues.sMinPriceDDXpath, ConstantValues.sMinTextValue);
		driverWorks.implicitWait(2);
	}

	@Test(priority = 2)
	public void selectMaxRangeFilter() throws InterruptedException {

		CommonMethods comMethods = new CommonMethods();
		FilterApply filterApp = new FilterApply();
		System.out.println("Hello SelectMaxRangeFilter");
		comMethods.waitForElementVisible(ConstantValues.sPriceDDXpath, 10);
		comMethods.waitForElementClickable(ConstantValues.sPriceDDXpath);
		test = extent.createTest("SelectMaxRangeFilter");
		filterApp.selectRangeDD(ConstantValues.sPriceDDXpath, ConstantValues.sTextValue);
		driverWorks.implicitWait(5);
	}

	@Test(priority = 3)
	public void selectRam() throws InterruptedException {
		System.out.println("Hello selectRam");
		test = extent.createTest("selectRam");
		// comMethods.waitForElementVisible(ConstantValues.sRamXapth);
		// comMethods.waitForElementClickable(ConstantValues.sRamXapth);
		try {
			driverWorks.clickByXpath(ConstantValues.sRamXapth);
		} catch (Exception e) {
			e.printStackTrace();
			filterApp.elementToClickByIndex(ConstantValues.sRamSize, ConstantValues.sSidePanelClassName, 1, ConstantValues.sRamXapth);
		}
		driverWorks.implicitWait(5);
	}

	@Test(priority = 4)
	public void selectProcessor() throws InterruptedException {

		System.out.println("Hello selectProcessor");
		test = extent.createTest("SelectProcessor");
//		filterApp.elementToClickByIndex(ConstantValues.sProccesorName, ConstantValues.sSidePanelClassName, 13, ConstantValues.sProccesorXpath);
		try {
			driverWorks.clickByXpath(ConstantValues.sProccesorXpath);
		} catch (Exception e) {
			e.printStackTrace();
			filterApp.elementToClickByIndex(ConstantValues.sProccesorName, ConstantValues.sSidePanelClassName, 13, ConstantValues.sProccesorXpath);
		}
		driverWorks.implicitWait(5);
	}

}
