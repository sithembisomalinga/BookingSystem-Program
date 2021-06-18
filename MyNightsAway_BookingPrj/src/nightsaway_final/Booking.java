package nightsaway_final;

import java.sql.Date;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class Booking {
    private Guest guest;
    private String roomNo;
    private double amountOwed; 
    private String dateArriving, dateLeaving;

    public Booking(Guest inGuest, String inRoomNo, double inAmounted, String inDateArriving, String inDateLeaving) 
    {
        guest = inGuest;
        roomNo = inRoomNo;
        amountOwed = inAmounted;
        dateArriving = inDateArriving;
        dateLeaving = inDateLeaving;
    }
    /*
        These are accessor methods for the Booking class
        All types returned are String 
        No peramters are required
    */
    public Guest getGuest() 
    {
        return guest;
    }

    public String getRoomNo() {
        return roomNo;
    }
    
    public double getAmountOwed() 
    {
        return amountOwed;
    }

    public String getDateArriving() 
    {
        return dateArriving;
    }

    public String getDateLeaving() 
    {
        return dateLeaving;
    }
    /*
        This method returns the above set fields of the Guest object as a String in a specific layout
        No perameters are required
    */
    @Override
    public String toString() 
    {
        String temp = "";
        temp += guest.toString() +"\t"+ amountOwed +"\t"+ dateArriving +"\t"+ dateLeaving;
        return temp;
        
    }
    /*
    The following code was commented out as it is not needed to run the programme
    However, should futre improments arise the following could be useful.
    public void setGuest(Guest guest)
    {
        this.guest = guest;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    
    public void setAmountOwed(double amountOwed)
    {
        this.amountOwed = amountOwed;
    }

    public void setDateArriving(String dateArriving) 
    {
        this.dateArriving = dateArriving;
    }

    public void setDateLeaving(String dateLeaving) 
    {
        this.dateLeaving = dateLeaving;
    }
    */
    
    
}
