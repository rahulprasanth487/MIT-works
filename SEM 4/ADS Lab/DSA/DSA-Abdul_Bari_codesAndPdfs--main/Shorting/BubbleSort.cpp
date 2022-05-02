#include<iostream>
 using namespace std ; 

struct BubbleSort
{
    int *ARR, size , length ;
};
void BubbleSort(struct BubbleSort *arr ){
    int flag ; 
    for (int i = 0; i < arr->length -1; i++)
    {      flag= 0; 
        for (int j = 0; j< arr->length- 1-i; j++)
        {
            if (arr->ARR[j]>arr->ARR[j+1])
            {
               int temp ;
              temp = arr->ARR[j]; 
              arr->ARR[j]=arr-> ARR[j+1];
              arr-> ARR[j+1] =temp;
              flag=1 ;
            }
            
        }
        if (flag==0)
        {
           break ;
        }
        
    }
    
}
void Disp(struct BubbleSort *arr )
{
    for (int i = 0; i < arr->length; i++)
    {
        cout<<arr->ARR[i]<<" "; 
    }
    
}
 int main(){
   
   struct BubbleSort array ; 
   cout<< "Enter the size of array " ; 
   cin>>array.size; 
   array.ARR = (int*)malloc(array.size*sizeof(int)); 
   cout<<"\nEnter the length of the array "; 
   cin>> array.length ; 
   cout<<"ENter the elements : \n"; 
   for (int i = 0; i < array.length; i++)
   {
       cin>>array.ARR[i]; 
   }
   
   cout<<"\nYour array is this : " ; 

    Disp(&array);
    cout<<"\n Now after bubble sort : \n"; 
    BubbleSort(&array); 
    Disp(&array);



   
      
 }