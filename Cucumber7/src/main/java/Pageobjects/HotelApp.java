package Pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelApp {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	public static void init(String typeDriver, String url) {
		if (typeDriver.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (typeDriver.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("foute keuze driver");
			System.exit(8);
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().fullscreen();
		driver.get(url);
//		driver.navigate().to(url);
		
	}

	public static void teardown() {
		driver.quit();
	}
}
