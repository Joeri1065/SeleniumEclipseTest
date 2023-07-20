package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BookingconfPage extends HotelApp {
	public static boolean check(String uid) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order_no")));
		
		try {
			String begroeting = driver.findElement(By.id("username_show")).getAttribute("value");
			String begroetingToBe = "Hello " + uid + "!";
			if (!begroeting.equals(begroetingToBe)) {
				System.out.println("begroeting is fout, deze is " + begroeting + " en moet zijn " + begroetingToBe);
			}
			driver.findElement(By.id("final_price"));
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Hotel Booking Confirmation")) {
			System.out.println("Bookingconfig page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}
	
	
	public static boolean klikBookedIt() {
		try {
			driver.findElement(By.linkText("Booked Itinerary")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
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
