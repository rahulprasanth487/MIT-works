#include <iostream>
using namespace std;

void swap_value(int a,int b)
{
    a=a^b;
    b=a^b;
    a=a^b;
   
}

void swap_pointers(int* a,int* b)
{
    *a=*a^*b;
    *b=*a^*b;
    *a=*a^*b;

}
void swap_reference(int& a,int& b)
{
    a=a^b;
    b=a^b;
    a=a^b;

}


int main()
{
    int a,b;
    cout<<"Enter the values of a and b = ";
    cin>>a>>b;
    cout << "A=" << a << " B=" << b << endl;
    swap_value(a,b);
     cout<<"A="<<a<<" B="<<b<<endl;
    swap_reference(a,b);
     cout<<"A="<<a<<" B="<<b<<endl;
    swap_pointers(&a,&b);
     cout<<"A="<<a<<" B="<<b<<endl;
    return 1;
}