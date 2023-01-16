package script.basescript;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.ChromeDriverPage;

public class BaseTest extends ChromeDriverPage {
	protected Logger logger = Logger.getLogger(this.getClass());

	public String password = "*****";
	public String base_url = "https://jqueryui.com/";
	public String username = "Admin";

	private final String line = "=================================================================";

	public BaseTest() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@BeforeClass
	public void beforeClass() {
		getStaticData();
		try {
			driver = new ChromeDriver(chromeOption());
			driver.manage().deleteAllCookies();
		} catch (UnhandledAlertException alertException) {
			logger.info(alertException);
			driver.switchTo().alert().accept();
			driver = new ChromeDriver(chromeOption());
		}
		driver.get(base_url);
		logger.info(line);
		logger.info("TESTCASE START TIME [BEFORE CLASS] : " + systemTime());
		logger.info(line);
	}

	@AfterClass
	protected void testCaseEndTime() throws IOException {
		logger.info(line);
		logger.info("TESTCASE END TIME [AFTER CLASS] : " + systemTime());
		logger.info(line);

		if (null != driver) {
			driver.manage().deleteAllCookies();
			driver.quit();
		
		}
	}

	protected void expectedResult() {
		Reporter.log("");
		Reporter.log("Expected :");
		Reporter.log("=========");
	}

	private void getStaticData() {
		logger.info("================= EXECUTION USER DETAILAS ====================");
		logger.info("CURRENT LOGGIN USER EMAIL ID IS : " + username);
		logger.info("CURRENT LOGGIN USER PASSWORD IS : " + password);
		logger.info("URL IS DETECTED FROM PROPERTY FILE : " + base_url);
	}

	protected void testCaseDevelopedBy(String scriptWriterName, String testCaseName) {
		Reporter.log("\n===============================================================");
		Reporter.log(
				"<b> <font color='blue' size='2'>Automation Case Developed by : " + scriptWriterName + "</font></b>");
		Reporter.log("<b> <font color='blue' size='2'>TestCase Name : " + testCaseName + "</font></b>");
		Reporter.log("<b> <font color='blue' size='2'>TestCase Start Time : " + systemTime() + "</font></b>");
		Reporter.log("<b> <font color='blue' size='2'>EXECUTION ON URL : " + base_url + "</font></b>");
		Reporter.log("=================================================================");
	}

	protected static String systemTime() {
		Calendar calendar = new GregorianCalendar();
		String amPm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0) {
			amPm = "AM";
		} else {
			amPm = "PM";
		}
		return hour + "_" + minute + "_" + second + "_" + amPm;
	}
}