package com.mxx.bootleetcode.demo;

import lombok.Data;

@Data
public class ListNode {

        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x) { val = x; }

}
