fun main() {
    val arr = intArrayOf(1, 2, 3)
    val fenwickTree = FenwickTree(arr)

    println("Sum: ${fenwickTree.sum(3)}")
}
