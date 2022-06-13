#include <bits/stdc++.h>
using namespace std;

class cls
{
      int x;
      public:
            cls(int x){this->x=x;}
            void operator *(cls ob)
            {
                  cout<<"The multiplied values are = "<<x*ob.x;
            }
};

int main()
{
      cls obj(109);
      cls obj2(990);
      obj*obj2;

      return 1;
}