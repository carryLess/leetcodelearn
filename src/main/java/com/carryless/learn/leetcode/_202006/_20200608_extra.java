package com.carryless.learn.leetcode._202006;

/**
 * 面试题64. 求1+2+…+n 【中等】
 */
public class _20200608_extra {

	public static void main(String[] args) {
		System.out.println(sumNums(4));
	}

	/**
	 * 面试题64. 求1+2+…+n
	 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 * <p>
	 * 示例 1：
	 * 输入: n = 3
	 * 输出: 6
	 * <p>
	 * 示例 2：
	 * 输入: n = 9
	 * 输出: 45
	 * <p>
	 * 限制：
	 * 1 <= n <= 10000
	 */
	public static int sumNums(int n) {
		return (n + multi(n, n)) >> 1;
	}

	public static int multi(int a, int b) {
		int i = 0;
		int res = 0;
		while (b != 0) {//乘数为0则结束
			//处理乘数当前位
			if ((b & 1) == 1) {
				res += (a << i);
				b = b >> 1;
				++i;//i记录当前位是第几位
			} else {
				b = b >> 1;
				++i;
			}
		}
		return res;
	}
}
