package com.carryless.learn.leetcode._202112;

/**
 * @Author carryless
 * @Date 2021/12/29
 * @Description
 */
public class _20211229_extra {

    public static void main(String[] args) {
        System.out.println(mySolution("a", "a"));
    }

    /**
     * @url https://leetcode-cn.com/problems/implement-strstr/
     * @title 实现 strStr()
     * @param haystack
     * @param needle
     * @des
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
     * 如果不存在，则返回 -1 。
     * 说明：
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     *
     * 示例 1：
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     *
     * 示例 2：
     * 输入：haystack = "aaaaa", needle = "bba"
     * 输出：-1
     *
     * 示例 3：
     * 输入：haystack = "", needle = ""
     * 输出：0
     * 提示：
     *
     * 0 <= haystack.length, needle.length <= 5 * 104
     * haystack 和 needle 仅由小写英文字符组成
     * Related Topics
     * 双指针
     * 字符串
     * KMP算法
     * 字符串匹配
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        return 0;
    }

    /**
     * 暴力解法
     * 思路：双重便利
     * @param haystack
     * @param needle
     * @return
     */
    public static int mySolution(String haystack, String needle){
        if(needle == null || needle.length() == 0){
            return 0;
        }
        int oriLength = haystack.length();
        int needLength = needle.length();
        for(int i = 0; i + needLength <= oriLength; i++){
            boolean flag = true;
            for(int j = 0; j < needLength; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

}
