package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给你一个字符串数组，请将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//示例 1：
//输入：strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出：[["bat"],["nat","tan"],["ate","eat","tea"]]
//
//示例 2：
//输入：strs = [""]
//输出：[[""]]
//
//示例 3：
//输入：strs = ["a"]
//输出：[["a"]]
public class Test110502 {

    //利用Arrays.sort这个方法
    public List<List<String>> groupAnagrams(String[] strs){
//
//        Map<String,List<String>> map = new HashMap<String, List<String>>();
//
//        for(String key : strs){
//
//            char[] charArray = key.toCharArray();
//            Arrays.sort(charArray);
//            String sortKey = new String(charArray);
//            if(map.contains(sortKey)){
//                map.put(sortKey,map.get(sortKey).add(key));
//            }else{
//                List<String> valueList = new ArrayList<>();
//                valueList.add(key);
//                map.put(sortKey,valueList);
//            }
//            return new ArrayList<>(map.values());
//        }
        Map<String,List<String>> map = new HashMap<String, List<String>>();

        for(String key : strs){

            Word w = new Word(key);
            if(map.containsKey(w)){
               map.get(w).add(key);
            }else{
                List<String> valueList = new ArrayList<>();
                valueList.add(key);
                map.put(sortKey,valueList);
            }
            return new ArrayList<>(map.values());
        }
        class Word{
            int[] counts;
            Word(String s){
                final char[] chars = s.toCharArray();
                counts = new int[26];
                for(char c : chars){
                    int index = c-'a';
                    counts[index]++;
                }
            }

            @Override
            public boolean equals(Object obj) {
                return Arrays.equals(counts,(Word)obj.counts);
            }

            public int hashCode(){
                return  Arrays.hashCode(counts);
            }
        }
    }
}
