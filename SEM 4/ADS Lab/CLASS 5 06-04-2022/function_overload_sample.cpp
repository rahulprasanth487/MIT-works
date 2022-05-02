#include <iostream> 
using namespace std;

class overload
{
    public:
        void print(int x)
        {
            cout<<"Integer x is printed "<<x<<endl;
        }

        void print(char y)
        {
            cout<<"character is printed "<<y<<endl;
        }

        void print(double z)
        {
            cout<<"Double value is printed = "<<z<<endl;
        }
};

int main()
{
    overload clas;
    clas.print(10);
    clas.print('z');
    clas.print(10.2);
}