package utils;

import java.awt.Dialog;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWorks {

	public static WebDriver driver;// = new ChromeDriver();
	Utility utils = new Utility();

	public String sGetCurrentProPath = System.getProperty("user.dir");
	static String sCurrentDateHour = "";
	static String sCurrentDateTime = "";

	public void initFFDriver() {
		System.setProperty("webdriver.gecko.driver", utils.sGetCurrentProPath + "\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
	}

	public void initChromeDriver() {
		// System.setProperty("webdriver.chrome.driver",
		// "E:\\Tarit\\Selenium\\Test7Nov\\Test\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", utils.sGetCurrentProPath + "\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void loadUrl(String sUrl) {
		driver.get(sUrl);
	}

	public void selectDD(String sXpath, int iIndex) {
		// driver.findElement(By.xpath(sXpath));

		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// sDD.selectByVisibleText(sTextName);
		// sDD.selectByIndex(1);

		WebElement selectElement = driver.findElement(By.xpath(sXpath));
		Select selectInstance = new Select(selectElement);
		// selectInstance.selectByVisibleText(sTextName);
		selectInstance.selectByIndex(iIndex);

	}

	public void selectDD(String sXpath, String sTextName) {
		// driver.findElement(By.xpath(sXpath));

		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// sDD.selectByVisibleText(sTextName);
		// sDD.selectByIndex(1);

		WebElement selectElement = driver.findElement(By.xpath(sXpath));
		Select selectInstance = new Select(selectElement);
		selectInstance.selectByVisibleText(sTextName);
		// selectInstance.selectByIndex(iIndex);

	}

	public void selectDDByValue(String sXpath, String sTextValue) {
		// driver.findElement(By.xpath(sXpath));

		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// Select sDD = new Select(driver.findElement(By.xpath(sXpath)));
		// sDD.selectByVisibleText(sTextName);
		// sDD.selectByIndex(1);

		WebElement selectElement = driver.findElement(By.xpath(sXpath));
		Select selectInstance = new Select(selectElement);
		selectInstance.selectByValue(sTextValue);
		// selectInstance.selectByIndex(iIndex);

	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void close() {
		driver.close();
	}

	public void quitDriver() {
		driver.quit();
	}

	public List<WebElement> returnAllElement(String sXpath) {
		List<WebElement> al = null;
		al = driver.findElements(By.xpath(sXpath));
		System.out.println("All Elements are : " + al);
		return al;
	}

	public void findByXpath(String sXpath) {
		driver.findElement(By.xpath(sXpath));
	}

	public void clickByXpath(String sXpath) {
		driver.findElement(By.xpath(sXpath)).click();
	}

	public String getTextByXpath(String sXpath) {
		String sText = null;
		sText = driver.findElement(By.xpath(sXpath)).getText().toString().trim();
		System.out.println("Fetched Text is : " + sText);
		return sText;
	}

	public void clickByName(String sName) {
		driver.findElement(By.name(sName)).click();
		driver.findElement(By.className(sName));
	}

	public void clickByclassName(String sName) {
		driver.findElement(By.className(sName));
	}

	public void clickByID(String sID) {
		driver.findElement(By.id(sID)).clear();
		driver.findElement(By.id(sID)).click();
	}

	public void sendKeysByID(String sID, String sValue) {
		driver.findElement(By.id(sID)).clear();
		driver.findElement(By.id(sID)).click();
		driver.findElement(By.id(sID)).sendKeys();
	}

	public void sendKeysByXpath(String sXpath, String sValue) {
		driver.findElement(By.xpath(sXpath)).click();
		driver.findElement(By.xpath(sXpath)).clear();
		driver.findElement(By.xpath(sXpath)).sendKeys(sValue);
	}

	public void sendKeyByXpathEnter(String sXpath, String sValue) {
		WebElement webElement = driver.findElement(By.xpath(sXpath));
		webElement.click();
		webElement.clear();
		webElement.sendKeys(sValue);
		webElement.sendKeys(Keys.ENTER);
	}

	public String returnPageTitle() {
		String sTitleName = driver.getTitle().toString();
		System.out.println(sTitleName);
		return sTitleName;
	}

	public boolean verifyPageContain(String sTextToVerify) {
		if (driver.getPageSource().contains(sTextToVerify)) {
			return true;

		} else {
			return false;
		}
	}

	// public String returnPageLoadTime() {
	// Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
	// "return performance.timing.loadEventEnd -
	// performance.timing.navigationStart;");
	// String sWriteIntoLog = "Page load Time : "+ loadtime.toString();
	// return sWriteIntoLog;
	// }
	public void clickUsingWebElementByClassName(String sName) {
		WebElement firstbutton = driver.findElement(By.className(sName));
		Actions actions = new Actions(driver);
		actions.moveToElement(firstbutton);
		actions.perform();
		System.out.println("Element click Done on :" + sName);
	}

	public void waitUntilElementVisibleByClassName(String sName) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(sName)));
	}

	public void clickUsingWebElementByXpath(String sXpath) {
		WebElement firstbutton = driver.findElement(By.xpath(sXpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(firstbutton);
		actions.perform();
		System.out.println("Element click Done on :" + sXpath);
	}

	public void waitUntilElementVisibleByXpath(String sXpath, int iSec) {
		WebDriverWait wait = new WebDriverWait(driver, iSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sXpath)));
		System.out.println(sXpath + " : Element is Visible");
	}

	public boolean isElementDisiplayed(String sXpath) throws NoSuchElementException {
		boolean bIsDisplayed = false;

		bIsDisplayed = driver.findElement(By.xpath(sXpath)).isDisplayed();

		return bIsDisplayed;
	}
	
	public boolean isElementEnabled(String sXpath) {
		boolean bIsEnabled = false;

		bIsEnabled = driver.findElement(By.xpath(sXpath)).isEnabled();

		return bIsEnabled;
	}
	
	public boolean isElementSelected(String sXpath) {
		boolean bIsSelected = false;

		bIsSelected = driver.findElement(By.xpath(sXpath)).isSelected();

		return bIsSelected;
	}
	
	public void implicitWait (int iTimeSec) {
		driver.manage().timeouts().implicitlyWait(iTimeSec, TimeUnit.SECONDS);
	}

	public void waitUntilElementClickableByXpath(String sXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sXpath)));
		System.out.println(sXpath + " : Element is Clickable");
	}

	public void modalPopClickButtonByXpath(String sChildXpath, int iWaitTimeSec) {

		driver.switchTo().activeElement();
		waitUntilElementVisibleByXpath(sChildXpath, iWaitTimeSec);
		WebElement button = driver.findElement(By.xpath(sChildXpath));
		button.click();
	}

	public void switchingTabs(int i) throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No. of tabs: " + tabs.size());
		driver.switchTo().window(tabs.get(i));
		Thread.sleep(5000);
		System.out.println("Page Title: " + driver.getTitle());
	}

	public void scrollDown(int i) {
		try {
			// i = 0;
			for (; i <= 20; i++) {
				((JavascriptExecutor) driver).executeScript(("window.scrollBy(0," + i + ")"), "");
			}
			for (; i > 0; i--) {
				((JavascriptExecutor) driver).executeScript(("window.scrollBy(0," + i + ")"), "");
			}
			System.out.println("Scrolling Down Completed");
		} catch (WebDriverException wde) {
		} catch (Exception e) {
		}
	}
	
	public void scrollDownintoView (WebElement element) {
		
//		WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500); 
	}

	/**
	 * scrollUp() method scrolls up the page.
	 *
	 * @return void
	 */
	public void scrollUp() {
		try {
			int i = 0;
			for (; i > -100; i--) {
				((JavascriptExecutor) driver).executeScript(("window.scrollBy(0," + i + ")"), "");
			}
			for (; i < 0; i++) {
				((JavascriptExecutor) driver).executeScript(("window.scrollBy(0," + i + ")"), "");
			}

			System.out.println("Scrolling Up Completed");
		} catch (WebDriverException wde) {
		} catch (Exception e) {
		}
	}

	public void takingJSE() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

	public void takeSnapShot(boolean bIsPass, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		utils.currentDate();
		utils.currentDateTime();
		utils.currentDateTimeSec();

		utils.currentDateNHour();
		File DestFile;

		System.out.println("Project Path:" + sGetCurrentProPath);

		String sPathSSFolder = "";
		if (bIsPass)
			sPathSSFolder = sGetCurrentProPath + "\\AutoGenOutput\\" + utils.sCurrentDate + "\\screenshot\\"
					+ utils.sCurrentDateHour + "\\Success\\";
		else
			sPathSSFolder = sGetCurrentProPath + "\\AutoGenOutput\\" + utils.sCurrentDate + "\\screenshot\\"
					+ utils.sCurrentDateHour + "\\Fail\\";
		Files.createDirectories(Paths.get(sPathSSFolder));
		if (bIsPass) {
			DestFile = new File(sPathSSFolder + fileWithPath + utils.sCurrentDateTimeSec + ".png");
			System.out.println("Success Screen Shot path is:" + DestFile);
			FileHandler.copy(SrcFile, DestFile);
		} else {
			DestFile = new File(sPathSSFolder + fileWithPath + utils.sCurrentDateTimeSec + ".png");
			System.out.println("Failed Screen Shot path is:" + DestFile);
			FileHandler.copy(SrcFile, DestFile);
		}
		// Setting Global Path for Report Attachment
		utils.sCaptureSSPath = sPathSSFolder + fileWithPath + utils.sCurrentDateTimeSec + ".png";

	}
}