package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author carryless
 * @Date 2022/1/18
 * @Description 二叉树的最小深度
 * @Url https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _20220116 {


    /**
     * 定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     * 提示：
     * 树中节点数的范围在 [0, 105] 内
     * -1000 <= Node.val <= 1000
     * Related Topics
     * 树
     * 深度优先搜索
     * 广度优先搜索
     * 二叉树
     * [2,null,3,null,4,null,5,null,6]
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return height(root, 1);
    }

    public static int height(TreeNode tree, int height){
        if(tree == null){
            return height - 1;
        }
        TreeNode left = tree.left;
        TreeNode right = tree.right;
        if(left == null){
            return height(right, height + 1);
        }
        if(right == null){
            return height(left, height + 1);
        }
        int leftHeight = height(left, height + 1);
        int rightHeight = height(right, height + 1);
        return Math.min(leftHeight, rightHeight);
    }


    class QueueNode{
        TreeNode treeNode;
        int deep;
        QueueNode(TreeNode treeNode, int deep){
            this.treeNode = treeNode;
            this.deep = deep;
        }
    }


    /**
     * 广度优先
     * @param root
     * @return
     */
    public int minDepthWide(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        QueueNode queueNode = new QueueNode(root, 1);
        queue.offer(queueNode);
        while (!queue.isEmpty()){
            QueueNode poll = queue.poll();
            TreeNode treeNode = poll.treeNode;
            int deep = poll.deep;
            if(treeNode.left == null && treeNode.right == null){
                return deep;
            }
            if(treeNode.left != null){
                queue.offer(new QueueNode(treeNode.left, deep + 1));
            }
            if(treeNode.right != null){
                queue.offer(new QueueNode(treeNode.right, deep + 1));
            }
        }
        return 0;
    }

}
