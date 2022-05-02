#include <iostream>
using namespace std;
struct Queue
{
    int size, front, Rear;
    int *Q;
};
void Create(struct Queue *q, int size)
{
    q->size = size;
    q->front = q->Rear = -1;
    // q->Q = new int;
    q->Q = (int *)malloc(q->size * sizeof(int));
}
void enqueue(struct Queue *q, int x)
{
    if (q->Rear == q->size - 1)
    {
        printf("Queues is full ");
    }
    else
        q->Rear++;
    q->Q[q->Rear] = x;
}
int dequeue(struct Queue *q)
{

    int x = -1;
    if (q->front == q->Rear)
    {
        printf("Queue is empty...");
    }
    else
    {
        q->front++;
        x = q->Q[q->front];
    }
    return x;
}
void Display(struct Queue *q){
    for (int i =q->front+1 ; i <= q->Rear; i++)
    {
       printf("%d ", q->Q[i]); 
    }
    
}
int main()
{
    struct Queue q;
    printf("ENter the size of que :");
    scanf("%d", &q.size);
    Create(&q, q.size);
    enqueue(&q, 10); 
    enqueue(&q, 10); 
    enqueue(&q, 10); 
    dequeue(&q); 
    Display(&q);
   
    
}