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
void removeDublicateElement(struct Node *p ){
    // struct Node *p =first; 
    struct Node *q =p->next; 
    while (q!=NULL)
    {
       if (p->data!=q->data)
       {
           p=q; 
           q=q->next; 

       }else{ 
           p->next= q->next; 
           free(q) ; 
           q=q->next; 
       }
        
    }
    

        

}
int main()
{
    int array[] = {10, 20, 20, 50, 70, 91, 100};
    create(array, 7);
    removeDublicateElement(first); 
    Display(first);
}