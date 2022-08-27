package com.manoj.memoization.howsum;

import java.util.*;

/*
* CoderByte youtube channel
* Return the combination of elements which results in target sum
* howSum(7, [2, 3, 4, 7]) -> output could be either [3,4] or [7]
 */
public class HowSum {
    private static List<Integer> nums = new ArrayList<>(Arrays.asList(1));
    private static Map<Integer, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(howSum(1000, nums, memo));
    }

    private static List<Integer> howSum(int targetSum, List<Integer> nums, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        for(Integer num: nums) {
            int rem = targetSum - num;
            List<Integer> result = howSum(rem, nums, memo);

            if(result != null) {
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