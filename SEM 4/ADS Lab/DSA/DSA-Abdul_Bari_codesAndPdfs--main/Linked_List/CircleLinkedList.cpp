#include <iostream>
#include <stdlib.h>
using namespace std;
struct Node
{
    int data;
    struct Node *next;

} * Head;
void Create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    Head = (struct Node *)malloc(sizeof(struct Node));
    Head->data = A[0];
    Head->next = Head;
    last = Head;
    for (i = 1; i < n; i++)
    {
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = last->next;
        last->next = t;
        last = t;
    }
}
void RDisplay(struct Node *h){
    static int flag = 0 ; 
    if (h!=Head || flag==0)
    {
       flag = 1; 
       printf("%d ",h->data); 
       RDisplay(h->next); 
    }
    flag= 0; 

}
void Display(struct Node *h)
{
    do
    {
        printf("%d ", h->data);
        h = h->next;
    } while (h != Head);
    cout << endl;
}
int main()
{
    int Arr[] = {0, 3, 5, 6, 7, 2};
    Create(Arr, 6);
    RDisplay(Head);
    return 0;
}