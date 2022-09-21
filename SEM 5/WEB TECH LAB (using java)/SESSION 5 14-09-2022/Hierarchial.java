/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_5;

import java.util.*;


class Country
{
    String country;
    void assign()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the country name = ");
        this.country=inp.nextLine();
        System.out.println("Country  = "+country);
    }
}

class State extends Country
{
    String state;
    
    State()
    {
        super.assign();
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the State name = ");
        this.state=inp.nextLine();
    }
}

class City extends Country
{
    String city;
    
    City()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the City name = ");
        this.city=inp.nextLine();
    }
}

class Village extends Country
{
    String vill;
    
    Village()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the Village name = ");
        this.vill=inp.nextLine();
    }
}

public class Hierarchial {
    public static void main(String[] args)
    {
        System.out.println("State = "+new State().state);
        System.out.println("City = "+new City().city);
        System.out.println("Village = "+new Village().vill);
    }
}
