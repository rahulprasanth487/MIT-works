#include <iostream>

using namespace std;

class Interest
{
      public:
            int Amount,w_d;
            static int Balance;

            void deposit()
            {
                  cout<<"Enter the amount to deposit = ";
                  cin>>Amount;
                  Balance+=Amount;
            }

            void withdraw()
            {
                  cout<<"Enter the amount to withdraw = ";
                  cin>>w_d;
                  Balance-=w_d;
            }
};

int Interest::Balance=0;

class SI:public Interest
{
      public:
            void show_si()
            {
                  cout<<"Acc balance = "<<Interest::Balance<<endl;
                  cout<<"Simple interest = "<<Interest::Balance*0.08<<endl;
            }

};


int main()
{
      SI si;

      cout<<"--------------------\n";
      cout<<"1.Deposit\n2.Withdraw\n3.Show Interest\n4.Balance\n";
      cout << "--------------------\n";

      while (true)
      {
           int ch;
           cout<<"Enter the choice = ";
           cin>>ch;

            if(ch==0) break;

            switch (ch)
            {
                  case 1:
                        si.deposit();
                        cout << "\nAccount Balance = " << Interest::Balance << "\n\n";
                        break;
                  case 2:
                        si.withdraw();
                        cout << "\nAccount Balance = " << Interest::Balance << "\n\n";
                        break;
                  case 3:
                        si.show_si();
                        cout << "\nAccount Balance = " << Interest::Balance << "\n\n";
                        break;
                  case 4:
                        cout<<"\nAccount Balance = "<<Interest::Balance<<"\n\n";
                        break;
            }
      }
      
      return 1;
}