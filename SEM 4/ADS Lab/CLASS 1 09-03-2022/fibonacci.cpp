#include <iostream>

using namespace std;

int main()
{
    int n;
    cout<<"Enter the number = ";
    cin>>n;
    int i=0;
    
    
    int a=0;
    int b=1;
    cout<<a<<"\n"<<b<<"\n";
    while(i<n)
    {
        
        
        int c=a+b;
        a = b;
        b=c;
        
        cout<<c<<endl;
        i++;
    }
    
    return 1;
}