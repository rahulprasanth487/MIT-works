
import java.util.*;
public class StringHandling {
    public static void main(String[] args)
    {
        StringBuilder str=new StringBuilder("Rahul ");
        System.out.println("Cpacity = "+str.capacity());
        
        System.out.println("Lowercase = "+(str.toString()).toLowerCase());

        System.out.println("Upper case = "+(str.toString()).toUpperCase());
        
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the string to append = ");
        str.append(inp.nextLine());
        System.out.println("New String = "+str);
        
        StringBuilder x=str.reverse();
        System.out.println("Reveersed string - "+str);
        
    }
}
