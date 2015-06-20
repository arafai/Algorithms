package codility

import scala.util.control.Breaks._

object PassingCars extends App {

  def solution(array: Array[Int]): Int = {
    var zeros = 0
    var i = 0
    var result = 0
    val size = array.size
    breakable {
      array.iterator.foreach { element =>
        if (element == 0)
          zeros += 1
        else
          result += zeros

        if (result > 1000000000) {
          result = -1
          break()
        }
        i += 1
      }
    }
    result
  }
}
