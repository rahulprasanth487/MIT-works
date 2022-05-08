#include <iostream>
#include <string>

using namespace std;

int main()
{
      string Time;
      getline(cin,Time);
      string hrs = Time.substr(0, 2);
      string min = Time.substr(3,2);
      string Zone = Time.substr(5, 7);

      cout << hrs << " " << min << endl;
}