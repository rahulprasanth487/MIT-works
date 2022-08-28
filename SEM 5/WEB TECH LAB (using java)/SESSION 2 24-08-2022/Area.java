/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;

import java.util.*;

class calarea
{
    calarea(int a)
    {
        System.out.println("Area of a square = "+Math.pow(a, 2));
    }
    
    calarea(int l, int b)
    {
        System.out.println("Area of a rectangle = "+(l*b));
    }
}

public class Area {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the side - ");
        int a=inp.nextInt();
        calarea obj1 = new calarea(a);
        System.out.print("Enter the lenght and breadth - ");
        int l=inp.nextInt();
        int b=inp.nextInt();
        calarea obj2 = new calarea(l,b);
    }
}
