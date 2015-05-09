//My Classes and Objects with Atomic Scala

//1.
val r = Range(0, 5)
println(r)

val r2 = Range(0, 5, 2)
println(r2)

//2.
val s = "This is an experiment".split(" ")
println(s)

//3.
var s1 = "Sally"
var s2 = "Sally"
def areEqual(arg1:String, arg2:String):String = {
if (arg1.equals(arg2)){ 
    "arg1 and arg2 are equal"
  } else {
    "arg1 and arg2 are not equal" 
  }
}
println(areEqual(s1, s2))

//4.
var s3 = "Sam"
println(areEqual(s1, s3))

//Intro to classes Atomin Scala

// prints when method is called on object
class Zebra { def zebra():String="I have stripes"}
val z1 = new Zebra
println(z1.zebra)
assert(z1.zebra == "I have stripes", "Expected 'I have stripes', Got " + z1)

//prints on creation
class Donkey { println("heeHaaa")}
val d1 = new Donkey

//methods inside a class

//1. 
class Sailboat {
  def raise():String = {"Sails raised"}
  def lower():String = {"Sails lowered"}
}
class Motorboat {
  def motorOn():String = {"Motor on"}
  def motorOff():String = {"Motor off"}
}
val sailboat = new Sailboat
val r3 = sailboat.raise()
assert(r3 == "Sails raised", "Expected 'Sails raised', Got " + r3)
val r4 = sailboat.lower()
println(r4)
assert(r4 == "Sails lowered", "Expected 'Sails lowered', Got " + r4)

