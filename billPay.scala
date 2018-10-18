import scala.io.StdIn

object Solution {

 def bonAppetit(bill: Array[Int], k: Int, b: Int) {
   //k: an integer representing the zero-based index of the item Anna doesn't eat
//b: the amount of money that Anna contributed to the bill
  val total = bill.sum
  val fair = (total- bill(k))/2
  if ( b == fair) println("Bon Appetit") else println( b - fair )
 }

}
import Solution._
bonAppetit(Array(3, 10, 2, 9), 1, 12)
