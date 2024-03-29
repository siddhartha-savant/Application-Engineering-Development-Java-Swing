/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Car;
import Model.FleetOfCars;
import java.awt.CardLayout;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siddharthasavant
 */
public class SearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchJPanel
     */
    private JPanel rightPane;
    private FleetOfCars fleet;
    
    public SearchJPanel(JPanel rightPane, FleetOfCars fleet) {
        initComponents();
        this.rightPane = rightPane;
        this.fleet = fleet;
    }
    
    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblFleetOfCars.getModel();
        dtm.setRowCount(0);
        
        for(Car car: fleet.getTemporaryDatabase()){
            Object[] row = new Object[10];
            row[0] = car.getManufacturerName();
            row[1] = car.getCarName();
            row[2] = car.getModelName();
            row[3] = car.getYearOfManufacture();
            row[4] = car.getNumberOfSeats();
            row[5] = car.getSerialNumberOfCar();
            row[6] = car.getCompanyName();
            row[7] = car.getCityName();
            row[8] = car.isMaintainanceCertificate()?"Valid":"Expired";
            row[9] = car.isAvailability()?"Yes":"No";
            dtm.addRow(row);
        }
    }
    
    private void populateTable1(){
        DefaultTableModel dtm = (DefaultTableModel) tblFleetOfCars.getModel();
        dtm.setRowCount(0);
        
        for(String manufacturer: fleet.getStringName()){
            Object[] row = new Object[10];
            row[0] = manufacturer;;
            row[1] = "";
            row[2] = "";
            row[3] = "";
            row[4] = "";
            row[5] = "";
            row[6] = "";
            row[7] = "";
            row[8] = "";
            row[9] = "";
            dtm.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tblFleetOfCars = new javax.swing.JTable();
        boxSearchName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        txtMinSeats = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaxSeats = new javax.swing.JTextField();
        btnForward = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 219, 245));

        jPanel1.setBackground(new java.awt.Color(200, 219, 245));

        tblFleetOfCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Manufacture Name", "Car Name", "Model Name", "Year of Manufacture", "Number of Seats", "Serial Number", "Company Name", "City Name", "Maintainance Certificate", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblFleetOfCars);

        boxSearchName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Available Car", "Number of Cars Available", "Manufacturer Name", "Car Name", "Model Name", "Year of Manufacture", "Number of Seats", "Serial Number", "Company Name", "City Name", "Maintainance Certificate", "Availability" }));
        boxSearchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSearchNameActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(32, 37, 113));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Search Terms:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 37, 113));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Search for Entry");

        btnSearch.setBackground(new java.awt.Color(32, 37, 113));
        btnSearch.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        txtMinSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinSeatsActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(32, 37, 113));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Minimum Seats:");

        jLabel3.setForeground(new java.awt.Color(32, 37, 113));
        jLabel3.setText("Maximum Seats:");

        btnForward.setBackground(new java.awt.Color(32, 37, 113));
        btnForward.setForeground(new java.awt.Color(255, 255, 255));
        btnForward.setText("Forward->");
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boxSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMinSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaxSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearch))))
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnForward)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnForward)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1165, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxSearchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSearchNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSearchNameActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty() && boxSearchName.getSelectedItem().toString().equals("Manufacturer Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
            //JOptionPane.showMessageDialog(null, "Please Enter Car Model Number!!", "Warning", JOptionPane.WARNING_MESSAGE);
            fleet.searchManufacturerList();
            populateTable1();
        }else{
            if(boxSearchName.getSelectedItem().toString().equals("Manufacturer Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchManufacturerName(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Car Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchCarName(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Model Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchModelName(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Year of Manufacture") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchYearOfManufacture(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Number of Seats") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchNumberOfSeats(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Serial Number") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchSerialNumber(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Company Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchCompanyName(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("City Name") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchCityName(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Maintainance Certificate") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchMaintainanceCertificate(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Availability") && txtMinSeats.getText().isEmpty() && txtMaxSeats.getText().isEmpty()){
                fleet.searchAvailability(txtSearch.getText());
                populateTable();
                fleet.clearTable();
            }else if(!txtMinSeats.getText().isEmpty() && !txtMaxSeats.getText().isEmpty()){
                fleet.searchCarSeatsList(Integer.parseInt(txtMinSeats.getText()), Integer.parseInt(txtMaxSeats.getText()));
                populateTable();
                fleet.clearTable();
                txtMinSeats.setText("");
                txtMaxSeats.setText("");
            }else if(boxSearchName.getSelectedItem().toString().equals("First Available Car")){
                fleet.searchFirstAvailableCar();
                populateTable();
                fleet.clearTable();
            }else if(boxSearchName.getSelectedItem().toString().equals("Number of Cars Available")){
                fleet.numberOfAvailableCars();
                populateTable();
                fleet.clearTable();
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
           
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtMinSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinSeatsActionPerformed

    private void btnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForwardActionPerformed
        // TODO add your handling code here:
        AdvancedSearchJPanel advancedSearchJPanel = new AdvancedSearchJPanel(rightPane, fleet);
        rightPane.add("AdvancedSearchJPanel", advancedSearchJPanel);
        CardLayout layout = (CardLayout) rightPane.getLayout();
        layout.next(rightPane);
    }//GEN-LAST:event_btnForwardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxSearchName;
    private javax.swing.JButton btnForward;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tblFleetOfCars;
    private javax.swing.JTextField txtMaxSeats;
    private javax.swing.JTextField txtMinSeats;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}