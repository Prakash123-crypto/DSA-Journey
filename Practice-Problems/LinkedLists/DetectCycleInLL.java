
import java.util.HashSet;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {

    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DetectCycleInLL {

    public static boolean hasCycle(Node head) {
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }

            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        //creating a cycle
        //50 -> 30
        Node temp = list.head;

        Node thirdNode = null;
        Node lastdNode = null;

        int cnt = 1;
        while (temp != null) {
            if (cnt == 3) {
                thirdNode = temp;
            }
            if (temp.next == null) {
                lastdNode = temp;
            }
            temp = temp.next;
            cnt++;
        }

        lastdNode.next = thirdNode;
        System.out.println(hasCycle(list.head));

    }

}
