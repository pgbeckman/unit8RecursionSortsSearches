import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BabyNames
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Name: ");
        String name = in.next();
        Scanner scan = null;
        //scan.useDelimiter(" ");
        ArrayList<String> rank = new ArrayList<String>();
        String save = "";
        try
        {
            for (int i = 70; i <= 90; i += 10)
            {
                File decade = new File("babyNames" + i + ".txt");
                scan = new Scanner(decade);
                while (scan.hasNext())
                {
                    if (scan.next().equals(name))
                    {
                        rank.add(save);
                    }
                    save = scan.next();
                }
                scan.close();
            }
        }
        catch(IOException e)
        {
        }
        System.out.println("70s: " + rank.get(0) + " 80s: " + rank.get(1) + " 90s: " + rank.get(2)); 
    }
}
