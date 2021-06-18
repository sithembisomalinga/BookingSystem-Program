/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import nightsaway_final.Booking;
import nightsaway_final.DatabaseManager;
import nightsaway_final.Guest;
import nightsaway_final.Help;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class HomepageNew extends javax.swing.JFrame {
    private Guest guestArr[] = new Guest[100];
    private int count = 0;
    private JTextField[][] days = new JTextField[5][31];
    private JTextField[] dayLabels = new JTextField[31];
    private int currMonth = 0;

    
    /**
     * Creates new form Homepage
     */
    public HomepageNew() {
        initComponents();
        
        DatabaseManager dm = new DatabaseManager();
        jPanel3.setVisible(true);
        previousMonth.setVisible(false);
        
        try {
            DatabaseManager.fetchBookingData();
        } catch (SQLException ex) {
            System.out.println("Fetched the data");
            Logger.getLogger(HomepageNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int xGap = 2, yGap = 2, xSize = 38, ySize = 38;
        
        for (int i = -1; i < 5; i++) {
            for (int j = 0; j < 31; j++) {
                if(i == -1){
                    dayLabels[j] = new JTextField("" + (j + 1));
                    daysBackPanel.add(dayLabels[j]);
                    dayLabels[j].setBounds(1 + (xGap * j) + (xSize * j), yGap, xSize, ySize);
                    dayLabels[j].setBackground(new Color(102, 102, 255));
                    dayLabels[j].setEditable(false);
//                    dayLabels[j].setOpaque(true);
//                    dayLabels[j].setBorder(new LineBorder(Color.BLACK, 1, false));
                    dayLabels[j].setHorizontalAlignment(javax.swing.JTextField.CENTER);
                }
                else{
                    days[i][j] = new JTextField();
                    daysBackPanel.add(days[i][j]);
                    days[i][j].setBounds(1 + (xGap * j) + (xSize * j), 24 + ySize + (yGap) + (i * ySize) + (i * yGap), xSize, ySize );
                    days[i][j].setVisible(true);
//                    days[i][j].setBackground(Color.red);
                    days[i][j].setEditable(false);
                    
                    days[i][j].addMouseListener(new java.awt.event.MouseAdapter(){
                        @Override
                        public void mousePressed(java.awt.event.MouseEvent evt){
                            //System.out.println("Yeet1");
                            JTextField source = (JTextField) evt.getSource();
                                //System.out.println("Yeet2");
                                Booking book = null;
                                
                                for (int k = 0; k < 5; k++) {
                                    for (int p = 0; p < DatabaseManager.DAYS_PER_MONTH[currMonth]; p++) {
                                        if(source == days[k][p]){
                                            if(DatabaseManager.bookingArr.get(currMonth).get(k).get(p) != null){
                                                //System.out.println("Found the TextField");
                                                book = DatabaseManager.bookingArr.get(currMonth).get(k).get(p);
                                                new ViewBooking(book).setVisible(true);
                                                break;
                                            }
                                        }
                                    }
                                }
                        }
                    });
                }
            }
        }
        setTextFieldBackgrounds();
    }
    
    private void changeOfMonth(){
        int noOfDaysSkipped = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 31; j++) {
                if(j >= DatabaseManager.DAYS_PER_MONTH[currMonth]){
                    days[i][j].setVisible(false);
                    dayLabels[j].setVisible(false);
                    noOfDaysSkipped++;
                }
                else{
                    days[i][j].setVisible(true);
                    dayLabels[j].setVisible(true);
//                    daysBackPanel.setMinimumSize(new Dimension(655, 472));
//                    daysBackPanel.setPreferredSize(new Dimension(655, 472));
//                    ScrollPanelBack.setMinimumSize(new Dimension(655, 472));
//                    ScrollPanelBack.setPreferredSize(new Dimension(655, 472));
                }
                days[i][j].setBackground(Color.white);
            }
        }
        setTextFieldBackgrounds();
//        ScrollPanelBack.setMinimumSize(new Dimension(655 - (noOfDaysSkipped * 40), 472));
//        ScrollPanelBack.setPreferredSize(new Dimension(655 - (noOfDaysSkipped * 40), 472));
//        daysBackPanel.setMinimumSize(new Dimension(655 - (noOfDaysSkipped * 40), 472));
//        daysBackPanel.setPreferredSize(new Dimension(655 - (noOfDaysSkipped * 40), 472));
    }

    
    private void setTextFieldBackgrounds(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < DatabaseManager.DAYS_PER_MONTH[currMonth]; j++) {
                try{
                    if(DatabaseManager.bookingArr.get(currMonth).get(i).get(j) != null){
                        DatabaseManager.bookingArr.get(currMonth).get(i).get(j);
                        days[i][j].setBackground(new Color(248, 155, 190));
                    }
                    else{
                        //System.out.println("Got em!");
                        days[i][j].setBackground(new Color(254, 254, 254));
                    }
                    
                }
                catch(NullPointerException ex){
                    //System.out.println("Got em!");
                    days[i][j].setBackground(new Color(254, 254, 254));
                }
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        R1_28 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jHomepage = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ScrollPanelBack = new javax.swing.JScrollPane();
        daysBackPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField78 = new javax.swing.JTextField();
        btnRoom1 = new javax.swing.JButton();
        btnRoom2 = new javax.swing.JButton();
        btnRoom3 = new javax.swing.JButton();
        btnRoom4 = new javax.swing.JButton();
        btnRoom5 = new javax.swing.JButton();
        btnMakeBooking = new javax.swing.JButton();
        monthName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        previousMonth = new javax.swing.JLabel();
        nextMonth = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaHelpOutput = new javax.swing.JTextArea();
        BtnExcursionHelp = new javax.swing.JButton();
        btnHelpRooms = new javax.swing.JButton();
        btnHelpMakeBookings = new javax.swing.JButton();
        btnHelpRoomButtons = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel8.setText("jLabel8");

        R1_28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        R1_28.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 510));
        getContentPane().setLayout(null);

        jHomepage.setMaximumSize(new java.awt.Dimension(655, 472));
        jHomepage.setMinimumSize(new java.awt.Dimension(655, 472));
        jHomepage.setPreferredSize(new java.awt.Dimension(655, 472));
        jHomepage.setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(655, 472));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(655, 472));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(655, 472));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(655, 472));
        jPanel1.setMinimumSize(new java.awt.Dimension(655, 472));
        jPanel1.setPreferredSize(new java.awt.Dimension(655, 472));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo.PNG"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 560, 260));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 160, 30));

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(655, 472));
        jPanel2.setMinimumSize(new java.awt.Dimension(655, 472));
        jPanel2.setPreferredSize(new java.awt.Dimension(655, 472));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ScrollPanelBack.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPanelBack.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPanelBack.setMaximumSize(new java.awt.Dimension(1271, 290));
        ScrollPanelBack.setMinimumSize(new java.awt.Dimension(1271, 290));
        ScrollPanelBack.setPreferredSize(new java.awt.Dimension(1271, 290));

        daysBackPanel.setBackground(new java.awt.Color(255, 255, 255));
        daysBackPanel.setMaximumSize(new java.awt.Dimension(1271, 290));
        daysBackPanel.setMinimumSize(new java.awt.Dimension(1271, 290));
        daysBackPanel.setPreferredSize(new java.awt.Dimension(1271, 290));

        javax.swing.GroupLayout daysBackPanelLayout = new javax.swing.GroupLayout(daysBackPanel);
        daysBackPanel.setLayout(daysBackPanelLayout);
        daysBackPanelLayout.setHorizontalGroup(
            daysBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1271, Short.MAX_VALUE)
        );
        daysBackPanelLayout.setVerticalGroup(
            daysBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        ScrollPanelBack.setViewportView(daysBackPanel);

        jPanel2.add(ScrollPanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 510, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jTextField78.setEditable(false);
        jTextField78.setBackground(new java.awt.Color(102, 102, 255));
        jTextField78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField78.setText("Day");
        jTextField78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField78ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField78);
        jTextField78.setBounds(10, 10, 100, 50);

        btnRoom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRoom1.setText("ROOM 1");
        btnRoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoom1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRoom1);
        btnRoom1.setBounds(10, 70, 100, 30);

        btnRoom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRoom2.setText("ROOM 2");
        btnRoom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoom2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRoom2);
        btnRoom2.setBounds(10, 110, 100, 30);

        btnRoom3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRoom3.setText("ROOM 3");
        btnRoom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoom3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRoom3);
        btnRoom3.setBounds(10, 150, 100, 30);

        btnRoom4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRoom4.setText("ROOM 4");
        btnRoom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoom4ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRoom4);
        btnRoom4.setBounds(10, 190, 100, 30);

        btnRoom5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRoom5.setText("ROOM 5");
        btnRoom5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoom5ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRoom5);
        btnRoom5.setBounds(10, 230, 100, 30);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 270));

        btnMakeBooking.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeBooking.setText("Make a booking");
        btnMakeBooking.setToolTipText("");
        btnMakeBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeBookingActionPerformed(evt);
            }
        });
        jPanel2.add(btnMakeBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 150, 30));

        monthName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthName.setText("January");
        jPanel2.add(monthName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 90, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sub-logo.PNG"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        previousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_left_30px_1.png"))); // NOI18N
        previousMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousMonthMouseClicked(evt);
            }
        });
        jPanel2.add(previousMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 30, 20));

        nextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_right_30px_3.png"))); // NOI18N
        nextMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMonthMouseClicked(evt);
            }
        });
        jPanel2.add(nextMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 30, 20));

        jTabbedPane1.addTab("Rooms", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Sub-logo.PNG"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txaHelpOutput.setEditable(false);
        txaHelpOutput.setColumns(20);
        txaHelpOutput.setRows(5);
        jScrollPane1.setViewportView(txaHelpOutput);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 370, 290));

        BtnExcursionHelp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnExcursionHelp.setText("Excursions");
        BtnExcursionHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcursionHelpActionPerformed(evt);
            }
        });
        jPanel5.add(BtnExcursionHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 140, -1));

        btnHelpRooms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHelpRooms.setText("Rooms Tab");
        btnHelpRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpRoomsActionPerformed(evt);
            }
        });
        jPanel5.add(btnHelpRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 140, -1));

        btnHelpMakeBookings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHelpMakeBookings.setText("Make Booking");
        btnHelpMakeBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpMakeBookingsActionPerformed(evt);
            }
        });
        jPanel5.add(btnHelpMakeBookings, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 140, -1));

        btnHelpRoomButtons.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHelpRoomButtons.setText("Room Buttons");
        btnHelpRoomButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpRoomButtonsActionPerformed(evt);
            }
        });
        jPanel5.add(btnHelpRoomButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 140, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_help_40px.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 40, 50));

        jPanel6.setBackground(new java.awt.Color(215, 236, 251));
        jPanel6.setToolTipText("");
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Contact our tech support:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 170, 31));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_customer_support_26px.png"))); // NOI18N
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("www.NightsAway.co.za");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 170, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8_phone_26px.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("035 657 8970");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 220, 120));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 440));

        jTabbedPane1.addTab("Help", jPanel4);

        jHomepage.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 660, 472);

        getContentPane().add(jHomepage);
        jHomepage.setBounds(0, 0, 655, 472);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jTextField78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField78ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField78ActionPerformed

    private void btnRoom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoom1ActionPerformed
        RoomList room1 = new RoomList(monthName.getText(), 1);
        room1.setVisible(true);
    }//GEN-LAST:event_btnRoom1ActionPerformed

    private void btnRoom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoom2ActionPerformed
        RoomList room1 = new RoomList(monthName.getText(), 2);
        room1.setVisible(true);
    }//GEN-LAST:event_btnRoom2ActionPerformed

    private void btnRoom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoom4ActionPerformed
        RoomList room1 = new RoomList(monthName.getText(), 4);
        room1.setVisible(true);
    }//GEN-LAST:event_btnRoom4ActionPerformed

    private void btnMakeBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeBookingActionPerformed
        new MakeBooking().setVisible(true);
    }//GEN-LAST:event_btnMakeBookingActionPerformed

    private void nextMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMonthMouseClicked
        previousMonth.setVisible(true);
        if(currMonth == 10){
            nextMonth.setVisible(false);
        }
        currMonth++;
        monthName.setText("" + DatabaseManager.MONTHS[currMonth]);
        this.changeOfMonth();
    }//GEN-LAST:event_nextMonthMouseClicked

    private void previousMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousMonthMouseClicked
        nextMonth.setVisible(true);
        if(currMonth == 1){
            previousMonth.setVisible(false);
        }
        currMonth--;
        monthName.setText(DatabaseManager.MONTHS[currMonth]);
        this.changeOfMonth();
    }//GEN-LAST:event_previousMonthMouseClicked

    private void btnRoom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoom3ActionPerformed
        RoomList room1 = new RoomList(monthName.getText(), 3);
        room1.setVisible(true);
    }//GEN-LAST:event_btnRoom3ActionPerformed

    private void btnRoom5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoom5ActionPerformed
        RoomList room1 = new RoomList(monthName.getText(), 5);
        room1.setVisible(true);
    }//GEN-LAST:event_btnRoom5ActionPerformed

    private void btnHelpRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpRoomsActionPerformed
        Help roomHelp = new Help("RoomsTabHelp");
        txaHelpOutput.setText(roomHelp.toString());
    }//GEN-LAST:event_btnHelpRoomsActionPerformed

    private void btnHelpMakeBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpMakeBookingsActionPerformed
        Help roomHelp = new Help("MakeBookingHelp");
        txaHelpOutput.setText(roomHelp.toString());
    }//GEN-LAST:event_btnHelpMakeBookingsActionPerformed

    private void btnHelpRoomButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpRoomButtonsActionPerformed
        Help roomHelp = new Help("RoomButtonsHelp");
        txaHelpOutput.setText(roomHelp.toString());
    }//GEN-LAST:event_btnHelpRoomButtonsActionPerformed

    private void BtnExcursionHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcursionHelpActionPerformed
        Help roomHelp = new Help("ExcursionsHelp");
        txaHelpOutput.setText(roomHelp.toString());
    }//GEN-LAST:event_BtnExcursionHelpActionPerformed

    
    private void getBooked(){
        
    }
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
            java.util.logging.Logger.getLogger(HomepageNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomepageNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomepageNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomepageNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomepageNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExcursionHelp;
    private javax.swing.JTextField R1_28;
    private javax.swing.JScrollPane ScrollPanelBack;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHelpMakeBookings;
    private javax.swing.JButton btnHelpRoomButtons;
    private javax.swing.JButton btnHelpRooms;
    private javax.swing.JButton btnMakeBooking;
    private javax.swing.JButton btnRoom1;
    private javax.swing.JButton btnRoom2;
    private javax.swing.JButton btnRoom3;
    private javax.swing.JButton btnRoom4;
    private javax.swing.JButton btnRoom5;
    private javax.swing.JPanel daysBackPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jHomepage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JLabel monthName;
    private javax.swing.JLabel nextMonth;
    private javax.swing.JLabel previousMonth;
    private javax.swing.JTextArea txaHelpOutput;
    // End of variables declaration//GEN-END:variables
}
