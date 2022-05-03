#include <iostream>

using namespace std;

class FD {
    protected:
        int amt=10000;
    public:
        virtual void interest()=0;
};

class SBI:public FD {
    public:
        void interest(){
            cout<<"The interest for "<<amt<<" in SBI is = "<<amt*0.04<<endl; ///1%
        }
};
class IOB:public FD {
    public:
        void interest(){
            cout<<"The interest for "<<amt<<" in IOB is = "<<amt*0.06<<endl; ///1%
        }
};
class IB :public FD {
    public:
        void interest(){
            cout<<"The interest for "<<amt<<" in Indian Bank is = "<<amt*0.05<<endl; ///1%
        }
};

int main()
{
    SBI sb;
    IOB iob;
    IB ib;
    sb.interest();
    iob.interest();
    ib.interest();

    return 1;
}