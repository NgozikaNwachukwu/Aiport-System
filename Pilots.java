/* Pilots class */

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
 * Date: 25th November, 2023.
 * Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest; // Package
import java.util.Objects; // added import statement

/**
 * Represents a pilot with details such as name, ID, and position.
 * Provides methods to check if the pilot is assigned to a flight and overrides equals and hashCode methods.
 */
public class Pilots{

    private String pilotName; // Name of Pilot
    private int pilotID; // ID of Pilot
    private String  pilotPosition; // Position of Pilot(Pilot, CoPilot, Navigator, Flight Attendant,etc.)

    /**
     * Constructor for the Pilots class.
     * @param pilotName The name of the pilot.
     * @param pilotID The ID of the pilot.
     * @param pilotPosition The position of the pilot (e.g., Captain, CoPilot).
     */

    public Pilots(String pilotName, int pilotID,String  pilotPosition){
        // Initialization of fields.
        this.pilotName= pilotName;
        this.pilotID = pilotID;
        this.pilotPosition=pilotPosition;
    }

    /**
     * Gets the name of the pilot.
     * @return The name of the pilot.
     */
    public String getPilotName() {
        // Returns the name of the pilot.
        return pilotName;
    }

    /**
     * Gets the ID of the pilot.
     * @return The ID of the pilot.
     */
    public int getPilotID() {
        // Returns the ID of the pilot.
        return pilotID;
    }

    /**
     * Gets the position of the pilot.
     * @return The position of the pilot (e.g., Captain, CoPilot).
     */
    public String getPilotPosition() {
        // Returns the position of the pilot.
        return pilotPosition;
    }


    /**
     * Checks if the pilot is assigned to any flight on the given aircraft.
     * @param aircraft The aircraft to check for pilot assignment.
     * @return True if the pilot is assigned to a flight, false otherwise.
     */
    public boolean isPilotForFlight(Aircraft aircraft) {
        // Iterates through the list of flights associated with the aircraft.
        // Checks if the given pilot is in the list of pilots associated with the flight.
        for (Flight flight : aircraft.getFlights()) {
            if (flight.getPilots().contains(this)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Overrides equals method to compare Pilots objects.
     * @param o The object to compare.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Overrides the equals method to compare Pilots objects.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilots pilot = (Pilots) o;
        return pilotID == pilot.pilotID &&
                Objects.equals(pilotName, pilot.pilotName) &&
                Objects.equals(pilotPosition, pilot.pilotPosition);
    }

    /**
     * Overrides hashCode method for consistent hashing.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        // Overrides the hashCode method for consistent hashing.
        return Objects.hash(pilotName, pilotID, pilotPosition);
    }

}