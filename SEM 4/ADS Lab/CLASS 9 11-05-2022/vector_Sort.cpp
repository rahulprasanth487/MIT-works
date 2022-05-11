#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main()
{
	vector<int> arr;
	int n,ele;
	cout<<"Enter the total number of elements = ";
	cin>>n;
	
	for(int i=0;i<n;++i)
	{
		cout<<" = ";
		cin>>ele;
		arr.push_back(ele);
	}
	
	
	//unsorted
	cout<<"Unsorted vector = ";
	for(int i=0;i<n;++i)
	{
		cout<<arr[i]<<"  ";
	}
	
	
	//sorted in ascending
	sort(arr.begin(),arr.end());
	cout<<"\nSorted vector (ascending order)= ";
	for(int i=0;i<n;++i)
	{
		cout<<arr[i]<<"  ";
	}
	
	//sorted in descending
	sort(arr.begin(),arr.end(),greater<int>());
	cout<<"\nSorted vector (descending order)= ";
	for(int i=0;i<n;++i)
	{
		cout<<arr[i]<<"  ";
	}
	cout<<endl;
	
}
