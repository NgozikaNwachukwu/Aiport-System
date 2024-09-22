/* Airport Class */

//------------------------------------------------------
//
/* Author: Ngozika Nwachukwu
 * Date: 25th November, 2023.
 * Assignment no.: SOFE fall 2023 semester assignment*/
//
//-------------------------------------------------------

package airporttest; // Package

/**
 * Represents an airport with details such as city, country, and ID.
 * Provides methods to get information about the airport.
 */


public class Airport {
    private String city;    //airport city
    private String country; //airport country
    private String id;      //airport id

    /**
     * Constructor for the Airport class.
     * @param city The city where the airport is located.
     * @param country The country where the airport is located.
     * @param id The unique ID of the airport.
     */
    public Airport(String city,String country, String id){
        // Initialization of fields.
        this.city = city;
        this.country = country;
        this.id = id;
    }

    /**
     * Gets the city where the airport is located.
     * @return The city of the airport.
     */
    public String getAirportCity(){
        // Returns the city where the airport is located.
        return city;
    }

    /**
     * Gets the country where the airport is located.
     * @return The country of the airport.
     */
    public String getAirportCountry(){
        // Returns the country where the airport is located.
        return country;
    }

    /**
     * Gets the unique identifier of the airport.
     * @return The id of the airport.
     */
    public String getAirportId() {
// Returns the unique identifier of the airport.
        return id;
    }

}