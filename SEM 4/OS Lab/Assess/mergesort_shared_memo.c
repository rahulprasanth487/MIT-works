#include <stdio.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/ipc.h>

void merge(int arr[], int l, int mid, int h)
{
      int n1 = mid - l + 1, i, j, k;
      int n2 = h - mid;
      int left[n1], right[n2];

      for (i = 0; i < n1; ++i)
            left[i] = arr[l + i];
      for (i = 0; i < n2; ++i)
            right[i] = arr[mid + 1 + i];

      i = 0;
      j = 0;
      k = l;
      while (i < n1 && j < n2)
      {
            if (left[i] < right[j])
            {
                  arr[k] = left[i];
                  ++i;
            }
            else
            {
                  arr[k] = right[j];
                  ++j;
            }
            ++k;
      }
      while (i < n1)
      {
            arr[k] = left[i];
            ++i;
            ++k;
      }
      while (j < n2)
      {
            arr[k] = right[j];
            ++j;
            ++k;
      }
}

void mergesort(int arr[], int l, int h)
{
      if (l > h)
      {
            return;
      }

      int f1, f2;
      int mid = (l + h) / 2;
      f1 = fork();
      if (f1 == 0)
      {
            mergesort(arr, l, mid);
            _exit(0);
      }
      else
      {
            f2 = fork();
            if (f2 == 0)
            {
                  mergesort(arr, mid + 1, h);
                  _exit(0);
            }
      }
      int status;
      waitpid(f1, &status, 0);
      waitpid(f2, &status, 0);
      merge(arr, l, mid, h);
}

int main()
{
      key_t k = IPC_PRIVATE;

      int *shm_array; // It is the shared segment we need to allocated the memory to this;
      int arr[1000], id, i;
      int n;
      printf("Enter the number of elements of the array = ");
      scanf("%d", &n);
      for (i = 0; i < n; ++i)
      {
            printf(" = ");
            scanf("%d", &arr[i]);
      }

      // IPC_CREAT |	0666  will set a flag to allocate the shared memory
      id = shmget(k, n * sizeof(int), IPC_CREAT | 0666);

      if (id < 0)
      {
            printf("Shared memory not created\n");
      }

      shm_array = shmat(id, NULL, 0); // allocating the id storage to the shm_array
      for (i = 0; i < n; ++i)
      {
            shm_array[i] = arr[i];
      }

      mergesort(shm_array, 0, n - 1);

      for (i = 0; i < n; ++i)
      {
            printf("%d ", shm_array[i]);
      }

      return 0;
}
