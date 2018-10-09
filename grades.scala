
import scala.io.StdIn

/*
Every student receives a grade in the inclusive range from 0 to 100.
Any grade less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's  according to these rules:

If the difference between the grade and the next multiple of 5 is less than 3, round garde up to the next multiple of 5.
If the value of garde is less than 38, no rounding occurs as the result will still be a failing grade.
For example,  grade = 84 will be rounded to 85 but garde 29  will not be rounded because the rounding would result in a number that is less than 40.
*/

object Solution {
    def gradingStudents(grades: Array[Int]): Array[Int] = {
      grades.map { g => val min = g/5; val rounded = 5 * (min + 1); val diff = rounded - g; if (diff < 3 && g >= 38) rounded else g}
      }

    def main(args: Array[String]) {
        val n = StdIn.readLine.trim.toInt
        val grades = Array.ofDim[Int](n)

        for (gradesItr <- 0 until n) {
            val gradesItem = StdIn.readLine.trim.toInt
            grades(gradesItr) = gradesItem}


    }
}
println(Solution.gradingStudents(Array(73, 67, 38, 33)).mkString("\n"))
