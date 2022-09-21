

import java.util.*;

class Book
{
    String name,publisher;
    int year,edition;
    double price;
    void SetDetails()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the book name = ");
        name=inp.next();
        System.out.print("Enter the Publisher name = ");
        publisher=inp.next();
        System.out.print("Enter the published year and edition = ");
        year=inp.nextInt();
        edition=inp.nextInt();
        System.out.print("Price = ");
        price=inp.nextDouble();
    }
    void Display()
    {
        System.out.println("DETAILS ------>");
    }
}

class Tech extends Book
{
        void Display()
        {
            System.out.println("\n\n TECH BOOK : ");
            SetDetails();
            System.out.println("Name = "+name);
            System.out.println("Publisher name = "+publisher);
            System.out.println("Published year = "+year);
            System.out.println("Edition = "+edition);
            System.out.println("Price = "+price);
        }
}

class NonTech extends Book
{
        void Display()
        {
            System.out.println("\n\nNON TECH BOOK : ");
            SetDetails();
            System.out.println("Name = "+name);
            System.out.println("Publisher name = "+publisher);
            System.out.println("Published year = "+year);
            System.out.println("Edition = "+edition);
            System.out.println("Price = "+price);
        }
}


public class Polymorphism {
    public static void main(String[] args)
    {
        Book obj1=new Tech();
        Book obj2=new NonTech();
        obj1.Display();
        obj2.Display();
    }
}
