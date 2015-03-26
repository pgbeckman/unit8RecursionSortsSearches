import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList tempList = new ArrayList<Integer>();
        if (n <= 0)  // The smallest list we can make
        {
        }
        else        // All other size lists are created here
        {
            tempList = makeList(n-1);
            tempList.add(n);
        }
        return tempList;
    }

    public static ArrayList deepClone(ArrayList tList)
    {
        ArrayList list = new ArrayList(); 
        for (int i = 0; i < tList.size(); i ++)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList reverseList(ArrayList tList)
    {
        ArrayList list = ListMethods.deepClone(tList); 
        if (list.size() <= 1 )
        {
            return list;
        }
        else
        {
            int save = list.get(0);
            list.remove(0);
            reverseList(list);
            list.add(save);
        }
        return list;
    }

    public static void main(String args[]){
        ArrayList printList = new ArrayList<Integer>();
        printList = makeList(10);
        for( int i = 0 ; i < printList.size() ; i++ ){
            System.out.println(printList.get(i));
        }
    }
}