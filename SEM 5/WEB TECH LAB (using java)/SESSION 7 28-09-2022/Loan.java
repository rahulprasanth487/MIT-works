/*
 * 2. Calculate EMI for personal loan of Rs100000/- with the
 * rate of interest:13% for a total of 3 years, if there is no balance in the
 * account to pay an EMI raise a custom exception also
 * use try catch finally mechanism.
 */


 /*
  * 

  Formula:
  EMI= p*r*((1+r)^n / (1+r)^n -1)
  p-priciple amount
  r-rate
  n-no of months

  */

  import java.io.*;
  import java.util.*;

import javax.naming.InitialContext;

  class InsufficientBalanceException extends Exception
  {
      public InsufficientBalanceException(String str)
      {
            super(str);
      }
  }

  class Loan
  {
      double EMI(int p,double r,int n)
      {
            return p*r*((Math.pow(1+r, n))/((Math.pow(1+r,n))-1));
      }
      public static void main(String[] args)
      {
            double balance=50000;
            int p=100000;
            double r=0.13;
            int n=3;
            try{
                  double ans=new Loan().EMI(p,r,n);
                  if(ans>balance) throw new InsufficientBalanceException("Insufficient Balance");
                  else{
                        balance-=ans;
                  }
                  System.out.printf("Current Balance = %.2f" ,balance);
            }
            catch(InsufficientBalanceException ae)
            {
                  System.out.println("Exception : "+ae.getMessage());
            }
            finally
            {
                  System.out.printf("EMI for 3 years = %.2f",new Loan().EMI(p,r,n));
            }
      }
  }