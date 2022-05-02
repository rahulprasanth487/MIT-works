#include <iostream>

using namespace std;

class Sample
{
    private:
        static int a;
    public:
        Sample()
        {
            a++;
        }


    static int cnt()
    {return a;}
};

int Sample::a;

int main()
{
    Sample a,b,c,d;

    cout<<"Total number of objects = "<<Sample::cnt();

    return 1;
}