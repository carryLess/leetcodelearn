package com.carryless.learn.leetcode._202006;

/**
 * 面试题46. 把数字翻译成字符串
 * 知识点 动态规划
 */
public class _20200609 {

	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}

	/**
	 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
	 * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
	 * <p>示例 1:
	 * <p>输入: 12258 输出: 5 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
	 * <p>提示：
	 * <p>0 <= num < 231
	 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int translateNum(int num) {

		/**
		 * 解题思路： 第i位数字可以分为两种情况
		 * 字符串第i位数字，可以当成一个数字解析
		 * 字符串第i位数字，可以和第 i-1 位数字一起解析 （前提条件是 10 <= (i - 1) <= 25）
		 * 所以 f(i) = f(i-1) + f(i-2)[10<=(i-1)<=25]
		 */

		String src = String.valueOf(num);
		String[] split = src.split("");
		int p = 0, q = 0, r = 1;
		for (int i = 0; i < split.length; i++) {
			p = q;
			q = r;
			r = 0;
			r += q;
			if (i == 0) {
				continue;
			}
			String temp = split[i - 1] + split[i];
			int tempInt = Integer.parseInt(temp);
			if (10 <= tempInt && tempInt <= 25) {
				r += p;
			}
		}
		return r;
	}

}
