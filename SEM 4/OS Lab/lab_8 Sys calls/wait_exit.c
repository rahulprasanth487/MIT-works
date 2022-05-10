#include <stdio.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int main()
{
	pid_t id;
	if(fork()==0)
	{
		printf("Child process in calling....");
		exit(0);
	}
	else
	{
		id=wait(NULL);
		printf("\nParent process is executing....");
		printf("\nParent PID\t: %d\n", getppid());
		printf("Child PID\t: %d\n", id);
	}

	return 1;
}

