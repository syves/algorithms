//How many different ways can £2 be made using any number of coins?
object solution {
  var cache = Map[Int, BigInt]()
  val denoms = List(1, 2, 5, 10, 20, 50, 100, 200)
  cache = cache + (0 -> 1)

  def combinations(changeDue: Int): BigInt = {
    if (cache.contains(changeDue)) {
      cache(changeDue)
    } else {
      val filtered = denoms.filter(_ <= changeDue)
      //println(filtered.toString)
      val c: BigInt = filtered.map(denom =>
        combinations(changeDue - denom)
      ).sum
      cache = cache + (changeDue -> c)
      c
    }
  }
    def main(args: Array[String]): Unit = {
      println(combinations(5))
      println(combinations(6))
      println(combinations(7))
      println(combinations(8))

      ///println(combinations(20))
      //println(combinations(30))
      println(combinations(35))
      //println(combinations(200))
      //println(cache.toString)
    }
}
