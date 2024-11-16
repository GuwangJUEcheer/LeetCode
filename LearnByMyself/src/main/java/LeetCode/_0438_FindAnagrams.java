package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 438. 找到字符串中所有字母异位词

给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词指由相同字母重排列形成的字符串（包括相同的字符串）。

示例 1：

输入：s = "cbaebabacd", p = "abc"
输出：[0, 6]
解释：
起始索引等于 0 的子串是 "cba"，它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac"，它是 "abc" 的异位词。
*
* */
public class _0438_FindAnagrams {

    public List<Integer> findAngrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        final int[] target = count(p, o, p.length());
        final int[] source = count(s, 0, s.length() - 1);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            ++source[s.charAt(i + p.length() - 1) - 'a'];
            if (Arrays.equals(target, source)) {
                res.add(i);
            }
            --source[s.charAt(i) - 'a'];
        }
        return res;
    }


    private int[] count(String s, int start, int end) {
        int[] res = new int[26];
        for (int i = start; i < end; i++) {
            final int c = s.charAt(i) - 'a';
            res[c]++;
        }
        return res;
    }
}
