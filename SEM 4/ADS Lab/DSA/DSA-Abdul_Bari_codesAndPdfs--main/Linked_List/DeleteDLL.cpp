#include <iostream>
using namespace std;
struct Node
{
    struct Node *next;
    struct Node *prev;
    int data;

} *first = NULL;
void Create(int A[], int n)
{
    struct Node *t, *last;

    first = new Node;
    first->data = A[0];
    first->prev = first->next = NULL;
    last = first;
    for (int i = 1; i < n; i++)
    {
        t = new Node;
        t->data = A[i];
        t->next = last->next;
        t->prev = last;
        last->next = t;
        last = t;
    }
}
void Display(struct Node *p)
{
    while (p)
    {
        printf("%d ", p->data);
        p = p->next;
    }
    cout << endl;
}
int Length(struct Node *p)
{
    int len = 0;
    while (p)
    {
        len++;
        p = p->next;
    }
    return len;
}
int DeleteDLL(struct Node *p, int index)
{
    // struct Node *q;
    int x = -1;
    if (index < 1 || index > Length(p))
    {
        return -1;
    }
    if (index == 1)
    {
        first = first->next; 
        if (first)
        {
           first->prev =NULL; 
        }
        x= p->data; 
        delete p ; 

    }else{ 
        for (int i = 0; i < index- 1; i++)
        {
            p=p->next; 
        }
        p->prev->next = p->next; 
        if (p->next)
        {
            p->next->prev= p->prev; 
        }
           x= p->data; 
           delete p;
        
    }
    return x ; 
}
int main()
{
    int Arr[] = {2, 3, 5, 7, 6, 0};
    Create(Arr, 6);
    Display(first);
    cout<<endl; 
    DeleteDLL(first, 2); 
    Display(first);
    return 0;
}
