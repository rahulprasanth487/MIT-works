#include <iostream>
using namespace std;
int findMax(int A[], int n)
{

    int max = INT32_MIN;
    int i;
    for (i = 0; i < n; i++)
    {
        if (A[i] > max)
            max = A[i];
    }
    return max;
}

void CountSort(int A[], int n)
{
    int max;
    int *C;
    max = findMax(A, n);
    C = new int[max + 1];
    for (int i = 0; i < max + 1; i++)
    {
        C[i] = 0;
    }
    for (int i = 0; i < n; i++)
    {
        C[A[i]]++;
    }
    int i = 0, j = 0;
    while (i < max + 1)
    {
        if (C[i] > 0)
        {
            A[j++] = i;
            C[i]--;
        }
        else
            i++;
    }
}

int main()
{
    int A[] = {10, 7, 4, 9, 15, 20, 17, 5, 12, 3};
    int n = 10;

    CountSort(A, n);
    for (int i = 0; i < n; i++)
    {
        cout << A[i] << " ";
    }
}