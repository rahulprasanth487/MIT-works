/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;
import java.util.*;


class Lib
{
    String name;
}


public class Library_management {
    int cnt=0;
    String insert()
    {
        Library_management ob=new Library_management();
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the name - ");
        String name=inp.nextLine();
        ob.cnt++;
        return name;
        
    }
    
    void borrow()
    {
        Library_management ob=new Library_management();
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the name - ");
        String name=inp.nextLine();
        ob.cnt--;
    }
    
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        Lib[] obj= new Lib[10];
        Library_management ob=new Library_management();
        for(int i=0;i<10;++i)
        {
            obj[i].name=ob.insert();
        }
        
        System.out.println("Total Books = "+ob.cnt);
        
        
        System.out.print("Want to borrow book 1/0 - ");
        int choice=inp.nextInt();
        if(choice==1) 
        {
            ob.borrow();
        }
        
        
    }
}
