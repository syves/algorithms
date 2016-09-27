//How many different ways can £2 be made using any number of coins?
object solution {
  var cache = Map[Int, Int]()
  val denoms = List(1, 2, 5, 10, 20, 50, 100, 200)
  cache = cache + (0 -> 1)

  def permutations(changeDue: Int): List[List[Int]] = {
    if (changeDue == 0) {
      List(List())
    } else {
    //if (cache.contains(changeDue) == false) {
      denoms.flatMap { denom =>
        //println(s"chagedue: ${changeDue}, denom: ${denom}")
        if (denom <= changeDue) {
          permutations(changeDue - denom).map(_ :+ denom)
        } else {
          List()
        }
      }
        //cache = cache + (changeDue -> p.sum))
    }
  }

  def combinations(change: Int): Set[List[Int]] = {
    permutations(change).map(list => list.sorted).toSet
  }

  //def sumCombos(change: Int): Int =
    //combinations(change).size

  def main(args: Array[String]): Unit = {
    println(combinations(5).size)
      //println(combinations(30))
      //println(combinations(35))
      //println(combinations(200))
      //println(cache.toString)
  }
}
