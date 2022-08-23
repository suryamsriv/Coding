
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedList = new ListNode();
        var current = list1;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                mergedList = list2;
                break;
            }
            if (list2 == null) {
                mergedList = list1;
                break;
            }

            if (list1.val < list2.val) {
                mergedList = new ListNode(list1.val, list1.next);
                list1 = list1.next;
            } else {
                mergedList = new ListNode(list2.val, list2.next);
                list2 = list2.next;
            }
        }

        return mergedList;
    }
}
