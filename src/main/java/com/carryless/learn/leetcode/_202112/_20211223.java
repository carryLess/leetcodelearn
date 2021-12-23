package com.carryless.learn.leetcode._202112;

import java.util.*;

/**
 * @Author carryless
 * @Date 2021/12/23
 * @Description 有效的括号
 * @url https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20211223 {

    public static void main(String[] args) {

    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     * Related Topics
     * 栈
     * 字符串
     */
    public static boolean isValid(String s){
        Stack<Character> chars = new Stack<Character>();
        int length = s.length();
        boolean result = true;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                chars.push(c);
            }else{
                if(!chars.empty()){
                    Character pop = chars.pop();
                    if(getOver(c) == pop){
                        continue;
                    }else{
                        result = false;
                    }
                }else{
                    result = false;
                }
            }
        }
        if(!chars.empty()){
            result = false;
        }
        return result;
    }

    public static char getOver(char c){
        char result = ' ';
        switch (c){
            case ')':
                result = '(';
                break;
            case ']':
                result = '[';
                break;
            case '}':
                result = '{';
                break;
        }
        return result;
    }

    public static boolean isValidOfficial(String s){
        int length = s.length();
        if(length % 2 != 0){
            return false;
        }
        Deque<Character> characters = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(characters.isEmpty() || characters.peek() != map.get(c)){
                    return false;
                }else{
                    characters.pop();
                }
            }else{
                characters.push(c);
            }
        }
        return characters.isEmpty();
    }

}
