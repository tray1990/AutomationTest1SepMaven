package classes;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.DriverWorks;

public class FilterApply {

	DriverWorks driverWorks = new DriverWorks();

	public void selectRangeDD(String sPriceDDXpath, String sTextValue) {
		driverWorks.selectDDByValue(sPriceDDXpath, sTextValue);
	}

	public void elementToClickByIndex(String sItemName, String sParentPanelXpath, int iIndex, String sItemXpath) {
		List<WebElement> list = driverWorks.returnAllElement(sParentPanelXpath);
		try {
			list.get(iIndex).click();
			driverWorks.implicitWait(2);
			if (driverWorks.isElementDisiplayed(sItemXpath)) {
				driverWorks.clickByXpath(sItemXpath);
				System.out.println("Element Found : " + sItemName);
				driverWorks.implicitWait(5);
				driverWorks.takeSnapShot(true, sItemName);
				// driverWorks.scrollDown(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			selectMoreFilter(sItemName, sParentPanelXpath, sItemXpath);
		}
	}

	public void selectMoreFilter(String sItemName, String sParentPanelXpath, String sItemXpath)
			throws NoSuchElementException {
		List<WebElement> list = driverWorks.returnAllElement(sParentPanelXpath);
		for (int i = 0; i <= list.size() - 1; i++) {

			list.get(i).click();
			// driverWorks.waitUntilElementVisibleByXpath(ConstantValues.sProccesor, 2);
			driverWorks.implicitWait(2);
			try {
				if (driverWorks.isElementDisiplayed(sItemXpath)) {
					driverWorks.clickByXpath(sItemXpath);
					System.out.println("Element Found : " + sItemName);
					driverWorks.implicitWait(5);
					driverWorks.takeSnapShot(true, sItemName);
					// driverWorks.scrollDown(i);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
