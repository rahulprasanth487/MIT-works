#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define maxsize 20

int block[maxsize+1],index_table[maxsize+1];
int b_n,n;

void display()
{
	for(int i=1;i<maxsize+1;++i)
	{
		printf(" %d ",block[i]);
		if(i>=5&&i%5==0) printf("\n");
	}
}


int index_display()
{
	
	printf("Enter the block number = ");
	scanf("%d",&b_n);
	
	if(b_n>maxsize)
	{
		printf("\nInvalid Block number\n");
	}
	else
	{
		if(block[b_n]==0){
			int c=0;
			printf("Enter the total number of blocks = ");
			scanf("%d",&n);

				for(int i=0;i<n;++i)
				{
					printf("File #%d = ",i+1);
					scanf("%d",&index_table[i]);
				}

				for(int i=0;i<n;++i)
				{
					
					if(index_table[i]>maxsize)
					{
						printf("\nMaximum LImit exceeded\n");
						return 1;
					}
					else if(block[index_table[i]]==0) c++;
				}
					
			
				if(c==n)
				{
					for(int i=0;i<n;++i)
					{
						block[index_table[i]]=1;
						printf("Block %d allocated\n",index_table[i]);
					}
				}

				else
				{
					printf("\nAlready allocated not free\n");
				}
			
		}
		else
		{
				printf("\nAlready allocated to the blocks\n");
		}	
	}
	
	return 0;
	
}


int main()
{
	//allocatingn values
	for(int i=1;i<maxsize+1;++i)
	{
		block[i]=0;
	}
	
	char ch[100];
	
	while(1)
	{
		printf("\n----BEFORE MODIFYING----	\n");
		display();
		int x=index_display();
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

