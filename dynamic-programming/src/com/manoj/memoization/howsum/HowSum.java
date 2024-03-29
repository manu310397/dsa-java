package com.manoj.memoization.howsum;

import java.util.*;

/*
 * CoderByte youtube channel
 * Return the combination of elements which results in target sum
 * howSum(7, [2, 3, 4, 7]) -> output could be either [3,4] or [7]
 */
/*
Take U Forward - Combination Sum
https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=8
*/

public class HowSum {
    private static final List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 7));
    private static final List<Integer> nums2 = new ArrayList<>(Arrays.asList(7, 14));
    private static final Map<Integer, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(howSum(7, nums, memo));
        System.out.println(howSum(300, nums2, memo));
    }

    private static List<Integer> howSum(int targetSum, List<Integer> nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (Integer num : nums) {
            int rem = targetSum - num;
            List<Integer> result = howSum(rem, nums, memo);

            if (result != null) {
                List<Integer> returnList = new ArrayList<>(result);
                returnList.add(num);
                memo.put(targetSum, returnList);
                return returnList;
            }
        }

        memo.put(targetSum, null);
        return null;
    }
}
