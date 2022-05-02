#include <iostream>

using namespace std;

class Interest
{
      public:
            int Amount;
            static int Balance;

            void deposit()
            {
                  cout<<"Enter the amount to deposit = ";
                  cin>>Amount;
                  Balance+=Amount;
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
      si.deposit();
      si.show_si();
      si.deposit();
      si.show_si();
      return 1;
}