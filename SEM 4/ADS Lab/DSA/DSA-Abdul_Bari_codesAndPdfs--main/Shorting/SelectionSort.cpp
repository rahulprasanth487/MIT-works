#include <iostream>
using namespace std;

struct SelectionSort
{
    int *Arr, size;
};
void SelectionSort(struct SelectionSort *arr)
{
    int k;
    for (int i = 0; i < arr->size - 1; i++)
    {
        for (int j = k = i; j < arr->size; j++)
        {
            if (arr->Arr[j] < arr->Arr[k])
            {
                k = j;
            }
        }
        int temp;
        temp = arr->Arr[i];
        arr->Arr[i] = arr->Arr[k];
        arr->Arr[k] = temp;
    }
}
int main()
{
    struct SelectionSort is_array;
    cout << "Enter the size : ";
    cin >> is_array.size;
    is_array.Arr = (int *)malloc(is_array.size * sizeof(int));
    cout << "Enter the elements : \n";
    for (int i = 0; i < is_array.size; i++)
    {
        cin >> is_array.Arr[i];
        /* code */
    }

    cout << "Entered array is :  ";
    for (int i = 0; i < is_array.size; i++)
    {
        cout << is_array.Arr[i] << "  ";
    }
    cout<<"working";
    SelectionSort(&is_array);
    cout << "\nSorted array is :  ";
    for (int i = 0; i < is_array.size; i++)
    {
        cout << is_array.Arr[i] << "  ";
    }
}