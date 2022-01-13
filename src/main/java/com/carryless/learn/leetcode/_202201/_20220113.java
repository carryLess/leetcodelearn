package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author carryless
 * @Date 2022/1/13
 * @Description 对称二叉树
 * @Url https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _20220113 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 提示：
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     *
     * Related Topics
     * 树
     * 深度优先搜索
     * 广度优先搜索
     * 二叉树
     *
     * 思路：比较左右孩子是否相同即可，两种方式，深度优先，广度优先
     * [1,2,2,3,4,4,3]
     *          1
     *      2        2
     *    3    4   4   3
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isXMirrorDeep(root.left, root.right);
    }

    /**
     * 深度优先对比
     * @param a
     * @param b
     * @return
     */
    public static boolean isXMirrorDeep(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null || a.val != b.val){
            return false;
        }
        return isXMirrorDeep(a.left, b.right) && isXMirrorDeep(a.right, b.left);
    }

    /**
     * 广度优先遍历
     * @param a
     * @param b
     * @return
     */
    public static boolean isXMirrorWide(TreeNode a, TreeNode b){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(a);
        queue.offer(b);
        while (!queue.isEmpty()){
            a = queue.poll();
            b = queue.poll();
            if(a == null && b == null){
                continue;
            }
            if(a == null || b == null || a.val != b.val){
                return false;
            }
            queue.offer(a.left);
            queue.offer(b.right);
            queue.offer(a.right);
            queue.offer(b.left);
        }
        return true;
    }
}
