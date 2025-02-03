#include <iostream>
using namespace std;

void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}

void merge(int arr[], int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftArray[n1];
    int rightArray[n2];

    for (int i = 0; i < n1; i++)
    {
        leftArray[i] = arr[i + left];
    }

    for (int i = 0; i < n2; i++)
    {
        rightArray[i] = arr[i + mid + 1];
    }

    int leftIdx = 0;
    int rightIdx = 0;
    int idx = left;

    while (leftIdx < n1 && rightIdx < n2)
    {
        if (leftArray[leftIdx] < rightArray[rightIdx])
        {
            arr[idx++] = leftArray[leftIdx++];
        }
        else
        {
            arr[idx++] = rightArray[rightIdx++];
        }
    }

    while (leftIdx < n1)
    {
        arr[idx++] = leftArray[leftIdx++];
    }

    while (rightIdx < n2)
    {
        arr[idx++] = rightArray[rightIdx++];
    }
}

void mergeSort(int arr[], int left, int right)
{
    if (left < right)
    {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

int main()
{
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);

    mergeSort(arr, 0, n - 1);
    printArray(arr, n);
}