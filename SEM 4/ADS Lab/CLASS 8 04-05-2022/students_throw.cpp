#include <iostream>
#include <string.h>
#include <string>
#include <cstdlib>
using namespace std;

class Student
{
      public:
            string name;
            int marks;
            int mobile;

            Student()
            {
                  cout<<"Enter the name of the student = ";
                  cin>>name;
                  cout<<"Enter the mobile number = ";
                  cin>>mobile;
                  cout<<"Enter the marks = ";
                  cin>>marks;
            }

            int length(int x)
            {
                  int len=0;
                  while(x>0)
                  {
                        int r=x%10;
                        len++;
                        x/=10;
                  }
                  return len;
            }

            void check()
            {
                  //int y=0;
                  try
                  {
                        try
                        {
                              if (marks < 0)
                                    throw 2;
                        }
                        catch(int y)
                        {
                              cout << "\nEnter the correct marks\n";
                        }

                        if (length(mobile) != 10)
                        {
                              throw 1;
                        }
                  }


                  catch(int y)
                  {

                        cout<<"\nEnter a 10 digit mobile number !\n";
                  }
            }     
};

int main()
{
      Student st;
      st.check();


      return 1;
}