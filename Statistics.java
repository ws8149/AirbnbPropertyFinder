
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class functions as a way to obtain and return statistics from the listing provided
 * @author weisheng3725
 */
public class Statistics {
    
    AirbnbDataLoader loader = new AirbnbDataLoader();
    ArrayList<AirbnbListing> listing = new ArrayList<AirbnbListing>();
    Map<String, Long> neighbourhoodToNumOfProperties;
    
    
    public Statistics(int min, int max) {
        this.listing = loader.loadByPrice(min,max);
        
        this.neighbourhoodToNumOfProperties = listing.stream()
        .collect(Collectors.groupingBy(AirbnbListing::getNeighbourhood, Collectors.counting()));
        
                                    
        
    }
    
    /**
     * Iterates through the listing array, counting the number of available properties    
     * @return Total number of available properties
     */
    public int getTotalAvailableProperties() {
        int count = 0;
        for (int i = 0; i < listing.size(); i++) {
            //check if property is available
            if (listing.get(i).getAvailability365() > 0) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Iterates through the listing array, counting the number of properties having the room type "Entire home/apt"    
     * @return Total number of properties having the room type "Entire home/apt"
     */
    public int getTotalHomeAndApartments() {
        int count = 0;
        for (int i = 0; i < listing.size(); i++) {
            //check if property is of home and apartment type
            if (listing.get(i).getRoom_type().equals("Entire home/apt")) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Obtains the priciest neighbourhood, this is judged based on the average price
     * inclusive of the minimum nights of each neighbourhood
     * @return The priciest neighbourhood's name
     */
    public String getPriciestNeighbourhood() {
         //Create a map linking the a neighbourhood to the average price of property in that neighbourhood        
        //Populate the map by using a stream and its collect function to process the listing
        Map<String, Double> neighbourhoodToAvgPrice = listing.stream() 
                
        //Average the price inclusive of the minimum nights and group by neighbourhood        
        .collect(Collectors.groupingBy(AirbnbListing::getNeighbourhood,
                Collectors.averagingInt(AirbnbListing -> AirbnbListing.getPrice() * AirbnbListing.getMinimumNights())));            
        
                        
        //Stores the entry with the max value
        Map.Entry<String, Double> maxEntry = null;

        //Iterate through the map to obtain the entry with the max average price 
        for (Map.Entry<String, Double> entry : neighbourhoodToAvgPrice.entrySet())        {            
            
            if (maxEntry == null //guard against null pointer exception
                    || entry.getValue().compareTo(maxEntry.getValue()) > 0) {                
                maxEntry = entry;
            }
        }
    
        return maxEntry.getKey();  
                                                                   
    }
    
    /**
     * Iterates through the listing array, calculating the average number of reviews per property
     * @return Average number of reviews per property
     */
    public int getAverageReviewsPerProperty() {    
        int sum = 0;
        for (int i = 0; i < listing.size(); i++) {            
            sum += listing.get(i).getNumberOfReviews();            
        }
        return sum / listing.size();         
    }
           
    /**
     * Returns the average price of property in London, without including the minimum stay 
     * @return Average price of property
     */
    public int getAveragePropertyPrice() {
        int sum = 0;
        for (int i = 0; i < listing.size(); i++) {            
            sum += listing.get(i).getPrice();
        }
        
        return sum / listing.size();        
    }    
    
    /**
     * 
     * @return The neighbourhood name with the most available properties throughout the year
     */
    public String getNeighbourhoodWithMostProperties() {
        
        //Create a map linking the a neighbourhood to the number of properties in that neighbourhood        
        //Populate the map by using a stream and use its collect function to process the listing
        Map<String, Long> neighbourhoodToNumOfProperties = listing.stream()
                
        //Group by neighbourhood name and count the number of properties for each neighbourhood        
        .collect(Collectors.groupingBy(AirbnbListing::getNeighbourhood, Collectors.counting()));          
                                                         
        //Stores the entry with the max value
        Map.Entry<String, Long> maxEntry = null;

        //Iterate through the map to obtain the entry with the max average price 
        for (Map.Entry<String, Long> entry : neighbourhoodToNumOfProperties.entrySet())        {            
            
            if (maxEntry == null //guard against null pointer exception
                    || entry.getValue().compareTo(maxEntry.getValue()) > 0) {                
                maxEntry = entry;
            }
        }
    
        return maxEntry.getKey();  
    }
    
    /**
     * 
     * @return Returns the name of the property with the most reviews
     * along with the neighbourhood it is in
     */
    public String getPropertyWithMostReviews() {
        AirbnbListing result = listing.get(0);
        for (int i = 0; i < listing.size(); i++) {            
            if (listing.get(i).getNumberOfReviews() > result.getNumberOfReviews()) {
                result = listing.get(i);
            }
        }
        return result.getName() + " in " + result.getNeighbourhood();
                
    }
    
    /**
     * 
     * @return Returns the name of the property with the highest number of minimum nights
     * along with the neighbourhood it is in
     */
    public String getPropertyWithMostMinimumNights() {
        AirbnbListing result = listing.get(0);
        for (int i = 0; i < listing.size(); i++) {            
            if (listing.get(i).getMinimumNights()> result.getMinimumNights()) {
                result = listing.get(i);
            }
        }
        return result.getName() + " in " + result.getNeighbourhood();
    }
    
    
    /**
     * 
     * @return A map with neighbourhood name as the key, number of properties in that neighbourhood
     * as the value
     */
    public Map<String,Long> getNeighbourhoodToNumOfProperties() {
        return neighbourhoodToNumOfProperties;
    }
    
    /**
     * 
     * @param name Neighbourhood name
     * @return An arraylist of airbnblisting specific to a neighbourhood
     */
    public ArrayList<AirbnbListing> getListingByNeighbourhood(String name) {
        ArrayList<AirbnbListing> listingByNeighbourhood = new ArrayList<AirbnbListing>();
        
        for (int i = 0; i < listing.size(); i++) {
            if (listing.get(i).getNeighbourhood().equals(name)) {
                listingByNeighbourhood.add(listing.get(i));
            }
        }
        
        return listingByNeighbourhood;
    }
}
