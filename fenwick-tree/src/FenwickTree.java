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
        this.tree = new int[this.n + 1];
    }

    public void update(int i, int value) {
        while (i <= this.n) {
            tree[i] += value;
            i += i & -i;
        }
    }

    public void create(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int y = i;
            while (y < n) {
                this.tree[y] += arr[i];
                i += i & -i;
            }
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    public int queryRange(int p1, int p2) {
        return query(p2) - query(p1 - 1);
    }

}
