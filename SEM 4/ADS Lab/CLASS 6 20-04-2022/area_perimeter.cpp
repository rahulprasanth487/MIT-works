#include <iostream>

using namespace std;

class Cube
{
      public:
            int l;
            int b;
            int h;

            Cube()
            {
                  cout<<"Enter l b h = ";
                  cin>>l>>b>>h;

                  cout << "Lenght = " << l << " Breadth = " << b << " Height = " <<h<<endl;
            }
};

class Area:public Cube
{
      public:
            Area()
            {
                  cout<<"Area of the cube is = "<<6*(l*b)<<endl;
            }
};

class Volume :public Area
{
      public:
            Volume()
            {
                  cout << "Volume of the cube is = " <<l*b*h<<endl;
            }
};

class perimeter:public Volume{
      public:
            perimeter()
            {
                  cout<<"Perimeter of the cube is = "<<2*(l*b+b*h+l*h)<<endl;
            }
};


int main()
{
      perimeter p;

      return 1;
}