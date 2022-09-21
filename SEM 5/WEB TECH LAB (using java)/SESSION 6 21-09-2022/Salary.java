/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.pkg6;

import java.util.*;

interface Payable
{
    public double getPaymentAmount(double wage,double hours,double weeklysal,double grosssales,double comm);
}


class Employee implements Payable
{
    String f_name,l_name,socialSecuritynumber;
    
    public double getPaymentAmount(double wage,double hours,double weeklysal,double grosssales,double comm)
    {
        double t1=wage*hours;
        double t2= grosssales*comm;
        
        return t1+t2+weeklysal;
    }
    
    void disp()
    {
        System.out.println("Name = "+f_name+" "+l_name);
        System.out.println("Social Security number = "+socialSecuritynumber);
    }
}




class Invoice implements Payable
{
    String PartNo,partDescription;
    int qty;
    double pricePeritem;
    public double getPaymentAmount(double wage,double hours,double weeklysal,double grosssales,double comm)
    {
        double t1=wage*hours;
        double t2= grosssales*comm;
        
        return t1+t2+weeklysal;
    }
    
    void disp()
    {
        System.out.println("Quantity = "+qty);
        System.out.println("Price per item - "+pricePeritem);
    }
}


class CommisionEmployee extends Employee
{
    double grossSales,commisionRATE;
}

class HourlyEmployee extends Employee
{
    double wage,hours;
}

class BaseplusCommision extends CommisionEmployee 
{
    double baseSalary;
}

public class Salary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double wage, hours,weeklysal,grosssales,comm,basepay;
        Scanner inp=new Scanner(System.in);
        Employee obj1=new Employee();
        Invoice obj2=new Invoice();
        System.out.print("Enter the first name and lastname = ");
        obj1.f_name=inp.nextLine();
        obj1.l_name=inp.nextLine();
        System.out.print("Enter the social security number = ");
        obj1.socialSecuritynumber=inp.nextLine();
        
        
        System.out.print("Quantity and price per item = ");
        obj2.qty=inp.nextInt();
        obj2.pricePeritem=inp.nextDouble();
        
        
        
        System.out.print("Enter the wage = ");
        wage=inp.nextDouble();
        System.out.print("Enter the hours = ");
        hours=inp.nextDouble();
        System.out.print("Enter the weeklysal = ");
        weeklysal=inp.nextDouble();
        System.out.print("Enter the grosssales = ");
        grosssales=inp.nextDouble();
        System.out.print("Enter the commision rate = ");
        comm=inp.nextDouble();
        System.out.print("Enter the basepay = ");
        basepay=inp.nextDouble();
        
        obj1.disp();obj2.disp();
        System.out.println("Total salary - "+(obj1.getPaymentAmount(wage, hours, weeklysal, grosssales, comm)+basepay));
    }
    
}
