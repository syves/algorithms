//Evaluate the sum of all the amicable numbers under 10000.

//d(220) = 284, are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110
//d(284) = 220, are 1, 2, 4, 71, 142
//pair 220, 284

//finding amicable numbers.
object solution {

  def factorize(n: Int): List[Int] = {
    for (i <- List.range(1, n) if n % i == 0) yield i
  }


  def isAmicable(n: Int): Boolean = {
    val n2 = factorize(n).sum
    n2 != n && factorize(n2).sum == n
  }

  def main(args: Array[String]): Unit =
    {
      println((for (i <- List.range(1, 10000) if isAmicable(i)) yield i).sum)

      println(factorize(28).sum)

      println(factorize(220))
      println(factorize(284))
      assert(isAmicable(220) == true)
    }
}
