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
int isLoopLL(struct Node *f ){
    struct Node *p , *q ; 
    p=q=f; 
    do
    {  
        p=p->next; 
        q=q->next ; 
        q=q!=NULL?q->next:NULL ; 

       
    } while (p && q && p!=q);
    if (p==q)
    {
       return true ; 
    }else{
        return false ; 
    }
    
        

}
int main()
{    
    struct Node *t1 , *t2 ; 
    int array[] = {10, 20, 50, 70, 80, 91, 100};
    create(array, 7);
    t1= first->next->next->next; 
    t2= first ->next->next->next->next ; 
    t2 ->next =t1 ; 
    
    printf("\n%d", isLoopLL(first)); 

}