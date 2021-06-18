package nightsaway_final;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mr S Malinga (218021100)
 */
    
public class DatabaseManager {
    private static final String driver = "jdbc:ucanaccess://";
    private static final String filename = (new File("NightsAway.accdb")).getAbsolutePath();
    private static Connection con;

    public static final String[] MONTHS = new String[]{
        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final int[] DAYS_PER_MONTH = new int[]{
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static LinkedList<LinkedList<LinkedList<Booking>>> bookingArr = new LinkedList<LinkedList<LinkedList<Booking>>>();
    /*
        Constructor used to call the methods in the DatabaseMnager class
        No parameters are required
    */
    public DatabaseManager()
    {
        
    }
    /*
        A void method that ensure that the connection between the DB and the 
        programme is successful. It will catch the error should is not make a 
        successful connection
        No perameters are required
    */
    public static void instatiateConnection(){
        try
        {
            con = DriverManager.getConnection(driver + filename);
            System.out.println("Database has successfully connected");
        }
        catch (SQLException ex)
        {
            System.out.println("Oh dear, something went wrong" + ex);
        }
    }
    
    /*
        Reads all the guest details into an array of Guest type and returns it
        to the programme
        No permaeters are required
    */
    public static Guest [] getGuest() throws SQLException
    {
        Guest guestArr[] = new Guest[100];
        int count = 0;

        Statement s = con.createStatement();
        String query = "SELECT * FROM tblGuest";
        ResultSet rs = s.executeQuery(query);

       while(rs.next())
       {
           String guestID = rs.getString("GuestID");
           String firstName = rs.getString("FirstName");
           String lastName = rs.getString("LastName");
           String cellNo = rs.getString("CellNo");
           /*
           String roomNo = rs.getString("RoomNo");
           Double amountOwed = rs.getDouble("AmountOwed");
           Date dateArriving = rs.getDate("DateArriving");
           Date dateLeaving = rs.getDate("DateLeaving");
           */
           guestArr[count] = new Guest(guestID, firstName, lastName, cellNo);
           count++;
       }
       return guestArr;
    }
    /*
        Adds a guest to the database, specifically to tblGuest
        Perameters required are of Guest type: String guestID, String firstName,
        String lastName, String cellNo
        Is a void method so no data is returned
    */
    public static void addGuest(String inGuestID, String inFirstName, String inLastName, String inCellNo) throws SQLException
    {
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM tblGuest";
        ResultSet rs = s.executeQuery(query);
        rs.moveToInsertRow();

        rs.updateString("GuestID", inGuestID);
        rs.updateString("FirstName", inFirstName);
        rs.updateString("LastName", inLastName);
        rs.updateString("CellNo", inCellNo);
        /*
        rs.updateDouble("AmountOwed", inAmountOwed);
        rs.updateString("RoomNo", inRoomNo);
        rs.updateString("DateArriving", (inDateArriving.substring(0, 4) + "-" + inDateArriving.substring(5, 7) + "-" +
                                         inDateArriving.substring(8, 10) + " 00:00:00.0"));
        rs.updateString("DateLeaving", (inDateLeaving.substring(0, 4) + "-" + inDateLeaving.substring(5, 7) + "-" +
                                         inDateLeaving.substring(8, 10) + " 00:00:00.0"));
        */
        rs.insertRow();
        rs.close();
        s.close();
    }
    /*
        Method adds a booking to the database
        This method corrosponds with the previous method and must run at the
        same time
        This method is required to upadate the tables of the different months
        Requires parameters of types: String guestID, int roomNo, String dayIn,
        String dayOut, double amountOwed
    */
    public static void addBooking(String inGuestID, int inRoomNo, String inDayIn, String inDayOut, double inAmountOwed, int inMonth) throws SQLException
    {
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String tbl = DatabaseManager.MONTHS[inMonth - 1] + "";
        String query = "SELECT * FROM " + tbl;
        ResultSet rs = s.executeQuery(query);
        rs.moveToInsertRow();

        rs.updateString("GuestID", inGuestID);
        rs.updateInt("RoomNo", inRoomNo);
        rs.updateString("DayIn", (inDayIn.substring(0, 4) + "-" + inDayIn.substring(5, 7) + "-" +
                                  inDayIn.substring(8, 10) + " 00:00:00.0"));
        rs.updateString("DayOut", (inDayOut.substring(0, 4) + "-" + inDayOut.substring(5, 7) + "-" +
                                   inDayOut.substring(8, 10) + " 00:00:00.0"));
        rs.updateDouble("AmountOwed", inAmountOwed);
        
        rs.insertRow();
        rs.close();
        s.close();
    }
    /*
        Method is used to edit the amount owed by the guest
        This is used explicitly for the excursions amount
        Requires parameters of type: String guestID, double amountOwed, 
        int roomID, int month
    */
    public static void editAmountOwed(String inGuestID, double inAmountOwed, int inRoomID, int inMonth) throws SQLException
    {
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM " + MONTHS[inMonth - 1];
        ResultSet rs = s.executeQuery(query);

        rs.next();
        while(!rs.getString("GuestID").equals(inGuestID) && rs.getInt("RoomNo") != inRoomID){
            rs.next();
        }

        rs.updateDouble("AmountOwed", rs.getDouble("AmountOwed") + inAmountOwed);

        rs.updateRow();
        rs.close();
        s.close();
    }
    /*
        The method is used to search the database and return a specific value 
        in type ResultSet
        Required parameters types: String colOne, String col2, 
        String colOneValue, String col2Value
    */
    public static ResultSet searchDataBase(String colOne, String col2, String colOneValue, String col2Value) throws SQLException{
        ResultSet rs = null;
        Statement s;
        
        for (int i = 0; i < 12; i++) {
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM " + MONTHS[i] + " WHERE " 
                            + colOne + " = '" + colOneValue + "' AND " + col2 + " = " + col2Value;
            rs = s.executeQuery(query);
            if(rs.next()){
                //System.out.println("Found The BOI");
                break;
            }
            else{
                rs.close();
            }
        }
        return rs;
    }
    /*
        This method is used to display the data from the database into a table
        in the programme and return type DefaultTableModel to be compatible with
        the table
        Required parameter types:String inMonth, int RoomNo
    */
    public static DefaultTableModel getRoomData(String inMonth, int RoomNo)
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("GuestID");
        model.addColumn("FirstName");
        model.addColumn("LastName");
        model.addColumn("CellNo");
        model.addColumn("AmountOwed");
        
        try {
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT * FROM " + inMonth + " WHERE RoomNo = " + RoomNo;
            ResultSet rs = s.executeQuery(query);

            Object[] rowData = new Object[5];
//            ResultSetMetaData meta = rs.getMetaData();

            String currGuestID = "";
            Guest guest = null;

            while(rs.next()){
                currGuestID = rs.getString("GuestID");
                guest = DatabaseManager.getGuestRelatedToID(currGuestID);
//                for (int i = 1; i < 5; i++) {
//                    rowData[i - 1] = guestRS.getObject(i);
//                }
                rowData[0] = guest.getGuestID();
                rowData[1] = guest.getFirstName();
                rowData[2] = guest.getLastName();
                rowData[3] = guest.getCellNo();
                rowData[4] = rs.getDouble("AmountOwed");
                model.addRow(rowData);
            }
            s.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    /*
        This method is used to identify which blocks in the "calendar" must be
        coloured to show it as booked
        No parameters are required
    */
    public static void fetchBookingData() throws SQLException
    {
        
        DatabaseManager.instantiateArrays();
        
        String GuestID;
        int RoomNo;
        String dayIn, dayOut;
        double amountOwed;
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        
        for (int i = 0; i < 12; i++) {
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM " + MONTHS[i];
            ResultSet rs = s.executeQuery(query);
            
            while(rs.next()){
                GuestID = rs.getString("GuestID");
                RoomNo = rs.getInt("RoomNo");
                dayIn = df.format(rs.getDate("DayIn"));
                dayOut = df.format(rs.getDate("DayOut"));
                amountOwed = rs.getDouble("AmountOwed");
                Guest gu = getGuestRelatedToID(GuestID);
                Booking book = new Booking(gu, "" + RoomNo, amountOwed, dayIn, dayOut);
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                
                LocalDate dateIn = LocalDate.parse(dayIn, dtf);
                LocalDate dateOut = LocalDate.parse(dayOut, dtf);
                //System.out.println("Day In: " + dateIn);
                //System.out.println("Day Out: " + dateOut);
//                long daysBetween = Duration.between(dateIn, dateOut).toDays();
                long daysBetween = ChronoUnit.DAYS.between(dateIn, dateOut);
                //System.out.println ("DaysBetween: " + daysBetween);
                
                int currDay = Integer.parseInt(dayIn.substring(8, 10));
                int dayResetCounter = 0;
                
                for (int j = 0; j < daysBetween; j++) {
//                    LinkedList<Booking> tempList1 = null;
//                    tempList1.add(book);
                    if(RoomNo != 0){
                        if(currDay > DAYS_PER_MONTH[i] && i != 11){
                            bookingArr.get(i + 1).get(RoomNo - 1).set(dayResetCounter, book);
                            dayResetCounter++;
                        }
                        else{
                            bookingArr.get(i).get(RoomNo - 1).set(currDay - 1, book);
                            currDay++;
                        }
                    }
                }
            }
            rs.close();
            s.close();
        }
    }
    /*
        This methods serves as a check to ensure that if a guest's amount is to
        be edited that the guest does exist--acts as a helper method within the
        class
        Parameter type: String ID
        Returns type Guest
    */
    private static Guest getGuestRelatedToID(String ID) throws SQLException
    {
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "SELECT * FROM tblGuest WHERE GuestID = '" + ID + "';";
        ResultSet rs = s.executeQuery(query);
        
        rs.next();
        
        String guestID, firstName, surname, cellNo;
        guestID = rs.getString("GuestID");
        firstName = rs.getString("FirstName");
        surname = rs.getString("LastName");
        cellNo = rs.getString("CellNo");
        Guest g = new Guest(guestID, firstName, surname, cellNo);
        rs.close();
        s.close();
        return g;
    }
    /*
        Method is used to delete a guest from the databse
        Required parameters are type: String guestID
    */
    public static void deleteGuest(String GuestID){
        System.out.println(GuestID);
        try {
            Guest g = getGuestRelatedToID(GuestID);
            System.out.println(g.toString());
            PreparedStatement st = con.prepareStatement("DELETE FROM tblGuest WHERE GuestID = ?;");
            st.setString(1, GuestID);
            st.executeUpdate();
//            st.execute();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed deleteing the guest ");
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    /*
        The method is used to assign the bookingArr list with values--is used
        as a helper method
        No parameters are required
    */
    private static void instantiateArrays() {
        bookingArr.clear();
        for (int i = 0; i < 12; i++) {
            LinkedList<LinkedList<Booking>> temp1 = new LinkedList<>();
            bookingArr.add(temp1);
            
            for (int j = 0; j < 5; j++) {
                LinkedList<Booking> temp2 = new LinkedList<>();
                bookingArr.get(i).add(temp2);
                for (int k = 0; k < DAYS_PER_MONTH[i]; k++) {
                    bookingArr.get(i).get(j).add(null);
                }
            }
        }
    }
    /*
     Method was used as an error checker to see what values were printed upon 
     requesting to see all data in the array list. It is not used but helpful to
     have
    */
    public static void printData(){
        String temp = "";
        for (int i = 0; i < 12; i++) {
            temp += MONTHS[i] + ":\n";
            for (int j = 0; j < 5; j++) {
                temp += "Room No. " + j + ":\n";
                for (int k = 0; k < DAYS_PER_MONTH[i]; k++) {
                    try{
                        temp += "BookingDay " + k + " - " + bookingArr.get(i).get(j).get(k).toString() + "\n";
                    }
                    catch(NullPointerException ex){
                        temp += "N/A\n";
                    }
                }
            }
        }
        System.out.println(temp);
    }
}
