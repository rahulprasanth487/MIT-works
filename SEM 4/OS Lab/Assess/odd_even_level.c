#include <stdio.h>
#include <unistd.h>
#include <math.h>
#include <stdlib.h>

void display(int arr[], int l, int n, int size)
{
      int i = l, cnt = 0;
      while (i < size && cnt < n && l < size)
      {
            printf(" %d ", arr[i]);
            ++i;
            cnt++;
      }

      printf("\n");
}

int main()
{
      int *arr;
      int n;
      printf("Enter the size = ");
      scanf("%d", &n);

      arr = (int *)malloc(n * sizeof(int));
      int ele;
      for (int i = 0; i < n; i++)
      {
            printf("Enter the element = ");
            scanf("%d", &arr[i]);
      }
      int id1 = fork();
      int id2 = fork();

      if (id1 > 0)
      {
            if (id2 > 0)
            {
                  // odd level;
                  int l = 0;
                  printf("ODD LEVELS: \n");
                  while (pow(2, l) <= n)
                  {
                        display(arr, pow(2, l) - 1, pow(2, l), n);
                        l = l + 2;
                  }
            }
      }
      else
      {
            if (id2 == 0)
            {
                  // even level;
                  int l = 1;
                  printf("EVEN LEVELS: \n");
                  while (pow(2, l) <= n)
                  {
                        display(arr, pow(2, l) - 1, pow(2, l), n);
                        l = l + 2;
                  }
            }
      }

      return 1;
}
