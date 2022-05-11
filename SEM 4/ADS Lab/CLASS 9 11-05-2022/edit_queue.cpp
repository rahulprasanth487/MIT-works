#include <iostream>
#include <queue>

using namespace std;


void display(queue<string> q,int size)
{
	for(int i=0;i<size;++i)
	{
		string temp=q.front();
		q.pop();
		cout<<temp<<"  ";
		q.push(temp);
	}
	cout<<endl;
}


int main()
{
	queue<string> q;
	q.push("milk");
	q.push("coffee");
	q.push("sugar");
	q.push("water");
	int size=q.size();
	cout<<"Before editing:\n";
	display(q,size);
	
	for(int i=0;i<size;++i)
	{
		string temp=q.front();
		q.pop();
		if(temp=="coffee") q.push("tea");
		else q.push(temp);
		
		
	}
	cout<<endl;
	
	cout<<"After editing:\n";
	display(q,size);
}


