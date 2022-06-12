#include <stdio.h>
#include <unistd.h>
#include <math.h>
#include <stdlib.h>

int search(int arr[], int l, int h, int ele)
{
      int flag = 0;
      for (int i = l; i <= h; ++i)
      {
            if (arr[i - 1] == ele)
                  flag = 1;
            printf(" %d ", arr[i - 1]);
      }
      printf("\n");
      return flag;
}

int main()
{
      int flag = 0;
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

      int mid = floor(n / 2);

      if (id1 > 0)
      {

            if (search(arr, 1, mid, 4))
                  printf("Present in first half\n");
            else
                  printf("absent in first half \n");
      }
      else
      {
            if (search(arr, mid + 1, n, 4))
                  printf("Present in second half\n");
            else
                  printf("absent in second half\n");
      }

      return 1;
}
