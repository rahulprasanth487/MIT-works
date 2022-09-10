/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session4;

import java.util.*;

class Bk
{
    long accno;
    static float balance=1000;
    String name;
    
    Scanner inp =new Scanner(System.in);
    Bk(String name,long accno)
    {
        this.name=name;
        this.accno=accno;
    }
    
    void credit()
    {
            System.out.print("Enter the amount to deposit = ");
            float x=inp.nextFloat();
            this.balance+=x;
            System.out.println("Amount Deposited!\nCurrent balance - "+this.balance);
    }
    
    void debit()
    {
            System.out.print("Enter the amount to withdraw = ");
            float x=inp.nextFloat();
            this.balance-=x;
            System.out.println("Amount Debited!\nCurrent balance - "+this.balance);
    }
    
    void display()
    {
        System.out.println("Name = "+name);
        System.out.println("Acc no = "+accno);
        System.out.println("balance = "+balance);
    }
}


public class Bank {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter the name = ");
        String nm=inp.nextLine();
        System.out.println("Enter the Acc no = ");
        long acc=inp.nextLong();
        Bk obj=new Bk(nm,acc);
        obj.display();
        obj.credit();
        obj.debit();
        
    }
}
