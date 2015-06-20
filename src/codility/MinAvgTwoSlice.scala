package codility

import scala.util.control.Breaks._

object MinAvgTwoSlice extends App {

  def solution(array: Array[Int]): Int = {
    val n = array.length
    val map = scala.collection.mutable.Map[Int, Boolean]()
    var steps = n
    var index = 0
    breakable {
      array.iterator.foreach { element =>
        if (element <= n && map.get(element).isEmpty) {
          map.put(element, true)
          steps -= 1
        } else {
          break
        }
        index += 1
      }
    }

    if (steps == 0 && index == n)
      1
    else
      0
  }

  println(solution(Array(4, 1, 3, 2)))
}
