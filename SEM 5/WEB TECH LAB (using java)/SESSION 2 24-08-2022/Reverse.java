
import java.util.*;

public class Reverse {
    int reverse(int n)
    {
        int rev=0;
        while(n>0)
        {
            rev=rev*10+n%10;
            n/=10;
        }
        return rev;
    }
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the number - ");
        int num=inp.nextInt();
        
        Reverse obj=new Reverse();
        System.out.println("Reverse = "+obj.reverse(num));
        
        
    }
}
