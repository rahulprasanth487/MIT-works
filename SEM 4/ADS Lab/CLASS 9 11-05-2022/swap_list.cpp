#include <iostream>
#include <forward_list>

using namespace std;

int main()
{
	forward_list<int> list1={1,2,3,4,5};
	forward_list<int> list2={10,20,30,40,50};
	
	cout<<"Before Swapping:\nList 1 = ";
	for(auto i:list1)
	{
		cout<<i<<"  ";
	}
	
	cout<<"\nBefore Swapping:\nList 2 = ";
	for(auto i:list2)
	{
		cout<<i<<"  ";
	}
	
	
	//swapping
	swap(list1,list2);
	
	
	cout<<"\nAfter Swapping:\nList 1 = ";
	for(auto i:list1)
	{
		cout<<i<<"  ";
	}
	
	cout<<"\nAfter Swapping:\nList 2 = ";
	for(auto i:list2)
	{
		cout<<i<<"  ";
	}
	
}
