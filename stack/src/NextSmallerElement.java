import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerEle(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(5, 0));

        // virtually double the array
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= st.peek()) {
                st.poll();
            }

            if (!st.isEmpty()) {
                ans.add(i, st.peek());
            } else {
                ans.set(i, -1);
            }

            st.push(nums[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerEle(nums));
    }
}
