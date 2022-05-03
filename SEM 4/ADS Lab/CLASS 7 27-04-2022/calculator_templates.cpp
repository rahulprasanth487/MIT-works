#include <iostream>
#include <math.h>
using namespace std;

template <typename T>
class calculator
{
      public:
            T a,b,n;
            calculator(){}

            calculator(T a,T b){
                  this->a=a;
                  this->b=b;
            }

            calculator(T n){this->n=n;}


            T sum(){return a+b;}
            T minus(){return a-b;}
            T multiply(){return a*b;}
            T divide(){return a/b;}
            void power(){cout<< pow(a,b)<<endl;}
            void sqr_root(){cout<< sqrt(n)<<endl;}
};


template <typename T>
void call()
{
      T a, b;
      cout << "Enter the numbers = ";
      cin >> a >> b;

      calculator<T> obj1(a, b);

      cout << "\nChoose \n1.Addition\n2-subtraction\n3-Multiplication\n4-Division\n5-Power\n6-Square root\n";
      
      while (true){
            int ch;
            cout<<"Enter the choice = ";
            cin>>ch;

            if(ch==0) break;

            switch (ch)
            {
                  case 1:
                        cout << obj1.sum() << endl;
                        break;
                  
                  case 2:
                        cout << obj1.minus() << endl;
                        break;
                  
                  case 3:
                        cout << obj1.multiply() << endl;
                        break;
                  
                  case 4:
                        cout << obj1.divide() << endl;
                        break;
                  
                  case 5:
                        obj1.power();
                        break;

                  case 6:
                        T x;
                        cout<<"\nEner the number = ";
                        cin>>x;
                        calculator<T> ob(x);
                        ob.sqr_root();
                        break;
            }
      }
}

int main()
{
      cout<<"Choose 1 if integer else choose 2 for float = ";
      int ch;
      cin>>ch;

      if(ch==1) call<int>();
      else call<float>();
      
}