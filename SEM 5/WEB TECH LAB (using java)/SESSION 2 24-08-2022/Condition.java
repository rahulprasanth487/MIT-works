import java.util.*;
public class Condition {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the numbers - ");
        int a=inp.nextInt();
        int b=inp.nextInt();
        System.out.println("(a<100 and a>b) = "+((a<100 && a>b)==true));
    }
}
