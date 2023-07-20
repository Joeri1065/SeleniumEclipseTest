package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends HotelApp {
	public static boolean check() {		
		try {
			driver.findElement(By.id("username"));
		} catch (NoSuchElementException e) {
			System.out.println("Element username niet gevonden " +e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Hotel Reservation System")) {
			System.out.println("Login page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}

	public static boolean Login(String Uid, String pw) {
		try {
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(Uid);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(pw);
			driver.findElement(By.id("login")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
}
