#include <iostream>
using namespace std;

class Bank 
{	
	public:
		virtual void deposit()=0;
		virtual void withdrawal()=0;
};

class SBI:public Bank
{
	public:
		int amt,balance=10000;
		
		void deposit()
		{
			cout<<"Enter the amount to deposit in SBI = ";
			cin>>amt;
			balance+=amt;
			
			cout<<"Balance amount in SBI = "<<balance<<endl;
		}
		
		void withdrawal()
		{
			if(balance<amt||balance<0) {cout<<"\nYou cant withdraw\n";}
			else
			{
			cout<<"Enter the amount to withdraw = ";
			cin>>amt;
			balance-=amt;
			
			cout<<"Balance amount in SBI = "<<balance<<endl;}
		}
};

class IOB:public Bank
{
	public:
		int amt,balance=15000;
		
		void deposit()
		{
			cout<<"Enter the amount to deposit IOB = ";
			cin>>amt;
			balance+=amt;
			
			cout<<"Balance amount in IOB = "<<balance<<endl;
		}
		
		void withdrawal()
		{
			if(balance<amt||balance<0) {cout<<"\nYou cant withdraw\n";}
			else
			{
			cout<<"Enter the amount to withdraw = ";
			cin>>amt;
			balance-=amt;
			
			cout<<"Balance amount in IOB = "<<balance<<endl;}
		}
};

class IB:public Bank
{
	public:
		int amt,balance=20000;
		
		void deposit()
		{
			cout<<"Enter the amount to deposit into Indian Bank = ";
			cin>>amt;
			balance+=amt;
			
			cout<<"Balance amount in Indian Bank = "<<balance<<endl;
		}
		
		void withdrawal()
		{

			if(balance<amt||balance<0) {cout<<"\nYou cant withdraw\n";}
			else
			{
			cout<<"Enter the amount to withdraw = ";
			cin>>amt;
			balance-=amt;
			
			cout<<"Balance amount in Indian Bank = "<<balance<<endl;}
		}
};


int option()
{
	int x;
	cout<<"Choose 1 to deposit else choose 2 to withdraw = ";
	
	cin>>x;
	
	return x;
}


int main()
{

	Bank *acc1=new SBI();
	Bank *acc2=new IOB();
	Bank *acc3=new IB();
	
	cout<<"----------------------\n";
	cout<<"1.SBI\n2.IOB\n3.Indian Bank\n";
	cout<<"----------------------\n";
	
	while(true)
	{
		int ch;
		cout<<"Choose the account to deposit or withdraw = ";
		cin>>ch;
		if(ch==0) break;

		int op=option();
		switch(ch)
		{
			case 1:
				if(op==1) acc1->deposit();
				else if(op==2){acc1->withdrawal();}
				break;
				
			case 2:
				if(op==1) acc2->deposit();
				else if(op==2){acc2->withdrawal();}
				break;
				
			case 3:
				if(op==1) acc3->deposit();
				else if(op==2){acc3->withdrawal();}
				break;
			default:
				cout<<"Wrong choice\n";
				break;
		}
	
	}
	
	
	return 1;
	
	
}



