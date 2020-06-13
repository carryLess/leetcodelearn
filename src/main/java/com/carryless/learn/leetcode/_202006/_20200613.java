package com.carryless.learn.leetcode._202006;

/**
 * 70. 爬楼梯
 * 典型的动态规划
 */
public class _20200613 {
	public static void main(String[] args) {
		System.out.println(climbStairs(4));

	}

	/**
	 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 * 注意：给定 n 是一个正整数。
	 *
	 * 示例 1：
	 * 输入： 2
	 * 输出： 2
	 * 解释： 有两种方法可以爬到楼顶。
	 * 1.  1 阶 + 1 阶
	 * 2.  2 阶
	 *
	 * 示例 2：
	 * 输入： 3
	 * 输出： 3
	 * 解释： 有三种方法可以爬到楼顶。
	 * 1.  1 阶 + 1 阶 + 1 阶
	 * 2.  1 阶 + 2 阶
	 * 3.  2 阶 + 1 阶
	 *
	 */
	public static int climbStairs(int n) {
		/**
		 * 解题思路：没什么好说的
		 * 		f(n) = f(n-1) + f(n-2)
		 * 该题中n最小为 1
		 */
		int a = 1, b = 1, sum;
		for (int i = 0; i < n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return a;
	}
}
