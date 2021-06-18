package nightsaway_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mr S Malinga (218021100)
 */
public class Help {
    private String HelpArray [] = new String [100];
    private int size = 0;
    /*
        Constructor requires a String parameter
        Returns an array of information relating to the specific help requested.
        Scaneer runs through the text file, reads each line into an element of
        array
    */
    public Help(String filename)
    {
        try 
        {
            Scanner scan1 = new Scanner(new File(filename + ".txt"));
            while (scan1.hasNextLine())
            {
                String line = scan1.nextLine();
                HelpArray[size] = line;
                size++;
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File not found, ensure all extensions/names are correct/not omitted");
        }
    }
    /*
        This method returns the above set array of the Help array object 
        as a String in a specific layout. This is displayed in the text area.
        No perameters are required.
    */
    @Override
    public String toString()
    {
        String temp = "";
        for (int i = 0; i < size; i++)
        {
            temp += HelpArray[i] +"\n";
        }
        return temp;
    }
}
