import java.awt.*; 
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.EtchedBorder;


/**
 * This class function as our second panel. 
 * It combines both MapSubPanel and StatisticsBox into one panel.
 *
 * @Hafiz
 */
public class Panel2 extends JPanel
{
    
    
    private Statistics stats;
    
    MapSubPanel map;
    
    GridBagConstraints bottomGBC = new GridBagConstraints();
    
    /**
     * Constructor for objects of class TestPanel2
     */
    public Panel2(int min, int max)
    {
        setLayout(new BorderLayout());        
        
        
        stats = new Statistics(min, max);
        map = new MapSubPanel(0, 20, stats);        
                
                                   
        //make map scrollable and add it to center
        JScrollPane scrollPane = new JScrollPane(map);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);               
        add(scrollPane, BorderLayout.CENTER);           
        
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,2));
        
        
        //create 4 statsbox        
        StatisticsBox stat1 = new StatisticsBox(1, stats);
        StatisticsBox stat2 = new StatisticsBox(2, stats);
        StatisticsBox stat3 = new StatisticsBox(3, stats);
        StatisticsBox stat4 = new StatisticsBox(4, stats);
        
        JPanel statsTopLeft = new JPanel();        
        JPanel statsTopRight = new JPanel();        
        JPanel statsBottomRight = new JPanel();        
        JPanel statsBottomLeft = new JPanel();
        
        statsTopLeft.add(stat1);
        statsTopRight.add(stat2);
        statsBottomRight.add(stat3);
        statsBottomLeft.add(stat4);
        
        bottom.add(statsTopLeft);
        bottom.add(statsTopRight);
        bottom.add(statsBottomLeft);
        bottom.add(statsBottomRight);       
        
        add(bottom, BorderLayout.SOUTH);
                
//        //create bottom panel (1st and 2nd Nest)
//        JPanel bottom = new JPanel();
//        bottom.setLayout(new BorderLayout());
//        JPanel statsTopBox = new JPanel();
//        statsTopBox.setLayout(new BorderLayout());
//        JPanel statsBottomBox = new JPanel();
//        statsBottomBox.setLayout(new BorderLayout());
//        
//        
//      
//        //create 4 statsbox (3rd nest)
//        JPanel statsTopLeft = new JPanel();
//        statsTopLeft.setLayout(new BorderLayout());
//        JPanel statsTopRight = new JPanel();
//        statsTopRight.setLayout(new BorderLayout());
//        JPanel statsBottomRight = new JPanel();
//        statsBottomRight.setLayout(new BorderLayout());
//        JPanel statsBottomLeft = new JPanel();
//        statsBottomLeft.setLayout(new BorderLayout());
//        
//        JPanel statsbox1 = new JPanel();
//        statsbox1.setLayout(new BorderLayout());
//        JPanel statsbox2 = new JPanel();
//        statsbox2.setLayout(new BorderLayout());
//        JPanel statsbox3 = new JPanel();
//        statsbox3.setLayout(new BorderLayout());
//        JPanel statsbox4 = new JPanel();
//        statsbox4.setLayout(new BorderLayout());
//                
//        StatisticsBox stat1 = new StatisticsBox(1, stats);
//        StatisticsBox stat2 = new StatisticsBox(2, stats);
//        StatisticsBox stat3 = new StatisticsBox(3, stats);
//        StatisticsBox stat4 = new StatisticsBox(4, stats);
//        
//        
//        statsbox1.setPreferredSize(new Dimension(920,200));
//        statsbox1.add(stat1);
//        
//        statsbox2.setPreferredSize(new Dimension(920,200));
//        statsbox2.add(stat2);
//        
//        statsbox3.setPreferredSize(new Dimension(920,200));
//        statsbox3.add(stat3);
//        
//        statsbox4.setPreferredSize(new Dimension(920,200));
//        statsbox4.add(stat4);
//        
//        bottom.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
//        statsbox1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
//        statsbox2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
//        statsbox3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
//        statsbox4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
//        
//        add(bottom, BorderLayout.SOUTH);
//        bottom.add(statsTopBox, BorderLayout.NORTH);
//        statsTopBox.add(statsTopLeft, BorderLayout.WEST);
//        statsTopBox.add(statsTopRight, BorderLayout.EAST);
//        statsTopRight.add(statsbox2);
//        statsTopLeft.add(statsbox1);
//        
//        bottom.add(statsBottomBox, BorderLayout.SOUTH);
//        statsBottomBox.add(statsBottomLeft, BorderLayout.WEST);
//        statsBottomBox.add(statsBottomRight, BorderLayout.EAST);
//        statsBottomRight.add(statsbox4);
//        statsBottomLeft.add(statsbox3);        
        
        
    }

}
