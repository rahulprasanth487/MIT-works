#include <iostream>
#include <time.h>
using namespace std;

int dist = 0;
class passenger
{
public:
      static string name;
      static string mobile;
      static string from;
      static string to;
      static float distance;
      static int hour;
      passenger()
      {
            if (name == "")
            {
                  time_t now = time(0);
                  struct tm *aTime = localtime(&now);
                  hour = aTime->tm_hour;
                  cout << "Enter name: ";
                  cin >> name;
                  cout << "Enter mobile number:";
                  cin >> mobile;
                  cout << "Enter from address: ";
                  cin >> from;
                  cout << "Enter to address: ";
                  cin >> to;
                  cout << "Enter distance in KM: ";
                  cin >> distance;
            }
      }
      virtual void auto_fare() = 0;
};
string passenger::name = "";
string passenger::mobile = "";
string passenger::from = "";
string passenger::to = "";
float passenger::distance = 0;
int passenger::hour = 0;
class ola;
class uber : public passenger
{
      float estimate;

public:
      friend void compare(uber u, ola o);
      friend class ola;
      void auto_fare()
      {
            if (hour == 9 || hour == 10)
            {
                  estimate = 2 * distance * 8;
            }
            else
                  estimate = distance * 8;
      }
};
class ola : public passenger
{
      float estimate;

public:
      friend void compare(uber u, ola o);
      void auto_fare()
      {

            if (hour >= 8 && hour <= 10)
            {
                  estimate = 2 * distance * 8;
            }
            else
                  estimate = distance * 8;
      }
};

void compare(uber u, ola o)
{

      if (u.estimate > o.estimate)
            cout << "Ola is better than Uber, fare: " << o.estimate << endl;
      else if (u.estimate < o.estimate)
            cout << "Uber is better than Ola, fare: " << u.estimate << endl;

      else
            cout << "Both Uber and Ola have same fare: " << o.estimate << endl;
}
int main()
{
      uber u;
      ola o;
      u.auto_fare();
      o.auto_fare();
      compare(u, o);
      return 0;
}
