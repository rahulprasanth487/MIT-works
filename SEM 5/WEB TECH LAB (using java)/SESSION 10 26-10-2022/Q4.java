import java.util.*;
import java.lang.*;

class Th1 extends Thread {
      public void run() {
            for (char i = 'A'; i <= 'Z'; ++i) {
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        System.out.println("Interrupt occurs in thread 1");
                  }
                  System.out.print(i + " ");
            }
      }
}

class Th2 extends Thread {
      public void run() {
            for (char i = 'Z'; i >= 'A'; --i) {
                  try {
                        Thread.sleep(2000);
                  } catch (InterruptedException e) {
                        System.out.println("Interrupt occurs in thread 1");
                  }
                  System.out.print(i + " ");
            }
      }
}

public class Q4 {
      public static void main(String[] args) {

            Th1 thread1 = new Th1();
            Th2 thread2 = new Th2();
            thread1.start();
            thread2.start();

            System.out.println("Waiting for execution of one thread = ");
            Th1 thread3 = new Th1();
            Th2 thread4 = new Th2();
            thread1.start();
            try {
                  thread3.join();
            } catch (Exception e) {
                  System.out.println("Exceptio occured");
            }
            thread4.start();

      }

}