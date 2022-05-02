
#include <iostream>

using namespace std;

int fact(int x)
{
    if(x<=1) return 1;
    else return x*fact(x-1);
}

int main()
{
    int n;
    cout<<"Enter the number = ";
    cin >>n;
    
    cout<<fact(n);

    return 0;
}