package com.carryless.learn.leetcode._202201;

import java.rmi.server.RMIClassLoader;

/**
 * @Author carryless
 * @Date 2022/1/7
 * @Description Sqrt(x)
 * @url https://leetcode-cn.com/problems/sqrtx/
 */
public class _20220107 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     *
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *
     * 提示：
     * 0 <= x <= 2的31次方 - 1
     * Related Topics
     * 数学
     * 二分查找
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        return cal(8);
    }
    public static int cal(int x){
        int start = 0, end = x, ans = -1;
        while (start <= end){
            int middle = (start + end) / 2;
            long l = (long) middle * middle;
            if(l <= x){
                ans = middle;
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return ans;
    }

    public static int calError1(int start, int end, int x){
        int middle = (start + end) / 2;
        if(middle == x){
            return middle;
        }else if(middle > x){
            int middlePre = middle - 1;
            if((middlePre * middlePre) <= x){
                return middlePre;
            }else{
                return calError1(start, middlePre, x);
            }
        }else{
            int middlePlus = middle + 1;
            int middlePlusX = middlePlus * middlePlus;
            if((middlePlusX) > x){
                return middle;
            }else if(middlePlusX == x){
                return middlePlus;
            }else{
                return calError1(middlePlus, end, x);
            }
        }
    }

}
