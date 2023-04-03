public class Solution {

    public static void main(String [] args) {
        int array[] = {1};
        int i = 0;
        ListNode first = null;
        ListNode last = null;

        while(i<array.length) {
            var node = new ListNode(array[i]);

            if (first == null)
                first = last = node;
            else {
                last.next = node;
                last = node;
            }
            i++;
        }

        LinkedListNthNode obj = new LinkedListNthNode();
        obj.removeNthFromEnd(first, 1);

        var pointer = first;
        while(pointer != null) {
            System.out.print(pointer.val + ", ");
            pointer = pointer.next;
        }
    }
}
