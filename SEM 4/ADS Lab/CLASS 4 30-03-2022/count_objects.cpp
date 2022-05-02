#include <iostream>


using namespace std;

class cls
{
    static int count;
    public:

        cls()
        {count++;}

        //destroying
        ~cls(){
            count--;
        }

        static void ret();
};

int cls::count=0;
void cls::ret()
{
    cout<<"Total objects = "<<count<<endl;
}

int main()
{
    cls a;
    a.ret();
    cls b;
    b.ret();
    cls c;
    c.ret();
    cls d;
    d.ret();
    return 0;
}