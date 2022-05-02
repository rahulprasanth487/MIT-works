#include<iostream>
using namespace std ; 

    struct InserationSort
    {
        int *Arr, size  ;
    };
    
void InserationSort (struct InserationSort *arr ){
        
        for (int i = 1; i < arr->size; i++)
        {
         int  j = i-1 ; 
           int x = arr->Arr[i];
           while (j>-1 && arr->Arr[j]>x)
           {
              arr->Arr[j+1]=arr->Arr[j]; 
              j--; 

           }
           arr->Arr[j+1]=x; 
           
        }

}
int main(){
    struct InserationSort is_array ;
    cout<<"Enter the size : "; 
    cin >> is_array.size ; 
    is_array.Arr= (int*)malloc(is_array.size*sizeof(int));
    cout<<"Enter the elements : \n"; 
    for (int i = 0; i < is_array.size; i++)
    {
    cin>>is_array.Arr[i];
        /* code */
    }
    
    cout<<"Entered array is :  "; 
    for (int i = 0; i < is_array.size; i++)
    {
        cout<<is_array.Arr[i]<<"  "; 
    }
     InserationSort(&is_array); 
     cout<<"\nSorted array is :  "; 
    for (int i = 0; i < is_array.size; i++)
    {
        cout<<is_array.Arr[i]<<"  "; 
    }

    
}