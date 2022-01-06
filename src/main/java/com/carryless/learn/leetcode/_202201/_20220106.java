package com.carryless.learn.leetcode._202201;


/**
 * @Author carryless
 * @Date 2022/1/6
 * @Description 加一
 * @url https://leetcode-cn.com/problems/plus-one/
 */
public class _20220106 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1：
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     *
     * 示例 2：
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     *
     * 示例 3：
     * 输入：digits = [0]
     * 输出：[1]
     * 提示：
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * Related Topics
     * 数组
     * 数学
     * @return
     */
    public static int[] plusOne(int[] digits){
        int length = digits.length;
        boolean plusPre = true;
        boolean plusOne = false;
        for(int i = length - 1; i >= 0; i--){
            if(plusPre){
                int digit = digits[i];
                digit += 1;
                if(digit == 10){
                    digits[i] = 0;
                    if(i == 0){
                        plusOne = true;
                    }
                }else{
                    digits[i] = digit;
                    break;
                }
            }
        }
        if(plusOne){
            int[] ints = new int[length + 1];
            ints[0] = 1;
            System.arraycopy(digits, 0, ints, 1, length);
            return ints;
        }else{
            return digits;
        }
    }

    /**
     * 第一次错误解法
     * 执行出错信息：
     * java.lang.NumberFormatException: For input string: "728509129536673284379577474947011174006"
     *   at line 68, java.base/java.lang.NumberFormatException.forInputString
     *   at line 699, java.base/java.lang.Long.parseLong
     *   at line 824, java.base/java.lang.Long.parseLong
     *   at line 7, Solution.plusOne
     *   at line 54, __DriverSolution__.__helper__
     *   at line 84, __Driver__.main
     * 最后执行的输入：
     * [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
     * @param digits
     * @return
     */
    public static int[] plusOneError(int[] digits){
        String s = "";
        for (int digit : digits) {
            s += String.valueOf(digit);
        }
        long sLong = Long.parseLong(s);
        sLong ++;
        String sum = String.valueOf(sLong);
        int length = sum.length();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(sum.charAt(i)));
        }
        return ints;
    }

}
