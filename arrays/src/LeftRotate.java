import java.util.Scanner;

public class LeftRotate {
    public static void main(String[] args) {
        int input[] = IOUtility.getInputArray();

        String msg = "Original Array";
        IOUtility.printArray(input, msg);

        int position = IOUtility.getPosition();
        leftRotateArray(input, position);
        
        msg = "Left Rotated array";
        IOUtility.printArray(input, msg);
    }

    private static void leftRotateArray(int[] array, int position) {
        if(position == 0) return;

        int length = array.length;

        reverseArray(array, 0, position-1);
        reverseArray(array, position, length-1);
        reverseArray(array, 0, length-1);
    }

    private static void reverseArray(int array[], int start, int end) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


}
