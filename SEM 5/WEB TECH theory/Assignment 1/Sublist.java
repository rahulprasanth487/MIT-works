import java.util.*;

public class Sublist
{
      public static void main(String[] args)
      {
            ArrayList<Integer> arr1=new ArrayList<>();
            Scanner inp=new Scanner(System.in);
            System.out.println("Enter the size of the array = ");
            int n=inp.nextInt();
            for(int i=0;i<n;++i)
            {
                  arr1.add(inp.nextInt());
            }
            ArrayList<Integer> arr2=new ArrayList<>();
            arr2.addAll(arr1.subList(1, 4));
            System.out.println(arr1);
            System.out.println(arr2);
      }
}