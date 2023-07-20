package Pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BookedItineraryPage extends HotelApp{
	
	private static String tripId1 = "";
	
	public static boolean check(String uid) {
		try {
			String begroeting = driver.findElement(By.id("username_show")).getAttribute("value");
			String begroetingToBe = "Hello " + uid + "!";
			if (!begroeting.equals(begroetingToBe)) {
				System.out.println("begroeting is fout, deze is " + begroeting + " en moet zijn " + begroetingToBe);
			}
			driver.findElement(By.id("order_id_text"));
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Select Hotel")) {
			System.out.println("Bookhotel page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}
	
	public static boolean Cancel1(int selectionNumber) {
		String xpath = "(//input[contains(@type, 'checkbox')])[" + String.valueOf(selectionNumber + 2) + "]";
		String xpath2 = "(//input[contains(@id, 'order_id_')])[" + String.valueOf(selectionNumber + 2) + "]";
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			System.out.println("Verwachting is ids[], resultaat is " + we.getAttribute("name"));
			WebElement sibling = driver.findElement(By.xpath(xpath2));
			tripId1 = sibling.getAttribute("value");
			System.out.println("---> trip to delete is: " + tripId1);
			we.click();
			driver.findElement(By.name("cancelall")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		return true;
	}
	
	public static boolean Cancel2() {	
		Alert popup = driver.switchTo().alert();
		String popupMessage = popup.getText();
		if (popupMessage.contentEquals("Are you sure want to Cancel Selected?.")) {
			System.out.println("verwachtte popup tekst gevonden") ;
		} else {
			System.out.println("popup tekst fout, gevonden tekst is " + popupMessage);
		}
		popup.accept();
		return true;
	}
		
	public static boolean isTripDeleted() {
		String xpath = "//input[contains(@value, '"+ tripId1 + "')]";
		System.out.println("---> check of de trip is verwijderd, wordt uitgevoerd met xpath " + xpath);
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			System.out.println("trip is niet verwijderd, webelement is: " + we);
			return false;
		} catch (NoSuchElementException e) {
			System.out.println("trip komt niet meer voor in de lijst, dus juist verwijderd.");
			return true;
		}
	}
	
	
	public static boolean logoff () {
		try {
			driver.findElement(By.linkText("Logout")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
	
}


