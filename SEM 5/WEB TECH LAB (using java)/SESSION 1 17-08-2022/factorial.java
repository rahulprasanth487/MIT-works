import java.util.Scanner;

import java.util.*;


class factorial
{
    int fact(int n)
    {
        int ans=1;
        for(int i=n;i>0;--i){ans*=i;}
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        factorial ob=new factorial();
        System.out.print("Enter the number = ");
        int n=inp.nextInt();
        System.out.println("Factorial of "+n+" is "+ob.fact(n));
    }
}