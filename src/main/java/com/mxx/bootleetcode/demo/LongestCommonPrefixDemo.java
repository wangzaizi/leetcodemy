package com.mxx.bootleetcode.demo;

public class LongestCommonPrefixDemo {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    //
    //示例 1：
    //
    //输入：strs = ["flower","flow","flight"]
    //输出："fl"
    //示例 2：
    //
    //输入：strs = ["dog","racecar","car"]
    //输出：""
    //解释：输入不存在公共前缀。
    //提示：
    //
    //1 <= strs.length <= 200
    //0 <= strs[i].length <= 200
    //strs[i] 仅由小写英文字母组成
    //Related Topics
    //字典树
    //字符串
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
