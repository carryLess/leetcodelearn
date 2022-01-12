package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author carryless
 * @Date 2022/1/12
 * @Description 相同的树
 * @Url https://leetcode-cn.com/problems/same-tree/
 */
public class _20220112 {

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1：
     * 输入：p = [1,2,3], q = [1,2,3] 输出：true
     *
     * 示例 2：
     * 输入：p = [1,2], q = [1,null,2] 输出：false
     *
     * 示例 3：
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     * 提示：
     *
     * 两棵树上的节点数目都在范围 [0, 100] 内
     * -104 <= Node.val <= 104
     * Related Topics
     * 树
     * 深度优先搜索
     * 广度优先搜索
     * 二叉树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null){
            return false;
        }
        if(q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 广度优先遍历
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeWidely(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            //一次性弹出两个节点进行比较
            p = queue.poll();
            q = queue.poll();
            //如果两个都为空则比较下一组
            if(p == null && q == null){
                continue;
            }
            if(p == null || q == null || p.val != q.val){
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.left);

            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }


    public static List<Integer> getTreeNumList(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.poll();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
