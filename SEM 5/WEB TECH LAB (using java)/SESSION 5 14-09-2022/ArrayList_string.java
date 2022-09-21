import java.lang.reflect.Array;
import java.util.*;

import javax.sound.sampled.SourceDataLine;

class ArrayList_string {
      void rev(List<String> arr)
      {
            Collections.reverse(arr);
      }

      void capitalize(List<String> arr)
      {
            for(int i=0;i<arr.size();++i)
            {
                  String str=arr.get(i);
                  if(str.charAt(str.length()-1)=='S'|| str.charAt(str.length() - 1) == 's')
                  {
                        arr.remove(i);
                  }
            }
      }

      public static void main(String[] args)
      {
            Scanner inp=new Scanner(System.in);
            System.out.print("Enter the number of strings = ");
            int n=inp.nextInt();

            List<String> arr=new ArrayList<String>();
            for(int i=0;i<n;++i)
            {
                  System.out.print("Enter the string = ");
                  arr.add(inp.next());
            }
            System.out.println(arr);

            ArrayList_string obj=new ArrayList_string();
            obj.rev(arr);
            System.out.println(arr);
            obj.capitalize(arr);
            System.out.println(arr);
      }
}
