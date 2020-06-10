package com.carryless.learn.leetcode._202006;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author carryLess
 * @Date 2020/6/10 20:27
 * @Describe
 */
public class _20200610_extra {

	public static void main(String[] args) {
		System.out.println(numWaysOffical(44));
	}

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
	 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
	 * <p>
	 * 示例 1：
	 * 输入：n = 2
	 * 输出：2
	 * <p>
	 * 示例 2：
	 * 输入：n = 7
	 * 输出：21
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param n
	 * @return
	 */
	public static int numWays(int n) {
		/**
		 * 阶梯思路
		 * f(n) = f(n-1) + f(n-2)
		 */
		if (n == 1 || n == 0) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		return numWays(n - 1) + numWays(n - 2);
	}

	/**
	 * 上种方法使用递归，大量重复递归操作，不合适
	 *
	 * @param n
	 * @return
	 */
	public static int numWaysOffical(int n) {
		int p = 1, q = 1, sum;
		for (int i = 0; i < n; i++) {
			sum = (p + q) % 1000000007;
			p = q;
			q = sum;
		}
		return p;
	}




	/**
	 *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
	 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
	 *
	 * 示例：
	 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
	 * 返回链表 4->5.
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 解题思路
	 * 1.先遍历一边链表，记录出所有的Node的一个List
	 * 2.根据list.size - k 得到索引获取node节点
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode getKthFromEnd(ListNode head, int k) {
		List<ListNode> list = getListNodeArr(head);
		int all = list.size();
		return list.get(all - k);
	}

	public static List<ListNode> getListNodeArr(ListNode node){
		List<ListNode> resultList = new ArrayList<>();
		resultList.add(node);
		while(node.next != null){
			resultList.add(node.next);
			node = node.next;
		}
		return resultList;
	}

	/**
	 * 官方解法：双指针
	 * 1.定义：前节点和后节点，
	 * 2.前节点向前移动k步，这时前节点和后节点的距离为k
	 * 3.然后双指针同时移动，前节点为空时，后节点即为所需结果
	 */
	public static ListNode getKthFromEndOffical(ListNode head, int k) {
		ListNode former = head, later = head;
		for (int i = 0; i < k; i++) {
			former = former.next;
		}
		while (former != null){
			former = former.next;
			later = later.next;
		}
		return later;
	}
}
