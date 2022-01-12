package com.carryless.learn.leetcode.common;

/**
 * @Author carryLess
 * @Date 2020/6/18 9:13
 * @Describe
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	public TreeNode() {}
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
