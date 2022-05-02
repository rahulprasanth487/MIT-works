#include <iostream>
using namespace std;

class rect
{
    int l,b;
    public:
        rect(int a,int c)
        {
            l=a;
            b=c;
        }

        int rectan() {return l*b;}
};

int main()
{
    int l,b;
    cout<<"Enter the length and breadth = ";
    cin>>l>>b;

    rect r(l,b);

    cout<<"\nArea of the rectangle = "<<r.rectan()<<endl;

    return 1;
}
