
import java.util.*;

interface Payable
{
      public static double getPaymentAmount=0;
}

class Employee implements Payable
{
      String f_name,l_name,social_Security_number;

      void getDetails()
      {
            Scanner inp=new Scanner(System.in);
            System.out.println("Enter the first ans last name and security number = ");
            f_name=inp.nextLine();
            l_name=inp.nextLine();
            social_Security_number=inp.nextLine();
      }
}


class Invoice implements Payable
{
      String Part_no,past_due;int quantity; double priceperitem;
      void getDetails()
      {
            Scanner inp = new Scanner(System.in);
            System.out.println("Enter the quantity ans price per item - ");
            quantity=inp.nextInt();
            priceperitem=inp.nextDouble();

            Payable.getPaymentAmount+=quantity*priceperitem;
      }
}

class Commisioner extends Employee
{
      double grosssales,commision_rate;
}

class Hourly extends Employee
{
      double hours,wage;
}

class Salaried extends Employee
{
      double weeklysalary;
}


class Basepluscommision extends Employee
{
      double base_salary;
}


public class Employee_interface {
      public static void main(String[] args)
      {

      }
}
