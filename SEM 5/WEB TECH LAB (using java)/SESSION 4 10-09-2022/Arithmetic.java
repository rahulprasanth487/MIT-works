import java.util.*;

class Ari
{
    static int a;
    static int b;
    Ari()
    {
        System.out.println("Addition of a & b = "+(a+b));
        System.out.println("Subtraction of a & b = "+(a-b));
        System.out.println("Multiplication of a & b = "+(a*b));
        System.out.println("Division of a & b = "+((float)a/b));
    }
}

public class Arithmetic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the numbers a & b = ");
        Ari.a=inp.nextInt();
        Ari.b=inp.nextInt();
        
        //calling  the constructor
        new Ari();
    }
    
}
