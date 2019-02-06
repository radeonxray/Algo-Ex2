public class QuickSort {

    // Partition function
    //As Parameters, takes an array, int low, int high
    //The purpose of the function, is to take the last element as a privot,
    //place the pivot at its correct position in the sorted array, and places all the smaller values (smaller than the pivot),
    //to the left of the pivot.
    //All the values that are greater than the pivot are placed on the right-side of the pivot.
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot)
            {
                i++;

                // Minor operation swapping the swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Minor operation to swap the arr[i+1] and the arr[high], or the pivot for that matter
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        //The return element (int) of the partition, which is i+1
        return i+1;
    }


    // The main sort function that implements the QuickSort(), in conjunction with the partition function
    // arr[], the array to be sorted,
    // int low, the starting index and the lowest value
    // int high, the last index
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            //pi is an int equal to the returning int of the partition, which have partitioned the index, such that arr[pi] is now in its right place
            int pi = partition(arr, low, high);


            //Sorting the elements (Recursively?) before the partition and after the partition.
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


    // Function to print an array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // The main function
    public static void main(String args[])
    {
        int arr[] = {81, 25, 37, 8, 10, 41,50,1,69,8,77};
        int n = arr.length;

        System.out.println("Start Array [Unsorted]:");
        printArray(arr);

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("The Sorted Array");
        printArray(arr);
    }
}
