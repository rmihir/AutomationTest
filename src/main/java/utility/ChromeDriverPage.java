package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ChromeDriverPage {

	public static WebDriver driver;
	public Actions action;
	
	protected static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-extensions");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--whitelisted-ips");
//		options.addArguments("--disable-software-rasterizer");
//		options.addArguments("--enable-precise-memory-info");
//		options.addArguments("--disable-dev-shm-usage");
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//		options.setAcceptInsecureCerts(true);
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setCapability(ChromeOptions.CAPABILITY, options);

		return options;
	}

	@SuppressWarnings("deprecation")
	public static WebDriver getInstance() {
		if (driver == null) {
			driver = new ChromeDriver(chromeOption());
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		}
		return driver;
	}
}
