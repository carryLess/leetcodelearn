package com.carryless.learn.leetcode._202006;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class _20200616 {

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		TreeNode eLeft = new TreeNode(2);
		TreeNode eRight = new TreeNode(3);
		root.left = eLeft;
		root.right = eRight;

		TreeNode endLeft = new TreeNode(4);
		TreeNode endRight = new TreeNode(5);

		eRight.left = endLeft;
		eRight.right = endRight;

		String serialize = serialize(root);
		System.out.println(serialize);*/

		String str = "[1,2,3,None,None,4,5,None,None,None,None]";
		//TreeNode deserialize = deserialize(str);
		//System.out.println(serialize(deserialize));


	}

	/**
	 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
	 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
	 *
	 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
	 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
	 *
	 * 示例: 
	 * 你可以将以下二叉树：
	 *
	 *     1
	 *    / \
	 *   2   3
	 *      / \
	 *     4   5
	 *
	 * 序列化为 "[1,2,3,null,null,4,5]"
	 * [1,2,3,None,None,4,5,None,None,None,None]
	 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
	 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
	 *
	 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		/**
		 * 解题思路：二叉树的遍历
		 */
		if(root == null){
			return null;
		}
		StringBuilder sb = new StringBuilder("[");
		Queue<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.offer(root);
		while (!nodesQueue.isEmpty()){
			TreeNode poll = nodesQueue.poll();
			if(poll == null){
				sb.append("None,");
			}else{
				sb.append(poll.val + ",");
				nodesQueue.offer(poll.left);
				nodesQueue.offer(poll.right);
			}
		}
		sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	public TreeNode deserialize(String data) {

		if(data == null){
			return null;
		}

		String substring = data.substring(1, data.length() - 1);
		String[] nodeStrs = substring.split(",");		//获取节点数组

		//首先，根节点肯定是第一个元素
		TreeNode root = getNode(nodeStrs[0]);
		if(root == null){
			return root;
		}
		//是否是左节点标识
		boolean isLeft = true;

		//定义父节点queue
		Queue<TreeNode> parents = new LinkedList<>();
		//初始parent节点是root
		parents.offer(root);
		TreeNode parent = parents.poll();
		//从第二个节点开始遍历
		for (int i = 1; i < nodeStrs.length; i++) {
			TreeNode node = getNode(nodeStrs[i]);
			if(isLeft){
				parent.left = node;
			}else{
				parent.right = node;
			}

			isLeft = !isLeft;

			//如果该节点不为空，那他必定是一个父节点（包括左右节点为空的节点）
			if(node != null){
				parents.offer(node);
			}

			//如果isLeft，说明当前父节点的左右节点已经写入完成，可以写下一个父节点的左右节点
			if(isLeft){
				parent = parents.poll();
			}
		}
		return root;
	}

	/**
	 * 根据字符串获取节点
	 * @param val
	 * @return
	 */
	public TreeNode getNode(String val){
		if("None".equals(val)){
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}