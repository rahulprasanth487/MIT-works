#include <bits/stdc++.h>

using namespace std;

void heapify(vector<int> &heap,int i)
{
      int largest=i;
      int sh=heap.size();
      int left=2*i+1,right=2*i+2;

      if(sh>left&&heap[left]>heap[largest]) largest=left;
      if(sh>right&&heap[right]>heap[largest]) largest=right;

      if(largest!=i)
      {
            swap(heap[i],heap[largest]);
            heapify(heap,largest);
      }
}


void insert_heap(vector<int> &heap,int val)
{
      int siz = heap.size();
      heap.push_back(val);
      if(siz>0)
      {
            for(int i=(siz+1)/2-1;i>=0;--i)
            {
                  heapify(heap,i);
            }
      }
}


void delete_heap(vector<int> &heap,int val)
{
      int siz=heap.size();
      int i;
      for(i=0;i<siz;i++)
      {
            if(heap[i]==val) break;
      }

      swap(heap[i],heap[siz-1]);
      heap.pop_back();
      for(int i=(siz-1)/2-1;i>=0;--i)
      {
            heapify(heap,i);
      }

}


void print(vector<int> &heap)
{
      for(auto i:heap)
      {
            cout<<" "<<i;
      }
      cout<<endl;
}


int main()
{
      vector<int> heap;

      insert_heap(heap, 12);
      printf("Initial heap: ");
      print(heap);

      insert_heap(heap, 90);
      printf("+ 90: ");
      print(heap);

      insert_heap(heap, 89);
      printf("+ 89: ");
      print(heap);

      insert_heap(heap, 2);
      printf("+ 2: ");
      print(heap);

      insert_heap(heap, 54);
      printf("+ 54: ");
      print(heap);

      delete_heap(heap, 90);
      printf("- 90: ");
      print(heap);

      delete_heap(heap, 89);
      printf("- 89: ");
      print(heap);

      delete_heap(heap, 12);
      printf("- 12: ");
      print(heap);

      delete_heap(heap, 2);
      printf("- 2: ");
      print(heap);

      delete_heap(heap, 54);
      printf("- 54: ");
      print(heap);

      return 0;
}