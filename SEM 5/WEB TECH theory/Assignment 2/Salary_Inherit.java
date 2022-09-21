

import java.util.*;


class Member
{
    public String name,address;
    protected int mobile,age,salary;
    
    Member()
    {
        Scanner inp =new Scanner(System.in);
        System.out.print("Name = ");
        this.name=inp.next();
        System.out.print("Age and mobile number = ");
        this.age=inp.nextInt();
        this.mobile=inp.nextInt();
        System.out.print("Salary = ");
        this.salary=inp.nextInt();
        System.out.print("Address = ");
        this.address=inp.next();
    }
    
    void display()
    {
        System.out.println("Name = "+name+"\nSalary = "+salary);
    }
}


class Employee extends Member
{
    String spec,dep;
    public Employee(String spec,String dep){
        this.spec=spec;
        this.dep=dep;
    }
    void Assign()
    {
        //Member obj=new Member();
        System.out.println("\n\nEmployee Details ----------> ");
        display();
        //super.display();
        System.out.println("Department = "+dep);
        System.out.println("Specialization = "+spec);
        
    }
    
}


class Manager extends Member
{
    String spec,dep;
    
    public Manager(String spec,String dep){
        this.spec=spec;
        this.dep=dep;
    }
    
    void Assign()
    {
        //Member obj=new Member();
        System.out.println("\n\nManager Details ------------> ");
        //super.display();
        display();
        System.out.println("Department = "+dep);
        System.out.println("Specialization = "+spec);
    }
    
}


public class Salary_Inherit {

    public static void main(String[] args) {
        String spec,dep;
        
       Scanner inp=new Scanner(System.in);
        //Emp
        System.out.print("Enter the Employee Specialization and department = ");
        spec=inp.nextLine();
        dep=inp.nextLine();
        
       
        Employee emp=new Employee(spec,dep);
        emp.Assign();
        
         //manager
        System.out.print("Enter the Manager Specialization and department = ");
        spec=inp.next();
        dep=inp.next();
        
        Manager man=new Manager(spec,dep);
        man.Assign();
    }
    
}
