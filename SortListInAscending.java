/*
148. Sort List
Medium
9.5K
288
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105


Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */


import java.util.PriorityQueue;

/**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
public class SortListInAscending {
        public ListNode sortList(ListNode head) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            var current = head;
            while(current != null)
            {
                queue.add(current.val);
                current = current.next;
            }

            current = head;
            while(!queue.isEmpty()) {
                current.val = queue.remove();
                current = current.next;
            }
            return head;
        }
}
