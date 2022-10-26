import java.util.*;
import java.lang.*;

class Th1 extends Thread
{
      public void run()
      {
            for (int i = 0; i < 10; ++i) {
            try{
                  Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                  System.out.println("Interrupt occurs in thread 1");
            }
            System.out.println("HELLO");}
      }
}

class Th2 extends Thread {
      public void run() {
            for (int i = 0; i < 10; ++i) {
            try {
                  Thread.sleep(2000);
            } catch (InterruptedException e) {
                  System.out.println("Interrupt occurs in thread 1");
            }
            System.out.println("WEAR MASK ! ");}
      }
}

class Th3 extends Thread {
      public void run() {
            for (int i = 0; i < 10; ++i) {
            try {
                  Thread.sleep(5000);
            } catch (InterruptedException e) {
                  System.out.println("Interrupt occurs in thread 1");
            }
            System.out.println("USE SANITIZER !");}
      }
}

public class Q1
{
      public static void main(String[] args)
      {
            
                  Th1 thread1 = new Th1();
                  Th2 thread2 = new Th2();
                  Th3 thread3 = new Th3();
                  thread1.start();
                  thread2.start();
                  thread3.start();
      }

}