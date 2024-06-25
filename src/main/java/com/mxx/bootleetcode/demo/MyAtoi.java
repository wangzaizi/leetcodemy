package com.mxx.bootleetcode.demo;

public class MyAtoi {
    public int myAtoi(String s) {
        int result = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            int sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int digit = s.charAt(index) - '0';
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
                index++;
            }
            return result * sign;
        }
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            int digit = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("     -042"));
    }
}
