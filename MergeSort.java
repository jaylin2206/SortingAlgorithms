public class MergeSort {

    public static int[] MergeSort(int[] data) {
        if (data.length > 1) {
            int[] left = new int[data.length / 2];
            for(int i = 0; i < left.length; i++) {
                left[i] = data[i];
            }
            int[] right = new int[data.length - left.length];
            for(int i = 0; i < right.length; i++) {
                right[i] = data[i + left.length];
            }

            int[] L = MergeSort(left);
            int[] R = MergeSort(right);
            return merge(L, R);
        }
        else return data;
    }

    // merge 2 sorted arrays
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[ left.length + right.length];
        int leftCount = 0;
        int rightCount = 0;
        int mergedIndex = 0;

        while (leftCount < left.length && rightCount < right.length) {
            if (left[leftCount] < right[rightCount]) {
                merged[mergedIndex++] = left[leftCount++];
            }
            else {
                merged[mergedIndex++] = right[rightCount++];
            }
        }

        if (leftCount == left.length) {
            while (rightCount < right.length) {
                merged[mergedIndex++] = right[rightCount++];
            }
        }
        else {
            while (leftCount < left.length) {
                merged[mergedIndex++] = left[leftCount++];
            }
        }

        return merged;
    }
}
