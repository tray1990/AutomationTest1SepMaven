package classes;

import utils.ConstantValues;
import utils.DriverWorks;

public class HomePage {

	DriverWorks driverWorks = new DriverWorks();
	
	public void closePopUp (String sXPath) {
		driverWorks.clickByXpath(sXPath);		
	}
	
	public void searchItem (String sXPath, String sValue) {
		driverWorks.sendKeyByXpathEnter(sXPath, sValue);		
	}
}
