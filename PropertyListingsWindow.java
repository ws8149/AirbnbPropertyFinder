
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;
/**
 * Displays data from the csv file in the form of a table
 * Columns can be sorted via the combo box and rows will display more info upon clicking
 * @author weisheng3725
 */

public class PropertyListingsWindow extends JFrame {        
    
    private JTable table;
    private JScrollPane scrollPane;        
    
    
    public PropertyListingsWindow(ArrayList<AirbnbListing> listing) {                        
        //create panel base        
        setLayout(new BorderLayout());          
        setTitle(listing.get(0).getNeighbourhood());                                          
        createTable(listing);                                                                            
        createSortOptionsBox();         
        pack();
        setVisible(true);
    }    
    
    
   
    
    
    /**
     * Create and add drop down menu 
     */
    private void createSortOptionsBox() {
        JPanel topPanel = new JPanel();
        
        String[] sortOptions = {"Number of Reviews", "Price", "Host Name"};
        
        JComboBox sortOptionsBox = new JComboBox(sortOptions);  
        
        
        
        //Make JComboBox sort table
        sortOptionsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Retrieve the selected option in the form of a string
                String selectedOption = (String) sortOptionsBox.getSelectedItem();                                                                                
                
                //Create and set row sorter to table
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());                
                table.setRowSorter(sorter);                
                List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
                                

                //If the option selected matches, carry out the sort in ascending order on the column
                if (selectedOption.equals("Number of Reviews")) {                                        
                    
                    sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));                                        
                        
                } else if (selectedOption.equals("Price")) {
                    
                    sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));                    
                
                } else if (selectedOption.equals("Host Name")) {
                    
                    sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));                    
                    
                }
                sorter.setSortKeys(sortKeys);     
            }
        });
        
        //Place combo box at top left corner
        add(topPanel, BorderLayout.NORTH);        
        topPanel.setLayout(new BorderLayout());        
        topPanel.add(sortOptionsBox, BorderLayout.WEST);                
        
    }
    
    
   /*
    * Create and add table to panel
    */ 
    private void createTable(ArrayList<AirbnbListing> listing) {                                      
        String[] columnNames = {"ID","Host Name", "Price", "Number of Reviews", "Minimum Nights"};
        Object[][] data = {};
        
        
        //Create a table model and assign types to the columns
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            
            Class[] types = { String.class, String.class, Integer.class,
                    Integer.class, Integer.class };            

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }                        
        };
        
        
        //Fill the table with data from the arraylist        
        Object rowData[] = new Object[5];
        
        for (int i = 0; i < listing.size(); i++ ) {
            rowData[0] = listing.get(i).getId();
            rowData[1] = listing.get(i).getHost_name();
            rowData[2] = listing.get(i).getPrice();
            rowData[3] = listing.get(i).getNumberOfReviews();
            rowData[4] = listing.get(i).getMinimumNights();            
            tableModel.addRow(rowData);                                   
        }        
        
            
        table = new JTable(tableModel);                                
                
        //Create a selection model to enable the table to be clickable
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {                                                
                //Guard against array out of bounds exceptions
                if (table.getSelectedRow() != -1) {
                    //Retrieve host id                                            
                    String id = table.getValueAt(table.getSelectedRow(), 0).toString();                
                
                    //Retrieve the entire property's details from the array list                
                    for (int i = 0; i < listing.size(); i++ ) {
                        if (id.equals(listing.get(i).getId())) {
                            JOptionPane.showMessageDialog(null, " Description: " + listing.get(i));
                        } 
                    }                 
                    
                } 
                
                                            
                                                                             
            
            }
            
        });        
               
        table.setSelectionModel(selectionModel);                
        
        scrollPane = new JScrollPane(table);       
        add(scrollPane);
      
    }           
        
    

    
}
