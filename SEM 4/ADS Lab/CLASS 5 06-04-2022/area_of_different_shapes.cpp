#include <iostream>
#define PI 3.14
using namespace std;

class shapes
{
    public:
        void area(float r)
        {
            cout<<"Area of the circle = "<<r*PI<<endl;
        }

        void area(int l,int b)
        {
            cout<<"Area of the rectangle = "<<l*b<<endl;
        }

        void area(double l)
        {
            cout<<"Area of the hexagon = "<<((3*1.732)/2)*l<<endl;
        }
};



int main()
{
    shapes s;
    s.area(4.5f);
    s.area(9,8);
    s.area(5.4);

    return 1;

}