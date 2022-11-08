

import java.util.*;

class AddAmount
{
    static float amount = 500;
    AddAmount()
    {
        System.out.println("No amount is deposited");
    }
    AddAmount(float x)
    {
        amount+=x;
        System.out.println("Amount is deposited");
    }
}

public class MoneyBx {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        new AddAmount();
        System.out.print("Enter the amount = ");
        new AddAmount(inp.nextFloat());
        
        System.out.println("Account Balance = "+AddAmount.amount);
    }
}
