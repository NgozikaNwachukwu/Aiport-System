/* AirportTest class */

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
 * Date: 25th November, 2023.
 * Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest; // Package
import java.util.ArrayList;
import java.util.*;
import java.text.*;

/**
 * A test class to demonstrate the functionality of the airport management system.
 * It uses all the different methods(including the getters) in the Pilots, Flight, Aircraft, Airport and Airline classes
 * to show the functionality
 */

public class AirportTest {

    public static void main(String[] args)throws ParseException {
    // Main method demonstrating the functionality of the airport management system.

        //instantiates objects from Airport class
        Airport pearson = new Airport("Toronto","Canada","YYZ");
        Airport montreal = new Airport("Montreal","Canada","YUL");
        Airport ottawa = new Airport("Ottawa","Canada","YOW");

        // instantiates objects from Pilots class
        Pilots johnSmith = new Pilots ("John Smith",540,"Captain");
        Pilots SarahEric = new Pilots ("Sarah Eric",651,"C`oPilot");
        Pilots monnaKam = new Pilots ("Monna Kam",785,"navigator");


        // Created new pilots for airbusA320
        Pilots chadMicheals = new Pilots("Chad Micheals", 123, "Captain");
        Pilots andrewGarfield= new Pilots("Andrew Garfield", 457, "C`oPilot");
        Pilots ryanRenolds = new Pilots("Ryan Renolds", 789, "Navigator");

        //instantiate objects from Aircraft class
        ArrayList<Pilots> pilots = new ArrayList<Pilots>();
        pilots.add(johnSmith);
        pilots.add(SarahEric);
        pilots.add(monnaKam);
        ArrayList<Flight> flightsForBoeing787 = new ArrayList<>();
        Aircraft boeing787 = new Aircraft("boeing787","Working","landed",pilots,flightsForBoeing787);
        // Created a new Aircraft
        ArrayList<Flight> flightsForAirbusA320 = new ArrayList<>();
        Aircraft airbusA320 = new Aircraft("Airbus A320", "Working", "Airborne", new ArrayList<>(), flightsForAirbusA320);


        //instantiate objects from Flight class
        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date departureTime = dateformat.parse("07/17/2018 03:19");
        Date arrivalTime = dateformat.parse("07/20/2018 04:50");
        Flight ac472 = new Flight("AC472",departureTime,arrivalTime,pearson,ottawa,boeing787);
        flightsForBoeing787.add(ac472);

        // Created a Flight for airbusA320
        dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        departureTime = dateformat.parse("08/17/2018 03:59");
        arrivalTime = dateformat.parse("08/20/2018 04:50");
        Flight dw846 = new Flight("DW846", departureTime, arrivalTime, pearson, montreal, airbusA320);
        flightsForAirbusA320.add(dw846);

        //instantiate objects from Airline class
        ArrayList<Flight> flights= new ArrayList<Flight>();
        flights.add(ac472);
        flights.add(dw846);
        ArrayList<Aircraft> aircrafts= new  ArrayList<Aircraft>();
        aircrafts.add(boeing787);
        Airline airCanada = new Airline("Air Canada",flights,aircrafts);

        // Creating new crew for boeing787 (assuming they needed more)
        Pilots harryStyles = new Pilots("Harry Styles", 999, "First Officer");
        Pilots tayWoods = new Pilots("Tay Woods", 456, "Flight Attendant");

        // Demonstrates the joinPilot method in the Aircraft class
        // The method has been tested properly to ensure that
        // if a user mistakenly adds a pilot twice
        // it will output an error message
        boeing787.joinPilot(harryStyles);
        boeing787.joinPilot(tayWoods);
        airbusA320.joinPilot(chadMicheals);
        airbusA320.joinPilot(andrewGarfield);
        airbusA320.joinPilot(ryanRenolds);


       // Prints the list of pilots for the aircraft boeing787
        System.out.println("List of Pilots for Aircraft boeing787: ");
        System.out.println();
        //demonstrates the printPilot method in the Aircraft class
        boeing787.printPilot();

        // Prints the list of pilots for the aircraft airbusA320
        System.out.println("List of Pilots for Aircraft airbusA320: ");
        System.out.println();
        //demonstrates the printPilot method in the Aircraft class
        airbusA320.printPilot();

      // Demonstrates the isPilotForFlight method in the Pilots class
       boolean isPilotForFlight = harryStyles.isPilotForFlight(boeing787);
        System.out.println("Is Harry Styles a pilot for a flight in boeing787? " + isPilotForFlight);
        System.out.println();
        isPilotForFlight = andrewGarfield.isPilotForFlight(airbusA320);
        System.out.println("Is Andrew Garfield a pilot for a flight in airbusA320? " + isPilotForFlight);
        System.out.println();
       //Supposed to return false because Chad is in airbusA320
        isPilotForFlight = chadMicheals.isPilotForFlight(boeing787);
        System.out.println("Is Chad Micheals a pilot for a flight in boeing? " + isPilotForFlight);
        System.out.println();
       //Supposed to return false because Tay is in boeing787
        isPilotForFlight = tayWoods.isPilotForFlight(airbusA320);
        System.out.println("Is Tay Woods a pilot for a flight in airbusA320? " + isPilotForFlight);
        System.out.println();



       // Demonstrates the owns method in the Airline class
        airCanada.owns(airbusA320); //added airbusA320 to AirCanada airline

       // Print the list of aircraft for the airline
        System.out.println("List of Aircrafts for "+ airCanada.getId() + ":" + "\n");
        for (Aircraft aircraft : airCanada.getAircraft()) {
            System.out.println("Aircraft Name: " + aircraft.getName());
            System.out.println("Aircraft State: " + aircraft.getState());
            System.out.println("Aircraft Flight State: " + aircraft.getFlightState());
            System.out.println();
        }

        // Demonstrates the printFlightByName method in the Airline class
        System.out.println("Flights for " + airCanada.getId()+ ": ");
        System.out.println();
        airCanada.printFlightByName();

        // Demonstrates the pilotsWorkingForAirlines method in the Airline class
        ArrayList<Pilots> workingPilots = airCanada.pilotsWorkingForAirlines(airCanada);

        // Print the list of working pilots for the airline
        System.out.println("List of Pilots Working for " + airCanada.getId() + ":" + "\n");
        for (Pilots pilot : workingPilots) {
            System.out.println("Name: " + pilot.getPilotName());
            System.out.println("ID: " + pilot.getPilotID());
            System.out.println("Position: " + pilot.getPilotPosition());
            System.out.println();
        }

        // Demonstrate the getDepartureFlightByAirport method in the Airline class for boeing787
        ArrayList<Flight> departureFlights = airCanada.getDepartureFlightByAirport(pearson, "07/17/2018 03:19");

       // Prints the list of departure flights from pearson at 07/17/2018 03:19:
        System.out.println("Departure Flights from " + pearson.getAirportCity() +
                " at " + "07/17/2018 03:19" + ":" + "\n");
        for (Flight departureFlight : departureFlights) {
            System.out.println("Flight Name: " + departureFlight.getFlightName());
            System.out.println("Departure Airport ID: " + pearson.getAirportId());
            System.out.println("Departure Airport Country: " + pearson.getAirportCountry());
            System.out.println();
        }

       // Demonstrates the getArrivalFlightByAirport method in the Airline class for boeing787
        ArrayList<Flight> arrivalFlights = airCanada.getArrivalFlightByAirport(ottawa, "07/20/2018 04:50");

        // Prints the list of arrival flights to ottawa at 07/20/2018 04:50:
        System.out.println("Arrival Flights to " + ottawa.getAirportCity() +
                " at " + "07/20/2018 04:50" + ":" + "\n");
        for (Flight arrivalFlight : arrivalFlights) {
            System.out.println("Flight Name: " + arrivalFlight.getFlightName());
            System.out.println("Arrival Airport ID: " + ottawa.getAirportId());
            System.out.println("Arrival Airport Country: " + ottawa.getAirportCountry());
            System.out.println();

        }

        // Demonstrates the getDepartureFlightByAirport method in the Airline class for Airbus A320
        ArrayList<Flight> departureFlightsAirbusA320 = airCanada.getDepartureFlightByAirport(pearson, "08/17/2018 03:59");

       // Prints the list of departure flights from pearson at 08/17/2018 03:59:
        System.out.println("Departure Flights from " + pearson.getAirportCity() +
                " at " + "08/17/2018 03:59" + ":" + "\n");
        for (Flight departureFlight : departureFlightsAirbusA320) {
            System.out.println("Flight Name: " + departureFlight.getFlightName());
            System.out.println("Departure Airport ID: " + pearson.getAirportId());
            System.out.println("Departure Airport Country: " + pearson.getAirportCountry());
            System.out.println();
        }

        // Demonstrates the getArrivalFlightByAirport method in the Airline class for Airbus A320
        ArrayList<Flight> arrivalFlightsAirbusA320 = airCanada.getArrivalFlightByAirport(montreal, "08/20/2018 04:50");

        // Prints the list of arrival flights to montreal at 08/20/2018 04:50:
        System.out.println("Arrival Flights to " + montreal.getAirportCity() +
                " at " + "08/20/2018 04:50" + ":" + "\n");
        for (Flight arrivalFlight : arrivalFlightsAirbusA320) {
            System.out.println("Flight Name: " + arrivalFlight.getFlightName());
            System.out.println("Arrival Airport ID: " + montreal.getAirportId());
            System.out.println("Arrival Airport Country: " + montreal.getAirportCountry());
            System.out.println();
        }

    }

}