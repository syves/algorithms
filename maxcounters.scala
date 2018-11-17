import scala.io.StdIn

object Solution {
  ("""You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.

A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X)""")


  def solution(n: Int, ops: Array[Int]): Array[Int] = {
    var counters = new Array[Int](n)
    var max = 0
    ops.foreach { op =>
      if (1 <= op && op <= n) {
        val idx = op - 1
        if (counters(idx) == max) max += 1
        counters(idx) += 1
      }
      else {
        for (idx <- 0 until counters.length) counters(idx) = max
      }
    }
    counters
  }

  def solution2(n: Int, ops: Array[Int]): Array[Int] = {
    (ops.foldLeft((0, new Array[Int](n)))((acc: (Int, Array[Int]), op: Int) =>
      if (1 <= op && op <= n) {
        val idx = op - 1
        (if (acc._2(idx) == acc._1) acc._1 + 1 else acc._1,
         acc._2.updated(idx, acc._2(idx) + 1))
      }
      else
        (acc._1, acc._2.map (x => acc._1))
   ))._2
  }

}

import Solution._
solution(5, Array(3,4,4,6,1,4,4))
solution2(5, Array(3,4,4,6,1,4,4))
