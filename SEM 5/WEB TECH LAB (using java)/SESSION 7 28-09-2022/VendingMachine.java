import java.io.*;
import java.util.*;

interface Reseting
{
      public void reset();
}


abstract class Vend implements Reseting
{
      public int choco_cnt=50,snk_cnt=10,nut_cnt=50,juice_cnt=10;
      public static int tot_amount=0;
      public int given_amt=0;
      final int chocolate=10,snack=25,nuts=50,juice=20;
      public void reset()
      {
            this.tot_amount=0;
            this.given_amt=0;
            choco_cnt=50;snk_cnt=10;nut_cnt=50;juice_cnt=10;
            System.out.println("\nResetted Sucessfully\nThank you for visiting!!!");
      }

}

class Access extends Vend{}

class NotPaidFullAmoutException extends Exception
{
      public NotPaidFullAmoutException(String str)
      {
            super(str);
      }
}


class NoSufficientChangeException extends Exception
{
      public NoSufficientChangeException(String str)
      {
            super(str);
      }
}

class SoldOutException extends Exception {
      public SoldOutException(String str) {
            super(str);
      }
}


class VendingMachineJava
{
      void display()
      {
            System.out.println("-----------VENDING MACHINE------------");
            System.out.println("Coins Accestable are 1,5,10,25,50");
            System.out.println("Price list: \n1.Chocolate = (10), 2.Snack = (25), 3.Nuts = (50), 4.Juice = (20) 111.Exit");
      }

      public static void main(String[] args)
      {
            Access obj=new Access();
            Scanner inp=new Scanner(System.in);
            new VendingMachineJava().display();

            while(true)
            {
                  
                  try{

                        int n;
                        System.out.println("Enter the items number = ");
                        n = inp.nextInt();

                        if (n == 111)
                              break;

                        switch (n) {
                              case 1:
                                    obj.choco_cnt -= 1;
                                    Vend.tot_amount += obj.chocolate;
                                    break;
                              case 2:
                                    obj.snk_cnt -= 1;
                                    Vend.tot_amount += obj.snk_cnt;
                                    break;
                              case 3:
                                    obj.nut_cnt -= 1;
                                    Vend.tot_amount += obj.nuts;
                                    break;
                              case 4:
                                    obj.juice_cnt -= 1;
                                    Vend.tot_amount += obj.juice;
                                    break;
                        }

                        if(obj.choco_cnt<=0||obj.juice_cnt<=0||obj.nut_cnt<=0||obj.snk_cnt<=0)
                        {
                              throw new SoldOutException("Out of STOCK\n");
                        }
                  }
                  catch(SoldOutException ex)
                  {
                        System.out.println("Exception = "+ex.getMessage());
                  }
            }



            System.out.println("\nAmount Need to pay = "+Vend.tot_amount);


            while (true) {
                  
                  try{
                        System.out.println("Enter the amount = ");
                        int x = inp.nextInt();

                        if (x == 111)
                              break;
                        if(x==1||x==5||x==10||x==25||x==50)
                        {
                              obj.given_amt += x;
                        }
                        else{
                              throw new NoSufficientChangeException(
                                          "\nPlease enter the correct change!!!\n" + obj.given_amt);
                        }
                  }
                  catch (NoSufficientChangeException ex) {
                        System.out.println("Exception = " + ex.getMessage());
                  }
                  
            }


            try
            {
                  if(Vend.tot_amount-obj.given_amt>0)
                  {
                        throw new NotPaidFullAmoutException("You have not paid the full amount");
                  }
                  else if(Vend.tot_amount - obj.given_amt ==0)
                  {
                        System.out.println("Thank you|||");
                        return;
                  }
                  else
                  {
                        System.out.println("Remaining amount to collect = "+Math.abs( Vend.tot_amount - obj.given_amt));
                  }
            }
            catch(NotPaidFullAmoutException ex)
            {
                  System.out.println("Exception = " + ex.getMessage());
            }

            obj.reset();

      }


}