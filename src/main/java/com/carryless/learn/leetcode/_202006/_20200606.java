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
     * @param dividend
     * @param divisor
     * @return
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
