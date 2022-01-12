package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.*;

/**
 * @Author carryless
 * @Date 2022/1/12
 * @Description 二叉树的中序遍历
 * @Url https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _20220111 {

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[2,1]
     *
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * Related Topics
     * 栈
     * 树
     * 深度优先搜索
     * 二叉树
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        addList(root, list);
        return list;
    }

    public static void addList(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        addList(node.left, list);
        list.add(node.val);
        addList(node.right, list);
    }

    /**
     * 递归方法比较简单，现在尝试使用迭代方法
     */
    public List<Integer> inorderTraversalItrator(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queen = new LinkedList<>();
        while (root != null || !queen.isEmpty()){
            while (root != null){
                queen.push(root);
                root = root.left;
            }
            root = queen.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
