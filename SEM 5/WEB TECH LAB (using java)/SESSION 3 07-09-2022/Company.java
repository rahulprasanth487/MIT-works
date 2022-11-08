

import java.util.*;

class Comp
{
    String name,date;
    float salary;
    Scanner inp=new Scanner(System.in);
    
    Comp()
    {
        System.out.print("Name = ");
        name=inp.nextLine();
        System.out.print("Salary = ");
        salary = inp.nextFloat();
        System.out.print("Date = ");
        inp.nextLine();
        date=inp.nextLine();
    }
    
    
    void display(int i)
    {
        System.out.println(i+".");
        System.out.println(" Name\t= "+name);
        System.out.println(" Salary  = "+salary);
        System.out.println(" Date of joining   = "+date);
        System.out.println();
    }
    
}

public class Company {
    public static void main(String[] args)
    {
        Comp obj[]=new Comp[10];
        
        for(int i=0;i<10;++i)
        {
            obj[i]=new Comp();
        }
        
        for(int i=0;i<10;++i)
        {
            obj[i].display(i+1);
        }
        
    }
}
