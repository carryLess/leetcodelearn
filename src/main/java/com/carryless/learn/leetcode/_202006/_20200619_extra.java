package com.carryless.learn.leetcode._202006;

import java.util.*;

/**
 * _20200617_extra
 */
public class _20200619_extra {
	public static void main(String[] args) {
		int[][] a = new int[][]{{5,8},{2,5}};
		System.out.println(merge(a));
	}


	/**
	 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
	 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
	 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
	 *
	 * 示例 1：
	 * 输入：
	 * nums = [1, 7, 3, 6, 5, 6]
	 * 输出：3
	 * 解释：
	 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
	 * 同时, 3 也是第一个符合要求的中心索引。
	 *
	 * 示例 2：
	 * 输入：
	 * nums = [1, 2, 3]
	 * 输出：-1
	 * 解释：
	 * 数组中不存在满足此条件的中心索引。
	 *
	 * 说明：
	 * nums 的长度范围为 [0, 10000]。
	 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/find-pivot-index
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param nums
	 * @return
	 */
	public static int pivotIndex(int[] nums) {
		/**
		 * 定义一个等长的数组，存储每个位置到0号索引位置的和
		 * 遍历集合
		 */
		int[] sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}

		//初始化result为-1
		int result = -1;

		for (int i = 0; i < sums.length; i++) {
			int left = sums[i] - nums[i];
			int right = sum - sums[i];
			if(left == right){
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 *
	 * 你可以假设数组中无重复元素。
	 *
	 * 示例 1:
	 * 输入: [1,3,5,6], 5
	 * 输出: 2
	 *
	 * 示例 2:
	 * 输入: [1,3,5,6], 2
	 * 输出: 1
	 *
	 * 示例 3:
	 * 输入: [1,3,5,6], 7
	 * 输出: 4
	 *
	 * 示例 4:
	 * 输入: [1,3,5,6], 0
	 * 输出: 0
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/search-insert-position
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int searchInsert(int[] nums, int target) {
		/**
		 * 解题思路：二分法
		 */

		int length = nums.length;
		if(nums[0] > target){
			return 0;
		}
		if(nums[length - 1] < target){
			return length;
		}

		int left = 0;
		int right = length - 1;

		int middle = 0;

		while (left < right){
			middle = (left + right) / 2;
			if(nums[middle] < target){
				left = middle + 1;
			}else{
				right = middle;
			}
		}
		int middleNum = nums[middle];
		if(target <= middleNum){
			return middle;
		}else {
			return middle + 1;
		}
	}

	/**
	 * 给出一个区间的集合，请合并所有重叠的区间。
	 *
	 * 示例 1:
	 * 输入: [[1,3],[2,6],[8,10],[15,18]]
	 * 输出: [[1,6],[8,10],[15,18]]
	 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 *
	 * 示例 2:
	 * 输入: [[1,4],[4,5]]
	 * 输出: [[1,5]]
	 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/merge-intervals
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int[][] merge(int[][] intervals) {
		/**
		 * 先排序，然后遍历，与list中最后一个数值进行比较
		 */
		if(intervals.length <= 1){
			return intervals;
		}
		Arrays.sort(intervals, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});
		int[] a = new int[]{};
		List<Integer> resultList = new ArrayList<>();
		int[] first = intervals[0];
		resultList.add(first[0]);
		resultList.add(first[1]);

		for (int i = 1; i < intervals.length; i++) {
			int[] temp = intervals[i];
			int start = temp[0];
			int end = temp[1];
			int sLength = resultList.size();
			//判定标准
			int flag = resultList.get(sLength - 1);
			if(start > flag){
				resultList.add(start);
				resultList.add(end);
			}else if(start == flag){
				resultList.set(sLength - 1, end);
			}else if(start < flag){
				if(end >= flag){
					resultList.set(sLength - 1, end);
				}
			}
		}
		boolean ifnew = true;
		int lIndex = 0;
		int rIndex = 0;
		int resultLength = resultList.size() / 2;
		int[][] result = new int[resultLength][2];
		for (Integer integer : resultList) {
			result[lIndex][rIndex] = integer;
			ifnew = !ifnew;
			rIndex ++;
			if(ifnew){
				lIndex ++ ;
				rIndex = 0;
			}
		}
		return result;
	}
}
