package com.mxx.bootleetcode.demo;

public class SolutionAddTwoNumbers {

    /**
     * 添加两个由链表表示的数字。
     *
     * @param l1 第一个链表的头节点，表示一个非负整数。
     * @param l2 第二个链表的头节点，表示一个非负整数。
     * @return 返回一个新的链表，表示两个输入链表相加的和。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化一个新的链表的头节点，用于存储结果。
        ListNode head = new ListNode();
        // 使用cur指针来遍历和构建新链表。
        ListNode cur = head;
        // 初始化进位变量。
        int carry = 0;

        // 遍历两个链表，直到它们都为null。
        while (l1 != null || l2 != null) {
            // 获取当前节点的值，如果节点为null，则值为0。
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 计算当前位的和，包括进位。
            int sum = x + y + carry;
            // 更新进位值。
            carry = sum / 10;
            // 创建新节点，并将和的个位数作为节点值。
            cur.next = new ListNode(sum % 10);
            // 移动cur指针到下一个节点。
            cur = cur.next;
            // 如果当前链表不为null，则移动到下一个节点。
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后还有进位，创建一个新节点来存储进位。
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // 返回新链表的头节点的下一个节点，即第一个有效节点。
        return head.next;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 初始化一个新的链表的头节点，用于存储结果。
        ListNode head = new ListNode();
        // 使用cur指针来遍历和构建新链表。
        ListNode cur = head;
        // 初始化进位变量。
        int carry = 0;

        // 遍历两个链表，直到它们都为null。
        while (l1 != null || l2 != null) {
            // 获取当前节点的值，如果节点为null，则值为0。
            int x = l1 ==null ? 0 : l1.val;
            int y = l2 ==null ? 0 : l2.val;
            // 计算当前位的和，包括进位。
            int sum = x + y + carry;
            // 更新进位值。
            carry = sum / 10;
            // 创建新节点，并将和的个位数作为节点值。
            cur.next = new ListNode(sum % 10);
            // 移动cur指针到下一个节点。
            cur = cur.next;
            // 如果当前链表不为null，则移动到下一个节点。
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        // 如果最后还有进位，创建一个新节点来存储进位。
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // 返回新链表的头节点的下一个节点，即第一个有效节点。
        return head.next;
    }
}
