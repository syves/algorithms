//shakrahObjectsMethodsClasses.scala
//sand box for atomic Scala

def multiplyByTwo(x: Int): Int = {
  x * 2
}
val r = multiplyByTwo(5) //method call stored in val
println(r)
println(multiplyByTwo(2))

def addMultiply(x: Int, y: Double, s: String):Double = {
  println(s)
  (x + y) * 2.1
}

"""maybe we want to keep expression seperate from print because
 we want to keep it pure and reuse it later.."""

val r2: Double = addMultiply(7,9, "inside multiply")
println(r2)

//test has no return value, so we assign type Unit!
def test(x:Int, y:Int, s:String, expected:Double): Unit = {
  val result = addMultiply(x,y,s)
  assert(result == expected, "expected " + expected + " Got " + result)
  println("result: " + result) 
}

test(7, 9, "Inside addMultiply", 33.6)

//Execises chapter Methods------------------------------------------
//1.
def getSquare(num: Int): Int = {
  num * num
}
def test(x:Int,expected:Int, s:String): Unit = {
  val result = getSquare(x)
  assert(result == expected, "expected " + expected + " Got " + result)
  println("result: " + result)
}
val a = getSquare(3)
println(a)
assert(a == 9, "Expected 9, Got " + a)
test(3,9,"Inside getSquare")

val b = getSquare(6)
test(6,36,"Inside getSquare")
assert(b == 36, "expected " + 36 + " Got " + b)

val c = getSquare(5); 
test(5,25,"Inside getSquare")
assert(c == 25, "expected " + 25 + " Got " + c)

//shows threadtrace if assertion fails and nothing if it passes!
assert(1 < 2)

//2.
def getSquareDouble(num: Double): Double = {
  num * num
}
val sd1 = getSquareDouble(1.2)
println(sd1)
assert(1.44 == sd1, "Expected 1.44, Got " + sd1)

"""
def test(x:Double,expected:Double, s:String): Unit = {
  val result = getSquareDouble(x)
  assert(result == expected, "expected " + expected + " Got " + result)
  println("result: " + result)
}
"""

//test(1.2,1.44,"Inside getSquareDouble")

val sd2 = getSquareDouble(5.7) 
println(sd2)
assert(32.49 == sd2, "expected 32.49, Got " + sd2)

//3.
def isArgGreaterThanArg2(num1:Double, num2:Double) :Boolean = {
    if (num1 > num2) {
      return true
    } else {
      return false
    }
  }
val t1 = isArgGreaterThanArg2(4.1, 4.12)
println(t1)
assert(t1 == false, "Expected false, Got " + t1)
val t2 = isArgGreaterThanArg2(2.1, 1.2)
println(t2)
assert(t2 == true, "Expected true, Got " + t2)

//4.
def getMe(a:String): String = {
    a.toLowerCase
}

val g1 = getMe("abraCaDabra")
println(g1)
assert(g1 == "abracadabra", "Expected 'abracadabra', Got " + g1)
val g2 = getMe("zxyVUT")
println(g2)
assert( g2 == "zxyvut", "Expected 'zxyvut', Got " + g2)

//5.
def addStrings(arg1:String, arg2:String):String = {
    arg1 + arg2
}
val s1 = addStrings("abc", "def")
println(s1)
assert(s1 == "abcdef", "Expected 'abcdef', Got " + s1)
val s2 = addStrings("zyx", "abc")
println(s2)
assert(s2 == "zyxabc", "Epected 'zyxabc', Got " + s2)

//.6
def manyTimesString(a: String, b: Int):String = {
  a * b
}
val m1 = manyTimesString("abc", 3)
println(m1)
assert(m1 == "abcabcabc", "Expected 'abcabcabc', Got " + m1)

val m2 = manyTimesString("123", 2)
println(m2)
assert(m2 == "123123", "Expected '123123', Got " + m1)

//.7
def bmiStatus(weight:Double, height:Double):String = {
  val bmi = weight / (height*height) * 703.07
  if (bmi < 18.5){
    "Underweight"
  } else if (bmi < 25){
    "Normal weight"
    } else {
      "Overweight"
    }
  }

val normal = bmiStatus(160, 68)
println(normal)
assert("Normal weight" == normal,
  "Expected Normal weight, Got " + normal)

val overweight = bmiStatus(180, 60)
println(overweight)
assert("Overweight" == overweight, "Expected Overweight, Got " + overweight)

val underweight = bmiStatus(100, 68) 
println(underweight)
assert("Underweight" == underweight, "Expected Underweight, Got " + underweight)


