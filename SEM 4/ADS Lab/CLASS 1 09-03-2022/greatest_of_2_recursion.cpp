#include <iostream>

using namespace std;

int Greatest(int a, int b,int x,int y)
{
    if(a==0) return y;
    else if(b==0) return x;
    return Greatest(--a,--b,x,y);
}

int main()
{
    int a,b;
    
    cout<<"Enter the 2 number a b = ";
    cin>>a>>b;
    
    cout<<"Greatest of 2 numbers = "<<Greatest(a,b,a,b);

    return 0;
}