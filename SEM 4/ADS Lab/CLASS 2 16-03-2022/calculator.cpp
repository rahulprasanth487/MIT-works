#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;


class calculator
{
   public:
       int a,b;

       void get()
       {
           cout<<"Enter the numbers = ";
           cin>>a>>b;
       }

        void sum();
        void subtract();
        void multiply();
        void divide();
        void power();
};


void calculator::sum()
{
    cout<<"Sum = "<<a+b;
}

void calculator::subtract()
{
    cout<<"Subtract = "<<a-b;
}

void calculator::multiply()
{
    cout<<"Product = "<<a*b;
}

void calculator::divide()
{
    cout<<"Division = "<<a/b;
}

void calculator::power()
{
    cout<<a<<" to the power of "<<b<<" is "<<pow(a,b);
}


int main()
{
    cout<<"1.ADD\n2.SUBTRACT\n3.MULTIPLICATION\n4.DIVISION\n5.POWER"<<endl;


    while(1)
    {
        calculator usr;

        //users



        int choice,a,b;
        cout<<"\nEnter the choice = ";
        cin>>choice;
        if(choice==0) break;


        //getting the input
        usr.get();

        switch(choice)
        {
            case 1:
                usr.sum();
                break;
            case 2:
                usr.subtract();
                break;
            case 3:
                usr.multiply();
                break;
            case 4:
                usr.divide();
                break;
            case 5:
                usr.power();
                break;
            default:
                cout<<"Wrong choice";
                break;
        }
    }

    return 1;
}
