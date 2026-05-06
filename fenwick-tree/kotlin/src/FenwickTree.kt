class FenwickTree {

    private var n: Int
    private var tree: IntArray

    constructor(n: Int) {
        this.n = n
        this.tree = IntArray(n + 1)
    }

    constructor(arr: IntArray) {
        this.n = arr.size
        this.tree = IntArray(arr.size + 1)
        for (i in arr.indices) {
            update(i + 1, arr[i])
        }
    }

    fun getTree(): IntArray = tree

    fun update(index: Int, value: Int) {
        var i = index
        while (i <= n) {
            tree[i] += value
            i += i and -i
        }
    }

    fun sum(index: Int): Int {
        var i = index
        var sum = 0

        while (i > 0) {
            sum += tree[i]
            i -= i and -i
        }

        return sum
    }

    fun sumBetween(startIndex: Int, endIndex: Int): Int {
        return sum(endIndex) - sum(startIndex - 1)
    }
}
