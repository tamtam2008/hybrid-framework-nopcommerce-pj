package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			// headless firefox
		} else if (browserName.equals("h_firefox")) {
			if (GlobalConstants.OS_NAME.contains("Mac OS")) {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.PROJECT_PATH + "/browserDrivers/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new FirefoxDriver(options);
			} else {
				System.setProperty("webdriver.gecko.driver", GlobalConstants.PROJECT_PATH + "\\browserDrivers\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new FirefoxDriver(options);
			}

			// headless chrome
			// recheck version chrome driver before run
		} else if (browserName.equals("h-chrome")) {
			if (GlobalConstants.OS_NAME.contains("Mac OS")) {
//				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new ChromeDriver(options);
			} else {
				System.setProperty("webdriver.chrome.driver", GlobalConstants.PROJECT_PATH + "\\browserDrivers\\\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new ChromeDriver(options);
			}

		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.PORTAL_PAGE_URL);
//		driver.get(getEnviromentUrl(enviromentName));
		return driver;
	}

	private String getEnviromentUrl(String enviromentName) {
		String url = null;
		switch (enviromentName) {
		case "DEV":
			url = GlobalConstants.PORTAL_PAGE_URL;
			break;
		case "STG":
			url = GlobalConstants.PORTAL_PAGE_URL;
			break;
		}
		return url;
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
