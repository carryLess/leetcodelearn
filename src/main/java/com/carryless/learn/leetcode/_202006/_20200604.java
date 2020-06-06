package com.carryless.learn.leetcode._202006;

/**
 * 238. 除自身以外数组的乘积
 */
public class _20200604 {
    public static void main(String[] args) {

    }


    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
     * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums){
        /**
         * 思路：原数组全部相乘，然后挨个相除
         * 结果：错误，未考虑到0的情况
         */
        /**
        int resultLength = nums.length;
        int product = 1;
        int[] results = new int[resultLength];
        for (int num : nums) {
            product *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            results[i] = product / nums[i];
        }
         **/

        /**
         * 等于该数，左右两侧的数字的乘积
         */
        int resultLength = nums.length;
        int[] resultArr = new int[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int product = 1;
            int j = i;
            for(int m = 0; m < j; m++ ){
                product *= nums[m];
            }
            for(int n = j+1; n < resultLength; n++){
                product *= nums[n];
            }
            resultArr[i] = product;
        }
        return resultArr;
    }

    /**
     * demo解题
     * @param nums
     * @return
     */
    public static int[] demoSolution(int[] nums){
        //定一个以前缀之积
        int nLength = nums.length;
        int[] L = new int[nLength];
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i-1] * L[i-1];
        }
        //定义一个后缀之积
        int R = 1;
        for (int j = nLength - 1; j >= 0; j--) {
            L[j] = L[j] * R;
            R *= nums[j];
        }
        return L;
    }
}
