import java.lang.reflect.Array;
import java.util.*;

import javax.sound.sampled.SourceDataLine;

class Details {
      String name, author;
      int borrow;

      Details(String name, String author, int borrow) {
            this.name = name;
            this.author = author;
            this.borrow = borrow;
      }

      void display() {
            System.out.println("Name = " + name);
            System.out.println("Author = " + author);
            System.out.println("Borrow status = "+borrow);
      }
}

public class Library {

      void update(ArrayList<Details> arr,String name)
      {
            int siz=arr.size();
            for(int i=0;i<siz;++i)
            {
                  System.out.println(arr.get(i).name);
                  if((arr.get(i).name).equals(name)){
                        if(arr.get(i).borrow==0) arr.get(i).borrow=1;
                        else System.out.println("Already Book is borrowed");
                        return;
                  }
                  else{
                        System.out.println("Book is not available");
                        return;
                  }
            }
      }


      void List(ArrayList<Details> arr)
      {
            System.out.println("\n\nBorrowed Books:");
            for(int i=0;i<arr.size();++i)
            {
                  if(arr.get(i).borrow==1) arr.get(i).display();
            }


            System.out.println("\n\nAvailable Books:");
            for (int i = 0; i < arr.size(); ++i) {
                  if (arr.get(i).borrow == 0)
                        arr.get(i).display();
            }
      }

      public static void main(String[] args)
      {
            ArrayList<Details> arr = new ArrayList<Details>();
            System.out.println("Choice list: ");
            System.out.println("1.Insert a book \n2.Borrow a book\n3.Display");
            Library obj=new Library();
            while(true)
            {
                  Scanner inp = new Scanner(System.in);
                  System.out.print("\n\nEnter the choice - ");
                  int ch=inp.nextInt();
                  if(ch==111) break;

                  String name,author;
                  switch(ch)
                  {
                        case 1:
                              System.out.print("Name of the book = ");
                              name=inp.next();
                              System.out.print("Name of the author = ");
                              author=inp.next();
                              Details det=new Details(name,author,0);
                              arr.add(det);
                              System.out.println("New book added");
                              break;

                        case 2:
                              System.out.print("Name of the book = ");
                              String Name=inp.next();
                              obj.update(arr, Name);
                              break;

                        case 3:
                              obj.List(arr);
                              break;

                        default:
                              System.out.println("Wrong choice");
                  }
            }

      } 

}
