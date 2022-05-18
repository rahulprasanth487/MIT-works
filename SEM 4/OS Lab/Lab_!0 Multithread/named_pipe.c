#include <stdio.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <string.h>
#include <fcntl.h>

void createPipe(char const *str1,char const *str2,char const *str3)
{
	int fp;
	//this is the file pointer
	
	fp=open("text.txt",O_CREAT|O_WRONLY,0777);

	write(fp,str1,strlen(str1));
	write(fp,str2,strlen(str2));
	write(fp,str3,strlen(str3));

	printf("\nThree messages were sent to named pipe\n");	
	
	close(fp);
}

void receive(char const *str1,char const *str2,char const *str3)
{
	char b1[100],b2[100],b3[100];
	int fp=open("text.txt",O_RDONLY);
	read(fp,b1,strlen(str1));
	read(fp,b2,strlen(str2));
	read(fp,b3,strlen(str3));

	printf("\nThe messages are\n");
	printf("%s\n",b1);
	printf("%s\n",b2);
	printf("%s\n",b3);

	close(fp);
}


int main()
{
	char const *str1="This is the first string\n";
	char const *str2="This is the second string\n";
	char const *str3="This is the third string\n";
	createPipe(str1,str2,str3);
	receive(str1,str2,str3);
}
