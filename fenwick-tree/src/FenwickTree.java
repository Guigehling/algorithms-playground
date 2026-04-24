public class FenwickTree {

    private int n;
    private int[] tree;

    public int[] getTree() {
        return tree;
    }

    public FenwickTree(final int n) {
        this.n = n;
        this.tree = new int[this.n + 1];
    }

    public FenwickTree(final int[] arr) {
        this.n = arr.length;
        this.tree = new int[arr.length + 1];

        for (int i = 0; i < n; i++) {
            update(i + 1, arr[i]);
        }
    }

    public void update(int i, int value) {
        while (i <= this.n) {
            tree[i] += value;
            System.out.println("Position on update:" + (i & -i));
            i += i & -i;
        }
    }

    // Not working
    public void create(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int y = i;
            while (y < n) {
                tree[y] += arr[i];
                i += i & -i;
            }
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            System.out.println("Position on query:" + (i & -i));
            i -= i & -i;
        }
        return sum;
    }

    public int queryRange(int p1, int p2) {
        return query(p2) - query(p1 - 1);
    }

}
