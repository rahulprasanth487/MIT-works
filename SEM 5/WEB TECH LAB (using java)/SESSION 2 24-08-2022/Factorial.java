/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;

import java.util.*;

public class Factorial {
    int fact(int n)
    {
        if(n<2) return 1;
        else return n*fact(n-1);
    }
    
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the number - ");
        int num=inp.nextInt();
        
        Factorial obj=new Factorial();
        System.out.println("Factorial = "+obj.fact(num));
    }
}
