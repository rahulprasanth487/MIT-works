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
void InsertLL(struct Node *p, int index, int x)
{
    struct Node *t;

    if (index < 0 || index > Count(p))
    {
        return;
    }
    t = new Node;
    t->data = x;
    if (index == 0)
    {
        //   t = new Node;
        //     t->data = x;
        t->next = first;
        first = t;
    }
    else
    {
        // t = new Node;
        // t->data = x;
        for (int i = 0; i < index - 1 && p; i++)
        {
            p = p->next;
        }
        t->next = p->next;
        p->next = t;
    }
}
int main()
{
    int array[] = {10, 20, 50, 2, 8, 51, 30};
    create(array, 7);
    InsertLL(first, 7, 7);
    // printf("%d\n", Delete(first, 1));
    Display(first);
}