package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SelectPage extends HotelApp {
	public static boolean check(String uid) {
		try {
			driver.findElement(By.xpath("//td[contains(text(),'Hello Username!')]"));
			
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Select Hotel")) {
			System.out.println("Select page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}
	
	public static boolean Logoff () {
		try {
			driver.findElement(By.linkText("Logout")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
	
	public static boolean select (String item) {
		try {
			driver.findElement(By.id("radiobutton_" + item)).click();
			driver.findElement(By.id("continue")).click();
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
}







