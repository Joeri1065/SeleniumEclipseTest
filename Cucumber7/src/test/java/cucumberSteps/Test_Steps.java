package cucumberSteps;

import java.util.List;


import Pageobjects.BookedItineraryPage;
import Pageobjects.BookhotelPage;
import Pageobjects.BookingconfPage;
import Pageobjects.HotelApp;
import Pageobjects.LoginPage;
import Pageobjects.LogoutPage;
import Pageobjects.SearchPage;
import Pageobjects.SelectPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Test_Steps {
	public static String uid = "";
	public static String pw = "";
	public static String location = "";
	public static String noRooms = "";
	public static String inDate = "";
	public static String outDate = "";
	public static String noAdults = "";
	public static String hotelToSelect = "1";
	public static String firstName = "";
	public static String lastName = ""; 
	// windows break char is \r\n, other operating systems \n
	public static String billingAddress = "";
	public static String creditCardNo = ""; 
	public static String creditCardType = "";
	public static String ccMonth = ""; 
	public static String ccYear = "";
	public static String ccCvv = "";
	public static int tripToDelete = 1;
	
	
	public static int testcase = 0;
	
	@Given("^de bezoeker ziet het start aanlog scherm$")
	public void de_bezoeker_ziet_het_start_aanlog_scherm()  {
		HotelApp.init("chrome", "https://www.adactin.com/HotelApp/");
		boolean ok = LoginPage.check();
		if (ok == true) {
			System.out.println("controle LoginPage met succes uitgevoerd");
		} else
			System.exit(1);
	}
	
	@When("^de bezoeker \"([^\"]*)\" en \"([^\"]*)\" invult en op login knop drukt$")
	public void de_bezoeker_userid_en_password_invult_en_op_login_knop_drukt(String arg1, String arg2) {
		uid = arg1;
		pw = arg2;
		boolean ok = LoginPage.Login(uid, pw);
		if (ok == true) {
			System.out.println("login transitie met succes uitgevoerd");
		} else
			System.exit(2);
	}

	@Then("^wordt de Search pagina getoond$")
	public void wordt_de_Search_pagina_getoond()  {
		boolean ok = SearchPage.check(uid);
		if (ok == true) {
			System.out.println("controle SearchPage met succes uitgevoerd");
		} else
			System.exit(3);
	}

	@Given("^de bezoeker ziet de Search pagina$")
	public void deBezoekerZietDeSearchPagina() {
		boolean ok = SearchPage.check(uid);
		if (ok == true) {
			System.out.println("controle SearchPage met succes uitgevoerd");
		} else
			System.exit(4);
	}

	@When("^de bezoeker de \"([^\"]*)\" en \"([^\"]*)\" en \"([^\"]*)\" en \"([^\"]*)\" en \"([^\"]*)\" invult$")
	public void de_Bezoeker_De_En_En_En_En_Invult(String arg1, String arg2, String arg3, String arg4, String arg5) {
		location = arg1;
		noRooms = arg2;
		noAdults = arg3;
		inDate = arg4;
		outDate = arg5;
		boolean ok = SearchPage.makeFirstSelection(location, noRooms, noAdults, inDate, outDate);
		if (ok == true) {
			System.out.println("makeFirstSelection transitie met succes uitgevoerd");
		} else
			System.exit(5);
	}
	
	@When("^de boeker de eerste hotelaanbieding kiest$")
	public void de_boeker_de_eerste_hotelaanbieding_kiest()  {
		boolean ok = SelectPage.select(hotelToSelect);
		if (ok == true) {
			System.out.println("transitie SelectPage.select met succes uitgevoerd");
		} else
			System.exit(6);
	}

	@Then("^wordt de Select pagina getoond$")
	public void wordt_de_Select_pagina_getoond()  {
		boolean ok = SelectPage.check(uid);
		if (ok == true) {
			System.out.println("controle SelectPage met succes uitgevoerd");
		} else
			System.exit(6);
	}

	@Given("^de bezoeker ziet de Select pagina$")
	public void de_bezoeker_ziet_de_Select_pagina()  {
		boolean ok = SelectPage.check(uid);
		if (ok == true) {
			System.out.println("controle SelectPage met succes uitgevoerd");
		} else
			System.exit(7);
	}
	//**************************************
	@When("^de boeker het eerste hotelaanbieding kiest$")
	public void de_boeker_het_eerste_hotelaanbieding_kiest()  {
		boolean ok = SelectPage.select(hotelToSelect);
		if (ok == true) {
			System.out.println("transitie SelectPage.select met succes uitgevoerd");
		} else
			System.exit(8);
	}

	@Then("^wordt de boekingsinformatie getoond$")
	public void wordt_de_boekingsinformatie_getoond()  {
		boolean ok = BookhotelPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookhotelPage met succes uitgevoerd");
		} else
			System.exit(9);
	}

	@Given("^de bezoeker ziet de BoekHotel pagina$")
	public void de_bezoeker_ziet_de_BoekHotel_pagina()  {
		boolean ok = BookhotelPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookhotelPage met succes uitgevoerd");
		} else
			System.exit(10);
	}

	@When("^de bezoeker BoekersInfo invult$")
	public void de_bezoeker_BoekersInfo_invult(List<BoekersInfo> boekInfo) {
		BoekersInfo boeker = boekInfo.get(testcase);
		firstName = boeker.getfName();
		lastName = boeker.getlName();
		billingAddress = boeker.getadress();
		creditCardNo = boeker.getcardNo();
		creditCardType = boeker.getcardType();
		ccMonth = boeker.getccMonth();
		ccYear = boeker.getccYear();
		ccCvv = boeker.getccCode();
		boolean ok = BookhotelPage.addPersonalInfo(firstName, lastName, billingAddress, creditCardNo, creditCardType,
				ccMonth, ccYear, ccCvv);
		if (ok == true) {
			System.out.println("transitie BookhotelPage.addPersonalInfo met succes uitgevoerd");
		} else
			System.exit(11);
		testcase ++;
		if (testcase == boekInfo.size()) {
			testcase = 0;
		}
	}

	@When("^daarna op Book Now klikt$")
	public void daarna_op_Book_Now_klikt()  {
		boolean ok = BookhotelPage.addPersonalInfo2();
		if (ok == true) {
			System.out.println("transitie BookhotelPage.addPersonalInfo2 met succes uitgevoerd");
		} else
			System.exit(12);
	}

	@Then("^wordt de Booking Confirmation pagina getoond$")
	public void wordt_de_Booking_Confirmation_pagina_getoond()  {
		boolean ok = BookingconfPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookingconfPage met succes uitgevoerd");
		} else
			System.exit(13);
	}

	
	
