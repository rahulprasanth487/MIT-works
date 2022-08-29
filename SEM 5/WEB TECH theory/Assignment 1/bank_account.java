import java.util.Scanner;

public class bank_account{
    long acc_no,mob;
    float balance=1000;
    String Name;
    Scanner inp=new Scanner(System.in);

    void getdetails()
    {
        System.out.print("Enter the Name = ");
        Name=inp.nextLine();
        System.out.print("Enter the Acc number = ");
        acc_no=inp.nextLong();
        System.out.print("Enter the Mobile number = ");
        mob=inp.nextLong();

    }
    void display()
    {
        System.out.println("\n----------------------------");
        System.out.println("Name = "+Name);
        System.out.println("Account number = "+acc_no);
        System.out.println("Mobile number = "+mob);
        System.out.println("Current balance = "+balance);
        System.out.println("----------------------------\n");
    }

    void credit()
    {
        System.out.print("Enter the amount to deposit - ");
        balance+=inp.nextFloat();
    }

    void debit()
    {
        System.out.print("Enter the amount to withdraw - ");
        float amt=inp.nextFloat();
        if(amt<balance){ balance-=amt;}
        else{System.out.println("Insufficient Balance\n");}
       
    }

    public static void main(String[] args)
    {
        bank_account obj=new bank_account();
        obj.getdetails();
        while(true){
            System.out.print("Enter the choice = ");
            int ch=obj.inp.nextInt();
            switch(ch)
            {
                case 1:
                    obj.display();
                    break;
            
                case 2:
                    obj.credit();
                    break;

                case 3:
                    obj.debit();
                    break;
            }
            if(ch==0) break;
        }
        
    }
}
