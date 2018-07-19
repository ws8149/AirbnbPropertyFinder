import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory; 
import javax.swing.border.EtchedBorder;


/**
 * This class functions as the panel where users can select a price range and proceed to next panel
 * to see the matched listings. This version is with the fixed resizable panel.
 * @author Hafiz
 */
public class PriceRangePanel extends JPanel
{
    private JLabel toLabel;
    private JLabel fromLabel;    
    private JLabel welcome;
    private JLabel instructions1;
    private JLabel instructions2;
    private JLabel instructions3;
    private JLabel instructions4;
    private JLabel instructions5;
    private JLabel instructions6;    
    
    String[] priceStrings = {};
    List<Integer> priceStringsInt = new ArrayList<Integer>();
    GridBagConstraints topGBC = new GridBagConstraints();
    GridBagConstraints centerGBC = new GridBagConstraints();
    GridBagConstraints bottomGBC = new GridBagConstraints();
    
    
    private int toPrice;
    private int fromPrice;

    /**
     * Constructor for objects of class PriceRangePanelV2
     */
    public PriceRangePanel()
    {
        //Frame1 for panel1
        setLayout(new BorderLayout());
        //setTitle("London Property Marketplace");
        setSize(1920, 1400);
        
        //create top panel
        JPanel top = new JPanel();
        JPanel comboBox = new JPanel();
        top.setLayout(new BorderLayout());
        top.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        int maxPrice = 7000;
        JComboBox<Integer> toPriceList  = new JComboBox<>();
        JComboBox<Integer> fromPriceList = new JComboBox<>();
        
        //for loop to create the combobox
        for (int x = 0; x <= maxPrice; x += 10)
        {
            priceStringsInt.add(x);
            toPriceList.addItem(x);
            fromPriceList.addItem(x);
        }
                
        fromLabel = new JLabel("From: ");
        comboBox.add(fromLabel);
        comboBox.add(fromPriceList, topGBC);
        
        toLabel = new JLabel("To: ");
        comboBox.add(toLabel);
        comboBox.add(toPriceList);
        
        top.add(comboBox,BorderLayout.EAST);
        add(top, BorderLayout.NORTH);
        
        //create center panel
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        
        add(center, BorderLayout.CENTER);
        center.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        centerGBC.gridx = 0;
        centerGBC.gridy = 0;
        centerGBC.insets = new Insets (10, 10, 1, 1);
        
        welcome = new JLabel("Welcome to TeamNasiGoreng's property finder!", JLabel.CENTER);
        instructions1 = new JLabel("> To use this application, you need to select a valid price range and click the next button.", JLabel.CENTER);
        instructions2 = new JLabel("> The application will then bring you to a new panel where it will display a map.", JLabel.CENTER);
        instructions3 = new JLabel("> From there users can click on house icons to access further details of available properties.", JLabel.CENTER);
        instructions4 = new JLabel("> Use the back and next arrow keys located at the bottom to navigate around where given.", JLabel.CENTER);
        instructions5 = new JLabel("> Once the table for selected area is displayed, to close it just simply close the window as it is shown on a new window.", JLabel.CENTER);
        instructions6 = new JLabel("(For optimal resolution view in 3440*1440)", JLabel.CENTER);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 1;
        center.add(welcome, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 2;
        center.add(instructions1, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 3;
        center.add(instructions2, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 4;
        center.add(instructions3, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 5;
        center.add(instructions4, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 6;
        center.add(instructions5, centerGBC);
        
        centerGBC.gridx = 0;
        centerGBC.gridy = 7;
        center.add(instructions6, centerGBC);
        
        
        
        //Action listener that parses price range selection
        toPriceList.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                toPrice = Integer.parseInt(toPriceList.getSelectedItem().toString());
                fromPrice = Integer.parseInt(fromPriceList.getSelectedItem().toString());
            }
        });
        
        
    }
    
    public int getFromComboBoxValues(){
        return fromPrice;
    }
    
    public int getToComboBoxValues(){
        return toPrice;
    }

}