//	****************************************************************************
	
	
	@Given("^de bezoeker ziet de Confirmation pagina$")
	public void de_bezoeker_ziet_de_Confirmation_pagina() {
		boolean ok = BookingconfPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookingconfPage met succes uitgevoerd");
		} else
			System.exit(17);
	}
	
	
	@When("^de bezoeker klikt op Booked Itinerary pagina$")
	public void de_bezoeker_klikt_op_Booked_Itinerary_pagina() {
		boolean ok = BookingconfPage.klikBookedIt();
		if (ok == true) {
			System.out.println("transitie BookingconfPage.klikBookedIt() met succes uitgevoerd");
		} else
			System.exit(18);
	}
	
	@Then("^de bezoeker is op de Booked Itinerary pagina$")
	public void de_bezoeker_is_op_de_Booked_Itinerary_pagina() {
		boolean ok = BookedItineraryPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookeditPage met succes uitgevoerd");
		} else
			System.exit(19);
	}
	
	
	@Given("de bezoeker ziet de Booked Itinerary pagina")
	public void de_bezoeker_ziet_de_booked_itinerary_pagina() {
		boolean ok = BookedItineraryPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookedItineraryPage met succes uitgevoerd");
		} else
			System.exit(17);
	}
	
	
	@When("^de bezoeker selecteerd een reis en klikt op Cancel Selected$")
	public void de_bezoeker_selecteerd_een_reis_en_klikt_op_Cancel_Selected() {
		boolean ok = BookedItineraryPage.Cancel1(1);
		if (ok == true) {
			System.out.println("transitie BookedItineraryPage.deleteBooking1 met succes uitgevoerd");
		} else
			System.exit(21);
	}

	@When("^klikt op OK in de popup$")
	public void klikt_op_OK_in_de_popup() {
		boolean ok = BookedItineraryPage.Cancel2();
		if (ok == true) {
			System.out.println("transitie BookedItineraryPage.deleteBooking2 met succes uitgevoerd");
		} else
			System.exit(22);
	}

	@Then("^de geselecteerde reis is uit het overzicht$")
	public void de_geselecteerde_reis_is_uit_het_overzicht() {
		boolean ok = BookedItineraryPage.isTripDeleted();
		if (ok == true) {
			System.out.println("controle BookedItineraryPage.isTripDeleted() met succes uitgevoerd");
		} else
			System.exit(23);
	}

	@Given("^de bezoeker is nog op de BookedItinerary pagina$")
	public void de_bezoeker_is_nog_op_de_BookedItinerary_pagina() {
		boolean ok = BookedItineraryPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookingconfPage met succes uitgevoerd");
		} else
			System.exit(24);
	}
	
	@When("^de bezoeker is op de logout pagina$")
	public void de_bezoeker_is_op_de_logout_pagina() {
		boolean ok = LogoutPage.check();
		if (ok == true) {
			System.out.println("controle LogoutPage met succes uitgevoerd");
		} else
			System.exit(26);
		HotelApp.teardown();
	}

	@When("^de bezoeker is op de Search pagina$")
	public void de_bezoeker_is_op_de_Search_pagina() {
		boolean ok = SearchPage.check(uid);
		if (ok == true) {
			System.out.println("controle SearchPage met succes uitgevoerd");
		} else
			System.exit(24);
	}

	@When("^de bezoeker is nog op de BookingConfirmation pagina$")
	public void de_bezoeker_is_op_de_bookingconfirm_pagina() {
		boolean ok = BookingconfPage.check(uid);
		if (ok == true) {
			System.out.println("controle BookingconfPage met succes uitgevoerd");
		} else
			System.exit(24);
	}

	@When("^de bezoeker klikt op BookedItinerary logout$")
	public void deBezoekerKliktOpBookedItineraryLogout() {
		boolean ok = BookedItineraryPage.logoff();
		if (ok == true) {
			System.out.println("transitie BookingconfPage.logoff() met succes uitgevoerd");
		} else
			System.exit(25);
	}

	@When("^de bezoeker klikt op SearchPage logout$")
	public void deBezoekerKliktOpSearchPageLogout() {
		boolean ok = SearchPage.Logoff();
		if (ok == true) {
			System.out.println("transitie BookingconfPage.logoff() met succes uitgevoerd");
		} else
			System.exit(25);
	}

	@When("^de bezoeker klikt op BookingConfirmation logout$")
	public void deBezoekerKliktOpBookingConfirmationLogout() {
		boolean ok = BookingconfPage.logoff();
		if (ok == true) {
			System.out.println("transitie BookingconfPage.logoff() met succes uitgevoerd");
		} else
			System.exit(25);
	}
}
