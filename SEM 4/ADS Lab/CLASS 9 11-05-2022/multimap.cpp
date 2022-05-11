#include <bits/stdc++.h>
#include <algorithm>
#include <vector>
#include <map>
#include <iterator>

using namespace std;

void display(multimap<int,int> mp)
{
	multimap<int,int>::iterator it;
	
	for(it=mp.begin();it!=mp.end();++it)
	{
		cout<<"Key = "<<it->first<<"   Value = "<<it->second<<endl;
	}
	cout<<endl;
}

void U_display(unordered_multimap<int,int> mp)
{
	unordered_multimap<int,int>::iterator it;
	
	for(it=mp.begin();it!=mp.end();++it)
	{
		cout<<"Key = "<<it->first<<"   Value = "<<it->second<<endl;
	}
	cout<<endl;
}

int main()
{
	multimap<int,int> mp;
	mp.insert(pair<int,int>(1,10));
	mp.insert(pair<int,int>(2,100));
	mp.insert(pair<int,int>(4,1000));
	mp.insert(pair<int,int>(21,105));
	mp.insert(pair<int,int>(3,103));
	mp.insert(pair<int,int>(10,102));
	mp.insert(pair<int,int>(2,101));
	mp.insert(pair<int,int>(6,109));
	
	cout<<"SORTED MULTIMAP: \n";
	display(mp);
	
	cout<<"Totally "<<mp.erase(2)<< " values are erased\n\n";
	display(mp);
	
	
	//-------------------------------------------------------------------------------------------
	
	//UNSORTED MULTIMAP
	cout<<"\nUNSORTED MULTIMAP: \n";
	unordered_multimap<int,int> u_mp(mp.begin(),mp.end());
	U_display(u_mp);
	
	cout<<"\nTotal elements with key 10 is "<<u_mp.count(10)<<endl;
	
	return 1;
}
