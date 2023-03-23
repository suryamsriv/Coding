/*
23. Merge k Sorted Lists
Hard
16.6K
607
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */


public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            int k = 0;
            // if(lists.length >= 0)
            var mergedList = new ListNode();

            ListNode head = list[0];
            ListNode tail = null;

            for(int index=0; index < lists.length; index++) {
                // var current = mergedList;
                var second = lists[index];
                while(second != null)
                {
                    var node = new ListNode(second.val);;
                    if(head == null) {
                        head = node;
                        tail = node;
                    }
                    else {
                        tail.next = node;
                        tail = node;
                    }
                    second = second.next;
                }
            }
            var curr = head;
            while(curr!=null) {
                System.out.println("Values: " + curr.val);
                curr = curr.next;
            }



            //         // System.out.println(" Second: " + second.val);
            //         if(current != null) {
            //                 if(current.val < second.val) {
            //                     current = current.next;
            //             }
            //             else {
            //                 var node = new ListNode(second.val);
            //                 var temp = current;
            //                 current = node;
            //                 current.next = temp;
            //                 second = second.next;
            //             }
            //         }
            //         else {
            //             var node = new ListNode(second.val);
            //             current = node;
            //             current.next = node;
            //             System.out.println("current:" + current.val + " next: " + current.next);
            //             // current = current.next;
            //             second = second.next;
            //             // System.out.println("here : " + mergedList.val);
            //         }
            //         mergedList = current;
            //         var curr = mergedList;
            //         int i=0;
            //         while(curr!=null)
            //         { System.out.println(i++ + "merged List: " + curr.val);
            //                 curr = curr.next;
            //             }
            //     }
            //     var test = mergedList;
            //     while(test != null) {
            //         System.out.println(test.val);
            //         test = test.next;
            //     }
            // }
            return new ListNode(2);
        }

}
