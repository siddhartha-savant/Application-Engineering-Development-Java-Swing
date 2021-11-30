/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Order.Order;
import Business.Restaurant.Dishes;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.CustomerRole.CustomerAreaJPanel;

/**
 *
 * @author monal
 */
public class OrderDetails extends javax.swing.JPanel {

    /**
     * Creates new form OrderDetails
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    Order order;
    EcoSystem system;
    public OrderDetails(JPanel userProcessContainer, UserAccount account, Order order, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.order = order;
        this.system = system;
        addressTxt1.setEnabled(false);
        populateTable();
    }

    private void populateTable() {
        jLabel1.setText("Order ID:"+order.getOrderID());
         DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);
        addressTxt1.setText(order.getFeedback());
         
         Object[] row = new Object[3];
                for(Dishes dish:order.getOrder()){
                     row[0] = dish;
                     row[1] = dish.getDescriptionOfDish();
                     row[2] = dish.getCostOfDish();
                     model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        statusBtn = new javax.swing.JButton();
        enterpriseLabel1 = new javax.swing.JLabel();
        addressTxt1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dish Name", "Description", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 600, 150));

        BackBtn.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        BackBtn.setText("<< Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order ID:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        statusBtn.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        statusBtn.setText("Change Status to Ready to Deliver");
        statusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBtnActionPerformed(evt);
            }
        });
        add(statusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 400, 50));

        enterpriseLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        enterpriseLabel1.setForeground(new java.awt.Color(255, 255, 255));
        enterpriseLabel1.setText("Customer Feedback:");
        add(enterpriseLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 190, 90));

        addressTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxt1ActionPerformed(evt);
            }
        });
        add(addressTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 260, 110));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Business/food-gbcc99b878_1280.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_BackBtnActionPerformed

    private void statusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBtnActionPerformed
        // TODO add your handling code here:
        order.setStatus("Ready to Deliver");
        for(Customer cust:system.getCustomerDirectory().getListOfCustomers()){
            if(order.getNameOfCustomer().equals(cust.getUserNameOfCustomer())){
                for(Order order : cust.getOrderList()){
                    order.setStatus("Ready to Deliver");
                }
            }
        }
        
    }//GEN-LAST:event_statusBtnActionPerformed

    private void addressTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTxt1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTextField addressTxt1;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton statusBtn;
    // End of variables declaration//GEN-END:variables
}
