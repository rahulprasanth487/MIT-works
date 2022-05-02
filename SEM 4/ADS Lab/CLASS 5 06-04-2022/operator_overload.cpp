
#include <iostream>
#include <stdio.h>
using namespace std;
class complex
{
      int real;
      float image;

public:
      void getdata()
      {
            cout << "\n enter the real and imaginary part = ";
            cin >> real>>image;
            
      }
      void operator+(complex);
      void operator-(complex);
};

void complex ::operator+(complex c1)
{
      complex temp;
      temp.real = real + c1.real;
      temp.image = image + c1.image;
      if (temp.image >= 0)
      {
            cout << "\n complex no. after addition :: ";
            cout << temp.real << "+" << temp.image << "i\n";
      }
      else
      {
            cout << "\n complex no. after addition :: ";
            cout << temp.real << temp.image << "i\n";
      }
}
void complex ::operator-(complex c1)
{
      complex temp;
      temp.real = real - c1.image;
      temp.image = image - c1.image;
      if (temp.image >= 0)
      {
            cout << "\n complex no. after subtraction :: ";
            cout<<temp.real
                 << "+" << temp.image << "i\n";
      }
      else
      {
            cout << "\n complex no. after subtraction :: ";
            cout << temp.real << temp.image << "i\n";
      }
}
int main()
{

      complex c1, c2;
      int n;
      c1.getdata();
      c2.getdata();
      c1+c2;
      c1-c2;
      return 0;
}