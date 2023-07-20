package Pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends HotelApp {
	public static boolean check(String uid) {
		try {
			// we halen de begroeting op die in het attribuut "value" staat
			String begroeting = driver.findElement(By.id("username_show")).getAttribute("value");
			// we bepalen hoe de begroeting moet zijn
			String begroetingToBe = "Hello " + uid + "!";
			// if (!begr.... betekent dat de equals onwaar moet zijn
			if (!begroeting.equals(begroetingToBe)) {
				System.out.println("begroeting is fout, deze is " + begroeting + " en moet zijn "+ begroetingToBe);
			}
			driver.findElement(By.id("location"));
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Search Hotel")) {
			System.out.println("Search page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}
	
	public static boolean Logoff () {
		// om de logout uit te voeren moet je klikken op <a href="Logout.php">Logout</a>
		try {
			driver.findElement(By.linkText("Logout")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
	
	public static boolean makeFirstSelection (String location, String noRooms, String noAdults, String inDate, String outDate) {
		try {
			Select select = new Select(driver.findElement(By.id("location")));
			select.selectByValue(location);
			select = new Select(driver.findElement(By.id("room_nos")));
			select.selectByValue(noRooms);
			select = new Select(driver.findElement(By.id("adult_room")));
			select.selectByVisibleText(noAdults);
			driver.findElement(By.id("datepick_in")).clear();
			driver.findElement(By.id("datepick_in")).sendKeys(inDate + Keys.TAB + outDate);
			driver.findElement(By.id("Submit")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}

	public static boolean klikSearchPage() {
		try {
			driver.findElement(By.linkText("Search Hotel")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
}
