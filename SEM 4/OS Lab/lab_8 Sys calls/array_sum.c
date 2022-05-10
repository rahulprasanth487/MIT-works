#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
int main()
{
	int sum=0;
	int Array[]={1,2,3,4,5,6,7,8,9,10};
	int id;
	
	id=fork();
	if(id<0)
	{
		printf("Error...\n");
		exit(0);
	}

	else if(id==0)
	{
		printf("Child process is calling ..\n");
		for(int i=0;i<sizeof(Array)/sizeof(Array[0]);++i)
		{
			sum+=Array[i];
		}
		printf("\nSum of the array = %d\n",sum);
		
	}
	else 
	{
		wait(NULL);
		printf("Parent process is calling...\n");
		
	}
	return 1;
}
