#include <iostream>

using namespace std;

class library
{
      public:
            string b_name;
            int delayed_days;

            library()
            {
                  cout<<"Enter the name of the book = ";
                  cin.ignore();
                  cout.flush();
                  getline(cin,b_name);

                  cout<<"Enter the total number of delayed days = ";
                  cin>>delayed_days;
            }

            friend ostream &operator<<(ostream &output,const library &obj)
            {
                  if(obj.delayed_days>0)
                  {
                        output<<"Total fine amount = "<<obj.delayed_days*10<<" for "<<obj.delayed_days<<" days \n\n";
                  }
                  else{
                        output<<"No fine \n\n";
                  }

                  return output;
            }

            friend istream &operator>>(istream &input,library obj)
            {
                  cout << "Enter the name of the book = ";
                  cin.ignore();
                  cout.flush();
                  getline(input,obj.b_name);

                  cout << "Enter the total number of delayed days = ";
                  input >>obj.delayed_days;

                  return input;
            }
};
int main()
{
      library lb1;
      cout<<lb1;
      lb1.delayed_days=0;
      cin>>lb1;
      cout<<lb1;

}
