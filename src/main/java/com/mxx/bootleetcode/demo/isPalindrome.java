package com.mxx.bootleetcode.demo;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        // 回文数
        if (x < 0){
            return false;
        }
        int temp = x;
        int res = 0;
        while (temp != 0){
            res = res * 10 + temp % 10;
            temp = temp / 10;
        }
        if (res == x){
            return true;
        }else {
            return false;
        }
    }
}
