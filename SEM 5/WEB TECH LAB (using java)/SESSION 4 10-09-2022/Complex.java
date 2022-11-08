
import java.util.*;
class Comp
{
    int real,imag;
    Comp(int real,int img)
    {
        this.real=real;
        this.imag=img;
    }
}

public class Complex {
    void add(Comp c1,Comp c2)
    {
        if(c1.imag+c2.imag <0) System.out.println((c1.real+c2.real)+""+(c1.imag+c2.imag)+"i");
        else System.out.println((c1.real+c2.real)+"+"+(c1.imag+c2.imag)+"i");
    }
    
    void sub(Comp c1,Comp c2)
    {
        if(c1.imag-c2.imag <0) System.out.println((c1.real-c2.real)+""+(c1.imag-c2.imag)+"i");
        else System.out.println((c1.real-c2.real)+"+"+(c1.imag-c2.imag)+"i");
    }
    void mult(Comp c1,Comp c2)
    {
        if((c2.real*c1.imag+c2.imag*c1.real)<0)
        {
            System.out.println((c2.real*c1.real + (-1*(c1.imag*c2.imag)))+""+(c2.real*c1.imag+c2.imag*c1.real)+"i");
        }
        else
        {
            System.out.println((c2.real*c1.real + (-1*(c1.imag*c2.imag)))+"+"+(c2.real*c1.imag+c2.imag*c1.real)+"i");
        }
    }
    
    public static void main(String[] args)
    {
        Comp c1=new Comp(1,-2);
        Comp c2=new Comp(1,2);
        Complex obj=new Complex();
        System.out.println("Addition = ");
        obj.add(c1,c2);
        System.out.println("Subtraction = ");
        obj.sub(c1,c2);
        System.out.println("Multiplication = ");
        obj.mult(c1,c2);
    }
}
