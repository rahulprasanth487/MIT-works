

import java.util.regex.*;
import java.util.Scanner;
/**
 *
 * @author student
 */
public class RegEx {
    void Job()
    {
        Scanner inp = new Scanner(System.in);
        System.out.print("Input - ");
        String role=inp.nextLine();
        String reg=".*job$";
        if(Pattern.matches(reg, role))
        {
            System.out.println("String matches to job");
        }
        else
        {
            System.out.println("String mismatch at end");
        }
    }
    
    void email()
    {
        Scanner inp = new Scanner(System.in);
        System.out.print("Input - ");
        String role=inp.nextLine();
        String reg="(.*)@(.*).com$";
        if(Pattern.matches(reg, role))
        {
            System.out.println("String matches to job");
        }
        else
        {
            System.out.println("String mismatch at end");
        }
    }
    
    void password()
    {
        Scanner inp = new Scanner(System.in);
        System.out.print("Input - ");
        String role=inp.nextLine();
        String reg="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$";
        if(Pattern.matches(reg, role))
        {
            System.out.println("String matches to job");
        }
        else
        {
            System.out.println("String mismatch at end");
        }
    }
    public static void main(String[] args)
    {
        RegEx obj=new RegEx();
        
        obj.Job();
        obj.email();
        obj.password();
    }
}
