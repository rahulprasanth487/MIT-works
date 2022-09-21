/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_5;

import java.util.*;


class Details
{
    String name,dep;
    int gpa;
    
    void getDetails()
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the name = ");
        this.name=inp.next();
        System.out.print("Enter the department = ");
        this.dep=inp.next();
        System.out.print("Enter the GPA= ");
        this.gpa=inp.nextInt();
    }
}

public class Student {
    void delete(ArrayList<Details> arr,String name)
    {
        for(int i=0;i<arr.size();++i)
        {
            if((arr.get(i).name).equals(name))
            {
                arr.remove(i);
                System.out.println("\nStudent successfully removed||\n");
            }
        }
    }
    
    
    void display(ArrayList<Details> arr)
    {
        for(int i=0;i<arr.size();++i)
        {
            System.out.println("Name = "+arr.get(i).name);
            System.out.println("Department = "+arr.get(i).dep);
            System.out.println("gpa = "+arr.get(i).gpa);
            System.out.println("\n");
        }
    }
    
    ArrayList<Details> groupadd()
    {
        Scanner inp=new Scanner(System.in);
        ArrayList<Details> arr2=new ArrayList<Details>();
        System.out.println("Enter the number of students= ");
        int n=inp.nextInt();
        
        for(int i=0;i<n;++i)
        {
            Details obj=new Details();
            obj.getDetails();
            arr2.add(obj);
        }
        return arr2;
    }
    
    void find(ArrayList<Details> arr,String name)
    {
        int flag=0;
        for(int i=0;i<arr.size();++i)
        {
            if((arr.get(i).name).equals(name))
            {
                flag=1;
                System.out.println("\nStudent is present\n");
                return;
            }
        }
        if(flag==0) System.out.println("Student is not in the list\n");
    }
    
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        ArrayList<Details> arr=new ArrayList<Details>();
        System.out.println("Choice List");
        System.out.println("1.Insert a student\n2.Insert a group of students\n3.remove a student\n4.find \n5.Display\n111 to exit");
        
        while(true)
        {
            System.out.print("Enter the choice = ");
            int ch=inp.nextInt();
            if(ch==111) break;
            Student own=new Student();
            switch(ch)
            {
                case 1:
                    Details obj=new Details();
                    obj.getDetails();
                    arr.add(obj);
                    System.out.println("Student Added succesfully");
                    break;
                  
                case 2:
                    arr.addAll(own.groupadd());
                    System.out.println("All are added Succssfuly");
                    break;
                case 3:
                      System.out.print("Enter the name = ");
                     own.delete(arr, inp.next());
                     break;
                case 4:
                    System.out.print("Enter the name to search = ");
                     own.find(arr, inp.next());
                     break;
                case 5:
                        own.display(arr);break;
                default:
                        System.out.println("Wrong choice");
                        break;
            }
        }
    }
}
