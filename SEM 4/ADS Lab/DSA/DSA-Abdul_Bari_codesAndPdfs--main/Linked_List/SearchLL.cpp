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
int Count(struct Node *p)
{
    int count = 0;
    while (p != 0)
    {
        count++;
        p = p->next;
    }
    return count;
}
struct Node * Rsearch(struct Node *p ,int key){
    if (p==NULL)
    {
       return NULL; 
    }
    if (key == p->data)
    {
        return p; 
    }
    
    return Rsearch(p->next, key); 
    
}
struct Node * LSearch (struct Node *p, int key ){
    while (p)
    {
        if (p->data == key )
        {
            return p ; 
        }
        p=p->next; 
    }
    return NULL ; 
}
int main()
{   struct Node *temp ; 
    int array[] = {10, 20, 50, 2, 8, 51, 30};
    create(array, 7);
    temp= Rsearch(first, 50); 
    if (temp)
    {
       printf("key is found\n "); 
    }
    else{
        printf("Key is not Found\n "); 
    }
    Display(first);
}