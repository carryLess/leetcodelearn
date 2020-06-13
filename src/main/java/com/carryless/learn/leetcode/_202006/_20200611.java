package com.carryless.learn.leetcode._202006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *	739. 每日温度
 *	知识点：单调栈
 */
public class _20200611 {

	public static void main(String[] args) {
		int[] test = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(dailyTemperatures(test)));
	}

	/**
	 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
	 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
	 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
	 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/daily-temperatures
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int[] dailyTemperatures(int[] t) {
		/**
		 * 解题思路：暴力解法，遍历数组，每个元素向后遍历 时间复杂度O(n*n)，
		 * 使用 单调栈：
		 * 		1.创建一个栈
		 * 		2.遍历给定数组，当栈中元素为空的时候，入栈，当当前元素小于栈顶元素的时候入栈
		 * 		3.当当前元素大于栈顶元素的时候，出栈，并计算当前元素与栈顶元素的坐标差即为所需值
		 * 		4.当数组遍历完后，栈中还有元素，该元素对应的所求值为0
		 */
		int[] result = new int[t.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < t.length; i++) {
			while((!stack.empty()) && t[stack.peek()] < t[i]){
				Integer pop = stack.pop();
				result[pop] = i - pop;
			}
			//如果栈为空，则入栈
			if(stack.empty() || t[stack.peek()] >= t[i]){
				stack.push(i);
			}
		}
		while (!stack.empty()){
			result[stack.pop()] = 0;
		}
		return result;
	}
}
