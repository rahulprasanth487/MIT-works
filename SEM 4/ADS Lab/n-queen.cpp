#include <bits/stdc++.h>
#include <vector>

using namespace std;

vector<vector<int>> arr(4, vector<int>(4, -1));

void display(vector<vector<int>> vec)
{
      for(int i=0;i<vec.size();++i)
      {
            for(int j=0;j<vec[0].size();++j)
            {
                  cout<<vec[i][j]<<" ";
            }
            cout<<endl;
      }
}


void make_block(int x,int y)
{
      int diff = abs(x - y);
      for (int i = 0; i < arr.size(); ++i)
      {
            for(int j=0;j<arr.size();++j)
            {
                  //if(x==y&&i==j) arr[i][j]=0;
                  if(abs(i+j)==x+y && arr[i][j]==-1) arr[i][j]=0;
            }
      }

      // int i=0;
      // cout<<"CALL "<<i<<endl;
      // ++i;
      // display(arr);
      // cout<<"\n\n";
}


int main()
{

      int r,c;
      cout<<"Enter the row and column to place the first queen = ";
      cin>>r>>c;
      make_block(r - 1, c - 1);
      arr[r-1][c-1]=1;
      display(arr);
      int qn_cnt=1;

      for (int i = 0; i < arr.size(); ++i)
      {
            for (int j = 0; j < arr[0].size(); ++j)
            {
                 if(qn_cnt<=4)
                 {
                       if(arr[i][j]==-1)
                       {
                             make_block(i,j);
                             arr[i][j]=1;

                             display(arr);

                       }
                 }
                 else

                        break;
            }
            cout << endl;
      }
      

      return 1;
}