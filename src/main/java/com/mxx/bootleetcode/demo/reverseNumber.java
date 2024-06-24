package com.mxx.bootleetcode.demo;

public class reverseNumber {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MAX_VALUE){
            return 0;
        }
        int result = 0;
        int pop = 0;
        while (x != 0){
            pop  = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
