package com.carryless.learn.leetcode._202006;

/**
 * @Author carryLess
 * @Date 2020/6/19 0:03
 * @Describe
 */
public class _20200619 {

	public static void main(String[] args) {
		System.out.println(new char[]{'a'});
	}

	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * 说明：本题中，我们将空字符串定义为有效的回文串。
	 *
	 * 示例 1:
	 * 输入: "A man, a plan, a canal: Panama"
	 * 输出: true
	 *
	 * 示例 2:
	 * 输入: "race a car"
	 * 输出: false
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/valid-palindrome
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static boolean isPalindrome(String s) {
		/**
		 * 解题思路：双指针
		 */
		String sUpper = s.toUpperCase();
		int left = 0;
		int right = sUpper.length() - 1;

		while (left < right){
			char leftC = sUpper.charAt(left);
			char rightC = sUpper.charAt(right);

			while (!((leftC >= '0' && leftC <= '9') || (leftC >= 'A' && leftC <= 'Z')) && left < right){
				left ++;
				leftC = sUpper.charAt(left);
			}
			while (!((rightC >= '0' && rightC <= '9') || (rightC >= 'A' && rightC <= 'Z')) && left < right){
				right --;
				rightC = sUpper.charAt(right);
			}
			if(leftC != rightC){
				return false;
			}else{
				left ++;
				right --;
			}
		}
		return true;
	}
}
