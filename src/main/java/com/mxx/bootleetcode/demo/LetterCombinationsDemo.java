package com.mxx.bootleetcode.demo;

import java.util.ArrayList;
import java.util.List;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例 1：
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//示例 2：
//
//输入：digits = ""
//输出：[]
//示例 3：
//
//输入：digits = "2"
//输出：["a","b","c"]
//提示：
//
//0 <= digits.length <= 4
//digits[i] 是范围 ['2', '9'] 的一个数字。
//Related Topics
//哈希表
//字符串
//回溯
public class LetterCombinationsDemo {
    public List<String> letterCombinations(String digits) {
        // 如果输入为空字符串，则直接返回空列表。
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        // 数字到字母的映射表，对应电话键盘上的数字。
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 结果列表，初始包含一个空字符串，作为生成组合的起点。
        List<String> res = new ArrayList<>();
        res.add("");

        // 遍历输入的数字字符串，逐个生成字母组合。
        for (int i = 0; i < digits.length(); i++) {
            // 将当前数字字符转换为数字。
            int x = digits.charAt(i) - '0';

            // 当结果列表中的第一个元素的长度等于当前数字的索引时，处理当前数字。
            while (res.get(0).length() == i) {
                // 从结果列表中移除并处理第一个元素。
                String t = res.remove(0);

                // 遍历当前数字对应的字母，与之前的结果拼接，添加到结果列表中。
                for (char s : numString[x].toCharArray()) {
                    res.add(t + s);
                }
            }
        }

        // 返回最终生成的所有字母组合列表。
        return res;
    }

    public List<String> letterCombinations1(String digits) {
        // 如果输入为空字符串，则直接返回空列表。
        if (digits.length() == 0){
            return new ArrayList<>();
        }

        // 数字到字母的映射表，对应电话键盘上的数字。
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 结果列表，初始包含一个空字符串，作为生成组合的起点。
        List<String> res = new ArrayList<>();
        res.add("");

        // 遍历当前输入字符串，逐个生成字母组合
        for (int i = 0;i < digits.length(); i++){
            // 将当前字符串换为数字
            int x = digits.charAt(i) - '0';
            // 当列表结果第一个元素长度等于当前数字长度的时候 进行处理
            while (res.get(0).length() == 1){
                //移除当前第一个元素
                String t = res.remove(0);
                for (char s:numString[x].toCharArray()){
                    res.add(t + s);
                }
            }
        }

        // 返回最终生成的所有字母组合列表。
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        // 如果输入为空字符串，则直接返回空列表。
        if (digits.length() == 0){
            return new ArrayList<>();
        }

        // 数字到字母的映射表，对应电话键盘上的数字。
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 结果列表，初始包含一个空字符串，作为生成组合的起点。
        List<String> res = new ArrayList<>();
        res.add("");

        // 遍历输入的数字字符串，逐个生成字母组合。
        for (int i = 0;i < digits.length(); i++){
            // 将当前数字字符转换为数字。
            int x = digits.charAt(i) - '0';

            // 当结果列表中的第一个元素的长度等于当前数字的索引时，处理当前数字。
            while (res.get(0).length() == i){
                // 从结果列表中移除并处理第一个元素。
                String t = res.remove(0);

                // 遍历当前数字对应的字母，与之前的结果拼接，添加到结果列表中。
                for (char s:numString[x].toCharArray()){
                    res.add(t + s);
                }
            }
        }
        // 返回最终生成的所有字母组合列表。
        return res;
    }
    public List<String> letterCombinations3(String digits) {
        // 如果直接输入空字符串则返回空
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 结果列表，初始包含一个空字符串，作为生成组合的起点。
        List<String> res = new ArrayList<>();
        res.add("");
        // 遍历当前输入字符串进行处理
        for (int i = 0 ;i< digits.length();i++){
            // 当前字符串变为数字
            int x = digits.charAt(i) - '0';
            // 如果当前字符串和当前i相等则进行处理
            while (res.get(0).length() == i){
                //从结果列表中移除并处理第一个元素。
                String t = res.remove(0);
                for (char s: numString[x].toCharArray()){
                    res.add(t + s);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String digits = "2323";
        List<String> res = new LetterCombinationsDemo().letterCombinations(digits);
        System.out.println(res);
    }
}
