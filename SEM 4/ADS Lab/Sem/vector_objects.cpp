#include <iostream>
#include <vector>
#include <string.h>
#include <stdlib.h>

using namespace std;

class CMS
{
      public:
            int credits;
            string sub_code,sub_name,staff_name;

            CMS()
            {
                  
                  cout<<"Enter the subject code = ";
                  cin>>sub_code;
                  cout<<"Enter the subject name = ";
                  cin>>sub_name;
                  cout<<"Enter the staff name = ";
                  cin>>staff_name;
                  cout<<"Enter the credits = ";
                  cin>>credits;
            }

            void modi()
            {
                  cout << "Enter the Modified subject code = ";
                  cin>>sub_code;
                  cout << "Enter the Modified subject name = ";
                  cin>> sub_name;
                  cout << "Enter the Modified staff name = ";
                  cin>> staff_name;
                  cout << "Enter the Modified credits = ";
                  cin >> credits;
            }

            void display()
            {
                  cout<<"Subject name = "<<sub_name<<endl;
                  cout<<"Subject code = "<<sub_code<<endl;
                  cout<<"Staff name = "<<staff_name<<endl;
                  cout<<"Credits = "<<credits<<endl;
            }

            string subjectcode() {return sub_code;}

};


vector<CMS> cms;
void addcourse()
{
      CMS c;
      cms.push_back(c);
}

void remove()
{

      string inp;
      int n = cms.size();
      cout<<"Enter the subject code = ";
      cin>>inp;

      for (int i = 0; i < n; i++)
      {
            if(cms[i].subjectcode()==inp)
            {
                  swap(cms[i],cms[n-1]);
            }
      }

      cms.pop_back();
      
}

void display()
{
      for (int i = 0; i < cms.size(); i++)
      {
            cms[i].display();
      }

      if(cms.size()==0) cout<<"Not subjects found";
}

void search()
{
      string inp;
      int n = cms.size();
      cout << "Enter the subject code to search = "; 
      cin>> inp;

      for (int i = 0; i < n; i++)
      {
            if (cms[i].subjectcode() == inp)
            {
                  cms[i].display();
            }
      }
}

void modify()
{
      string inp;
      int n = cms.size();
      cout << "Enter the subject code = ";
      cin>> inp;
      int flag=0;
      for (int i = 0; i < n; i++)
      {
            if (cms[i].subjectcode() == inp)
            {
                  cms[i].modi();
                  flag=1;
            }
            else{
                  flag=0;
            }
      }
      if(flag==0) cout<<"NOT FOUND\n";
}

int main()
{
      int ch;
      cout<<"1.ADD 2.REMOVE 3.SEARCH 4.MODIFY 5.DISPLAY\n";
      while (1)
      {
            cout<<"Enter the choice = ";
            cin>>ch;
            switch (ch)
            {
            case 1:
                  addcourse();
                  break;
            case 2:
                  remove();
                  break;
            case 3:
                  search();
                  break;
            case 4:
                  modify();
                  break;
            case 5:
                  display();
                  break;
            
            default:
                  return 1;
                  break;
            }
      }

      return 1;
      
}