package com.carryless.learn.leetcode._202006;

/**
 * 9. 回文数
 */
public class _20200610 {

	public static void main(String[] args) {
		System.out.println(isPalindromeOffical(121));
	}

	/**
	 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 *
	 * 示例 1:
	 * 输入: 121
	 * 输出: true
	 *
	 * 示例 2:
	 * 输入: -121
	 * 输出: false
	 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	 *
	 * 示例 3:
	 * 输入: 10
	 * 输出: false
	 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/palindrome-number
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static boolean isPalindrome(int x) {
		/**
		 * 解题思路：
		 * 	1.所有负数和10的整数倍不可能是回文数
		 * 	2.特殊情况：0为回文数
		 * 	3.左右索引开始对比，有一个不相等，返回false,否则为true
		 */
		if(x == 0){
			return true;
		}
		if(x < 0 || x % 10 == 0){
			return false;
		}
		String src = String.valueOf(x);
		int left = 0;
		int right = src.length() - 1;
		while (left < right){
			if(src.charAt(left) != src.charAt(right)){
				return false;
			}
			left ++;
			right --;
		}
		return true;
	}

	
	public static boolean isPalindromeOffical(int x){
		if((x < 0) || (x % 10 == 0 && x != 0)){
			return false;
		}
		int reverse = 0;
		while (x > reverse){
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return x == reverse || x == reverse / 10;
	}
}
