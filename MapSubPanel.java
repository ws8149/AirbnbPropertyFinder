
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *  Display a map with markers that can be clicked to open up a listings window *  
 * 
 */
public class MapSubPanel extends JPanel {

    ArrayList<JButton> buttonList = new ArrayList<>();

    public MapSubPanel(int min, int max, Statistics stats) {
        //Retrieve data to work with
        Statistics statsData = stats;
        Map<String, Long> propertyData = statsData.getNeighbourhoodToNumOfProperties();

        


        //Load up images
        ImageIcon imageMap = new ImageIcon(this.getClass().getResource("londonmap.jpg"));
        JLabel labelMap = new JLabel(imageMap);
        labelMap.setBounds(0, 0, 1202, 900);

        ImageIcon imageMarker = new ImageIcon(this.getClass().getResource("house-icon.png"));
        Image img = imageMarker.getImage();

        

        //Create all the buttons and scale them accordingly
        Iterator it = propertyData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Long numOfProperties = (Long) pair.getValue();

            if (numOfProperties.intValue() > 0) {
                createButton((String) pair.getKey(), numOfProperties.intValue(), img, statsData);
            }
        }

        
        
       
        //Create layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1202, 900));
        layeredPane.add(labelMap, new Integer(1));

        for (int i = 0; i < buttonList.size(); i++) {            
            layeredPane.add(buttonList.get(i), new Integer(2));
        }

        add(layeredPane);
        
    }

    /**
     * Creates button of a size relative to the number of properties in an area
     *
     * @param size The height and width of the buttons
     * @param imageMarker The image to be loaded into the buttons
     * 
     */
    private void createButton(String name, int size, Image img, Statistics statsData) {                                           

        //Scale image and load into button        
        size = (size * 100) / statsData.listing.size();        
        if (size > 7) {
            size = 50;
        } else if (size > 4) {
            size = 30;
        } else {
            size = 20;
        }

        JButton button = new JButton(new ImageIcon(img.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH)));

        
        

        //Make button transparent
        button.setBackground(new Color(0.2f, 0.2f, 0.2f, .2f));
        button.setOpaque(false);
        button.setBorderPainted(false);
        
        
        
        //Link button to the listings window
        button.addActionListener((ActionEvent e) -> {                        
            PropertyListingsWindow newWindow = new PropertyListingsWindow(statsData.getListingByNeighbourhood(name));            ;
        });

        

        //Set button coordinates for each neighbourhood                
        switch (name) {
            case "Enfield":
                button.setBounds(650, 100, size, size);
                break;
            case "Westminster":
                button.setBounds(490, 360, size, size);
                break;
            case "Hillingdon":
                button.setBounds(100, 385, size, size);
                break;
            case "Harrow":
                button.setBounds(250, 230, size, size);
                break;
            case "Barnet":
                button.setBounds(390, 150, size, size);
                break;
            case "Haringey":
                button.setBounds(590, 200, size, size);
                break;
            case "Waltham Forest":
                button.setBounds(720, 180, size, size);
                break;
            case "Redbridge":
                button.setBounds(800, 210, size, size);
                break;
            case "Havering":
                button.setBounds(950, 180, size, size);
                break;
            case "Barking and Dagenham":
                button.setBounds(900, 290, size, size);
                break;
            case "Newham":
                button.setBounds(780, 350, size, size);
                break;
            case "Hackney":
                button.setBounds(620, 265, size, size);
                break;
            case "Islington":
                button.setBounds(555, 275, size, size);
                break;
            case "Camden":
                button.setBounds(500, 270, size, size);
                break;
            case "Brent":
                button.setBounds(330, 290, size, size);
                break;

            case "Ealing":
                button.setBounds(270, 385, size, size);
                break;
            case "Hounslow":
                button.setBounds(250, 465, size, size);
                break;
            case "Richmond upon Thames":
                button.setBounds(270, 580, size, size);
                break;
            case "Kingston upon Thames":
                button.setBounds(350, 700, size, size);
                break;
            case "Wandsworth":
                button.setBounds(430, 500, size, size);
                break;

            case "Merton":
                button.setBounds(430, 585, size, size);
                break;
            case "Sutton":
                button.setBounds(470, 700, size, size);
                break;
            case "Croydon":
                button.setBounds(610, 640, size, size);
                break;

            case "Lambeth":
                button.setBounds(570, 530, size, size);
                break;
            case "Southwark":
                button.setBounds(625, 470, size, size);
                break;
            case "Lewisham":
                button.setBounds(720, 500, size, size);
                break;
            case "Greenwich":
                button.setBounds(800, 500, size, size);
                break;
            case "Bromley":
                button.setBounds(800, 650, size, size);
                break;
            case "Bexley":
                button.setBounds(950, 500, size, size);
                break;

            case "Tower Hamlets":
                button.setBounds(695, 385, size, size);
                break;
            case "Hammersmith and Fulham":
                button.setBounds(410, 385, size, size);
                break;
            case "Kensington and Chelsea":
                button.setBounds(490, 430, size, size);
                break;
            case "City of London":
                button.setBounds(610, 385, size, size);
                break;

        }

        buttonList.add(button);
    }
}
