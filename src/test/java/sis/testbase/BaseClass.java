package sis.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sis.utils.ConfigsReader;
import sis.utils.Constants;

public class BaseClass  {

	public static WebDriver driver;

	public static void setUp() throws InterruptedException {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		String browser = ConfigsReader.getProperty("browser");
		// System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

//		if(browser.toLowerCase() == "chrome") {
//			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
//			driver = new ChromeDriver();
//		} else if (browser.toLowerCase() == "firefox") {
//			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
//			driver = new FirefoxDriver();
//		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		String website = ConfigsReader.getProperty("url");
		driver.get(website);


			PagesInitializer.inititalize();	

	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
