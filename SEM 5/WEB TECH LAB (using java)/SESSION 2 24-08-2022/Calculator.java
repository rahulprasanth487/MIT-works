
package session_2;
import java.util.*;
public class Calculator {

    public static void main(String[] args) {
        while(true)
        {
            Scanner inp=new Scanner(System.in);
            System.out.print("Enter the choice - ");
            int ch=inp.nextInt();
            if(ch==111) break;
            System.out.print("Enter the numebers = ");
            int a = inp.nextInt();
            int b=inp.nextInt();
            
            switch(ch)
            {
                case 1:
                    System.out.println("Addition of a b = "+(a+b));
                    break;
                case 2:
                    System.out.println("Subtraction of a b = "+(a-b));
                    break;
                case 3:
                    System.out.println("Multiplication of a b = "+(a*b));
                    break;
                case 4:
                    System.out.println("Division of a b = "+(a/b));
                    break;
                case 5:
                    System.out.println("Square root of a and b = "+(Math.sqrt(a))+" and "+Math.sqrt(b));
                    break;
                case 6:
                    System.out.println("Power = "+Math.pow(a, b));
                    break;
                default:
                    System.out.println("Error input");
                    break;
            }
        }
    }
    
}
