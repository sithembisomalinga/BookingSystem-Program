package GUI;

import java.awt.Color;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nightsaway_final.DatabaseManager;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class MakeBooking extends javax.swing.JFrame {

    /**
     * Creates new form MakeBooking
     */
    public MakeBooking() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfFirstName = new javax.swing.JTextField();
        txfLastName = new javax.swing.JTextField();
        combRoomNo = new javax.swing.JComboBox<>();
        txfID = new javax.swing.JTextField();
        txfCellNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sub-logo.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txfFirstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfFirstName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(txfFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 150, 120, 30));

        txfLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txfLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 120, 30));

        combRoomNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combRoomNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(combRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 120, 30));

        txfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 120, 30));

        txfCellNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txfCellNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Last name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 70, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID number:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cell number:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Date Arriving:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Room number:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Date Leaving:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 100, 30));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 300, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfFirstNameActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DatabaseManager con = new DatabaseManager();
        
        String inFirstName = null, inLastName = null, inGuestID = null, inCellNo = null;
        String inDayIn = null, inDayOut = null;
        int inRoomNo = 0;
        final double inAmountOwed = 1500.00;
        
        inFirstName = txfFirstName.getText();
        inLastName = txfLastName.getText();
        inGuestID = txfID.getText();
        inCellNo = txfCellNo.getText();
        inRoomNo = combRoomNo.getSelectedIndex() + 1;
        DateFormat ff = new SimpleDateFormat("yyyy/MM/dd");
        //inDayIn = ff.format(jDateArriving.getDate());
        //inDayOut = ff.format(jDateLeaving.getDate());
        
        int currMonth = Integer.parseInt((inDayIn).substring(5, 7));
        
        /*boolean result = true;
        if (inFirstName.equals("") || checkString(inFirstName) == false) 
        {
            JOptionPane.showMessageDialog(null, "Please enter a name in the 'First Name' field i.e. letters only");
            result = false;
        }
        if (inLastName.equals("") || checkString(inLastName) == false)
        {
            JOptionPane.showMessageDialog(null, "Please enter a surname in the 'Last Name' field i.e. letters only");
            result = false;
        }
        if (inGuestID.equals("") || inGuestID.length() != 13)
        {
            JOptionPane.showMessageDialog(null, "Please enter an ID of 13 numbers in the 'ID' field");
            result = false;
        }
        if (inCellNo.equals("") || inCellNo.length() != 10)
        {
            JOptionPane.showMessageDialog(null, "Please enter a cell number of 10 numbers in the 'Cell number' field");
            result = false;
        }
        if (result == true)*/
        {
            try 
            {
                con.addGuest(inGuestID, inFirstName, inLastName, inCellNo);
                con.addBooking(inGuestID, inRoomNo, inDayIn, inDayOut, inAmountOwed, currMonth);
            } 
            catch (SQLException ex)
            {
                Logger.getLogger(MakeBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (NullPointerException ex)
            {
                System.out.println("error");
            }
                    
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeBooking().setVisible(true);
            }
        });
    }
    /*
        A helper method responsible to ensure the string does not contain numbers.
    */
    private static Boolean checkString(String inName)
    {
        String tempArr[] = new String [100];
        int size = 0;
        
        for (int i = 0; i < inName.length(); i++)
        {
            tempArr[i] = inName.charAt(i) + "";
            size++;
        }
        
        int count = 0;
        boolean found = false;
        while (count < size || found == false)
        {       
                switch (tempArr[count]) 
                {
                    case "0":
                        found = false;
                    case "1":
                        found = false;
                    case "2":
                        found = false;
                    case "3":
                        found = false;
                    case "4":
                        found = false;
                    case "5":
                        return false;
                    case "6":
                        found = false;
                    case "7":
                        found = false;
                    case "8":
                        found = false;
                    case "9":
                        found = false;
                    default:
                        found = true;
                }
                count++;
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox<String> combRoomNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfCellNo;
    private javax.swing.JTextField txfFirstName;
    private javax.swing.JTextField txfID;
    private javax.swing.JTextField txfLastName;
    // End of variables declaration//GEN-END:variables
}
