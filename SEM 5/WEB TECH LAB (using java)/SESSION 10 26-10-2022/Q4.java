import java.util.*;
import java.lang.*;

class Print extends Thread {
      void AZprint() {
            try {
                  for (int i = 0; i < 26; i++) {
                        Thread.sleep(1000);
                        System.out.print((char) (65 + i));
                  }
                  System.out.println();
            } catch (Exception e) {
                  System.out.println(e);
            }
      }

      void ZAprint() {
            try {
                  for (int i = 0; i < 26; i++) {
                        Thread.sleep(2000);
                        System.out.print((char) (90 - i));
                  }
                  System.out.println();
            } catch (Exception e) {
                  System.out.println(e);
            }
      }
}

class ThreadDemo extends Thread {
      String name;
      Print p;

      ThreadDemo(String name, Print p) {
            this.name = name;
            this.p = p;
      }

      public void run() {
            try {
                  synchronized (p) {
                        if (name.equals("thread 1"))
                              p.AZprint();
                        else if (name.equals("thread 2"))
                              p.ZAprint();
                  }
            } catch (Exception e) {
                  System.out.println(e);
            }
      }
}

public class Q4 {
      public static void main(String[] args) {
            Print p = new Print();
            ThreadDemo t1 = new ThreadDemo("thread 1", p);
            ThreadDemo t2 = new ThreadDemo("thread 2", p);
            t1.start();
            t2.start();
      }
}
