#include <iostream>
using namespace std;

class def
{
    public:
        void print(int x,int y=98)
        {
            cout<<x<<" "<<y<<endl;
        }
};


int main()
{
    def cls;
    cls.print(10);
    cls.print(10,20);
    
    return 1;
}