#include <bits/stdc++.h>
using namespace std;

void BellmanFord(int graph[][3],int v,int e,int src)
{
      int dist[v];
      for (int i = 0; i < v; i++)
      {
            dist[i]=INT_MAX;
      }
      dist[src]=0;

      for (int i = 0; i <v-1; i++)
      {
            for(int j=0;j<e;++j)
            {
                if(dist[graph[j][0]]!=INT_MAX&&dist[graph[j][0]]+graph[j][2]<dist[graph[j][1]])
                {
                      dist[graph[j][1]]=graph[j][2]+dist[graph[j][0]];
                }
            }
      }


      //for negative weight
      for (int i = 0; i < e; i++)
      {
            int x=graph[i][0];
            int y=graph[i][1];
            int weight=graph[i][2];
            if(dist[x]+weight<dist[y] && dist[x]!=INT_MAX)
            {
                  cout<<"Negative weight"<<endl;
            }
      }

      cout << "Vertex Distance from Source" << endl;
      for (int i = 0; i < v; i++)
            cout << i << "\t\t" << dist[i] << endl;
}



int main()
{
      int V = 5; // Number of vertices in graph
      int E = 8; // Number of edges in graph

      // Every edge has three values (u, v, w) where
      // the edge is from vertex u to v. And weight
      // of the edge is w.
      int graph[][3] = {{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}};

      BellmanFord(graph, V, E, 0);
      return 0;
}