#include <iostream> 
using namespace std;

class overload
{
    public:

        void print(float y)
        {
            cout<<"Float value is printed "<<y<<endl;
        }

        void print(double z)
        {
            cout<<"Double value is printed = "<<z<<endl;
        }
};

int main()
{
    overload clas;
    clas.print(111.111f);
    clas.print(10.2);
}