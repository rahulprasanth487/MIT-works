import java.util.*;

public class Str_man {
    public static void main(String[] args)
    {
        String name = new String("Rahul Prasanth D");
        name=name.toLowerCase();
        System.out.println("Length of name  = "+name.length());
        System.out.println(name);
        int cnt=0;
        for(int i=0;i<name.length();++i)
        {
            if(name.charAt(i)==name.charAt(0)) cnt++;
        }
        System.out.println("Count of first letter along with that = "+cnt);
    }
}
