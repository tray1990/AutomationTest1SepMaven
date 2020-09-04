package testsCases;

import java.util.ArrayList;
import java.util.List;

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
import utils.WriteJSONFile;

public class TcStorePhonePrice extends Reporting {

	DriverWorks driverWorks = new DriverWorks();
	HomePage homePage = new HomePage();
	ReadExcelFile ref = new ReadExcelFile();

	@Test
	public void storePhoneName() throws Exception {
		System.out.println("Hello StorePhoneName");
		// homePage.searchItem(ConstantValues.sSearchItemXpath,
		// ConstantValues.sSearchItemName);
		// test = extent.createTest("searchItem");

		List<WebElement> listPhoneName = driverWorks.returnAllElement("//div[@class = '_3wU53n']");
		List<WebElement> listPhonePrice = driverWorks.returnAllElement("//div[@class = '_1vC4OE _2rQ-NK']");
		ArrayList<String> alPhoneName = new ArrayList<String>();
		ArrayList<String> alPhonePrice = new ArrayList<String>();;

		for (int i = 0; i <= listPhoneName.size() - 1; i++) {

			System.out.println(i + " phone Name is : " + listPhoneName.get(i).getText());
			alPhoneName.add(i, listPhoneName.get(i).getText().toString());
		}
		
		for (int j = 0; j <= listPhonePrice.size() - 1; j++) {
			System.out.println(j + " price is : " + listPhonePrice.get(j).getText());
			alPhonePrice.add(j, listPhonePrice.get(j).getText().toString());
		}
		
		WriteJSONFile writeJSONFile = new WriteJSONFile();
		writeJSONFile.jsonWrite(alPhoneName, alPhonePrice);

	}

}
