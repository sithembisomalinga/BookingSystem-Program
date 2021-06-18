package nightsaway_final;


import java.io.*;
import java.util.*;
/**
 *
 * @author Mr S Malinga (218021100)
 */

public class Login_Class {
    private String username, password;
    /*
        Constructor requires to String inputs as its parameters
        Nothing is returned
    */
    public Login_Class(String inUsername, String inPassword)
    {
        username = inUsername;
        password = inPassword;
    }
    /*
        This method returns an int type depending whether the password and 
        username is correct. 
        0 if correct and 1 if incorrect
        It requires a text file to use a scanner to scan through the file, 
        decryptes the information stored in it and compares it to the inputted 
        values.
    */
    public int isCorrect() throws FileNotFoundException
    {
        Scanner scan1 = new Scanner (new File("LoginInfo.txt"));
        
        String tempUser = scan1.next();
        String tempPass = scan1.next();
        
        String tempArr[] = tempUser.split("@");
        String finalUser = "";
        for (int i = 0; i < tempArr.length; i++)
        {
            finalUser += tempArr[i];
        }
        
        String tempArr2 [] = tempPass.split("@");
        String tempFinalPass = "";
        int num1 = Integer.parseInt(tempArr2[0])-1;
        int num2 = Integer.parseInt(tempArr2[1])+1;
        int num3 = Integer.parseInt(tempArr2[2])-1;
        int num4 = Integer.parseInt(tempArr2[3])+1;
        String finalPass = num1 + "" + num2 + "" + num3 + "" + num4 + "";
        
        int result = 1;
        if (username.equals(finalUser) && password.equals(finalPass))
        {
            result = 0;
        }
        else if (!username.equals(finalUser) || !password.equals(finalPass))
        {
            result = 1;
        }
        return result;
    }
    
    /*
    The following code was commented out as it is not needed to run the programme
    However, should futre improments arise the following could be useful.
    public String getTypeOfExcursion() 
        public void setUsername(String username) 
        {
            this.username = username;
        }

        public void setPassword(String password) 
        {
            this.password = password;
        }

        public String getUsername() 
        {
            return username;
        }

        public String getPassword() 
        {
            return password;
        } 
    */
}
    

