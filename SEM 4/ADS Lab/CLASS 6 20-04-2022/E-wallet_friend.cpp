#include <iostream>

using namespace std;

class wallet2;

class wallet1
{
      public:
            static int balance1;
            int amt;
            void deposit()
            {
                  cout<<"Enter the amount to deposit in walllet 1 = ";
                  cin>>amt;
                  balance1+=amt;
            }

            void withdraw()
            {
                  cout << "Enter the amount to withdraw in walllet 1 = ";
                  cin >> amt;
                  balance1 -= amt;
            }

            friend void compare(wallet1 w1,wallet2 w2);
};

class wallet2
{
      public:
            static int balance2;
            int amt;
            void deposit()
            {
                  cout << "Enter the amount to deposit in wallet 2= ";
                  cin >> amt;
                  balance2 += amt;
            }

            void withdraw()
            {
                  cout << "Enter the amount to withdraw in walllet 2 = ";
                  cin >> amt;
                  balance2 -= amt;
            }

            friend void compare(wallet1 w1, wallet2 w2);
};

int wallet1::balance1=0;
int wallet2::balance2=0;


void compare(wallet1 w1, wallet2 w2)
{
      if(w1.balance1>w2.balance2)
      {
            cout<<"Wallet 1 has more money than wallet 2\n";
            cout<<"Balance of wallet 1 = "<<w1.balance1<<"\n";
            cout<<"Balance of wallet 2 = "<<w2.balance2<<"\n\n";
            
      }
      else{
            cout << "Wallet 2 has more money than wallet 1\n\n";
            cout << "Balance of wallet 1 = " << w1.balance1 << "\n";
            cout << "Balance of wallet 2 = " << w2.balance2 << "\n\n";
      }
}


int main()
{
      wallet1 w1;
      wallet2 w2;
      while (true)
      {
           int amt,wal;
           cout<<"Choose the wallet to deposit = ";
           cin>>wal;
           if(wal==0) break;
           else if(wal==1)
           {
                 w1.deposit();
                 compare(w1,w2);

                 w1.withdraw();
                 compare(w1,w2);
           }
           else
           {
                 w2.deposit();
                 compare(w1,w2);

                 w1.withdraw();
                 compare(w1, w2);
           }
      }
}