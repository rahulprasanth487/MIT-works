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
	
	int n;
	printf("Enter the number of messages to sent = ");
	scanf("%d",&n);
	
	//memory allocation for the string
	char *str=(char *)malloc(sizeof(char *));
	
	
	for(int i=0;i<n;i++)
	{
		
		printf("Enter the messages to send = ");
		scanf("%s",str);
		
		write(p[1],str,50);
		
		printf("One message is sent\n");

		
		c++;
	}
	
	printf("Totally %d were sent\n",c);
	
	printf("-------------------------------\n");
	printf("The sent messages are \n");
	printf("-------------------------------\n");
	
	for(int i=0;i<n;++i)
	{
		read(p[0],buffer,50);
		printf("%s\n",buffer);
	}
	
	return 1;
}
















