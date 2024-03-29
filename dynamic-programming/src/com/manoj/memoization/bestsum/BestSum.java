package com.manoj.memoization.bestsum;

import java.util.*;

/*
 * CoderByte youtube channel
 * Return the best combination of elements which results in target sum
 * howSum(7, [2, 3, 4, 7]) -> output should be [7]
 */
public class BestSum {
    private static List<Integer> nums = new ArrayList<>(Arrays.asList(5, 3, 4, 100));
    private static Map<Integer, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(bestSum(7, nums, memo));
        System.out.println(bestSum(1000, nums, memo));
    }

    private static List<Integer> bestSum(int targetSum, List<Integer> nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestComb = null;

        for (int num : nums) {
            int rem = targetSum - num;
            List<Integer> remainderComb = bestSum(rem, nums, memo);

            if (remainderComb != null) {
                List<Integer> combination = new ArrayList<>(remainderComb);
                combination.add(num);

                if (shortestComb == null || combination.size() < shortestComb.size()) {
                    shortestComb = combination;
                    memo.put(targetSum, shortestComb);
                }
            }
        }

        return shortestComb;
    }
}
