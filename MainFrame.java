import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Acts as the main window the user will be interacting with
 * It has two buttons at the bottom that takes the user back and forth panels * 
 * @author Imran
 */
public class MainFrame extends JFrame {

    PriceRangePanel p1 = new PriceRangePanel();
    //keeps track of the current panel
    String currentPanel = PANEL1;
    final static String PANEL1 = "PANEL1";
    final static String PANEL2 = "PANEL2";
    final static String PANEL3 = "PANEL3";

    public MainFrame() {
        setSize(1920, 1440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(true);
        setLayout(new BorderLayout());
        
        //Create buttons at the bottom
        JButton backButton = new JButton("<");
        JButton nextButton = new JButton(">");
        JPanel footer = new JPanel(new BorderLayout());
        footer.add(backButton, BorderLayout.WEST);
        footer.add(nextButton, BorderLayout.EAST);
        add(footer, BorderLayout.SOUTH);

        //Create cards panel
        JPanel cards = new JPanel(new CardLayout());
        cards.add(p1, PANEL1);
        add(cards, BorderLayout.CENTER);
        backButton.setEnabled(false);

        //Make buttons switch panels
        nextButton.addActionListener((ActionEvent e) -> {
            CardLayout layout = (CardLayout) (cards.getLayout());

            switch (currentPanel) {
                case PANEL1:
                    //Check if combo box values are valid
                    if(p1.getFromComboBoxValues() < p1.getToComboBoxValues()){
                        Panel2 p2 = new Panel2(p1.getFromComboBoxValues(), p1.getToComboBoxValues());
                        cards.add(p2, PANEL2);
                        currentPanel = PANEL2;
                        layout.show(cards, PANEL2);
                        backButton.setEnabled(true);                        
                        break;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The price range is invalid, please try again.");
                        break;
                    }                    
                case PANEL2:
                    SurprisePanel p3 = new SurprisePanel();
                    cards.add(p3, PANEL3);
                    currentPanel = PANEL3;
                    layout.show(cards, PANEL3);
                    backButton.setEnabled(true);                    
                    break;
            }
        });

        backButton.addActionListener((e) -> {
            CardLayout layout = (CardLayout) (cards.getLayout());

            switch (currentPanel) {
                case PANEL2:
                    layout.show(cards, PANEL1);
                    currentPanel = PANEL1;
                    backButton.setEnabled(false);
                    nextButton.setEnabled(true);
                    break;
                case PANEL3:
                    layout.show(cards, PANEL2);
                    currentPanel = PANEL2;
                    backButton.setEnabled(true);                    
                    break;
            }
        });

    }

}