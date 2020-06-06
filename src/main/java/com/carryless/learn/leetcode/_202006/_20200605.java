package com.carryless.learn.leetcode._202006;

/**
 * LCP 01. 猜数字
 */
public class _20200605 {
    public static void main(String[] args) {

    }

    /**
     *
     * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
     * 他们一共进行三次这个游戏，请返回 小A 猜对了几次
     *
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     *
     * 示例 1：
     * 输入：guess = [1,2,3], answer = [1,2,3]
     * 输出：3
     * 解释：小A 每次都猜对了。
     *  
     * 示例 2：
     * 输入：guess = [2,2,3], answer = [3,2,1]
     * 输出：1
     * 解释：小A 只猜对了第二次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *  
     * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
     *
     */
    public static int mySolution(int[] guess, int[] answer) {
        int result = 0;
        for(int i = 0; i <= 2; i++){
            if(guess[i] == answer[i]){
                result ++;
            }
        }
        return result;
    }
}
