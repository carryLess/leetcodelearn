package com.carryless.learn.leetcode._202006;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 1028. 从先序遍历还原二叉树
 */
public class _20200618 {

	public static void main(String[] args) {
		//String s = "1-401--349---90--88";
		String s = "10-7--8";
		TreeNode treeNode = recoverFromPreorder(s);
		System.out.println(treeNode);
	}

	/**
	 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
	 *
	 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
	 * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
	 *
	 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
	 * 给出遍历输出 S，还原树并返回其根节点 root。
	 *
	 * 示例 1：
	 *
	 * 输入："1-2--3--4-5--6--7"
	 * 输出：[1,2,5,3,4,6,7]
	 *
	 * 示例 2：
	 * 输入："1-2--3---4-5--6---7"
	 * 输出：[1,2,5,3,null,6,null,4,null,7]
	 *
	 * 示例 3：
	 * 输入："1-401--349---90--88"
	 * 输出：[1,401,null,349,88,90]
	 *
	 * 提示：
	 *
	 * 原始树中的节点数介于 1 和 1000 之间。
	 * 每个节点的值介于 1 和 10 ^ 9 之间。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param s
	 * @return
	 */
	public static TreeNode recoverFromPreorder(String s) {
		Stack<TreeNode> parentStack = new Stack<>();
		if(s == null || s.length() == 0){
			return null;
		}
		//取出第一个数字
		String sroot = s.split("-")[0];
		TreeNode root = getTreeNode(sroot);
		parentStack.add(root);
		int chartLeave = 0;
		String sTemp = "";

		for (int i = sroot.length(); i < s.length() ; i++) {
			if("-".equals(String.valueOf(s.charAt(i)))){
				chartLeave ++;
				continue;
			}else{
				sTemp += String.valueOf(s.charAt(i));
				if(i < s.length() - 1 && !"-".equals(String.valueOf(s.charAt(i+1)))){
					continue;
				}

				TreeNode treeNode = getTreeNode(sTemp);
				int stackDeep = parentStack.size();

				while (stackDeep > chartLeave){
					parentStack.pop();
					stackDeep = parentStack.size();
				}

				if(stackDeep == chartLeave){
					TreeNode parent = parentStack.peek();
					if(parent.left == null){
						parent.left = treeNode;
					}else{
						parent.right = treeNode;
					}
					parentStack.add(treeNode);
				}
				chartLeave = 0;
				sTemp = "";
			}
		}

		return root;
	}

	public static TreeNode getTreeNode(String charAt){
		int i = Integer.parseInt(charAt);
		return new TreeNode(i);
	}
}

