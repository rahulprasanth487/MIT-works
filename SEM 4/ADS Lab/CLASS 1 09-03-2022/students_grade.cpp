#include <iostream>
#include <string.h>
using namespace std;

struct students
{

  string name;

  int roll_no;

  int math, phy, chem;
};

int main()
{
  struct students stud;
  cout << "Enter the name = ";

  string nam;

  getline(cin, stud.name);

  cout << "Enter the roll number = ";

  cin >> stud.roll_no;

  cout << "Enter math marks = ";

  cin >> stud.math;

  cout << "Enter phy marks = ";

  cin >> stud.phy;

  cout << "Enter chem marks = ";

  cin >> stud.chem;

  int tot = stud.chem + stud.math + stud.phy;

  if (tot >= 90)
    cout << "A";

  else if (tot > 80 && tot < 90)
    cout << "B";

  else if (tot < 80 && tot > 70)
    cout << "C";

  else
    cout << "Lower grades";
}
