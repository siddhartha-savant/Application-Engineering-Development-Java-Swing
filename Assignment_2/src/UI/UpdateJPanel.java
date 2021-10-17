/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Car;
import Model.FleetOfCars;
import java.awt.CardLayout;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siddharthasavant
 */
public class UpdateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateJPanel
     */
    private JPanel rightPane;
    private Car car;
    private DefaultTableModel dtm;
    private FleetOfCars fleet;
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    Instant now = Instant.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
    
    public UpdateJPanel(JPanel rightPane, Car car, DefaultTableModel dtm, FleetOfCars fleet) {
        initComponents();
        this.rightPane = rightPane;
        this.car = car;
        this.dtm = dtm;
        this.fleet = fleet;
        this.yes.setActionCommand("Yes");
        this.valid.setActionCommand("Valid");
        this.no.setActionCommand("No");
        this.expired.setActionCommand("Expired");
        populateDetails();
    }
    
    private void populateDetails(){
        txtManufacturerName.setText(car.getManufacturerName());
        txtCarName.setText(car.getCarName());
        txtModelName.setText(car.getModelName());
        txtYearOfManufacture.setYear(car.getYearOfManufacture());
        txtNumberOfSeats.setText(Integer.toString(car.getNumberOfSeats()));
        txtSerialNumber.setText(car.getSerialNumberOfCar());
        txtCompanyName.setText(car.getCompanyName());
        txtCityName.setText(car.getCityName());
        if(car.isAvailability()){
            yes.setSelected(true);
        }
        else{
             no.setSelected(true);
        }
        if(car.isMaintainanceCertificate()){
            valid.setSelected(true);
        }
        else{
             expired.setSelected(true);
        }
        txtManufacturerName.setEnabled(true);
        txtCarName.setEnabled(true);
        txtModelName.setEnabled(true);
        txtYearOfManufacture.setEnabled(true);
        txtNumberOfSeats.setEnabled(true);
        txtSerialNumber.setEnabled(true);
        txtCompanyName.setEnabled(true);
        txtCityName.setEnabled(true);
        yes.setEnabled(true);
        no.setEnabled(true);
        valid.setEnabled(true);
        expired.setEnabled(true);
    }
    
    private void populateTable(){
        dtm.setRowCount(0); 
        for(Car car: fleet.getTotalDatabase()){
            Object[] row = new Object[10];
            row[0] = car.getManufacturerName();
            row[1]= car.getCarName();
            row[2] = car.getModelName();
            row[3]= car.getYearOfManufacture();
            row[4] = car.getNumberOfSeats();
            row[5] = car.getSerialNumberOfCar();
            row[6] = car.getCompanyName();
            row[7] = car.getCityName();
            row[8] = car.isMaintainanceCertificate()?"Valid":"Expired";
            row[9] = car.isAvailability()?"Yes":"No";
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

        buttonGroupMC = new javax.swing.ButtonGroup();
        buttonGroupA = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblManufacturerName = new javax.swing.JLabel();
        txtManufacturerName = new javax.swing.JTextField();
        lblCarName = new javax.swing.JLabel();
        txtCarName = new javax.swing.JTextField();
        lblModelName = new javax.swing.JLabel();
        txtModelName = new javax.swing.JTextField();
        lblYearOfManufacture = new javax.swing.JLabel();
        lblNumberOfSeats = new javax.swing.JLabel();
        txtNumberOfSeats = new javax.swing.JTextField();
        lblSerialNumber = new javax.swing.JLabel();
        txtSerialNumber = new javax.swing.JTextField();
        lblCompanyName = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        lblMaintainanceCertificate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        valid = new javax.swing.JRadioButton();
        expired = new javax.swing.JRadioButton();
        yes = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        txtCityName = new javax.swing.JTextField();
        lblCityName = new javax.swing.JLabel();
        txtYearOfManufacture = new com.toedter.calendar.JYearChooser();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(200, 219, 245));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 37, 113));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Car Details");

        lblManufacturerName.setForeground(new java.awt.Color(32, 37, 113));
        lblManufacturerName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblManufacturerName.setText("Manufacturer Name:");

        txtManufacturerName.setEnabled(false);
        txtManufacturerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufacturerNameActionPerformed(evt);
            }
        });

        lblCarName.setForeground(new java.awt.Color(32, 37, 113));
        lblCarName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCarName.setText("Car Name:");

        txtCarName.setEnabled(false);
        txtCarName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarNameActionPerformed(evt);
            }
        });

        lblModelName.setForeground(new java.awt.Color(32, 37, 113));
        lblModelName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblModelName.setText("Model Name:");

        txtModelName.setEnabled(false);
        txtModelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNameActionPerformed(evt);
            }
        });

        lblYearOfManufacture.setForeground(new java.awt.Color(32, 37, 113));
        lblYearOfManufacture.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblYearOfManufacture.setText("Year of Manufacture:");

        lblNumberOfSeats.setForeground(new java.awt.Color(32, 37, 113));
        lblNumberOfSeats.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumberOfSeats.setText("Number of Seats:");

        txtNumberOfSeats.setEnabled(false);
        txtNumberOfSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberOfSeatsActionPerformed(evt);
            }
        });

        lblSerialNumber.setForeground(new java.awt.Color(32, 37, 113));
        lblSerialNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSerialNumber.setText("Serial Number:");

        txtSerialNumber.setEnabled(false);
        txtSerialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerialNumberActionPerformed(evt);
            }
        });

        lblCompanyName.setForeground(new java.awt.Color(32, 37, 113));
        lblCompanyName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCompanyName.setText("Company Name:");

        txtCompanyName.setEnabled(false);
        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });

        lblMaintainanceCertificate.setForeground(new java.awt.Color(32, 37, 113));
        lblMaintainanceCertificate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaintainanceCertificate.setText("Maintainance Certificate:");

        jLabel10.setForeground(new java.awt.Color(32, 37, 113));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Availability:");

        buttonGroupMC.add(valid);
        valid.setText("Valid");

        buttonGroupMC.add(expired);
        expired.setText("Expired");

        buttonGroupA.add(yes);
        yes.setText("Yes");

        buttonGroupA.add(no);
        no.setText("No");

        txtCityName.setEnabled(false);
        txtCityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityNameActionPerformed(evt);
            }
        });

        lblCityName.setForeground(new java.awt.Color(32, 37, 113));
        lblCityName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCityName.setText("City Name:");

        txtYearOfManufacture.setEnabled(false);

        btnBack.setBackground(new java.awt.Color(32, 37, 113));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(32, 37, 113));
        btnSave.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(348, 348, 348)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblModelName)
                                            .addComponent(lblYearOfManufacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblManufacturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNumberOfSeats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblSerialNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblMaintainanceCertificate)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtManufacturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYearOfManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valid)
                                    .addComponent(yes))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(no)
                                    .addComponent(expired)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManufacturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManufacturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYearOfManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYearOfManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaintainanceCertificate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid)
                    .addComponent(expired))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yes)
                    .addComponent(no))
                .addGap(27, 27, 27)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtManufacturerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufacturerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufacturerNameActionPerformed

    private void txtCarNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarNameActionPerformed

    private void txtModelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNameActionPerformed

    private void txtNumberOfSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfSeatsActionPerformed

    private void txtSerialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerialNumberActionPerformed

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed

    private void txtCityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        rightPane.remove(this);
        CardLayout layout = (CardLayout) rightPane.getLayout();
        layout.previous(rightPane);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String manufactureName = txtManufacturerName.getText();
        String carName = txtCarName.getText();
        String modelName = txtModelName.getText();
        
        int yearOfManufacture;
        try{
            yearOfManufacture = txtYearOfManufacture.getYear();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Enter Correct Year");
            return;
        }
        
        int numberOfSeats;
        try{
            numberOfSeats = Integer.parseInt(txtNumberOfSeats.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Enter Correct Number of Seats");
            return;
        }
        
        String serialNumberOfCar = txtSerialNumber.getText();
        String companyName = txtCompanyName.getText();
        String cityName = txtCityName.getText();
        boolean maintainanceCertificate;
        boolean availability;
        
        try{
            if(buttonGroupMC.getSelection().getActionCommand().equals("Valid")){
                maintainanceCertificate = true;
            }else{
                maintainanceCertificate = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Please select an option");
            return;
        }
        
        try{
            if(buttonGroupA.getSelection().getActionCommand().equals("Yes")){
                availability = true;
            }else{
                availability = false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Please select an option");
            return;
        }
        
        if(txtManufacturerName.getText().isEmpty() || txtModelName.getText().isEmpty() || txtCarName.getText().isEmpty()
                || txtNumberOfSeats.getText().isEmpty() || txtSerialNumber.getText().isEmpty() || txtCompanyName.getText().isEmpty() || txtCityName.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter Correct Data and try again");
            return;
        }
        
        if(!fleet.getSet().add(serialNumberOfCar)){
            JOptionPane.showMessageDialog(null, "Error: Enter unique Serial Number");
            return;
        }
        
        car.setManufacturerName(manufactureName);
        car.setCarName(carName);
        car.setModelName(modelName);
        car.setYearOfManufacture(yearOfManufacture);
        car.setNumberOfSeats(numberOfSeats);
        car.setSerialNumberOfCar(serialNumberOfCar);
        car.setCompanyName(companyName);
        car.setCityName(cityName);
        car.setMaintainanceCertificate(maintainanceCertificate);
        car.setAvailability(availability);
        car.setDate(formatter.format(now));
        MainJFrame.numberOne = true;
        
        populateTable();
        
        JOptionPane.showMessageDialog(null, "Car Details Sucessfully Updated");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroupA;
    private javax.swing.ButtonGroup buttonGroupMC;
    private javax.swing.JRadioButton expired;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCarName;
    private javax.swing.JLabel lblCityName;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblMaintainanceCertificate;
    private javax.swing.JLabel lblManufacturerName;
    private javax.swing.JLabel lblModelName;
    private javax.swing.JLabel lblNumberOfSeats;
    private javax.swing.JLabel lblSerialNumber;
    private javax.swing.JLabel lblYearOfManufacture;
    private javax.swing.JRadioButton no;
    private javax.swing.JTextField txtCarName;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtManufacturerName;
    private javax.swing.JTextField txtModelName;
    private javax.swing.JTextField txtNumberOfSeats;
    private javax.swing.JTextField txtSerialNumber;
    private com.toedter.calendar.JYearChooser txtYearOfManufacture;
    private javax.swing.JRadioButton valid;
    private javax.swing.JRadioButton yes;
    // End of variables declaration//GEN-END:variables
}