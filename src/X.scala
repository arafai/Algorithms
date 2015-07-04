import scala.collection.mutable.ListBuffer


object X extends App {

  val test = new Test
  //  println(Test.intersectingDiscs( Array(1,5,2,1,4,0)))

  val x = ListBuffer(1, 2, 3, 4)

  x(2) = 4

  x.+=(3)
  x.+=:(1)

  println(x.mkString(" "))

}
