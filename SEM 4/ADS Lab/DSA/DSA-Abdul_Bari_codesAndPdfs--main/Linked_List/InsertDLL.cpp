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
void InsertDLL(struct Node *p, int index, int x)
{

    struct Node *t;
    if (index < 0 || index > Length(p))
    {
        return;
    }
    if (index == 0)
    {

        t = new Node;
        t->data = x;
        t->prev = NULL;
        t->next = first;
        first->prev = t;
        first = t;
    }
    else
    {
        t = new Node;
        t->data = x;
        for (int i = 0; i < index - 1; i++)
        {
            p = p->next;
        }
        t->next = p->next;
        t->prev = p;
        if (p->next)
        {
            p->next->prev = t;
        }
        p->next = t;
    }
}

int main()
{
    int Arr[] = {2, 3, 5, 7, 6, 0};
    Create(Arr, 6);
    Display(first);
    InsertDLL(first, 2, 150);
    cout << endl;
    Display(first);

    return 0;
}
