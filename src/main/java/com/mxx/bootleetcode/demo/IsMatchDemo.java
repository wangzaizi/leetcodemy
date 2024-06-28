package com.mxx.bootleetcode.demo;

public class IsMatchDemo {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // 初始化 并且 dp[0][0]= true 在此时为空字符串而所以为true
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //处理一种特殊情况 即p为*
        for (int j = 2; j <= n; j += 2) { // 步长为2，因为*总是与前面的字符成对出现
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // 前面的字符必须为空或者也是*
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符串为. 或者 当前字符相等 则看上一个是否匹配
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j) == '*'){
                    // 如果当前字符为* 则需要去判断处理
                    // 1. *表示前一个字符出现0次，则跳过这对字符，看s的前i个字符和p的前j-2个字符是否匹配
                    // 2. *表示前一个字符出现1次或多次，则看s的前i-1个字符和p的前j个字符是否匹配，并且当前字符s.charAt(i-1)必须匹配p.charAt(j-2)
                    dp[i][j] = dp[i][j - 2] || (dp[i-1][j]&& s.charAt(i-1) == p.charAt(j-2));
                }
            }
        }

        return dp[m][n];
    }
}
