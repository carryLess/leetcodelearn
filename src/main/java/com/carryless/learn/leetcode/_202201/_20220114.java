package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author carryless
 * @Date 2022/1/14
 * @Description 将有序数组转换为二叉搜索树
 * @Url https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _20220114 {

    public static void main(String[] args) {
        int[] a = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(a);
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 示例 1：
     * 输入：nums = [-10,-3,0,5,9] 输出：[0,-3,9,-10,null,5] 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 示例 2：
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     * 提示：
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     *
     * Related Topics
     * 树
     * 二叉搜索树
     * 数组
     * 分治
     * 二叉树
     *
     * 思路：广度优先遍历，使用Deque,依次赋值，数组为空后，结束
     * [-10,-3,0,5,9]
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int length = nums.length;
        int allowCount = length;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.offer(root);
        allowCount--;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode poll = queue.poll();
                if(length > 0){
                    poll.val = nums[length - 1];
                    length --;
                    if(allowCount > 0){
                        poll.left = new TreeNode();
                        queue.offer(poll.left);
                        allowCount--;
                    }
                    if(allowCount > 0){
                        poll.right = new TreeNode();
                        queue.offer(poll.right);
                        allowCount--;
                    }
                }else{
                    poll = null;
                }
                size --;
            }
        }
        return root;
    }


    public static TreeNode sortedArrayToBST2(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
            int length = nums.length;
        int allowCount = length;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.offer(root);
        allowCount--;
        boolean firstFlag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode poll = null;
                if(firstFlag){
                     poll = queue.removeFirst();
                }else{
                    poll = queue.removeLast();
                }
                firstFlag = !firstFlag;
                if(length > 0){
                    poll.val = nums[length - 1];
                    length --;
                    if(allowCount > 0){
                        poll.left = new TreeNode();
                        queue.offer(poll.left);
                        allowCount--;
                    }
                    if(allowCount > 0){
                        poll.right = new TreeNode();
                        queue.offer(poll.right);
                        allowCount--;
                    }
                }else{
                    poll = null;
                }
                size --;
            }
        }
        return root;
    }

    public static TreeNode sortedArrayToBSTOfficial(int[] nums) {
        return blanceTreeNode(nums, 0, nums.length);
    }

    public static TreeNode blanceTreeNode(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = blanceTreeNode(nums, start, middle - 1);
        treeNode.right = blanceTreeNode(nums, middle + 1, end);
        return treeNode;
    }

}
