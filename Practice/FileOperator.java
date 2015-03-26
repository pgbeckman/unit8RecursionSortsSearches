import java.util.Scanner;
import java.io.*;

public class FileOperator
{
    public static void main(String[] args){
        Scanner userIn = new Scanner(System.in);
        boolean t = true;
        Scanner scan = null;
        while (t){
            try{
                System.out.println("Text file name:");
                File inputFile = new File(userIn.nextLine()+".txt");
                scan = new Scanner(inputFile);
                t = false;
            }
            catch(IOException e){
                System.out.println("That text file does not exist");
            }
        }
        int words = 0;
        int characters = 0;
        int lines = 0;
        while (scan.hasNextLine())
        {
            String value = scan.nextLine();
            lines++;
            words++;
            characters += value.length();
            for(int i = 0; i < value.length(); i++){
                if(value.substring(i,i+1).equals(" ")){
                    words++;
                }
            }
        }
        scan.close();
        System.out.println("Lines: " + lines + " Words: " + words + " Characters: " + characters); 
    }
}
