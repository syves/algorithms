object Solution {
  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
    var count = 0
    for (i <- ar) {
      for (j <- ar) {
        if (i < j && (i + j)% k == 0) count += 1
      }
    }
    count
 }
}
import Solution._

println(divisibleSumPairs(6,3, Array(1, 3, 2, 6, 1, 2)))

//6 3
//1 3 2 6 1 2
