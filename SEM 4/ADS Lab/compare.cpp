#include <iostream>
#include <algorithm>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

void print(vector<string> ans){
      for (auto i : ans)
      {
            cout << i << endl;
      }
}

int main()
{
      vector<string>s{"aabaab","aaaabb"};
      vector<string>t{"bbabbc","abb"};
      vector<string>ans;

      unordered_map<char, int> M1;
      unordered_map<char, int> M2;

      for(int i=0;i<s.size();++i)
      {
            if(s[i].size()!=t[i].size())
            {
                  ans.push_back("NO");
            }
            else{
                  string a=s[i];
                  string b=t[i];
                  int len=a.size();
                  for(int j=0;j<len;++j)
                  {
                        if(M1.find(a[j])==M1.end())
                        {
                              M1.insert(make_pair(a[j],1));
                        }
                        else
                        {
                              M1[a[j]]++;
                             // M2[b[j]]++;
                        }
                        if(M2.find(b[j])==M2.end())
                        {
                              M2.insert(make_pair(b[j], 1));
                        }
                        else{
                              //M1[a[j]]++;
                              M2[b[j]]++;
                        }
                  }

                  int flag = 0;

                  for (auto &k : M1)
                  {
                        for (auto &l: M2)
                        {
                              if(k.first==l.first)
                              {
                                    if((max(k.second,l.second)-min(l.second,k.second))>3)
                                    {
                                          flag=0;
                                          continue;
                                    }
                                    else{
                                          
                                          flag=1;
                                          continue;
                                    }
                              }
                        }

                  }

                  if (flag == 1)
                        ans.push_back("YES");
                  else
                        ans.push_back("NO");
            }

          
      }

      print(ans);

      return 1;
}