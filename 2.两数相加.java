/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (37.33%)
 * Likes:    4508
 * Dislikes: 0
 * Total Accepted:    457K
 * Total Submissions: 1.2M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tempRes = result;
        boolean flag = false;
        int temp = l1.val + l2.val;
        if (temp >= 10) {
            temp -= 10;
            flag = true;
        }
        result.val = temp;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            temp = l1.val + l2.val;
            if (flag == true) {
                temp++;
                flag = false;
            }
            if (temp >= 10) {
                temp -= 10;
                flag = true;
            }
            tempRes.next = new ListNode(temp);
            tempRes = tempRes.next;
        }
        while (l1.next != null) {
            l1 = l1.next;
            temp = l1.val;
            if (flag == true) {
                temp++;
                flag = false;
            }
            if (temp >= 10) {
                temp -= 10;
                flag = true;
            }
            tempRes.next = new ListNode(temp);
            tempRes = tempRes.next;
        }
        while (l2.next != null) {
            l2 = l2.next;
            temp = l2.val;
            if (flag == true) {
                temp++;
                flag = false;
            }
            if (temp >= 10) {
                temp -= 10;
                flag = true;
            }
            tempRes.next = new ListNode(temp);
            tempRes = tempRes.next;
        }
        if (flag) {
            tempRes.next = new ListNode(1);
        }
        return result;
    }
}
/* 简单易懂， 非递归版
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return root.next;
    }
}*/
// @lc code=end
