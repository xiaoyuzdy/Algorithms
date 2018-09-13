package linklist;

/**
 * 向有序链表中插入一个node
 * 时间复杂度O（n） ，空间复杂度O（n）(call back)
 *
 * @author Zcc
 * Create on  2018/9/13
 **/
public class Practice1 {

    private static Node insert(Node head, int value) {
        if (head == null || head.value >= value) {
            Node n = new Node();
            n.value = value;
            n.next = head;
            return n;
        }
        head.next = insert(head.next, value);
        return head;
    }

    private static void print(Node head) {
        for (Node x = head; x != null; x = x.next) {
            System.out.print(x.value + "--->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 1;
        Node second = new Node();
        second.value = 5;

        Node third = new Node();
        third.value = 9;

        head.next = second;
        head.next.next = third;

        System.out.println("before insert :");
        print(head);

        head = insert(head, 4);
        head = insert(head, 7);
        System.out.println(" after insert :");
        print(head);
    }

}
