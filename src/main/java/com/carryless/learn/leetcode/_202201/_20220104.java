package com.carryless.learn.leetcode._202201;

/**
 * @Author carryless
 * @Date 2022/1/4
 * @Description
 */
public class _20220104 {
    public static void main(String[] args) {

    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     *
     * 示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * 提示：
     *
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     *
     * Related Topics
     * 数组
     * 分治
     * 动态规划
     * @param nums
     */
    /**
     * [-2,1,-3,4,-1,2,1,-5,4]
     * f(1) = -2 MAX=-2
     * f(2) = Max(f(1) + nums[2], nums[2]} = 1 MAX=1
     * f(3) = Max(f(2) + nums[3], nums[3]) = -2 Max=1
     * f(4) = Max(f(3) + nums[4], num[4]) = 4 Max=4
     * f(5) = Max(f(4) + nums[5], num[5]) = 3 Max=4
     * f(6) = Max(f(5) + nums[6], nums[6]) = 5 Max=5
     * f(7) = Max(f(6) + nums[7], nums[7]) = 6 Max=6
     */

    public static int solution(int[] nums){
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }

}
