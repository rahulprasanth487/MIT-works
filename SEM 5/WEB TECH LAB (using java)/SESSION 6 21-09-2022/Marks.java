
package session.pkg6;
import java.util.*;

abstract class Mks
{
    abstract void getPercentage();
}

class A extends Mks
{
    double s1,s2,s3;
    A(double a,double b,double c)
    {
        this.s1=a; this.s2=b; this.s3=c;
    }
    
    void getPercentage()
    {
        System.out.println("Total marks of class A = "+((s1+s2+s3)/300)*100);
    }
}


class B extends Mks
{
    double s1,s2,s3,s4;
    B(double a,double b,double c,double d)
    {
        this.s1=a; this.s2=b; this.s3=c; this.s4=d;
    }
    
    void getPercentage()
    {
        System.out.println("Total marks of class B = "+((s1+s2+s3+s4)/400)*100);
    }
}



public class Marks {
    public static void main(String[] args)
    {
        double s1,s2,s3,s4;
        System.out.println("Enter the 3 subject marks = ");
        Scanner inp=new Scanner(System.in);
        s1=inp.nextDouble();
        s2=inp.nextDouble();
        s3=inp.nextDouble();
        
        A obj1=new A(s1,s2,s3);
        obj1.getPercentage();
        
        
        System.out.println("Enter the 4 subject marks = ");
        s1=inp.nextDouble();
        s2=inp.nextDouble();
        s3=inp.nextDouble();
        s4=inp.nextDouble();
        
        B obj2=new B(s1,s2,s3,s4);
        
        
        obj2.getPercentage();
    }
}
