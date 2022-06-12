#include <bits/stdc++.h>
using namespace std;

#define V 9

void printpath(int parent[],int n)
{
      if(parent[n]==-1) return;

      printpath(parent,parent[n]);
      cout<<n<<" ";
}

int mindistance(int dist[],bool visited[])
{
      int min=INT_MAX;
      int min_node;
      for(int i=0;i<V;++i)
      {
            if(!visited[i]&&dist[i]<=min)
            {
                  min=dist[i];
                  min_node=i;
            }
      }

      return min_node;
}

void printSolution(int dist[],int n,int parent[])
{
      int src=0;
      cout<<"VERTEX\tdistance\tpath\n";
      for(int i=1;i<V;++i)
      {
            cout<<src<<"->"<<i<<"\t"<<dist[i]<<"\t\t"<<src<<" ";
            printpath(parent,i);
            cout<<endl;
      }
}


void dijkstra(int graph[V][V],int src)
{
      int dist[V];
      bool visited[V]={false};
      int parent[V]={-1};

      for (int i = 0; i < V; i++)
      {
            dist[i]=INT_MAX;
      }
      dist[src]=0;


      for (int i = 0; i < V-1; i++)
      {
            int u=mindistance(dist,visited);
            visited[u]=true;

            for (int v = 0; v <V; v++)
            {
                  if (!visited[v] && graph[u][v] && dist[u] + graph[u][v] < dist[v])
                  {
                        parent[v]=u;
                        dist[v]=dist[u]+graph[u][v];
                  }
            }
      }
      
      printSolution(dist,V,parent);
}


int main()
{
      // Let us create the example graph discussed above
      int graph[V][V] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                         {4, 0, 8, 0, 0, 0, 0, 11, 0},
                         {0, 8, 0, 7, 0, 4, 0, 0, 2},
                         {0, 0, 7, 0, 9, 14, 0, 0, 0},
                         {0, 0, 0, 9, 0, 10, 0, 0, 0},
                         {0, 0, 4, 0, 10, 0, 2, 0, 0},
                         {0, 0, 0, 14, 0, 2, 0, 1, 6},
                         {8, 11, 0, 0, 0, 0, 1, 0, 7},
                         {0, 0, 2, 0, 0, 0, 6, 7, 0}};
      dijkstra(graph, 0);
      return 0;
}
