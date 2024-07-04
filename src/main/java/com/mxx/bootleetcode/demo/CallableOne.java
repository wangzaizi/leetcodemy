package com.mxx.bootleetcode.demo;

import java.util.concurrent.Callable;

public class CallableOne implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(">>>>>>>>>>>>>callable");
        return 111111;
    }
}
