package codility

import scala.util.control.Breaks._

// al credit goes to http://www.lucainvernizzi.net/blog/2014/11/21/codility-beta-challenge-number-of-disc-intersections/
object NUmberOfDiscIntersections extends App {

  def solution(array: Array[Int]): Int = {
    val events = scala.collection.mutable.ArrayBuffer.empty[(Long, Int)]
    array.zipWithIndex.foreach { case (el, i) =>
      events.+=((i.toLong - el, 1))
      events += ((i.toLong + el, -1))
    }
    val sortedEvents = events.sortBy(_._1)
    var intersections, activeCircles = 0
    breakable {
      sortedEvents.foreach { case (_, circleCountDelta) =>
        if (circleCountDelta > 0)
          intersections += activeCircles
        activeCircles += circleCountDelta
        if (intersections > 10E6) {
          intersections = -1
          break
        }
      }
    }
    intersections
  }

  println(solution(Array(1, 5, 2, 1, 4, 0)))
}
