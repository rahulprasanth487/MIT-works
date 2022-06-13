#include <iostream>
using namespace std;

#define V 5

void printsolution(int graph[V][V],int parent[])
{
      for (int i = 1; i < V; i++)
      {
            cout << parent[i] << " " << i << "      " << graph[i][parent[i]] << endl;
      }
      
}

int mindistance(int dist[],int visited[])
{
      int min=INT_MAX;
      int min_node;

      for (int i = 0; i < V; i++)
      {
            if((visited[i]==0) && dist[i]<min)
            {
                  min=dist[i];
                  min_node=i;
            }
      }

      return min_node;
      
}


void primMST(int graph[V][V])
{
      int dist[V];
      int visited[V]={0};
      int parent[V]={-1};

      for (int i = 0; i < V; i++)
      {
            dist[i]=INT_MAX;
      }

      dist[0]=0;

      for (int i = 0; i < V-1; i++)
      {
            int u=mindistance(dist,visited);
            visited[u]=1;

            for (int v = 0; v < V; v++)
            {
                  if(!visited[v]&&graph[u][v]&& graph[u][v]<dist[v])
                  {
                        parent[v]=u;
                        dist[v]=graph[u][v];
                  }
            }
            

      }

      printsolution(graph,parent);
      
}


int main()
{
      int graph[V][V] = {{0, 2, 0, 6, 0},
                         {2, 0, 3, 8, 5},
                         {0, 3, 0, 0, 7},
                         {6, 8, 0, 0, 9},
                         {0, 5, 7, 9, 0}};

      // Print the solution
      primMST(graph);

      return 0;
}