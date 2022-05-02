
#include <iostream>
#include <math.h>
using namespace std;

int length(int x)
{
    int len=0;
    while(x>0)
    {
        x/=10;
        ++len;
    }
    
    return len;
}

int main()
{
    
    int l,h;
    printf("Enter the range a b = ");
    scanf("%d %d",&l,&h);
    
    for(int i=l;i<=h;++i)
    {
        int sum = 0;
        int leng = length(i);
        int x = i;
        while(x>0)
        {
            int temp = x%10;
            sum+=pow(temp,leng);
            x/=10;
        }
        
        if(sum==i) cout<<i<<endl;
        else continue;
    }

    return 0;
}
