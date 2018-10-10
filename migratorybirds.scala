import scala.io.StdIn

object Solution {
  // It should return the lowest type number of the most frequently sighted bird.
  def migratoryBirds(arr: Array[Int]): Int = {
    ar.toList.groupBy(x => x).toSeq.map(p => (- p._2.size, p._1) ).sorted.head._2
 }
 val ar = Array(1,2,3,4,5,4,3,2,1,3,4)
}
import Solution._
println(migratoryBirds(ar))

//11 birds
//1 2 3 4 5 4 3 2 1 3 4 ids
