package com.eden.explore.interviewclassic.intermediate;

import java.util.*;

/**
 * @Description: 回溯算法
 * @Author gexx
 * @Date 2020/5/9
 * @Version V1.0
 **/
public class BacktrackingAlgorithm {
    /**
     * @Description: 电话号码的字母组合
     * @Author: gexx
     * @Date: 2020/5/9
     **/
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        Map<Character, String> dictionaries = new HashMap();
        dictionaries.put('2', "abc");
        dictionaries.put('3', "def");
        dictionaries.put('4', "ghi");
        dictionaries.put('5', "jkl");
        dictionaries.put('6', "mno");
        dictionaries.put('7', "pqrs");
        dictionaries.put('8', "tuv");
        dictionaries.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : chars) {
            List<String> tmpList = new ArrayList<>();
            String sufStr = dictionaries.get(c);
            for (String str : result) {
                for (Character tmpC : sufStr.toCharArray()) {
                    String tmpStr = str + tmpC;
                    tmpList.add(tmpStr);
                }
            }
            result = tmpList;
        }

        return result;

    }
}
