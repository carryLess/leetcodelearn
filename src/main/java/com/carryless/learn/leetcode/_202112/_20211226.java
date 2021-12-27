package com.carryless.learn.leetcode._202112;


/**
 * @Author carryless
 * @Date 2021/12/26
 * @Description 合并两个有序链表
 * @url https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _20211226 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例 1:
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     * Related Topics
     * 递归
     * 链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //暴力解法&哑节点
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return root.next;
    }

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListRe(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoListRe(list1.next, list2);
            return list1;
        }
        if(list1.val > list2.val){
            list2.next = mergeTwoListRe(list2.next, list1);
            return list2;
        }
        return null;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
