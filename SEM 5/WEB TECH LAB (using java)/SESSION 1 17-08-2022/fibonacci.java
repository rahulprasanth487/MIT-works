import java.util.*;  //used to include the all util packages includes Scanner for user input

public class fibonacci
{
	public static void main(String[] args)
	{
		System.out.println("Enter the value = :");
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		System.out.println("Fibonacci Series:");
		
		int a=0,b=1,c;
		for(int i=0;i<n;++i)
		{
			System.out.print(" "+a);
			c=a+b;
			a=b;
			b=c;
		}
	}
}