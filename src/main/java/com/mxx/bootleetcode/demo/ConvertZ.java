package com.mxx.bootleetcode.demo;

public class ConvertZ {
    public String convert(String s, int numRows)
    {
        // 如果行数为1，Z字形排列没有意义，直接返回原字符串
        if (numRows == 1){
            return s;
        }
        // 初始化一个StringBuilder数组，用于存储Z字形排列后的每行字符串
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0 ;i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        int j = 0;
        while (i < s.length()){
            // 填充每一行的字符
            while (j < numRows && j < s.length()){
                sb[j] = sb[j].append(s.charAt(i));
                i++;
                j++;
            }
            // 从右往左填充每一行，除了首行和末行
            j = j - 2;
            while (j > 0 && i < s.length()) {
                sb[j].append(s.charAt(i));
                i++;
                j--;
            }
            // 跳过首行，准备下一轮从左往右的填充
            j = j + 2;
        }
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < sb.length; k++){
            result.append(sb[k]);
        }
        return result.toString();
    }
}
