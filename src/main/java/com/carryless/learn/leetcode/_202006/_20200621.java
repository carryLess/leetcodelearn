package com.carryless.learn.leetcode._202006;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class _20200621 {

	public static void main(String[] args) {
		String ss = "a good   example";
		reverseWords(ss);
	}

	/**
	 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
	 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
	 *
	 * 示例 1：
	 * 输入: "the sky is blue"
	 * 输出: "blue is sky the"
	 *
	 * 示例 2：
	 * 输入: "  hello world!  "
	 * 输出: "world! hello"
	 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	 *
	 * 示例 3：
	 * 输入: "a good   example"
	 * 输出: "example good a"
	 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	 *
	 * 说明：
	 * 无空格字符构成一个单词。
	 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		/**
		 * 解题思路
		 * 	去除首尾空格，根据空格切分
		 */
		String trimS = s.trim();
		String[] s1 = trimS.split(" ");
		StringBuilder sb = new StringBuilder();
		int length = s1.length;
		for (int i = length - 1; i >= 0; i--) {
			String oneTrim = s1[i];
			if("".equals(oneTrim)){
				continue;
			}
			sb.append(oneTrim);
			if(i != 0){
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
	 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
	 *
	 * 示例 1:
	 * 输入: [0,1,3]
	 * 输出: 2
	 *
	 * 示例 2:
	 * 输入: [0,1,2,3,4,5,6,7,9]
	 * 输出: 8
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		/*int initNum = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != initNum){
				return initNum;
			}
			initNum ++;
		}
		return initNum;*/
		int i = 0,j = nums.length - 1;
		while (i < j){
			int m = (i + j) / 2;
			if(nums[m] == m){
				i = m + 1;
			}else{
				j = m;
			}
		}
		return i;
	}
}
