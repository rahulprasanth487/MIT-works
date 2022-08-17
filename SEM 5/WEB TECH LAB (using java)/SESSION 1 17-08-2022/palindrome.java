import java.util.*;

public class palindrome
{
	boolean ispalin(int n){
		int rem,rev=0,i=0,temp=n;
		while(temp>0){
			rem=temp%10;
			rev=rev*10+rem;
			temp=temp/10;
		}
		boolean ans=(n==rev)?true:false;
		return ans;
	}

	public static void main(String[] args)
	{
		Scanner inp=new Scanner(System.in);
		palindrome obj= new palindrome();
		System.out.print("Enter the number = ");
		int n=inp.nextInt();	
		if(obj.ispalin(n)){System.out.print("It's palindrome");}
		else{System.out.print("Not a palindrome");}
	}
}	