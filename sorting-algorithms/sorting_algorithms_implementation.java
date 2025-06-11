//in java 
public class sorting_algorithms_implementation
{
    public static int[] Bubble_Sort(int[] arr)
    {
        int n = arr.length ;
        for(int i =0;i<n-1 ;i++)
        {
            boolean swap = false ;
            for(int j=0;j<n-1-i ;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                    swap = true ;
                }
            }
            if (!swap )
                break ;
        }
        return arr ;
    }
    
    public static int[] Selection_Sort(int[] arr)
    {
        int n = arr.length ;
        int temp ;
        for (int i =0;i<n-1;i++)
        {
            int minIndex = i ;
            for(int j=i+1; j<n ;j++)
            {
                if(arr[j] < arr[minIndex])
                    minIndex = j ;
            }
            // swap(&arr[i] , &arr[minIndex]) ;
            temp = arr[i] ;
            arr[i] = arr[minIndex] ;
            arr[minIndex] = temp ;
        }
        return arr ;
    }
    
    public static int[] Insertion_Sort(int[] arr)
    {
        int n = arr.length ;
        int key ;
        int j ;
        for(int i=1;i<n;i++)
        {
            key = arr[i] ;
            j = i - 1 ;
            while(j>=0 && arr[j]>key)
            {
                arr[j+1] = arr[j] ;
                j-- ;
            }
            arr[j+1] = key ;
        }
        return arr ;
    }
    
    public static void Merge(int[] arr , int start , int mid , int end)
    {
        int n1 = mid - start + 1 ;
        int n2 = end - mid ;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for(int i=0;i<n1;i++)
            left[i] = arr[start+i] ;
        
        for(int i=0;i<n2;i++)
            right[i] = arr[mid+1+i];
        
        int i = 0 , j = 0 , k = start;
        while(i<n1 && j<n2) 
        {
            if(left[i] < right[j])
                arr[k++] = left[i++] ;
            else 
                arr[k++] = right[j++] ;
        }
        while(i<n1)
            arr[k++] = left[i++] ;
        
        while(j<n2)
            arr[k++] = right[j++] ;
    }
    public static void Merge_Sort(int[] arr , int start , int end )
    {
        if (start < end) 
        {
            int mid = (end+start) / 2;
            Merge_Sort(arr , start , mid ) ;
            Merge_Sort(arr , mid+1 , end) ;
            Merge(arr , start , mid , end) ;
        }
    }
    
    public static int partition(int[] arr , int start , int end )
    {
        int pivot = arr[start]  ;//starting element as pivot 
        int i = start ; // i-searches for element greater than pivot
        int j = end ; //j-searches for element lesser or equal than pivot
        int temp ;
        while(i<j)
        {
            while(i<=end && arr[i]<=pivot) 
                i++ ;
            
            while(j>=start && arr[j]>pivot)
                j-- ;
            
            if(i<j)
            {
                // swap jth and ith element
                temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
            }
        }
        // swap the jth element with pivot
        temp = arr[start] ;
        arr[start] = arr[j] ;
        arr[j] = temp ;
        return j ;
    }
    public static void Quick_Sort(int[] arr , int start , int end )
    {
        if(start < end )
        {
            int q = partition(arr , start , end ) ;
            Quick_Sort(arr , start , q-1 ) ;
            Quick_Sort(arr , q+1 , end ) ;
        }
    }
    public static void max_heapify(int[] arr, int i , int n)
    {
        int largest = i ;
        int left = 2*i + 1 ;
        int right = 2*i+ 2 ;
        if(left<n && arr[left]>arr[largest])
            largest = left ;
        if(right <n && arr[right]>arr[largest])
            largest = right ;
        if(largest!=i)
        {
            // swap(arr[i] , arr[largest])
            int temp = arr[i] ;
            arr[i] = arr[largest] ;
            arr[largest] = temp ;
            max_heapify(arr, largest , n) ;
        }
    }
    public static void build_max_heap(int[] arr , int n)
    {
        for(int i=n/2 -1 ; i>=0 ; i--)
            max_heapify(arr , i , n) ;
    }
    public static void Heap_Sort(int[] arr)
    {
        int n = arr.length ;
        build_max_heap(arr,n) ;
        for(int i= n-1 ; i>=1 ; i--)
        {
            // swap(arr[i] , arr[0]) ;
            int temp = arr[i] ;
            arr[i] = arr[0] ;
            arr[0] = temp ;
            max_heapify(arr , 0 , i) ;
        }
    }
	public static void main(String[] args) {
		int[] arr = {90,98,78 ,35, 45, -100 , 9,-12,23,41, 100} ;
        Quick_Sort(arr , 0 , arr.length-1);
        Merge_Sort(arr , 0 , arr.length-1)
        Heap_Sort(arr) ;
        for (int num : arr) {
            System.out.print(num + " ");
        }
	}
}


