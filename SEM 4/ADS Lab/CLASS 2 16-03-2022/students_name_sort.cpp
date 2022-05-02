#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>


using namespace std;

class student
{
    public:
        vector<string> names;

        void add(string nam)
        {
            names.push_back(nam);
        }

};


 void display(vector <string> v)
     {

        for(int i=0;i<v.size();++i)
        {
            cout<<"\n"<<v[i];
        }
    }


int main()
{
    student st;
    while(1)
    {
        vector<string> vec;
        string nam;

        cout <<"\nEnter the name = ";
        getline(cin,nam);

        if(nam!="exit")
            st.add(nam);

        vec=st.names;

        sort(vec.begin(),vec.end());

        display(vec);
        if (nam == "exit")
            break;
    }
    return 1;
}
