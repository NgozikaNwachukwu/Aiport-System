/* Airline class */

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
 * Date: 25th November, 2023.
 * Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest;
import java.util.ArrayList;
// Added import Statements
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an airline with details such as ID, a list of flights, and a list of aircraft.
 * Provides methods to get information about the airline, manage aircraft, and retrieve pilot information.
 */
        public class Airline {
        private String id;              // airline id
        ArrayList<Flight> flights;      // list of flights for this airline
        ArrayList<Aircraft> aircraft;   // list of aircraft for this airline

    /**
     * Constructor for the Airline class.
     * @param id The unique ID of the airline.
     * @param flights List of flights associated with the airline.
     * @param aircraft List of aircraft associated with the airline.
     */
        public Airline(String id, ArrayList<Flight> flights, ArrayList<Aircraft> aircraft) {
            // Initialization of fields.
        this.id = id;
        this.flights = flights;
        this.aircraft = aircraft;
        }

    /**
     * Gets the unique identifier of the airline.
     * @return The id of the airline.
     */
        public String getId() {
            // Returns the unique identifier of the airline.
            return id;
        }


    /**
     * Gets the list of aircraft associated with the airline.
     * @return An ArrayList of Aircraft objects.
     */
        public ArrayList<Aircraft> getAircraft() {
            // Returns the list of aircraft associated with the airline.
            return aircraft;
        }



    /**
     * Adds an aircraft to the list of aircraft associated with the airline.
     * If the aircraft is already owned by the airline, the method does nothing.
     * @param aircraft The aircraft to be added.
     */
        public void owns(Aircraft aircraft){
            // Adds an aircraft to the list of aircraft associated with the airline.
        if (!this.aircraft.contains(aircraft)) {
            this.aircraft.add(aircraft);
        }
        }

    /**
     * Prints information about all flights owned by the airline.
     */
        public void printFlightByName() {
            // Prints information about all flights owned by the airline.
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }

    /**
     * Gets the list of flights departing from the given airport.
     * @param airport The departure airport.
     * @param departTime The departure time in the format "MM/dd/yyyy HH:mm".
     * @return An ArrayList of Flight objects departing from the specified airport at the given time.
     *  @throws ParseException If there's an issue parsing the departure time.
     */
    public ArrayList<Flight> getDepartureFlightByAirport(Airport airport, String departTime) {
        // Returns the list of flights departing from the given airport at the specified time.
        ArrayList<Flight> list = new ArrayList<Flight>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            Date departureTime = dateFormat.parse(departTime);
            for (Flight flight : flights) {
                // Check if the flight departs from the specified airport at the given time
                if (flight.departureAirport.equals(airport) && flight.getDepartureTime().compareTo(departureTime) == 0) {
                    list.add(flight);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Handles the exception appropriately
        }
        return list;
    }

    /**
     * Gets the list of flights arriving at the given airport.
     * @param airport The arrival airport.
     * @param arrivalTime The arrival time in the format "MM/dd/yyyy HH:mm".
     * @return An ArrayList of Flight objects arriving at the specified airport at the given time.
     *  @throws ParseException If there's an issue parsing the arrival time.
     */
    public ArrayList<Flight> getArrivalFlightByAirport(Airport airport, String arrivalTime) {
        // Returns the list of flights arriving at the given airport at the specified time.
        ArrayList<Flight> list = new ArrayList<Flight>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            Date arrivalTimeDate = dateFormat.parse(arrivalTime);
            for (Flight flight : flights) {
                // Check if the flight arrives in the specified airport at the given time
                if (flight.arrivalAirport.equals(airport) && flight.getArrivalTime().compareTo(arrivalTimeDate) == 0) {
                    list.add(flight);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Handles the exception appropriately
        }
        return list;
    }

    /**
     * Retrieves a list of pilots working for the airline.
     * @param airline The airline to retrieve pilot information for.
     * @return An ArrayList of Pilots working for the airline.
     */
    public ArrayList<Pilots> pilotsWorkingForAirlines(Airline airline) {
        // ArrayList to store the working pilots
        ArrayList<Pilots> workingPilots = new ArrayList<>();

        // Iterates through the list of aircraft owned by the airline
        for (Aircraft aircraft : airline.getAircraft()) {
            // Gets the list of pilots associated with the aircraft
            ArrayList<Pilots> aircraftPilots = aircraft.getPilots();

            // Adds each pilot to the workingPilots list
            workingPilots.addAll(aircraftPilots);
        }

        // Returns the ArrayList containing the working pilots
        return workingPilots;
    }
}