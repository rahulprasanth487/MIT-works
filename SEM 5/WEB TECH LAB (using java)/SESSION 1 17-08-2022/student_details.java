import java.util.Scanner;

public class student_details {
    long roll_no,mob;
    String name;

    void getdetails()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the Name = ");
        name=inp.nextLine();
        System.out.print("Enter the Roll number = ");
        roll_no=inp.nextLong();
        System.out.print("Enter the Mobile number = ");
        mob=inp.nextLong();
    }
    void display()
    {
        System.out.println("Name = "+name);
        System.out.println("Roll number = "+roll_no);
        System.out.println("Mobile number = "+mob);
    }

    public static void main(String[] args)
    {
        student_details obj=new student_details();
        obj.getdetails();
        obj.display();
    }
}
