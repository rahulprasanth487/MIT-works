 #include <iostream>
using namespace std;

struct QuickSort
{
    int *Arr, size;
};

int partition(struct QuickSort *arr){
    int pivot =arr->Arr[0] ; 

}
void QuickSort(struct QuickSort *arr)
{

}
int main()
{
    struct QuickSort is_array;
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
    QuickSort(&is_array);
    cout << "\nSorted array is :  ";
    for (int i = 0; i < is_array.size; i++)
    {
        cout << is_array.Arr[i] << "  ";
    }
}