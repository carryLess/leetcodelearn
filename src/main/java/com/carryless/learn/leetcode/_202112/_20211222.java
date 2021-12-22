package com.carryless.learn.leetcode._202112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author carryless
 * @Date 2021/12/22
 * @Description 罗马数字转整数
 * @url https://leetcode-cn.com/problems/roman-to-integer/
 */
public class _20211222 {
    public static void main(String[] args) {
        System.out.println(romanToInt("CM"));
    }

    /**
     * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     *
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    static int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> kvMap = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("IV", 4);
                put("IX", 9);
                put("XL", 40);
                put("XC", 90);
                put("CD", 400);
                put("CM", 900);
            }
        };

        /**
         * 特殊六种情况
         * IV   4
         * IX   9
         * XL   40
         * XC   90
         * CD   400
         * CM   900
         */
        List<Integer> specialIndexList = new ArrayList<>();
        int iv = s.indexOf("IV");
        insertSpecialIndex(iv, specialIndexList);
        int ix = s.indexOf("IX");
        insertSpecialIndex(ix, specialIndexList);
        int xl = s.indexOf("XL");
        insertSpecialIndex(xl, specialIndexList);
        int xc = s.indexOf("XC");
        insertSpecialIndex(xc, specialIndexList);
        int cd = s.indexOf("CD");
        insertSpecialIndex(cd, specialIndexList);
        int cm = s.indexOf("CM");
        insertSpecialIndex(cm, specialIndexList);
        for (int i = 0; i < s.length(); i++) {
            if(specialIndexList.contains(i)){
                result += kvMap.get(s.substring(i, i+2));
            }else if(specialIndexList.contains(i-1)){
                continue;
            }else{
                result += kvMap.get(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }

    public static void insertSpecialIndex(int index, List<Integer> special){
        if(index > -1){
            special.add(index);
        }
    }

    static int romanToIntOfficial(String s) {
        int ans = 0;
        HashMap<String, Integer> kvMap = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        int strLength = s.length();
        for (int i = 0; i < strLength; i++) {
            int value = kvMap.get(String.valueOf(s.charAt(i)));
            if(i < strLength - 1 && value < kvMap.get(String.valueOf(s.charAt(i + 1)))){
                ans -= value;
            }else{
                ans += value;
            }
        }
        return ans;
    }
}
