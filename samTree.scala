object Solution {

    // Complete the countApplesAndOranges function below.
    def countApplesAndOranges(startHouse: Int, endHouse: Int, appleTree: Int, orangeTree: Int, apples: Array[Int], oranges: Array[Int]) {

      val houseRange = (startHouse to endHouse +1).toSet
      val positionApples = apples.map( a => a + appleTree).toSet
      val positionOranges = oranges.map( o => o + orangeTree) .toSet
       val a = houseRange.intersect(positionApples).size
       val o = houseRange.intersect(positionOranges).size
      a +"\n" + o
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val distances = stdin.readLine.split(" ")
        val treeLocals = stdin.readLine.split(" ")
        val fruitCounts = stdin.readLine.split(" ")
        //distances at which each apple falls from the tree.
        val apples = stdin.readLine.split(" ").map(_.trim.toInt)

        //distances at which each orange falls from the tree.
        val oranges = stdin.readLine.split("").map(_.trim.toInt)

        val startHouse = distances(0).trim.toInt
        val endHouse = distances(1).trim.toInt

        val appleTree = treeLocals(0).trim.toInt
        val orangeTree = treeLocals(1).trim.toInt

        val numApples = fruitCounts(0).trim.toInt
        val numOranges = fruitCounts(1).trim.toInt

        countApplesAndOranges(startHouse, endHouse, appleTree, orangeTree, apples, oranges)
    }
}
