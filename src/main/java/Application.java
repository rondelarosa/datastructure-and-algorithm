import com.example.BubbleSort;

public class Application {

    public static void  main(String[] args) {
        System.out.println("Entry point...");
        System.out.println("args > " + String.valueOf(args.length));

        int[] bubbleSort = BubbleSort.sort(new int[]{12, 5, 8, 7, 2});
        for (int a:bubbleSort) {
            System.out.println("sorted :" + String.valueOf(a));
        }
    }
}
