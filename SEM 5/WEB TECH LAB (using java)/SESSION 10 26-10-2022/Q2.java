import java.util.*;
import java.lang.*;


class Thr extends Thread{
      public void run(){
            try{
            Thread.sleep(10000);
            }catch(Exception e){System.out.println("exception occured");}
            System.out.println("Content 1");
      }
}

class Thr2 extends Thread {
      public void run() {
            System.out.println("Content 2");
      }
}
public class Q2 {
      public static void main(String[] args)
      {
            Thr2 t1 = new Thr2();
            Thr2 t2 = new Thr2();
            Thr t3 = new Thr();
            Thr t4 = new Thr();
            Thr t5 = new Thr();
            

            //current pri = 5 for all thread

            t1.setPriority(10);
            t2.setPriority(10);

            System.out.println("Priorities:");
            System.out.println("Thread 1 = " + t1.getPriority());
            System.out.println("Thread 2 = " + t2.getPriority());
            System.out.println("Thread 3 = " + t3.getPriority());
            System.out.println("Thread 4 = " + t4.getPriority());
            System.out.println("Thread 5 = " + t5.getPriority());

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();


            try{
                  t1.sleep(1000);
                  t2.sleep(1000);
            }catch(Exception e){System.out.println("Exception occured");}

            if (t1.isAlive())
                  System.out.println("Thread 1 is alive - " + t1.currentThread().getId());

            if (t2.isAlive())
                  System.out.println("Thread 2 is alive - " + t2.currentThread().getId());

            if (t3.isAlive())
                  System.out.println("Thread 3 is alive - " + t3.currentThread().getId());

            if (t4.isAlive())
                  System.out.println("Thread 4 is alive - " + t4.currentThread().getId());

            if (t5.isAlive())
                  System.out.println("Thread 5 is alive - " + t5.currentThread().getId());
            

            
      }
}
