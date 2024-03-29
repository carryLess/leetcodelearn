package com.carryless.learn.leetcode._202112;

import java.util.Arrays;

/**
 * @Author carryless
 * @Date 2021/12/27
 * @Description 26. 删除有序数组中的重复项
 * @url https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _20211227 {

    public static void main(String[] args) {
        int[] c = {1,2};
        System.out.println(removeDuplicatesOfficial(c));
        System.out.println("****************");
        for (int i : c) {
            System.out.println(i);
        }
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2
     * 不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * 提示：
     * 0 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     * Related Topics
     * 数组
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return 1;
        }
        int start = 0;
        int end = 1;
        int count = 1;
        while(end <= length - 1){
            if(nums[start] == nums[end]){
                end ++;
            }else{
                start = end;
                end ++;
                count ++;
            }
        }
        return count;
    }

    /**
     * ## 1.双指针的快慢指针法
     *
     * 这个方法使用最重要的点就是 **明确快慢指针分别代表的含义**, 写代码之前一定要明确两者的具体含义, 再来写代码就比较容易了.
     *
     * 比如在 移除元素 之中, 我们使用的双指针: **右指针right指向当前将要处理的元素, 左指针left指向下一个将要赋值的位置**. 其实在本题 删除有序数组的重复项 中, 两个指针的含义和 移除元素 之中的含义是**完全相同的**: 定义两个指针 fast 和 slow 分别为快指针和慢指针, 快指针表示遍历数组到达的下标位置, 慢指针表示下一个不同元素要填入的下标位置. 在表达上有点差别, 但是本质的思想是完全一致的.
     *
     * ## 2.和 移除元素 的不同
     *
     * 虽然在双指针的使用上, 两者的思想是一致的, 但是具体的使用过程还是**有点区别**的.
     *
     * 在 移除元素 中, 我们 **需要比较的对象** 是题目中的给定值, 而且是**唯一固定**的, 从头到尾都是没有任何变化的.
     *
     * 但是在本题中, 我们 需要比较的对象 不再是某个固定的元素了, 而是 **快指针指向位置的前一个元素和当前元素的比较**, 因为这样比较, 才能确定两个相邻的元素是否为 **重复元素**, 从而决定是否要保留当前元素, 这是两题最大的不同点.
     *
     * 还有一个小细节注意下, 因为 移除元素 中被移除的元素可能是任意一个位置的元素, 所以两个指针的下标都是 **从0开始** 的. 但是在本题中, 数组的第一个元素一定是被保留下来的元素, 所以我们直接从 第二个元素 开始遍历就可以了, 也就是 双指针的下标都是**从1开始**的.
     *
     * ## 3.本题的进阶版:每个元素最多出现两次
     *
     * 进阶版和原题的**唯一区别**就是: 并不是要把所有重复元素都删去, 而是允许 **每个元素最多出现两次**. 改动看似挺简单, 实则是有一定的难度的, 这也直接让本题由 简单 直接提升到 中等 的难度.
     *
     * 如果没有想通此题的变化, 还是比较难处理的, 很多人也有想到用一个**count变量**来记录每个元素出现的次数, 两次就不处理, 超过两次就进行删除等方法, 但真正实施起来还是有点绕的, 有兴趣的朋友可以自己尝试一下.
     *
     * 我们直接来分析**改进后的不同**, 也就是**进行比较的两个元素变化了**. 在原本的题目中, 只需要比较 快指针指向位置的前一个元素和当前元素 即可满足要求, 但是此题明显复杂的多.
     *
     * 首先由于我们并不知道哪些元素会重复多少次, 所以想直接通过快指针指向的元素进行区别是很困难的, 但是这时我们还可以利用**慢指针**来进行比较. 分析后会发现, 慢指针之前的所有元素都是我们处理好的元素, 也就是 每个元素最多出现两次, 所以如果 当前待检查元素 **nums[fast] 和 nums[slow−2]** 相同的话, 那么它的出现**必然就超过了两次**, 因为此时必然有nums[slow−2]=nums[slow−1]=nums[fast], 反正如果不相同, 也就代表 它的出现没有超过两次, 这样我们就找到了 两个需要比较的对象了, 此题也就没什么难点了.
     *
     * ## 4.本题的通解扩展
     *
     * 既然都已经扩展到了 每个元素最多出现两次了, 那么同样可以扩展为 **每个元素最多出现k次**, 这样就形成了此题的通解问题, 解决了这个问题, 只需把k替换一下, 我们就可以解决任意次数的问题了.
     *
     * 有了两次的经验之后, 其实这个扩展也很容易就理解了, 能够**保留的前提**是：**与当前写入的位置前面的第 k 个元素进行比较,不相同则保留**, 也就是直接比较 **nums[slow - k] 和 nums[fast]** 两个元素即可, 在两次的代码上稍微修改下就能实现了, 这样我们就成功的将这一类问题完美的解决了!
     * @param nums
     * @return
     */
    public static int removeDuplicatesOfficial(int[] nums){
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
