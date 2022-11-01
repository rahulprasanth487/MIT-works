import java.util.*;
import java.lang.*;

class Th_1 extends Thread {
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

class Th_2 extends Thread {
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

            Th_1 thread1 = new Th_1();
            Th_2 thread2 = new Th_2();
            thread1.start();
            thread2.start();

            System.out.println("Waiting for execution of one thread = ");
            Th_1 thread3 = new Th_1();
            Th_2 thread4 = new Th_2();
            thread1.start();
            try {
                  thread3.join();
            } catch (Exception e) {
                  System.out.println("Exceptio occured");
            }
            thread4.start();

      }

}