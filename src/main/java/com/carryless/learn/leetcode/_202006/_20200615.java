package com.carryless.learn.leetcode._202006;

import sun.swing.StringUIClientPropertyKey;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class _20200615 {

	public static void main(String[] args) {
		String[] strss = new String[]{"dog","racecar","car"};
		String[] efStr = new String[]{"flower","flow","flight"}; // √
		//String[] efStr = {"c", "c"};
		System.out.println(dichotomyOffical(efStr));
	}

	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 如果不存在公共前缀，返回空字符串 ""。
	 *
	 * 示例 1:
	 * 输入: ["flower","flow","flight"]
	 * 输出: "fl"
	 *
	 * 示例 2:
	 * 输入: ["dog","racecar","car"]
	 * 输出: ""
	 * 解释: 输入不存在公共前缀。
	 *
	 * 说明:
	 * 所有输入只包含小写字母 a-z 。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static String longestCommonPrefix(String[] strs) {
		/**
		 *
		 *
		 */

		return null;
	}

	/**
	 * 解题思路（暴力破解法）：遍历第一个元素的每个字母然后检查其他元素
	 * @param strs
	 * @return
	 */
	public static String forceSolve(String[] strs){
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		StringBuilder result = new StringBuilder("");
		if(strs.length == 0){
			return result.toString();
		}else if(strs.length == 1){
			return strs[0];
		}else{
			String rootStr = strs[0];
			String[] split = rootStr.split("");
			boolean flag = true;
			for (int i = 0; i < split.length; i++) {
				String s = result.toString() + split[i];
				for(int j = 1; j < strs.length; j++){
					if(!strs[j].startsWith(s)){
						flag = false;
					}
				}
				if(flag){
					result.append(split[i]);
				}else{
					break;
				}
			}
		}
		return result.toString();
	}

	/**
	 * 二分法
	 * @param strs
	 * @return
	 */
	public static String dichotomy(String[] strs){
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		if(strs.length == 0){
			return "";
		}else if(strs.length == 1){
			return strs[0];
		}else{
			String sResult = "";
			String rootStr = strs[0];
			int length = rootStr.length();
			int left = 0, middle = length / 2;
			while (left <= middle){
				String sss = rootStr.substring(0, middle);
				boolean b = ifStartWith(strs, sss);
				if(b){
					sResult = sss;
					left = middle + 1;
					middle = (left + length) / 2;
				}else{
					middle = (middle - 1) / 2;
				}
			}
			return sResult;
		}

	}

	public static boolean ifStartWith(String[] strs, String commonStr){
		for (String str : strs) {
			if(!str.startsWith(commonStr)){
				return false;
			}
		}
		return true;
	}

	public static String dichotomyOffical(String[] strs){
		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}

		int low = 0;
		int high = minLength;

		while (low < high){
			int mid = (high - low) / 2 + low;
			if(ifStartWith(strs, strs[0].substring(0, mid))){
				low = mid;
			}else{
				high = mid - 1;
			}
		}

		return strs[0].substring(0, low);
	}




}
