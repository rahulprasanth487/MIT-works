#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

using namespace std;
int
main ()
{
  string str, temp;
  cout << "Enter the string = ";
  cin >> str;
  int size = str.size ();

  int last = size - 1;
  int flag = 0;
  for (int i = 0; i < size; ++i)
    {
      if (str[i] == str[last])
	flag = 1;
      else
	flag = 0;

      //cout<<str[i]<<str[last]<<endl;

      last--;


    }

  if (flag == 1)
    cout << "Palindrome";
  else
    cout << "Not a palimdrome";
  return 1;
}