// in python
// class SortingAlgorithms:
    
//     def bubble_sort(self, arr):
//         n = len(arr)
//         for i in range(n - 1):
//             swap = False
//             for j in range(n - 1 - i):
//                 if arr[j] > arr[j + 1]:
//                     arr[j], arr[j + 1] = arr[j + 1], arr[j]
//                     swap = True
//             if not swap:
//                 break
//         return arr

//     def selection_sort(self, arr):
//         n = len(arr)
//         for i in range(n - 1):
//             min_index = i
//             for j in range(i + 1, n):
//                 if arr[j] < arr[min_index]:
//                     min_index = j
//             arr[i], arr[min_index] = arr[min_index], arr[i]
//         return arr

//     def insertion_sort(self, arr):
//         n = len(arr)
//         for i in range(1, n):
//             key = arr[i]
//             j = i - 1
//             while j >= 0 and arr[j] > key:
//                 arr[j + 1] = arr[j]
//                 j -= 1
//             arr[j + 1] = key
//         return arr

//     def merge(self, arr, start, mid, end):
//         left = arr[start:mid + 1]
//         right = arr[mid + 1:end + 1]
//         i = j = 0
//         k = start
//         while i < len(left) and j < len(right):
//             if left[i] < right[j]:
//                 arr[k] = left[i]
//                 i += 1
//             else:
//                 arr[k] = right[j]
//                 j += 1
//             k += 1
//         while i < len(left):
//             arr[k] = left[i]
//             i += 1
//             k += 1
//         while j < len(right):
//             arr[k] = right[j]
//             j += 1
//             k += 1

//     def merge_sort(self, arr, start, end):
//         if start < end:
//             mid = (start + end) // 2
//             self.merge_sort(arr, start, mid)
//             self.merge_sort(arr, mid + 1, end)
//             self.merge(arr, start, mid, end)

//     def partition(self, arr, start, end):
//         pivot = arr[start]
//         i = start
//         j = end
//         while i < j:
//             while i <= end and arr[i] <= pivot:
//                 i += 1
//             while j >= start and arr[j] > pivot:
//                 j -= 1
//             if i < j:
//                 arr[i], arr[j] = arr[j], arr[i]
//         arr[start], arr[j] = arr[j], arr[start]
//         return j

//     def quick_sort(self, arr, start, end):
//         if start < end:
//             q = self.partition(arr, start, end)
//             self.quick_sort(arr, start, q - 1)
//             self.quick_sort(arr, q + 1, end)

//     def max_heapify(self, arr, i, n):
//         largest = i
//         left = 2 * i + 1
//         right = 2 * i + 2
//         if left < n and arr[left] > arr[largest]:
//             largest = left
//         if right < n and arr[right] > arr[largest]:
//             largest = right
//         if largest != i:
//             arr[i], arr[largest] = arr[largest], arr[i]
//             self.max_heapify(arr, largest, n)

//     def build_max_heap(self, arr, n):
//         for i in range(n // 2 - 1, -1, -1):
//             self.max_heapify(arr, i, n)

//     def heap_sort(self, arr):
//         n = len(arr)
//         self.build_max_heap(arr, n)
//         for i in range(n - 1, 0, -1):
//             arr[0], arr[i] = arr[i], arr[0]
//             self.max_heapify(arr, 0, i)
//         return arr


// # Example usage
// if __name__ == "__main__":
//     print("Hello World")
//     arr = [90, 98, 78, 35, 45, -100, 9, -12, 23, 41, 100]
    
//     sorting_algorithms = SortingAlgorithms()  # Create instance of SortingAlgorithms class
//     sorting_algorithms.heap_sort(arr)
//     print("Sorted array:", arr)

