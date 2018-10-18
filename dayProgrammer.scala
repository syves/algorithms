import scala.io.StdIn

object Solution {
  /*
  //return the date of the 256 day of the year.
  In the Julian: leap years are divisible by 4;
   in the Gregorian calendar,
Divisible by 400.
Divisible by  4and not divisible by 100.*/
  def dayOfProgrammer(year: Int): String = {

    val commonDate = "13.09."
    val leapDate = "12.09."
    val yr = year.toString

    year match {
      case 1918 => "26.09.1918"
      case julian if (year <= 1917) =>
        if (year % 4 == 0)
          leapDate + yr
        else
          commonDate + yr
      case george if (year > 1918) =>
        if (year % 400 == 0 | ((year % 4 == 0) && (year % 100 != 0)))
          leapDate + yr
        else
          commonDate + yr
        }
   }

}
import Solution._
println(dayOfProgrammer(2018))
println(dayOfProgrammer(1800))
