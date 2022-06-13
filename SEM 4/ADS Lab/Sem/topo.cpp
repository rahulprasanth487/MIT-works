#include <bits/stdc++.h>
using namespace std;

class ts
{
      void findtoposort(int node,vector<int> &vis,stack<int> &st,vector<int> adj[])
      {
            vis[node]=1;
            for(auto x:adj[node])
            {
                  if(vis[x]==0)
                  {
                        findtoposort(x,vis,st,adj);
                  }
            }
            st.push(node);
      }
      public:
            vector<int> toposort(int N,vector<int> adj[])
            {
                  stack<int> st;
                  vector<int> vis(N,0);
                  for(int i=0;i<N;++i)
                  {
                        if(vis[i]==0)
                              findtoposort(i,vis,st,adj);
                  }

                  vector<int> op;
                  for(int i=0;i<N;++i)
                  {
                        op.push_back(st.top());
                        st.pop();
                  }

                  return op;
            }
};

int main()
{
      vector<int> adj[5+1];
      int N=6;
      ts obj;
      adj[5].push_back(2);
      adj[5].push_back(0);
      adj[4].push_back(0);
      adj[4].push_back(1);
      adj[2].push_back(3);
      adj[3].push_back(1);
      vector<int> res=obj.toposort(N,adj);
      for (int i = 0; i < N; i++)
      {
            cout<<res[i]<<" ";
      }
      return 1;
      
}