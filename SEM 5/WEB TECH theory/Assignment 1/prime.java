import java.util.*;

class prime
{
	int prime(int n)
	{
		for(int i=2;i<n/2;++i)
		{
			if(n%i==0){return 0;}
		}
		return 1;
	}

	public static void main(String[] args)
	{
		prime obj=new prime();
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the number = ");
		int num=in.nextInt();
		int out=obj.prime(num);

		if(out==0){System.out.println("Not a prime number");}
		else{System.out.println("It is a prime number");}
	}
}