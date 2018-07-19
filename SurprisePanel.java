
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.*;
import javax.swing.*;


/**
 * Displays a panel with a button in the center.
 * The button will take the user to the app's facebook page
 * 
 * @author weisheng3725
 */


public class SurprisePanel extends JPanel {
    
    public SurprisePanel() {
        //Use default GridBagLayout to center button
        setLayout(new GridBagLayout());
        
        //Create and load image into button                
        JButton button = new JButton(new ImageIcon(this.getClass().getResource("fbicon.png")));
        button.setBackground(new Color(0.2f, 0.2f, 0.2f, .2f));
        button.setOpaque(false);
        button.setBorderPainted(false);
                
        //Make button open a web page
        button.addActionListener((ActionEvent e) -> {            
            openURL("https://www.goo.gl/1474xj");
        });
        
        add(button);
        
        
        
    }
   
   /**
    * Guards against URISyntaxException and IOException 
    * @param link URL link to web page
    */ 
   private void openURL(String link) {
    try {
        java.awt.Desktop.getDesktop().browse(new URI(link));
    } catch (URISyntaxException | IOException e) {
        System.out.println("Error opening url");        
    }
    
} 
   
}


