import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 7, 8, 10 };

        FenwickTree fenwickTree = new FenwickTree(arr);

        for (int i = 0; i < arr.length; i++) {
            fenwickTree.update(i + 1, arr[i]);
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Fenwick Tree: " + Arrays.toString(fenwickTree.getTree()));
        System.out.println("Sum until position 3: " + fenwickTree.query(3));
        System.out.println("Sum between postions 2 and 4: " + fenwickTree.queryRange(2, 4));
    }

}
