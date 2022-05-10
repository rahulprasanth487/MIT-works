#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
int main()
{
	int r,s=0;
	static int c=0;
	int p[2];
	r=pipe(p);
	char buffer[1024];
	
	if(r<0) printf("Error in creating pipe\n");
	
	//memory allocation for the string
	char *str=(char *)malloc(sizeof(char *));
	
	int id=fork();
	if(id<0) printf("Error in forking\n");
	else if(id==0)
	{
		printf("Child called:\nEnter the string = ");
		scanf("%s",str);
		
		write(p[1],str,100);
		printf("Message sent\n");
	}
	
	else
	{
		read(p[0],buffer,100);
		printf("\nParent called:\n%s",buffer);
	}
	
	return 1;
}
















