#include <iostream>
#include <ios>
#include <limits>

using namespace std;

class emp
{
    public:
        int id;
        string name;
        float sal;
        float tax;

    //18% tax means
        emp()
        {
            cin.ignore(numeric_limits<streamsize>::max(),'\n');
            cout<<"Enter the name = ";
            getline(cin,name);
            cout<<"Enter the salary = ";
            cin>>this->sal;
            cout<<"Enter your ID = ";
            cin>>id;
            this->tax = 0.18*sal;
        }
        emp(float s,string nm,int id)
        {
            this->sal=s;
            this->name=nm;
            this->id=id;
            this->tax = 0.18*s;
        }

        void display()
        {
            cout<<"Name = "<<name<<endl;
            cout<<"id = "<<id<<endl;
            cout<<"Salary = "<<sal<<endl;
            cout<<"Tax = "<<tax<<endl;
        }
};

int main()
{
    int n;
    cout<<"Enter the total number of employees = ";
    cin>>n;

    emp * obj;
    obj = new emp[n];
    for(int i=0;i<n;++i)
    {
        obj[i].display();
    }

    return 0;

}