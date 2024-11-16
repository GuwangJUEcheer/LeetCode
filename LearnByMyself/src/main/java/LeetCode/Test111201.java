package LeetCode;

import java.util.HashMap;

/*
---

**3. 无重复字符的最长子串**

给定一个字符串 `s`，请你找出其中不含有重复字符的 **最长子串** 的长度。

---

**示例 1：**

输入：s = "abcabcbb"
输出：3
解释：因为无重复字符的最长子串是 "abc"，所以其长度为 3。

---

**示例 2：**

输入：s = "bbbbb"
输出：1
解释：因为无重复字符的最长子串是 "b"，所以其长度为 1。

---

**示例 3：**

输入：s = "pwwkew"
输出：3
解释：因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 **子串** 的长度，"pwke" 是一个子序列，不是子串。

---
*/
public class Test111201 {

    public  int lengthNoRepeatSubString(String args){
        int s = args.length();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int maxLength = 0;
        int lastIndex = 0;
        for(int i = 0;i< s;i++){
            final char c = args.charAt(i);
            if(hashMap.containsKey(c)){
               lastIndex = Math.max(lastIndex,hashMap.get(c)+1);
            }
            hashMap.put(c,i);
            int currentIndex = i - lastIndex +1;
            if(maxLength < currentIndex){
                maxLength = currentIndex;
            }
        }
        return maxLength;
    }
}
