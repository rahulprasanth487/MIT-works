#include <iostream>
using namespace std;
struct Node
{
    int data;
    struct Node *next;
} *first = NULL;
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
void ReverseRecursive(struct Node *q, struct Node *p)
{ /// Using Recursion
    if (p != 0)
    {
        ReverseRecursive(p, p->next);
        p->next = q;
    }
    else
    {
        first = q;
    }
}
void Reverse(struct Node *p)
{ // Using Links
    p = first;
    struct Node *q = NULL, *r = NULL;
    while (p)
    {
        r = q;
        q = p;
        p = p->next;
        q->next = r;
    }
    first = q;
}
void ReverseWithArr(struct Node *p)
{
    int *Arr;
    struct Node *q = p;
    int i = 0;
    Arr = (int *)malloc(sizeof(int) * Count(p));
    while (q != NULL)
    {
        Arr[i] = q->data;
        q = q->next;
        i++;
    }
    q = p;
    i--;
    while (q != NULL)
    {
        p->data = Arr[i];
        p = p->next;
        i--;
    }
}
int main()
{
    int array[] = {10, 20, 30, 50, 70, 91, 100};
    create(array, 7);
    Display(first);
    printf("\nAfter Reversing \n");
    // ReverseRecursive(NULL, first);
    // Reverse(first); //Reversing Links
    ReverseWithArr(first);
    Display(first);
}