public class Quick {
    
    public static int QuickSelect( int[] data, int start, int end, int k ) {

        int pivot = partition( data, start, end);
        if (pivot > k - 1) return QuickSelect(data, start, pivot - 1, k);
        else if (pivot < k - 1) return QuickSelect(data, pivot + 1, end, k);
        return data[k - 1];
    }

    public static void QuickSort(int[] data, int start, int end) {
        if (start < end) {
            int pivot = partition(data, start, end);
            QuickSort(data, start, pivot - 1);
            QuickSort(data, pivot + 1, end);
        }
    }
    
    public static int partition( int[] data, int start, int end ) {
        int pivot = (int) (Math.random() * (end - start)) + start;
        int k = data[pivot];

        if (pivot != start) {
            swapElements(data, pivot, start);
            pivot = start;
            start += 1;
        }
        
        while (start != end) {
            if (data[start] > k) {
                swapElements( data, end, start);
                end -= 1;
            }
            else start += 1;
        }

        if (data[start] <= k) {
            swapElements( data, pivot, start);
            pivot = start;
        }
        else {
            swapElements (data, start - 1, pivot);
            pivot = start - 1;
        }

        return pivot;   
    }

    public static void swapElements( int[] data, int aIndex, int bIndex) {
        int swap = data[aIndex];
        data[aIndex] = data[bIndex];
        data[bIndex] = swap;
    }

}
