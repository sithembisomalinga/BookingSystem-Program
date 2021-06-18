package nightsaway_final;

import java.sql.Date;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class Guest {
    private String roomNo, firstName, LastName, guestID, cellNo;
   
    public Guest(String inGuestID, String inFirstName, String inLastName, String inCellNo)
    {
        guestID = inGuestID;
        firstName = inFirstName;
        LastName = inLastName;
        cellNo = inCellNo;
    }
    /*
        These are accessor methods for the Guest class
        All types returned are String 
        No peramters are required
    */
    public String getGuestID() 
    {
        return guestID;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public String getCellNo()
    {
        return cellNo;
    }

    /*
        This method returns the above set fields of the Guest object as a String
        in a specific layout.
        No perameters are required.
    */
    @Override
    public String toString()
    {
        String temp = "";
        
        temp += roomNo +"\t"+ firstName +"\t"+ LastName +"\t"+ guestID +"\t"+ cellNo;
        return temp;
    }
   /* 
    The following code was commented out as it is not needed to run the programme
    However, should futre improments arise the following could be useful.
    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public void setCellNo(String cellNo) 
    {
        this.cellNo = cellNo;
    }*/
}
