package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class BookhotelPage extends HotelApp {
	public static boolean check(String uid) {
		try {
			String begroeting = driver.findElement(By.id("username_show")).getAttribute("value");
			String begroetingToBe = "Hello " + uid + "!";
			if (!begroeting.equals(begroetingToBe)) {
				System.out.println("begroeting is fout, deze is " + begroeting + " en moet zijn " + begroetingToBe);
			}
			driver.findElement(By.id("price_night_dis"));
		} catch (NoSuchElementException e) {
			System.out.println("een element is niet gevonden " + e);
			return false;
		}
		String titel = driver.getTitle();
		if (!titel.contentEquals("Adactin.com - Book A Hotel")) {
			System.out.println("Bookhotel page titel onjuist, gevonden titel is " + titel);
			return false;
		}
		return true;
	}

	public static boolean addPersonalInfo(String firstName, String lastName, String billingAddress,
			String creditCardNo, String creditCardType, String ccMonth, String ccYear,
			String ccCvv) {
		try {
			driver.findElement(By.id("first_name")).clear();
			driver.findElement(By.id("first_name")).sendKeys(firstName);
			driver.findElement(By.id("last_name")).clear();
			driver.findElement(By.id("last_name")).sendKeys(lastName);
			driver.findElement(By.id("address")).clear();
			driver.findElement(By.id("address")).sendKeys(billingAddress);
			driver.findElement(By.id("cc_num")).clear();
			driver.findElement(By.id("cc_num")).sendKeys(creditCardNo);
			Select select = new Select(driver.findElement(By.id("cc_type")));
			select.selectByVisibleText(creditCardType);
			select = new Select(driver.findElement(By.id("cc_exp_month")));
			select.selectByVisibleText(ccMonth);
			select = new Select(driver.findElement(By.id("cc_exp_year")));
			select.selectByVisibleText(ccYear);
			driver.findElement(By.id("cc_cvv")).clear();
			driver.findElement(By.id("cc_cvv")).sendKeys(ccCvv);
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		return true;
	}
	public static boolean addPersonalInfo2() {
		try {
			driver.findElement(By.id("book_now")).click();
			// om te checken of het juiste element is geselecteerd, laat
			// ik voor de zekerheid de volledig tekst op het console plaatsen
			System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'Please wait')]")).getText());
		} catch (NoSuchElementException e) {
			System.out.println("een selenium element is niet gevonden " + e);
			return false;
		}
		
		return true;
	}
}
