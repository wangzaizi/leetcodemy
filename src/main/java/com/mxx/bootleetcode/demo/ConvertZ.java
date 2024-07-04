package com.mxx.bootleetcode.demo;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class ConvertZ {
    public String convert(String s, int numRows) {
        // 如果行数为1，Z字形排列没有意义，直接返回原字符串
        if (numRows == 1) {
            return s;
        }

        // 初始化一个StringBuilder数组，用于存储Z字形排列后的每行字符串
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            sb[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1){
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        // 将所有行的StringBuilder内容合并成一个结果
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            res.append(stringBuilder);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
        RunableOne runableOne = new RunableOne();
        Thread thread = new Thread(runableOne);
        thread.start();
        CallableOne callableOne = new CallableOne();
        FutureTask<Integer> futureTask = new FutureTask<>(callableOne);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, null, null);
        threadPoolExecutor.execute(new RunableOne());
        threadPoolExecutor.execute(new ThreadOne());
        threadPoolExecutor.shutdown();
    }
}
