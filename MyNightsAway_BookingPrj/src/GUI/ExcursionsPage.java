package GUI;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nightsaway_final.DatabaseManager;
import nightsaway_final.Excursions;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class ExcursionsPage extends javax.swing.JFrame {

    /**
     * Creates new form ExcursionsPage
     */
    public ExcursionsPage() {
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

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combExcursion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaOutput = new javax.swing.JTextArea();
        txfGuestID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDone = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        combRoomNo = new javax.swing.JComboBox<>();
        combBoxInRoomNo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(310, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(310, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(310, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(310, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sub-logo.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 120));

        combExcursion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combExcursion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select...", "Boat Cruise", "Game Drive", "Safari Walks" }));
        combExcursion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                combExcursionActionPerformed(evt);
            }
        });
        jPanel1.add(combExcursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 140, 30));

        txaOutput.setEditable(false);
        txaOutput.setColumns(20);
        txaOutput.setRows(5);
        jScrollPane1.setViewportView(txaOutput);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 280, 80));

        txfGuestID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfGuestID.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txfGuestIDActionPerformed(evt);
            }
        });
        jPanel1.add(txfGuestID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Number of guests: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("GuestID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Excursion: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));

        btnDone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDoneActionPerformed(evt);
            }
        });
        jPanel1.add(btnDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        combRoomNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combRoomNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(combRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 120, 30));

        combBoxInRoomNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combBoxInRoomNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel1.add(combBoxInRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Room Number:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfGuestIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfGuestIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfGuestIDActionPerformed

    private void combExcursionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combExcursionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combExcursionActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
//        DatabaseManager con = new DatabaseManager();
          int numOfPeople = 0;
        
        String excursion = combExcursion.getSelectedItem() +"";
        String guestID = txfGuestID.getText();
        int roomNo = Integer.parseInt("" + combBoxInRoomNo.getSelectedItem());
        //int numOfPeople = spinNoPeople.getValue();
        Excursions excursionNew = new Excursions(excursion, guestID, roomNo, numOfPeople);
        int cost = 0;
        boolean isValidEntry = false;
        int monthOfEntry = -1;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        
        try(ResultSet temp = DatabaseManager.searchDataBase("GuestID", "RoomNo", guestID, "" + roomNo)){
            monthOfEntry = Integer.parseInt(("" + temp.getObject("DayIn")).substring(5, 7));
            isValidEntry = true;
            temp.close();
        }
        catch(SQLException ex){
            isValidEntry = false;
            System.out.println(ex.getMessage());
        }
        
        switch (excursion)
        {
            case "Boat Cruise":
                cost = Integer.parseInt(JOptionPane.showInputDialog("Enter the going cost of " + excursion + " per person"));
                String display = excursionNew.CalcCost(cost, numOfPeople) +"";
                txaOutput.setText(excursionNew.toString() + display);
                    
                try 
                {
                    System.out.println(monthOfEntry);
                    if(isValidEntry){
                        DatabaseManager.editAmountOwed(guestID, Double.parseDouble(display), roomNo, monthOfEntry);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "<html>Sorry,<br>either no such guest exits<br>or the wrong room number has been entered</html>",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(ExcursionsPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "Game Drive":
                cost = Integer.parseInt(JOptionPane.showInputDialog("Enter the going cost of " + excursion + " per person"));
                display = excursionNew.CalcCost(cost, numOfPeople) +"";
                txaOutput.setText(excursionNew.toString() + display);
                
                try 
                {
                    System.out.println(monthOfEntry);
                    if(isValidEntry){
                        DatabaseManager.editAmountOwed(guestID, Double.parseDouble(display), roomNo, monthOfEntry);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "<html>Sorry,<br>either no such guest exits<br>or the wrong room number has been entered</html>",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(ExcursionsPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "Safari Walks":
                cost = Integer.parseInt(JOptionPane.showInputDialog("Enter the going cost of " + excursion + " per person"));
                display = excursionNew.CalcCost(cost, numOfPeople) +"";
                txaOutput.setText(excursionNew.toString() + display);
                
                try 
                {
                    System.out.println(monthOfEntry);
                    if(isValidEntry){
                        DatabaseManager.editAmountOwed(guestID, Double.parseDouble(display), roomNo, monthOfEntry);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "<html>Sorry,<br>either no such guest exits<br>or the wrong room number has been entered</html>",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(ExcursionsPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            default:
                JOptionPane.showMessageDialog(this, "Please ensure all fields are filled");
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(ExcursionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcursionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcursionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcursionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcursionsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JComboBox<String> combBoxInRoomNo;
    private javax.swing.JComboBox<String> combExcursion;
    private javax.swing.JComboBox<String> combRoomNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaOutput;
    private javax.swing.JTextField txfGuestID;
    // End of variables declaration//GEN-END:variables
}
