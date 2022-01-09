package com.carryless.learn.leetcode._202201;

import com.carryless.learn.leetcode.common.ListNode;

/**
 * @Author carryless
 * @Date 2022/1/9
 * @Description 删除排序链表中的重复元素
 * @Url https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _20220109 {

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * 返回同样按升序排列的结果链表。
     * 示例 1：
     * 输入：head = [1,1,2] 输出：[1,2]
     * 示例 2：
     * 输入：head = [1,1,2,3,3] 输出：[1,2,3]
     *
     * 提示：
     *
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode tempNode = head;
        while (tempNode.next != null){
            ListNode nextOne = tempNode.next;
            int val = tempNode.val;
            if(nextOne.val == val){
                tempNode.next = tempNode.next.next;
            }else {
                tempNode = tempNode.next;
            }
        }
        return head;
    }
}
