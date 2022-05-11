#include <bits/stdc++.h>
#include <vector>
#define MAX_SIZE 5

using namespace std;

int main()
{
	vector<int> stack;
	
	cout<<"-----------------------------------\n";
	cout<<"1.Push into the stack\n2.Pop out of the stack\n3.Display the stack";
	cout<<"\n-----------------------------------\n";
	
	while(1)
	{
		int ch,ele;
		cout<<"Enter the choice = ";
		cin>>ch;
		
		if(ch==0)
		{
			cout<<"\nThank you\n";
			break;
		}
		
		switch(ch)
		{
			case 1:
				cout<<"Enter the element = ";
				cin>>ele;
				if(stack.size()>=MAX_SIZE)
				{
					cout<<"\nStack is already full\n";
				}
				else
				{
					stack.push_back(ele);
				}
				break;
				
			case 2:
				if(stack.size()<=0)
				{
					cout<<"\nStack is Empty\n";
				}
				else
				{
					stack.pop_back();
				}
				break;
				
			case 3:
				cout<<"\nTop of the element of the stack is = "<<stack.back()<<endl;

				for(auto i:stack)
				{
					cout<<"| "<<i<<" |"<<endl;
				}
				break;
					
		}
	}
	
	return 1;
}



























