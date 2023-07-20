Feature: Alleen een bekende Webshop bezoeker mag de reizen zien of boeken
As a        product manager
I want    	dat alleen een geregistreerde bezoeker de reizen in mag zien boeken en of annuleren
So that    	het foutief aantal boekingen wordt gereduceerd met 10%

Background: aanloggen in het systeem
Given de bezoeker ziet het start aanlog scherm
When de bezoeker "userid_wijzig" en "password_wijzig" invult en op login knop drukt
 | Joeri1065 | &FK#1Bi2$EtX!zTr |
 | uid2 | pw2 |
Then wordt de Search pagina getoond

Scenario Outline: selecteren van een aantal reizen
Given de bezoeker ziet de Search pagina
When de bezoeker de "<Location>" en "<noRooms>" en "<noAdults>" en <"dateIn>" en "<dateOut>" invult
And de boeker het eerste hotelaanbieding kiest
And de bezoeker voornaam, achternaam, Billing adres, en CreditCardop invult
| klaas | smit | A-straat 10  \n B-Stad | 1234567890123456 | VISA | June | 2022 | 1234 |
| piet | deWitt | B-straat 10  \n C-Dorp | 2345678901234567 | Master Card | April | 2020 | 4321 |
| rene | jansen | C-straat 10  \n D-Dorp | 3456789012345678 | Master Card | April | 2020 | 5432 |
And daarna op Book Now klikt
And de bezoeker klikt op BookingConfirmation logout
Then de bezoeker is op de logout pagina
Examples: 
| Location | noRooms | noAdults | dateIn | dateOut |
| London | 1 | 1 - One | 13/05/2022 | 18/05/2022 | 
| Paris | 2 | 2 - Two | 13/05/2023 | 18/05/2023 |

Scenario: annuleren van een reis
Given de bezoeker ziet de Search pagina
When de bezoeker klikt op Booked Itinerary pagina
And de bezoeker selecteerd een reis en klikt op Cancel Selected
And klikt op OK in de popup
And de bezoeker klikt op BookedItinerary logout
Then de bezoeker is op de logout pagina


