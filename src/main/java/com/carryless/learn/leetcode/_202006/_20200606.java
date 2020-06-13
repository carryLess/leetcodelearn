package com.carryless.learn.leetcode._202006;

/**
 * 29. 两数相除
 */
public class _20200606 {

    public static void main(String[] args) {
        System.out.println(mySolution(-2147483648, -1));
        //System.out.println((-2147483648) * -1);
        //int a = -2147483648;
        //System.out.println(Math.abs(a));
        //System.out.println(mySolution(7, -3));
    }

    /**
     *
     *给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *
     *  
     *
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     *
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int mySolution(int dividend, int divisor) {
        long _result = 0;
        long _x = 1;
        long a = Long.valueOf(dividend);
        long b = Long.valueOf(divisor);

        if((a * b) < 0){
            _x = -1;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        if(b == 1){
            _result = a;
        }else{
            while (true){
                if(a >= b){
                    _result += 1;
                }else{
                    break;
                }
                a -= b;
            }

        }

        if(_result > Integer.MAX_VALUE && _x == 1){
            _result -= 1;
        }
        return Integer.parseInt(String.valueOf(_result * _x));
    }
}
