#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Bank
{
    static long long int accno;
    float balance=0;
    int mobile,age;
    public:
     string name;
        int trans=0;
        void newAccount();
        void Deposit();
        void Withdrawal();
        void balance_enq();
        void account_details();

        //deletion 
        ~Bank(){}
};

long long int Bank::accno=20021228000;

void Bank::newAccount()
{
    cout<<"Enter the Name = ";
    cin.clear();
    fflush(stdin);
    getline(cin,name);
    cout<<"Enter the mobile number = ";
    cin>>mobile;
    cout<<"Enter the age = ";
    cin>>age;
    accno =accno+1;

    cout<<"\nSuccessfully Created\n";
}


void Bank::Deposit()
{
    float amt;
    cout<<"Enter the amount = ";
    cin>>amt;
    balance+=amt;

    cout<<"\nSuccessfully Deposited\n"<<endl;

    trans++;

}

void Bank::Withdrawal()
{
    float amt;
    cout<<"Enter the amount to withdraw = ";
    cin>>amt;
    balance-=amt;

    cout<<"\nSuccessfully Withdrawed\n"<<endl;

    trans++;
}

void Bank::balance_enq()
{
    cout<<"Name = "<<name<<endl;
    cout<<"Current account balance = "<<balance<<endl;
}


void display()
{
    cout<<"\n----------------------------\n";
    cout<<"1.Open a account\n";
    cout<<"2.Deposit\n";
    cout<<"3.Withdraw\n";
    cout<<"4.Balance Enquiry\n";
    cout<<"5.Total number of transaction \n";
    cout<<"6.Delete Account\n";
    cout<<"7.Display account details"<<endl;
    cout<<"----------------------------\n";
}

void Bank::account_details()
{
    cout<<"Name = "<<name<<endl;
    cout<<"Account number = "<<accno<<endl;
    cout<<"Balance  = "<<balance<<endl;
    cout<<"Mobile number = "<<mobile<<endl;
    cout<<"Total number of transactions = "<<trans<<endl;
}


int main()
{
    int cnt=0;
    Bank A;
    display();

    while (1)
    {
        int choice;
        cout<<"Enter the choice = ";
        cin>>choice;
        
        switch (choice)
        {
            case 1:
                if(cnt!=0) cnt++;
                A.newAccount();
                break;

            case 2:
                A.Deposit();
                break;

            case 3:
                A.Withdrawal();
                break;

            case 4:
                A.balance_enq();
                break;
            case 5:
                cout<<"Total number of transaction = "<<A.trans<<endl;
                break;

            case 6:
                A.~Bank();
                cout<<"Account Successfully deleted\n";
                return 1;
                break;

            case 7:
                A.account_details();
                break;
        }


        if(choice==0) break;
    }
    
    return 0;
}
