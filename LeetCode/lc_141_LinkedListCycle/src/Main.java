import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        boolean result = hasCycle(l1);
        System.out.println(result);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ArrayList<ListNode> listNodes = new ArrayList<>();

        while (true) {
            listNodes.add(head);
            head = head.next;

            if (head.next == null) return false;

            for (int i = 0; i < listNodes.size(); i++) {
                 if (listNodes.get(i) == head) {
                     return true;
                 }
            }
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
