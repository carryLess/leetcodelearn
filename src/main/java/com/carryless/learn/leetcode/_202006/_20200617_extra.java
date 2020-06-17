package com.carryless.learn.leetcode._202006;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * _20200617_extra
 */
public class _20200617_extra {
	public static void main(String[] args) {
		/*int a = 2;
		int b = 3;
		System.out.println(a + "---" + b);
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println(a + "---" + b);

		int[] arr = new int[]{1,2,3,4};
		int[] ints = exchange2(arr);*/
		//System.out.println(movingCount(38, 15, 9));
		_20200617_extra extra = new _20200617_extra();
		System.out.println("DFS_result:" + extra.movingCountDFS(38, 15, 9));
		System.out.println("BFS_result:" + extra.movingCountBFS(38, 15, 9));
	}


	/**
	 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
	 * 要求时间复杂度为O(n)。
	 * 示例1:
	 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 *
	 * 提示：
	 * 1 <= arr.length <= 10^5
	 * -100 <= arr[i] <= 100
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int maxSubArray(int[] nums) {
		/**
		 * 解题思路 dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
		 * 分两种情况：
		 * 		if(dp[i-1] <= 0) dp[i] = nums[i]
		 * 		if(dp[i-1] > 0)  dp[i] = dp[i-1] + nums[i]
		 */
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1] > 0){
				nums[i] += nums[i-1];
			}
			max = Math.max(max, nums[i]);
		}
		return max;
	}


	/**
	 * 面试题21. 调整数组顺序使奇数位于偶数前面
	 *
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
	 *
	 * 示例：
	 * 输入：nums = [1,2,3,4]
	 * 输出：[1,3,2,4]
	 * 注：[3,1,2,4] 也是正确的答案之一。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int[] exchange(int[] nums) {
		/**
		 * 解题思路：双指针
		 * 左指针：当当前左指针指向位置为奇数时候指针右移直至其为偶数
		 * 右指针：当当前右指针指向位置为偶数的时候指针左移直至其为奇数
		 * 判断左指针是否小于右指针，是则交换否则break
		 */
		int leftIndex = 0;
		int rightIndex = nums.length - 1;
		while (leftIndex < rightIndex){
			while ((nums[leftIndex] & 1) == 1 && leftIndex < rightIndex){
				leftIndex ++;
			}
			while ((nums[rightIndex] & 1) == 0 && leftIndex < rightIndex){
				rightIndex --;
			}
			if(leftIndex < rightIndex){
				int temp = nums[rightIndex];
				nums[rightIndex] = nums[leftIndex];
				nums[leftIndex] = temp;
			}
			leftIndex ++;
			rightIndex --;
		}
		return nums;
	}

	/**
	 * 快慢指针
	 * @param nums
	 * @return
	 */
	public static int[] exchange2(int[] nums) {
		int slow = 0, fast = 0;
		while (fast < nums.length){
			if((nums[fast] & 1) == 1){
				if(slow != fast){
					nums[fast] ^= nums[slow];
					nums[slow] ^= nums[fast];
					nums[fast] ^= nums[slow];
					slow++;
				}
			}
			fast++;
		}
		return nums;
	}

	/**
	 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
	 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
	 * 请问该机器人能够到达多少个格子？
	 *
	 * 示例 1：
	 * 输入：m = 2, n = 3, k = 1
	 * 输出：3
	 *
	 * 示例 2：
	 * 输入：m = 3, n = 1, k = 0
	 * 输出：1
	 *
	 * 提示：
	 * 1 <= n,m <= 100
	 * 0 <= k <= 20
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @return
	 */
	public static int movingCountError(int m, int n, int k) {
		/**
		 * 解题思路：二元数组，机器人一次只能走一个格子
		 */
		int count = 0;
		for (int i = 0; i < m; i++) {
			int sumI = getNumSum(i);
			for(int j = 0; j < n; j++){
				if ((sumI + getNumSum(j)) <= k){
					count++;
				}else{
					break;
				}
			}
			if(sumI > k){
				break;
			}
		}
		return count;
	}

	public static int getNumSum(int num){
		int sum = 0;
		while (num >= 10 && num / 10 > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum + num;
	}


	int m;
	int n;
	int k;
	boolean[][] visited;
	/**
	 *	精髓
	 *		1.定义boolean[][] visited 是否已经走到该区域
	 *		2.索引i的数字和为 S(i), 则S(i+1)有两种情况
	 *			当(i + 1) % 10 == 0时， S(i+1) = S(i) - 8, eg: 19 -> 10 : 10 -> 2 : 2 = 10 - 8
	 *			当(i + 1) % 10 != 0时， S(i+1) = S(i) + 1, eg: 18 -> 19 : 9 -> 10 : 10 = 9 + 1
	 *		转为状态方程即为 S(i+1) = (i+1) % 10 == 0 ? S(i) - 8 : S(i) + 1
	 */

	/**
	 * 深度优先：
	 * 		遍历某个格子时候分别向两个方向遍历到底，
	 * 		遍历的时候创建一个visited[][]二元数组，标识是否已经遍历
	 */
	public int movingCountDFS(int m, int n, int k) {
		this.m = m;
		this.n = n;
		this.k = k;
		this.visited = new boolean[m][n];
		return countDFS(0, 0, 0, 0);
	}
	public int countDFS(int i, int j, int iSum, int jSum){
		if(i >= m || j >= n || k < (iSum + jSum) || visited[i][j]){
			return 0;
		}
		visited[i][j] = true;
		return 1 + countDFS(i+1, j, (i+1) % 10 == 0 ? iSum - 8 : iSum + 1, jSum) + countDFS(i, j+1, iSum, (j+1) % 10 == 0 ? jSum - 8 : jSum + 1);
		//return 1 + countDFS(i+1, j, (i+1) % 10 != 0 ? iSum + 1 : iSum - 8, jSum) + countDFS(i, j+1, iSum, (j+1) % 10 != 0 ? jSum + 1 : jSum - 8);
	}

	/**
	 * 广度优先
	 */
	public int movingCountBFS(int m, int n, int k){
		Queue<int[]> queue = new LinkedList<>();
		this.visited = new boolean[m][n];
		int[] root = new int[]{0, 0, 0, 0};
		queue.offer(root);
		int res = 0;
		while (queue.size() > 0){
			int[] poll = queue.poll();
			int i = poll[0];
			int j = poll[1];
			int si = poll[2];
			int sj = poll[3];
			if(i >= m || j >= n || si + sj > k || visited[i][j]){
				continue;
			}
			visited[i][j] = true;
			res ++;
			queue.offer(new int[]{i+1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
			queue.offer(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});
		}
		return res;
	}
}
