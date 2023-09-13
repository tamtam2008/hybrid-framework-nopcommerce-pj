package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	
	protected WebDriver getBrowserDriver(String browserName) {
		
		if (browserName.equals("firefox")) {
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
				driver = new FirefoxDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
		} else if (browserName.equals("chrome")) {
			if (osName.contains("Mac OS")) {
				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		return driver;
	}
}
