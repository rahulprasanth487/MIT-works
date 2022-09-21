/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_5;

import java.util.*;

class Train_journey
{
    static String start,terminating;
    int journey_time;
    
    void Set_start(String start){ this.start=start;}
    void Get_start(String termination){this.terminating=termination;}
    void Get_journey_time()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the total journey time = ");
        this.journey_time=inp.nextInt();
    }
}


class Freight extends Train_journey
{
    final int capacity=200;int carriages;
    boolean hazard;
    Scanner inp=new Scanner(System.in);
    
    
    void getParent()
    {
        String start,end;
        System.out.print("Enter the starting point - ");
        start=inp.nextLine();
        System.out.print("Enter the ending point - ");
        end=inp.nextLine();
        
        super.Set_start(start);
        super.Get_start(end);
        super.Get_journey_time();
        
    }
    
    
    void set_hazard()
    {
        System.out.print("Is it hazardous? true/false= ");
        this.hazard=inp.nextBoolean();
        if(hazard==true) System.out.println("Hazardous materials are not allowed\n");
    }
    
    void get_capacity()
    {
        System.out.print("capacity = "+capacity+" tonnes");
    }
}


class Passenger extends Train_journey
{
    int first_class,carriages;
    boolean catering;
    Scanner inp=new Scanner(System.in);
    
    void get_first_class()
    {
        System.out.print("Enter the first class number = ");
        this.first_class=inp.nextInt();
    }
    
    void addCarraiges(int x)
    {
        if(carriages<x) System.out.println("You can't carry more than the capacity\n");
        this.carriages=x;
    }
    
    void In_service()
    {
        System.out.print("Whether the catering services are available true/false");
        this.catering=inp.nextBoolean();
    }
}


public class Train {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        Freight frt=new Freight();
        Passenger psr=new Passenger();
        
        
        frt.getParent();
        
        System.out.println("\nFREIGHT DETIALS->\n");
        frt.set_hazard();
        frt.get_capacity();
        
        System.out.println("\n\nPASSENGER DETIALS->\n");
        psr.get_first_class();
        System.out.print("Enter the total number of carriages = ");
        psr.addCarraiges(inp.nextInt());
        psr.In_service();
    }
}
