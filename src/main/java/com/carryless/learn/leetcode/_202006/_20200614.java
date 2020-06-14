package com.carryless.learn.leetcode._202006;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 *
 */
public class _20200614 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * 给你一个整数数组 arr 和一个目标值 target ，
	 * 请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近target （最接近表示两者之差的绝对值最小）。
	 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
	 * 请注意，答案不一定是 arr 中的数字。
	 *
	 * 示例 1：
	 * 输入：arr = [4,9,3], target = 10
	 * 输出：3
	 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
	 *
	 * 示例 2：
	 * 输入：arr = [2,3,5], target = 10
	 * 输出：5
	 *
	 * 示例 3：
	 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
	 * 输出：11361
	 *
	 * 提示：
	 * 1 <= arr.length <= 10^4
	 * 1 <= arr[i], target <= 10^5
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int findBestValue(int[] arr, int target) {
		/**
		 * 解题思路：
		 * 	1.如果数组的所有元素之和小于 target ，则直接返回数组最大值
		 * 	2.计算 ave = target / arr.lenget
		 * 	3.如果ave小于数组最小值，直接返回ave
		 * 		（判断ave是否是整除所得，如果非整除所得需要判断ave+1的情况）
		 * 	4.若果ave大于数组最大值，返回数组最大值
		 * 	5.如果ave在数组中间，按照边界 ave < result < max(arr) 枚举即可
		 */

		Arrays.sort(arr);
		int arrLength = arr.length;
		//数组最大最小值
		int minArr = arr[0];
		int maxArr = arr[arrLength - 1];
		//target 均值
		int ave = target / arrLength;

		if(ave <= minArr){
			//判断ave是否是整除所得，如果非整除所得需要判断ave+1的情况
			if(target % arrLength != 0){
				int aveN = ave + 1;
				int minResult = Math.abs(ave * arrLength - target);
				int minResultN = Math.abs(aveN * arrLength - target);
				if(minResultN < minResult){
					return aveN;
				}
			}
			return ave;
		}else if(ave >= maxArr){
			return maxArr;
		}

		int sum = 0;
		int left = -1;
		int leftIndex = -1;
		int sumLeft = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if(arr[i] >= ave && left != -1){
				left = arr[i];
				leftIndex = i;
				sumLeft = sum;
			}
		}

		if(sum <= target){
			return maxArr;
		}

		int minResult = sumLeft + (left * (arrLength - 1 - leftIndex));
		int minD = Math.abs(minResult - target);
		int resultLeft = left;

		while(left <= maxArr){
			left ++;
			if(left >= arr[leftIndex + 1]){
				sumLeft += arr[leftIndex + 1];
				leftIndex ++;
			}
			int minResultN = sumLeft + (left * (arrLength - 1 - leftIndex));
			int minDN = Math.abs(minResultN - target);
			if(minDN < minD){
				minResult = minResultN;
				minD = minDN;
				resultLeft = left;
			}else{
				break;
			}
		}

		return resultLeft;
	}
}
