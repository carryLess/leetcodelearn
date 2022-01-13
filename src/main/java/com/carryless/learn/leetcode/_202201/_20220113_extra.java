package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author carryless
 * @Date 2022/1/13
 * @Description
 */
public class _20220113_extra {


    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * Related Topics
     * 树
     * 深度优先搜索
     * 广度优先搜索
     * 二叉树
     * @param root
     * @return
     * @des 二叉树的最大深度
     * @url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        return calDeepLevel(root, 0);
    }

    /**
     * 深度优先遍历
     * @param node
     * @param level
     * @return
     */
    public static int calDeepLevel(TreeNode node, int level){
        if(node != null){
            return Math.max(calDeepLevel(node.left, level + 1), calDeepLevel(node.right, level + 1));
        }
        return level;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int maxDepthWide(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        Queue<TreeNode> queue = new LinkedList<>();
        if(left != null){
            queue.offer(left);
        }
        if(right != null){
            queue.offer(right);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
                size--;
            }
            result ++;
        }
        return result;
    }

}
