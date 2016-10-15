//to run: scala, just paste it, do not use :paste, import object, run fucntion

object funcs {
  def map_[A, B](f: (A) => B, l: List[A]): List[B] = {
    for (i <- l) yield f(i)
  }

  def fold_[A, B](l: List[A], acc: B)(f: (B, A) => B): B = {
    var res = acc
    for (elem <- l) res = f(res, elem)
    res
  }
}

//fold_(List("1", "3", "4"), 0) ((acc, a) => acc + a.toInt))

//map_[String, Int]((x: String)=> x.toInt + 2, List("1", "2", "3"))
//scala> val res2: List[Int] = for (i <- l) yield  i + 2
//res2: List[Int] = List(3, 4, 5)
