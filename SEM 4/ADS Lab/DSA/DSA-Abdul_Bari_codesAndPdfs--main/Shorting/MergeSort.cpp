#include<iostream>
using  namespace std ; 

void Merge(int A[],int B[], int m ,int n ){
    int i ,j ,k ; 
    
    int C[100]; 
    i=j=k=0; 
    while (i<m && j<n)
    {
        if(A[i]<B[j]){
            C[k++]=A[i++]; 


        }
        else {
            C[k++]=B[j++];
        }
        for ( ;  i < m; i++)
        {
            C[k++]=A[i]; 
            /* code */
        }
        for ( ; i < n; i++)
        {
            C[k++]=B[j];
            /* code */
        }
       

       for (int i = 0; i <100; i++)
       {
           cout<<C[i]<<"  "; 
       }
       


     

        
        
    }
    
}
int main(){
    


    int n1, n2 ,n3 ; 
    cout<<"Enter the length of array :";
    cin>>n1 ; 
    int A[n1]; 
    cout<<"Enter element : \n";

    for (int i = 0; i < n1; i++)
    {
        cin>>A[i]; 
    }
     
    cout<<"Enter the length of  2nd array :";
    cin>>n2 ; 
    int B[n2]; 
    cout<<"Enter Element : \n";
    for (int i = 0; i < n2; i++)
    {
        cin>>B[i];
    }

    Merge( A,B, n1 ,n2 );
    



    

}