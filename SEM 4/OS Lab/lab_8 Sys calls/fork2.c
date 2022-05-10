#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

void print()
{
	for(int i=1;i<11;++i)
	{
		printf(" %d ",i);
	}
}

int main()
{
	int id;
	id=fork();
	
	if(id>0)
	{
		printf("Parent process is calling ...\n");
	}
	
	else if(id==0)
	{
		printf("Child process is calling ...\n");

	}
	else
	{
		printf("\nError in creating child\n");	
	}
	
	printf("Value from 1 to 10 is = \n");
	
	print();
	
	printf("\n Main ended\n");
	
}
