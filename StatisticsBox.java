import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

/**
 * Displays statistics data retrieved from the Statistics class
 * Each statistic box is linked to an additional statistic
 *
 * @author Imran
 * @version (a version number or a date)
 */
public class StatisticsBox extends JPanel{
    
    private Statistics statsSource;
    
    private JLabel statLabel;
    private JLabel displayLabel;
    private String statName;
    private String displayData;
    private int statIndex;
    
    /**
     * Constructor for objects of class StatsPanel
     */
    public StatisticsBox(int indexGiven, Statistics statsToFollow)
    {
        setLayout(new BorderLayout());
        setSize(920, 200);
        
        statsSource = statsToFollow;        
        statIndex = indexGiven;
        displayData = infoToDisplay(statIndex);
        statName = statToDisplay(statIndex);
        
        //Placing labels and buttons in the box
        statLabel = new JLabel(statName, JLabel.CENTER);
        displayLabel = new JLabel(displayData, JLabel.CENTER);
        
        JButton leftButton = new JButton("<");
        JButton rightButton = new JButton(">");       
        
        add(statLabel, BorderLayout.NORTH);
        add(displayLabel, BorderLayout.CENTER);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        
        //Make buttons swap current box to another box
        ActionListener buttonPressed = new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton)e.getSource();
                    if(source.getText().equals("<"))
                    {
                        update();
                    }
                    
                    if(source.getText().equals(">"))
                    {
                        update();
                    }
                }   
        };
        
        rightButton.addActionListener(buttonPressed);
        leftButton.addActionListener(buttonPressed);

    }
    
    /**
     * Swap the current statistic with another statistic
     */
    private void update()
    {
        displayData = infoToDisplay(statIndex);
        displayLabel.setText(displayData);
        
        statName = statToDisplay(statIndex);
        statLabel.setText(statName);
    }
    
    /** Gets the name for the statistic to be displayed based on the statIndex of the current
     * StatisticsBox
     */
    private String statToDisplay(int currentStat)
    {
        String stat = "No statistics to display";
        
        switch(currentStat){
            case 1:
                stat = "Number of available properties:";
                statIndex = 5;
                break;
            case 2:
                stat = "Average number of reviews per property:";
                statIndex = 6;
                break;
            case 3:
                stat = "Number of entire houses/apartments:";
                statIndex = 7;
                break;
            case 4:
                stat = "The priciest neighbourhood:";
                statIndex = 8;
                break;
            case 5:
                stat = "Average property price (GBP k):";
                statIndex = 1;
                break;
            case 6:
                stat = "Neighbourhood with most properties:";
                statIndex = 2;
                break;
            case 7:
                stat = "Property with most reviews:";
                statIndex = 3;
                break;
            case 8:
                stat = "Property with most minimum nights:";
                statIndex = 4;
                break;
        }

        return stat;
    }
    
    /** Gets the data for the statistic to be displayed based on the statIndex of the current
     * StatisticsBox
     */
    private String infoToDisplay(int currentStat)
    {
        String info = "";
        
        switch(currentStat){
            case 1:
                info = "" + statsSource.getTotalAvailableProperties();
                break;
            case 2:
                info = "" + statsSource.getAverageReviewsPerProperty();
                break;
            case 3:
                info = "" + statsSource.getTotalHomeAndApartments();
                break;
            case 4:
                info = statsSource.getPriciestNeighbourhood();
                break;
            case 5:
                info = "" + statsSource.getAveragePropertyPrice();
                break;
            case 6:
                info = statsSource.getNeighbourhoodWithMostProperties();
                break;
            case 7:
                info = statsSource.getPropertyWithMostReviews();
                break;
            case 8:
                info = statsSource.getPropertyWithMostMinimumNights();
                break;
        }
        
        return info;
    }
}
