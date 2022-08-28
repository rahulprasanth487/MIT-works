/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;
import java.util.*;
/**
 *
 * @author student
 */
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
