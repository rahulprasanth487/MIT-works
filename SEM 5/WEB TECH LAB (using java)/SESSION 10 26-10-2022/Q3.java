import java.util.*;
import java.lang.*;

class thread1 extends Thread 
{
      int val;
      public void run()
      {
            Random rand=new Random();
            val=rand.nextInt(100);
      }
      public int get()
      {
            return val;
      }
}

class thread2 extends Thread
{
      int val;
      public void set(int x){val=x;}
      public void run()
      {
      }
      public void compute()
      {
            if(val%2==0)
            {
                  System.out.println(val+" -even- "+Math.pow(val,2));
            }
            else{
                  System.out.println(val + " -odd- " + Math.pow(val, 1));
            }
      }
}

public class Q3
{
      public static void main(String[] args)
      {
            for(int i=0;i<10;++i){
                  thread1 t1=new thread1();
                  Thread thr1 = new Thread(t1);

                  thr1.start();

                  try{thr1.join();}
                  catch(Exception e) {System.out.println("Exceptio occured");}


                  int z=t1.get();


                  thread2 t2 = new thread2();
                  Thread thr2 = new Thread(t2);
                  thr2.start();
                  
                  try {
                        thr2.join();
                  } catch (Exception e) {
                        System.out.println("Exceptio occured");
                  }
                  t2.set(z);
                  t2.compute();
            }
      }
}
