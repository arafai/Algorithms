package codility

import scala.util.control.Breaks._

object FrogRiverOne extends App {

  val solution1 = solution(1, Array(1))

  def solution(x: Int, array: Array[Int]): Int = {
    val jumps = Array.fill[Boolean](x)(false)
    var steps = x
    var result = -1
    breakable {
      array.zipWithIndex.foreach { case (element, index) =>
        if (!jumps(element - 1)) {
          jumps(element - 1) = true
          steps -= 1
        }
        if (steps == 0) {
          result = index
          break
        }
      }
    }

    return result

  }

  println(solution1)

}
