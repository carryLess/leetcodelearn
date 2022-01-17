package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

/**
 * @Author carryless
 * @Date 2022/1/17
 * @Description 平衡二叉树
 * @Url https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _20220115 {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(getDeeper(root.left, 1) - getDeeper(root.right, 1)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public static Integer getDeeper(TreeNode root, int startDeep){
        if(root == null){
            return startDeep - 1;
        }
        return Math.max(getDeeper(root.left, startDeep + 1), getDeeper(root.right, startDeep + 1));
    }

    /**
     * 自下而上遍历，时间复杂度低
     * @param root
     * @return
     */
    public boolean isBalancedOfficial(TreeNode root){
        return height(root) >= 0;
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
