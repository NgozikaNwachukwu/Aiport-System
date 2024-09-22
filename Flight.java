/* Flight Class*/

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
* Date: 25th November, 2023.
* Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest; // Package
// Added import statements.
import java.util.Date;
import java.util.ArrayList;

/**
 * Represents a flight with details such as name, departure, and arrival times.
 * Also, includes information about the departure and arrival airports, as well as the aircraft.
 */

public class Flight{

    // Made them all protected to maintain good practice of encapsulation
    // if I did not I would have had to make departureAirport and arrivalAirport public
    // which violates encapsulation.
    protected String flightName; // Name of flight.
    protected Date departureTime; // Departure time of Flight.
    protected Date arrivalTime; // Arrival time of Flight.
    protected Airport departureAirport; // Airport that a flight departs from.
    protected  Airport arrivalAirport; // Airport that a flight arrives in.
    protected Aircraft aircraftName; // Name of Aircraft

    /**
     * Constructor for the Flight class.
     * @param flightName The name of the flight.
     * @param departureTime The departure time of the flight.
     * @param arrivalTime The arrival time of the flight.
     * @param departureAirport The departure airport for the flight.
     * @param arrivalAirport The arrival airport for the flight.
     * @param aircraftName The aircraft associated with the flight.
     */

    public Flight(String flightName, Date departureTime, Date arrivalTime,
                  Airport departureAirport, Airport arrivalAirport, Aircraft aircraftName) {
        // Initialization of fields.
        this.flightName = flightName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.aircraftName = aircraftName;
    }

    /**
     * Gets the list of pilots associated with the aircraft.
     * @return An ArrayList of Pilots.
     */
    public ArrayList<Pilots> getPilots() {
        // Returns the list of pilots associated with the aircraft.
    if (aircraftName != null) {
        return aircraftName.getPilots();
    } else {
        return new ArrayList<>();
    }
    }

    /**
     * Gets the name of the flight.
     * @return The name of the flight.
     */
    public String getFlightName() {
        // Returns the name of the flight.
       return flightName;
    }

    /**
     * Gets the departure time of the flight.
     * @return The departure time of the flight.
     */
    public Date getDepartureTime() {
        // Returns the departure time of the flight.
        return departureTime;
    }

    /**
     * Gets the arrival time of the flight.
     * @return The arrival time of the flight.
     */
    public Date getArrivalTime() {
        // Returns the arrival time of the flight.
        return arrivalTime;
    }

    /**
     * Gets the aircraft associated with the flight.
     * @return The Aircraft object associated with the flight.
     */
    public Aircraft getAircraft() {
        // Returns the Aircraft object associated with the flight.
        return aircraftName;
    }


    /**
     * Custom toString method for Flight class.
     * @return A formatted string representation of the flight.
     */
    @Override
    public String toString() {
        // Returns a formatted string representation of the flight.
        return "Flight Name: " + getFlightName() +
                "\nAircraft: " + getAircraft().getName() +
                "\nDeparture Time: " + getDepartureTime() +
                "\nArrival Time: " + getArrivalTime() + "\n";
    }

}