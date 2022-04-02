import com.example.BubbleSort;
import com.example.InsertionSort;
import com.example.SelectionSort;

public class Application {

    public static void  main(String[] args) {
        System.out.println("Entry point...");
        System.out.println("args > " + String.valueOf(args.length));

//        int[] bubbleSort = BubbleSort.sort(new int[]{12, 5, 8, 7, 2});
//        System.out.println("Bubble sort...");
//        for (int a:bubbleSort) {
//            System.out.println("sorted :" + String.valueOf(a));
//        }

//        int[] selectionSort = SelectionSort.sort(new int[]{12, 5, 8, 7, 2});
//        System.out.println("Selection sort...");
//        for (int a:selectionSort) {
//            System.out.println("sorted :" + String.valueOf(a));
//        }

        int[] insertionSort = com.example.InsertionSort.sort(new int[]{12, 5, 8, 7, 2});
        System.out.println("Insertion sort...");
        for (int a:insertionSort) {
            System.out.println("sorted :" + String.valueOf(a));
        }
    }
}
