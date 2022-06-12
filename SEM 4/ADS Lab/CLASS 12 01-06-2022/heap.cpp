#include <iostream>
#include <algorithm>
using namespace std;
template <typename T>
void printArray(T arr[],T n)
{
    for(T i=0;i<n;++i)
    {
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

template <typename T>
void heapify(T arr[],T n,T i)
{
    T largest=i;
    T left=2*i+1;
    T right=2*i+2;

    if(left<n&&arr[left]>arr[largest]) largest=left;
    if(right<n&&arr[right]>arr[largest]) largest=right;

    if(largest!=i)
    {
        swap(arr[i],arr[largest]);
        heapify(arr,n,largest);
    }
}

template <typename T>
void heapsort(T arr[],T n)
{
    for(T i=n/2 -1;i>=0;--i)
    {
        heapify(arr,n,i);
    }
    
    for(T i=n-1;i>0;--i)
    {
        swap(arr[0],arr[i]);
        heapify(arr,i,0);
    }
}


int main()
{
    int arr[]={10,9,8,7,4,5,6,3,2,1};
    int n=sizeof(arr)/sizeof(int);
    heapsort<int>(arr,n);
    printArray(arr,n);
    return 1;
}