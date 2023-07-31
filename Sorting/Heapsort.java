package Sorting;

public class Heapsort {

    // 1. build Heap array
    // 2. Heapify if needed to childrens and parents recursively
    // 3. swap the top element with the last element and heapify the rest of the array
    // 4. repeat step 3 until the array is sorted
    // 5. output is an sorted array
    
      //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        //build heap from the half and include children 
        for(int i=n/2 -1;i>=0;i--)
        heapify(arr,n,i);
    
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        
        int big = i;
        int left = 2*i+1;
        int right= 2*i+2;
        
        if(left<n && arr[left]>arr[big])
        big = left;
        
        if(right<n && arr[right]>arr[big])
        big = right;
        
        if(big!=i){
            arr[big] = (arr[big] + arr[i]) - (arr[i]=arr[big]);
            heapify(arr,n,big);
        }
        
        
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        
        buildHeap(arr, n);
    
        //sort heap move element from top to the back    
        for(int i=n-1;i>0;i--){
            arr[i] = (arr[i]+ arr[0]) - (arr[0]=arr[i]);
            heapify(arr, i,0);
        }
    }
}

