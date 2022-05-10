#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>


char const *Prime_check(int x)
{
	for(int i=2;i<=x/2;++i)
	{
		if(x%i==0)
		{
			return "It is not a prime number\n"
;		}
	}
	
	return "It is a Prime number\n";	
}



int main()
{
	int r;
	int p[2];
	char buffer[1024];
	
	r=pipe(p);
	
	char const *str;
	
	printf("Enter the number to check = ");
	scanf("%s",str);
	
	if(r<0)
	{
		printf("Pipe is not created\n");
	}
	
	write(p[1],str,sizeof(str));
	
	read(p[0],buffer,sizeof(str));
	
	printf("The received value is %s\n",buffer);
	
	int value=atoi(buffer);
	
	printf("%s",Prime_check(value));
	
	return 1;
}







