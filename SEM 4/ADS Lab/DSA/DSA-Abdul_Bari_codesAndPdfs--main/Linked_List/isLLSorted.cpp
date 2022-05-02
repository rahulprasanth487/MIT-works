#include <iostream>
using namespace std;
struct Node
{
    int data;
    struct Node *next;
} *first = NULL;
void Display(struct Node *p)
{

    while (p)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}
void create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    first = (struct Node *)malloc(sizeof(struct Node));
    first->data = A[0];
    first->next = NULL;
    last = first;

    for (i = 1; i < n; i++)
    {
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = NULL;
        last->next = t;
        last = t;
    }
}
int isLLSorted(struct Node *p ){
    int x= -32768; 
        while (p)
        {
           if (p->data<x)
           {
              return false; 
           }
           x= p->data; 
           p=p->next ; 

        }
        return true ; 
        

}
int main()
{
    int array[] = {10, 20, 50, 70, 80, 91, 100};
    create(array, 7);
    printf("%d\n",isLLSorted(first) ); 
    Display(first);
}