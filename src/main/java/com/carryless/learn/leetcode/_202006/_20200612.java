package com.carryless.learn.leetcode._202006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 */
public class _20200612 {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}


	/**
	 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
	 * 请你找出所有满足条件且不重复的三元组。
	 * 注意：答案中不可以包含重复的三元组。
	 *
	 * 示例：
	 *
	 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	 *
	 * 满足要求的三元组集合为：
	 * [
	 *   [-1, 0, 1],
	 *   [-1, -1, 2]
	 * ]
	 *
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		/**
		 * 解题思路：
		 * 		1.首先将数组排序
		 * 		2.遍历数组（当nums[i] == nums[i-1]的时候continue,作用是去重）
		 * 		3.设置两个指针 leftpoint rightpoint,计算三数之和，
		 * 			如果大于0，结果偏大，右指针左移
		 * 			如果小于0，结果偏小，左指针右移动
		 * 			如果等于0，加入结果集
		 * 	 	4.移动指针的时候判同（去重）
		 */
		Arrays.sort(nums);	//排序
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0){
			return result;
		}
		//for loop
		for (int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			//定义target, 左右指针对应的值相加需等于该值
			int target = nums[i];
			int leftpoint = i + 1;
			int rightpoint = nums.length - 1;
			while (leftpoint < rightpoint){
				int sum = target + nums[leftpoint] + nums[rightpoint];
				if(sum > 0) {
					rightpoint --;
				}else if(sum < 0) {
					leftpoint ++;
				}else{
					List<Integer> oneResult = new ArrayList<>();
					oneResult.add(nums[i]);
					oneResult.add(nums[leftpoint]);
					oneResult.add(nums[rightpoint]);
					result.add(oneResult);
					rightpoint --;
					leftpoint ++;
					while (rightpoint > i && nums[rightpoint] == nums[rightpoint + 1]){
						rightpoint --;
					}
					while (leftpoint < nums.length && nums[leftpoint] == nums[leftpoint - 1]){
						leftpoint ++;
					}
				}
			}
		}
		return result;
	}
}
