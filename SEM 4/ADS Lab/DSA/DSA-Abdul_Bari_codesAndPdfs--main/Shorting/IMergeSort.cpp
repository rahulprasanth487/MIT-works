#include<iostream>
using  namespace std ; 
// void Merge( int A[] , int l , int mid , int h){
             
//              int i , j ,k ; 
//              int B[h+1]; 
//              i= l, j=mid+1 , k=l ;
//              while (i<=mid && j<=h)
//              {
//                if (A[i]<A[j])
//                {
//                   B[k++]= A[i++]; 
//                }
//                else 
//                B[k++]= A[j++]; 

//              }
//              for (; i <= mid ; i++)
//              {
//                 B[k++]= A[i]; 
//              }
//              for (; i <= h ; j++)
//              {
//                 B[k++]= A[j]; 

//              }
//              for ( i = l ; i <= h ; i++)
//              {
//                A[i]=B[i];
//              }
             
             
             
             
   
// }

void Merge(int A[], int low, int mid, int high){
    int i = low;
    int j = mid+1;
    int k = low;
    int B[high+1];
    while (i <= mid && j <= high){
        if (A[i] < A[j]){
            B[k++] = A[i++];
        } else {
            B[k++] = A[j++];
        }
    }
    while (i <= mid){
        B[k++] = A[i++];
    }
    while (j <= high){
        B[k++] = A[j++];
    }
    for (int i=low; i<=high; i++){
        A[i] = B[i];
    }
}
void IMergeSort(int A[] , int n ){
    int p , i , l , mid , h; 
    for ( p = 2; p <= n ; p=p*2)
    {
    for (size_t i = 0; i+p-1< n; i=i+p)
    {
        l= i ; 
        h = i +p -1 ; 
        mid = (l+h)/2; 
        Merge(A , l , mid ,h ); 
    }
    
    }if (p/2<n)
    {
        /* code */
        Merge(A, 0 , p/2-1 , n-1);
    }
    //  int p;
    // for (p=2; p<=n; p=p*2){
    //     for (int i=0; i+p-1<n; i=i+p){
    //         int low = i;
    //         int high = i+p-1;
    //         int mid = (low+high)/2;
    //         Merge(A, low, mid, high);
    //     }
    // }
    // if (p/2 < n){
    //     Merge(A, 0, p/2-1, n-1);
    // }
    
    
}

int main(){

    int A[]= { 10 ,7,4,9,15,20,17, 5, 12 ,3};
    int n=10;

    IMergeSort(A ,n ); 
    for (int i = 0; i < n; i++)
    {
        cout<<A[i]<<" "; 
    }
    
    
}