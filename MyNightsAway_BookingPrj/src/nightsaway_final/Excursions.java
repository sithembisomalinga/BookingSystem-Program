package nightsaway_final;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class Excursions {
    private String typeOfExcursion, guestID;
    private int roomNo;
    private int noOfPeople = 0;

    public Excursions(String inTypeOfExcursion, String InGuestID, int inRoomNo, int inNoOfPeople) 
    {
        typeOfExcursion = inTypeOfExcursion;
        guestID = InGuestID;
        roomNo = inRoomNo;
        noOfPeople = inNoOfPeople;
    }
    /*
        This method is used to calculate the total owed from the excursion
        It return the total as an int type...this is converted to double as int
        can automatically be.
        Required parameters of the price of the excurion and number of people
        both as int tpyes.
    */
    public int CalcCost(int inPrice, int inNoOfPeople)
    {
        return inPrice*inNoOfPeople;
    }   
    /*
    The following code was commented out as it is not needed to run the programme
    However, should futre improments arise the following could be useful.
    public String getTypeOfExcursion() 
    {
        return typeOfExcursion;
    }

    public String getGuestID() 
    {
        return guestID;
    }

    public int getRoomNo() 
    {
        return roomNo;
    }
    
    public int getNoOfPeople()
    {
        return noOfPeople;
    }

    public void setTypeOfExcursion(String typeOfExcursion)
    {
        this.typeOfExcursion = typeOfExcursion;
    }

    public void setGuestID(String guestID)
    {
        this.guestID = guestID;
    }

    public void setRoomNo(int roomNo) 
    {
        this.roomNo = roomNo;
    }
    
    public void setNoOfPeople(int noOfPeople) 
    {
        this.noOfPeople = noOfPeople;
    }
    
    @Override
    public String toString()
    {
        String temp = "";
        
        temp += "The total for "+ noOfPeople +" people to experience "+ typeOfExcursion +" is: R";
        return temp;
    }
    */
}
