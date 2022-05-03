#include <iostream>
using namespace std;

template <typename T>


void swapping(T &x,T &y){
    T temp=x;
    x=y;
    y=temp;
}


int main()
{
    int x=10,y=20;
    float m=1.1,n=2.2;
    double l=111.111,j=222.2222;
    char a='A',b='B';
    string p=" Rahul ",q=" Prasanth ";

    cout << "Before swapping " << endl;
    cout << " x = " << x << " , y =" << y << endl;
    cout << " m = " << m << " , n =" << n << endl;
    cout << " l = " << l << " , j =" << j << endl;
    cout << " a = " << a << " , b =" << b << endl;
    cout << " p = " << p << " , q =" << q << endl;

    swapping<int>(x, y);
    swapping<float>(m, n);
    swapping<double>(l, j);
    swapping<char>(a, b);
    swapping<string>(p,q);

    cout << "\nAfter swapping " << endl;
    cout << " x = " << x << " , y =" << y << endl;
    cout << " m = " << m << " , n =" << n << endl;
    cout << " l = " << l << " , j =" << j << endl;
    cout << " a = " << a << " , b =" << b << endl;
    cout << " p = " << p << " , q =" << q << endl;
}