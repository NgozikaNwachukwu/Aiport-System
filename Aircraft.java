/* Aircraft class*/

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
 * Date: 25th November, 2023.
 * Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest; // Package
import java.util.ArrayList;

/**
 * Represents an aircraft with details such as name, state, flight state, and a list of pilots.
 * Provides methods to get information about the aircraft and manage pilots.
 */

public class Aircraft {
    private String name;  // Aircraft name
    private String state; //Aircraft state : working/under repair
    private String flightState; //landed/Airborne
    public ArrayList<Pilots> pilots; //list of all pilots for the aircraft
    private ArrayList<Flight> flights; // List of Flights

    /**
     * Constructor for the Aircraft class.
     * @param name The name of the aircraft.
     * @param state The state of the aircraft (e.g., Working, Under Repair).
     * @param flightState The flight state of the aircraft (e.g., Landed, Airborne).
     * @param pilots List of pilots associated with the aircraft.
     * @param flights List of flights associated with the aircraft.
     */
    public Aircraft(String name, String state, String flightState, ArrayList<Pilots> pilots, ArrayList<Flight> flights) {
        // Initialization of fields.
        this.name = name;
        this.state = state;
        this.flightState = flightState;
        this.pilots = pilots;
        this.flights = flights;
    }

    /**
     * Gets the name of the aircraft.
     * @return The name of the aircraft.
     */

    public String getName() {
        // Returns the name of the aircraft.
        return name;
    }

    /**
     * Gets the state of the aircraft.
     * @return The state of the aircraft (working/under repair).
     */
    public String getState() {
        // Returns the state of the aircraft.
        return state;
    }

    /**
     * Gets the flight state of the aircraft.
     * @return The flight state of the aircraft (Landed/Airborne).
     */
    public String getFlightState() {
        // Returns the flight state of the aircraft.
        return flightState;
    }

    /**
     * Gets the list of flights associated with the aircraft.
     * @return An ArrayList of Flight objects.
     */
   public ArrayList<Flight> getFlights() {
       // Returns the list of flights associated with the aircraft.
       return this.flights;
   }

    /**
     * Gets the list of pilots associated with the aircraft.
     * @return An ArrayList of Pilots.
     */
    public ArrayList<Pilots> getPilots() {
        // Returns the list of pilots associated with the aircraft.
        return this.pilots;
    }



    /**
     * Adds a pilot to the list of pilots associated with the aircraft.
     * @param pilot The pilot to be added.
     */
    public void joinPilot(Pilots pilot) {
        // Adds a pilot to the list of pilots associated with the aircraft.
        if (!pilots.contains(pilot)) {
            pilots.add(pilot);
        } else {
            System.out.println("Error. Pilot has already been added.");
        }

    }

    /**
     * Prints the list of pilots associated with the aircraft.
     */
    public void printPilot() {
        // Prints the list of pilots associated with the aircraft.
        for (Pilots pilot : pilots) {
            System.out.println("Name: " + pilot.getPilotName());
            System.out.println("ID: " + pilot.getPilotID());
            System.out.println("Position: " + pilot.getPilotPosition());
            System.out.println();
        }
    }

}