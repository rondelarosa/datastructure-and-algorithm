import com.example.Recursive;
import com.example.sort.BubbleSort;
import com.example.sort.InsertionSort;
import com.example.sort.SelectionSort;
import com.example.struct.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("Entry point...");
        System.out.println("args > " + String.valueOf(args.length));
//
//        bubbleSort();
//
//        selectionSort();
//
//        insertionSort();
//        linkedList();
//        doubleEndedList();
//        sortedlinkedList();
//        doubleLinkedList();
        recursion();
    }

    private static void recursion() {
        System.out.println("recursive > factorial of 3: " + Recursive.factorial(3));
    }

    private static void doubleLinkedList() {
        // Insert nodes
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtHead(5);
        list.insertAtHead(12);
        list.insertAtHead(2);
        list.insertAtHead(10);
        list.insertAtHead(19);
        list.insertAtHead(20);

        System.out.println("List : " + list);
        System.out.println("Length: " + list.length());
        DoubleLinkedNode node = list.getHead();
        while (node != null) {
            if (node.getPreviousNode() != null && node.getNextNode() != null)
                System.out.println("node : " + node.getData() + " previous:" + node.getPreviousNode().getData() + " next:" + node.getNextNode().getData());
            if (node.getPreviousNode() != null && node.getNextNode() == null)
                System.out.println("node : " + node.getData() + " previous:" + node.getPreviousNode().getData());
            else if (node.getPreviousNode() == null && node.getNextNode() != null)
                System.out.println("node : " + node.getData());
            node = node.getNextNode();
        }
    }

    private static void sortedlinkedList() {
        // Insert nodes
        SortedLinkedList list = new SortedLinkedList();
        list.insertAtHead(5);
        list.insertAtHead(12);
        list.insertAtHead(2);
        list.insertAtHead(10);
        list.insertAtHead(19);
        list.insertAtHead(20);

        System.out.println("List : " + list);
        System.out.println("Length: " + list.length());
    }

    private static void doubleEndedList() {
        // Insert nodes
        DoubleEndedList list = new DoubleEndedList();
        list.insertAtTail(5);
        list.insertAtTail(10);
        list.insertAtTail(2);
        list.insertAtTail(12);
        list.insertAtTail(19);
        list.insertAtTail(20);

        System.out.println("List : " + list);
        System.out.println("Length: " + list.length());
    }

    private static void linkedList() {
        // Insert nodes
        LinkedList list = new LinkedList();
        list.insertAtHead(5);
        list.insertAtHead(10);
        list.insertAtHead(2);
        list.insertAtHead(12);
        list.insertAtHead(19);
        list.insertAtHead(20);

        System.out.println("List : " + list);
        System.out.println("Length: " + list.length());

        // delete nodes
        System.out.println("deleting head");
        list.deleteFromHead();
        System.out.println("List : " + list);
        System.out.println("Length: " + list.length());

        // delete nodes
        System.out.println("finding node");
        System.out.println("search for 12: " + list.find(12));
        System.out.println("search for 15: " + list.find(15));
    }

    private static void insertionSort() {
        int[] insertionSort = InsertionSort.sort(new int[]{12, 5, 8, 7, 2});
        System.out.println("Insertion sort...");
        for (int a : insertionSort) {
            System.out.println("sorted :" + String.valueOf(a));
        }
    }

    private static void selectionSort() {
        int[] selectionSort = SelectionSort.sort(new int[]{12, 5, 8, 7, 2});
        System.out.println("Selection sort...");
        for (int a : selectionSort) {
            System.out.println("sorted :" + String.valueOf(a));
        }
    }

    private static void bubbleSort() {
        int[] bubbleSort = BubbleSort.sort(new int[]{12, 5, 8, 7, 2});
        System.out.println("Bubble sort...");
        for (int a : bubbleSort) {
            System.out.println("sorted :" + String.valueOf(a));
        }
    }


}
