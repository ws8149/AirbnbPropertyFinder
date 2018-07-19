

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StatisticsTest.
 *
 */
public class StatisticsTest
{
   Statistics statisti1 = new Statistics(0, 7000);
    
    /**
     * Default constructor for test class StatisticsTest
     */
    public StatisticsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    

    
    /**
     * Test implemented statistics
     */
    @Test
    public void getTotalAvailableProperties()
    {
        
        assertEquals(41941, statisti1.getTotalAvailableProperties());
    }

    @Test
    public void testGetTotalHomeAndApartments()
    {

        assertEquals(27175, statisti1.getTotalHomeAndApartments());        
    }
    
    @Test
    public void testGetPriciestNeighbourhood()
    {

        assertEquals("Richmond upon Thames", statisti1.getPriciestNeighbourhood());        
    }
    
    @Test
    public void testGetAveragePropertyPrice()
    {
        assertEquals(96, statisti1.getAveragePropertyPrice());        
    }
    
    @Test
    public void testGetAverageReviewsPerProperty()
    {
        assertEquals(12, statisti1.getAverageReviewsPerProperty());        
    }
    
    @Test
    public void testGetNeighbourhoodWithMostProperties()
    {
        assertEquals("Tower Hamlets", statisti1.getNeighbourhoodWithMostProperties());        
    }
    
    @Test
    public void testGetPropertyWithMostMinimumNights()
    {
        assertEquals("Large double room in East Sheen in Richmond upon Thames", statisti1.getPropertyWithMostMinimumNights());        
    }
    
    @Test
    public void testGetPropertyWithMostReviews()
    {
        assertEquals("SOHO W1/2 THEATRELAND DESIGNER FLAT in Westminster", statisti1.getPropertyWithMostReviews());        
    }
    
    /**
    * Tests if the neighbourhoodToNumOfProperties map has all the neighbourhoods in London
    */
    @Test    
    public void testGetNeighbourhoodToNumOfProperties() {
        assertEquals("[Enfield, Westminster, Hillingdon, Wandsworth, Havering, Tower Hamlets, Lewisham, Hounslow, Southwark, Redbridge, Camden, Bromley, Kensington and Chelsea, Lambeth, Islington, Richmond upon Thames, Barnet, Kingston upon Thames, Sutton, Harrow, Haringey, Bexley, Brent, Hackney, Greenwich, Hammersmith and Fulham, Merton, Waltham Forest, Newham, Croydon, Ealing, City of London, Barking and Dagenham]",
        statisti1.getNeighbourhoodToNumOfProperties().keySet().toString());        
    }
    
    /**
     * Tests if the method returns the listings with the correct neighbourhood name
     */
    @Test
    public void testGetListingByNeighbourhood() {
        ArrayList<AirbnbListing> testListings = statisti1.getListingByNeighbourhood("Havering");
        
        for (int i = 0; i < testListings.size(); i++) {
            assertEquals("Havering", testListings.get(i).getNeighbourhood());
        }
                
    }            
    
    
    
    
}



