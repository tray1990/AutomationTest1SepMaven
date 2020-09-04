package classes;

import utils.ConstantValues;
import utils.DriverWorks;

public class CommonMethods {

	DriverWorks driverWorks = new DriverWorks();

	public void clickByXpath(String sXpath) {
		driverWorks.clickByXpath(sXpath);
	}

	public void waitForElementVisible(String sXpathForElement, int iWaitSec) {
		driverWorks.waitUntilElementVisibleByXpath(sXpathForElement, iWaitSec);
		;
	}

	public void waitForElementClickable(String sXpathForElement) {
		driverWorks.waitUntilElementClickableByXpath(sXpathForElement);
	}
}
