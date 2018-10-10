
object choc {
def birthday(s: Array[Int], d: Int, m: Int): Int = {
    if( s.size > 1)
    s.sliding(m, 1).filter(chunk => chunk.sum == d).size
    else
    if (s(0)== d) 1 else 0
}

val nums = Array(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)
}

import choc._
println(birthday(nums,18,7))
