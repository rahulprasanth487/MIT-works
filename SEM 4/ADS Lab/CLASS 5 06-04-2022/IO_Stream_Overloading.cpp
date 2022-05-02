#include <iostream>
using namespace std;

class temp
{
      public:
            int x;
            temp(int x1)
            {
                  x=x1;
            }

            void operator<<(temp ob)
            {
                cout<<"Enter the value of x = ";
                cin>>x>>ob.x;  
            }

            void operator>>(temp ob)
            {
                  cout<<"\nThe entered number are "<<x<<" and "<<ob.x<<endl;
            }
};

int main()
{
      temp o1(10);
      temp o2(10);

      //<< is used for showing O/P, here we used to get input
      o1<<o2;
      //>> to show the values;
      o1>>o2;

      return 1;
}