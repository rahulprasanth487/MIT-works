/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;

import java.util.*;
public class Condition {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the numbers - ");
        int a=inp.nextInt();
        int b=inp.nextInt();
        System.out.println("(a<100 and a>b) = "+((a<100 && a>b)==true));
    }
}
