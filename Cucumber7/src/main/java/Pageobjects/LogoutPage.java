package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LogoutPage extends HotelApp {
	public static boolean check() {
		// we kijken of de succesfully logout informatie aanwezig is. Dit element heeft
		// geen id. Dus
		// we moeten op een andere wijze naar dit element zoeken, bijvoorbeeld met xpath
		// (zie internet)
		// in de cursus wordt dit later ook behandeld.
		try {
			driver.findElement(By.xpath("//td[contains(text(),'You have successfully logged out.')]"));
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden" + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Logout")) {
			System.out.println("Logout Page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}

}
