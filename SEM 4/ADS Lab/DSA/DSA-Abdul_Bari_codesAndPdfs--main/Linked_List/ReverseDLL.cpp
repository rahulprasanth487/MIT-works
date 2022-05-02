#include <iostream>
using namespace std;
struct Node
{
    struct Node *next ;
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
void Display(struct Node *p){
    while (p)
    {
        printf("%d ",p->data); 
        p=p->next; 
    }
    cout<<endl; 
    
}
int Length(struct Node *p ){
    int len =0 ; 
    while (p)
    {
        len++; 
        p= p->next; 

    }
    return len; 
}
void ReverseDLL(struct Node *p){
    struct Node *temp ; 
    
     
    //   p=first; 
      while (p)
      {
         temp = p->next ; 
         p->next = p->prev; 
         p->prev=temp; 
         p =p->prev; 
         if ( p!=NULL && p->next == NULL)
         {
            first = p;
         }
         
      }
      
}
int main(){
    int Arr[]={2,3,5,7,6,0};
    Create(Arr, 6); 
    Display(first); 
    cout<<endl; 
    ReverseDLL(first); 
    Display(first);
    return 0 ; 
}
