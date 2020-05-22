import java.util.Scanner;

public class IOUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int[] getInputArray() {
        System.out.println("Enter length of the input array");
        int length = sc.nextInt();

        int[] input = new int[length];
        int count = 0;

        System.out.println("Enter elements of the input array");
        while (count < length && sc.hasNextInt()) input[count++] = sc.nextInt();

       return input;
    }

    public static int getPosition() {
        System.out.println("Please provide the number by how much array should be rotated");
        return sc.nextInt();
    }

    public static int getSearchElement() {
        System.out.println("Please provide the key to be searched in an array");
        return sc.nextInt();
    }

    public static void printArray(int[] array, String msg) {
        System.out.println(msg);
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
