#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>

int main()
{
	int p[2];
	int r=pipe(p);
	char buffer[1024];
	//p[1] to write
	//p[0] to read
	
	char const *str1="Hello This is Rahul Prasanth D\n";
	char const *str2="I am creating pipes to connect\n";
	
	unsigned int len=strlen(str1);
	
	if(r<0)
	{
		printf("Error in creating pipe");
		exit(0);
	}
	

	write(p[1],str1,strlen(str1));
	write(p[1],str2,strlen(str1));
	//above will write the string into the buffer storage
	
	//Now to read the strings 
	read(p[0],buffer,sizeof(buffer));
	
	printf(" %s ",buffer);
	
	return 1;		
}