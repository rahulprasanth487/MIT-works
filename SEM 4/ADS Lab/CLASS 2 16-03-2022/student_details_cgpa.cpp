#include <iostream>
#include <vector>
#include <numeric>
using namespace std;


class StudentsDB
{
    public:
        int roll_no,sem;
        int s1,s2,s3,s4,s5,cr1,cr2,cr3,cr4,cr5;
        string name;
        vector<float> gpa_arr;

        StudentsDB(string nme,int roll,int sub_1,int sub_2,int sub_3,int sub_4,int sub_5,int cred_1,int cred_2,int cred_3,int cred_4,int cred_5)
        {
            name = nme;
            roll_no=roll;
            s1=sub_1;
            s2=sub_2;
            s3=sub_3;
            s4=sub_4;
            s5=sub_5;
            cr1=cred_1;
            cr2=cred_2;
            cr3=cred_3;
            cr4=cred_4;
            cr5=cred_5;
        }

        float gpa();

};

 float StudentsDB::gpa()
{
    float tot = ((s1*cr1)+(s2*cr2)+(s3*cr3)+(s4*cr4)+(s5*cr5))/(cr1+cr2+cr3+cr4+cr5);
    return tot;
}



int grade_points(int m)
{
    if(m<100&&m>=90) return 10;
    else if(m<90&&m>=80) return 9;
    else if(m<80&&m>=70) return 8;
    else if(m<70&&m>=60) return 7;
    else if(m<60&&m>=50) return 6;
    else return 0;
}



int main()
{

    vector<float> temp;

    int roll_no;
    int s1,s2,s3,s4,s5,cr1,cr2,cr3,cr4,cr5;
    string name,department;

    while (1)
    {
        cout.flush();
        cout << "\nName of the student = ";
        getline(cin, name);
        cout << "Roll Number = ";
        cin >> roll_no;

        cout << "Enter subject 1 marks and its credits = ";
        cin >> s1 >> cr1;
        cout << "Enter subject 2 marks and its credits = ";
        cin >> s2 >> cr2;
        cout << "Enter subject 3 marks and its credits = ";
        cin >> s3 >> cr3;
        cout << "Enter subject 4 marks and its credits = ";
        cin >> s4 >> cr4;
        cout << "Enter subject 5 marks and its credits = ";
        cin >> s5 >> cr5;

        StudentsDB stud(name, roll_no, grade_points(s1), grade_points(s2), grade_points(s3), grade_points(s4), grade_points(s5), cr1, cr2, cr3, cr4, cr5);

        cout << name << " = " << stud.gpa();
        stud.gpa_arr.push_back(stud.gpa());



        int choice;
        cout<<"Do you want to continue?1/0 = ";
        cin>>choice;

        temp=stud.gpa_arr;

        if(choice==0) break;
    }
    
    cout<<"Name = "<<name<<endl;
    printf("CGPA = %.2f",accumulate(temp.begin(),temp.end(),0.0)/temp.size());
   
    
    return 1;
}
