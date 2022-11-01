
import java.util.*;
public class WT11 {
    int Stock=5;
    synchronized void consume(int val)
    {
        if(this.Stock<val)
        {
            System.out.println("Stock is insufficient");
            try{wait();this.Stock-=val;}
            catch(Exception e){}
            //now it will call the next thread
        }
        else
        {
            this.Stock-=val;
        }
    }
    synchronized void addStock(int val)
    {
        this.Stock+=val;
        System.out.println("Stock is added");
        notify();
        //now it will notify the previous thread to execute
 
    }
    
    public static void main(String[] args) {
        WT11 obj=new WT11();
        
        Thread thr=new Thread(
                new Runnable()
                {
                    public void run(){obj.consume(94);}
                }
        );
        
        Thread thr2=new Thread(
                new Runnable()
                {
                    public void run(){obj.addStock(100);}
                }
        );
        
        
        System.out.println("Current stock value - "+obj.Stock);
        
        thr.start();
        thr2.start();
        try{
            thr.join();
            thr2.join();
        }
        catch(Exception e){}
        
        //if we didn't use join the below statement will execute before the thread execution
        
        //beacause of join the statement is printed after the execution of the threads
        System.out.println("Current stock value after consuming - "+obj.Stock);
       
    }
    
}
