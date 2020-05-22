public class SearchElement1 {
    public static void main(String args[]) {
        int input[] = IOUtility.getInputArray();

        int key  = IOUtility.getSearchElement();

        String msg = "Original Array";
        IOUtility.printArray(input, msg);

        int index = searchElement(input, key);
        System.out.println("Element found at "+index);
    }

    private static int searchElement(int[] array, int key) {
        int index = 0;
        int length = array.length;

        int pivot = findPivot(array, 0, length -1);

        if(pivot == -1)
            return binarySearch(array, 0, length-1, key);

        if(array[pivot] == key) return pivot;
        if(array[0] <= key) return binarySearch(array, 0, pivot-1, key);
        return binarySearch(array, pivot+1, length-1, key);
    }

    private static int findPivot(int[] array, int low, int high) {
        if(high < low) return -1;

        if(high == low) return low;

        int mid = low + (high - low)/2;

        if(array[mid] > array[mid+1]) return mid;
        if(array[mid] < array[mid-1]) return mid-1;
        if(array[low] >= array[mid]) findPivot(array, low, mid-1);
        return findPivot(array, mid+1, high);
    }

    private static int binarySearch(int[] array, int low, int high, int key) {
        if(high < low) return -1;

        int mid = low + (high-low)/2;
        if(key == array[mid]) return mid;
        if(key > array[mid]) return binarySearch(array, (mid+1), high, key);
        return binarySearch(array, low, (mid-1), key);
    }

}
