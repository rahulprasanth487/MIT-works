#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXSIZE 20

int block[MAXSIZE+1];
int b_n,n;

void display()
{
	for(int i=1;i<MAXSIZE+1;++i)
	{
		printf(" %d ",block[i]);
		if(i>=5&&i%5==0) printf("\n");
	}
}


void sequence()
{
	
	printf("Enter the block number = ");
	scanf("%d",&b_n);
	
	if(b_n>MAXSIZE)
	{
		printf("\nInvalid Block number\n");
	}
	else
	{
		if(block[b_n]==0){
			int c=0;
			printf("Enter the total number of blocks = ");
			scanf("%d",&n);
		
			if(block[b_n]!=0)
			{	
				printf("\nMemory already allocated\n");
			}
			else
			{	
				for(int i=b_n;i<b_n+n;++i)
				{
					if(block[i]==0) c++;
				}
			
				if(c==n)
				{
					for(int i=b_n;i<b_n+n;++i)
					{
						block[i]=1;
						printf("Block %d allocated\n",i);
					}
				}
			
				else if(b_n+n>MAXSIZE)
				{
					printf("\nMaximum LImit exceeded\n");
				}
			
				else
				{
					printf("\nAlready allocated\n");
				}
			}
		}
		else
		{
				printf("\nAlready allocated to the blocks\n");
		}	
	}
	
}


int main()
{
	//allocatingn values
	for(int i=1;i<MAXSIZE+1;++i)
	{
		block[i-1]=0;
	}
	
	char ch[100];
	
	while(1)
	{
		printf("\n----BEFORE MODIFYING----	\n");
		display();
		sequence();
		printf("----AFTER MODIFYING----	\n");
		display();
		
		printf("DO u want to continue ? Yes/No = ");
		scanf("%s",ch);
		
		if(strcmp(ch,"yes")==0||strcmp(ch,"Yes")==0||strcmp(ch,"YES")==0)
	 		continue;
	
		else{
			printf("\nThank you\n\n");
			exit(0);
		}
	}	
	return 1;
}

