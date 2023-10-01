/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package method;
public class Sort {
    public void swap(int arr[], int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
//bubble sort
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) 
                    swap(arr, j, j+1);
    }
//quick sort
    public void QuickSort(int[] arr, int i, int j) 
    {  
        
        int p=arr[(i+j)/2];
        int l= i, r= j;
        do {            
            while (arr[i]<p)
                i++;
            while (arr[j]>p)
                j--;
            if(i<=j){
                swap(arr, i,j);
                i++; j--;
            }
            if (i>j) break;
        } while (true);
        if(l<j) QuickSort(arr, l, j);
        if(i<r) QuickSort(arr, i, r);
    }  
    public void QuickSort(int[] arr){
        QuickSort(arr,0 , arr.length-1);
    }
//selection sort
    void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
//insertion sort    
    void insertionSort (int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[++j] = key;
        }
    }
//merge sort
    void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void mergSsort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            mergSsort(arr, l, m);
            mergSsort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void mergSsort(int arr[]){
        mergSsort(arr, 0, arr.length - 1);
    }
//heap sort
     public void heapSort(int arr[]){
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapSort(arr, N, i);
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }
    }
    void heapSort(int arr[], int N, int i)
    {
        int largest = i;
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < N && arr[l] > arr[largest])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapSort(arr, N, largest);
        }
    }
//print
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Sort method= new Sort();
        int a[]={4,7,1,9,10,7,11,80,43,12,36,27};
        //method.bubbleSort(a);
        method.insertionSort(a);
        method.printArray(a);
    }
    
}
