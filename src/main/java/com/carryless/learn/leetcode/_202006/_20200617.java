package com.carryless.learn.leetcode._202006;

import java.util.Arrays;

/**
 * 1014. 最佳观光组合
 */
public class _20200617 {

	public static void main(String[] args) {
		int[] testcase = new int[]{8,1,5,2,6};
		System.out.println(solutionOfficial(testcase));
	}

	/**
	 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
	 *
	 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
	 *
	 * 返回一对观光景点能取得的最高分。
	 *
	 * 示例：
	 * 输入：[8,1,5,2,6]
	 * 输出：11
	 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
	 *
	 * 提示：
	 * 2 <= A.length <= 50000
	 * 1 <= A[i] <= 1000
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int maxScoreSightseeingPair(int[] A) {
		return 0;
	}


	/**
	 * 解题思路：Max: int[i] + int[j] + i - j
	 * 		分为 int[i] + i, int[j] - j
	 * 		以j为基准遍历 数组前面j-1，最大值即为j-1里面最大Max的结果值
	 * 		分别定义	ans, maxi,从j = 1,开始遍历
	 * @param A
	 * @return
	 */
	public static int solutionOfficial(int[] A) {
		int ans = 0;
		int maxi = A[0] + 0;
		for (int j = 1; j < A.length; j++) {
			ans = Math.max(ans, maxi + A[j] - j);
			maxi = Math.max(maxi, A[j] + j);
		}
		return ans;
	}

	/**
	 * 错误解法
	 * @param A
	 * @return
	 */
	public static int solution2(int[] A){
		/**
		 * Max: int[i] + int[j] + i - j
		 * 解题思路：
		 * 		1.遍历数组
		 * 			* 每个元素改为 int[i] + i
		 * 		 	* 每个元素改为 int[j] - j
		 * 		2.排序取最大两个值相加
		 */
		int[] iArr = new int[A.length];
		int[] jArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			iArr[i] = A[i] + i;
			jArr[i] = A[i] - i;
		}
		Arrays.sort(iArr);
		Arrays.sort(jArr);
		System.out.println(Arrays.toString(iArr));
		System.out.println(Arrays.toString(jArr));
		return iArr[A.length - 1] + jArr[A.length - 1];
	}

	/**
	 * 暴力破解法
	 * @param A
	 * @return
	 */
	public static int forceSolution(int[] A){
		/**
		 * 解题思路： 暴力破解法，时间复杂度 n * n
		 */
		//和, i, j
		int[] resultMax = new int[]{0, 0, 0};
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int sum = resultMax[0];
				int iR = resultMax[1];
				int jR = resultMax[2];
				int sumN = A[i] + A[j] + i - j;
				if(sum < sumN){
					resultMax[0] = sumN;
					resultMax[1] = i;
					resultMax[2] = j;
				}
			}
		}
		return resultMax[0];
	}
}
