#include <iostream>
using namespace std;


template <typename T>
void swapping(T &x,T &y){
    T temp=x;
    x=y;
    y=temp;
}



template<typename T>
void sorting(T ptr[],T size)
{
    for(T i=0;i<size;++i){
        for(T j=0;j<size-i-1;++j){
            if(ptr[j]>ptr[j+1])
            {
                swapping(ptr[j],ptr[j+1]);
            }
        }
    }
}


template<typename T>
void print(T ptr[],T s){
    for(T i=0;i<s;++i){
        cout<<ptr[i]<<" ";
    }
}


template <typename T>
T min_ans(T ptr[],T size)
{
    T mini=ptr[0];
    for(T i=1;i<size;++i){
        if(ptr[i]<mini) mini=ptr[i];
    }

    return mini;
}


template <typename T>
T max_ans(T ptr[],T size)
{
    T maxi=ptr[0];
    for(T i=1;i<size;++i){
        if(ptr[i]>maxi) maxi=ptr[i];
    }

    return maxi;
}


int main()
{
    int arr[] = {3,2,1,7,5,4};
    int size=sizeof(arr)/sizeof(arr[0]);
    

    print<int>(arr,size);
    cout<<"Maximum = "<<max_ans<int>(arr,size)<<endl;
    cout<<"Minimum = "<<min_ans<int>(arr,size)<<endl;

    sorting<int>(arr,size);
    print<int>(arr,size);
}