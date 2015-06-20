package codility

object MinAvgTwoSlice extends App {

  def solution(array: Array[Int]): Int = {
    // a lot of objects are created - performance wise
    // looks concise
    array.sliding(2).zipWithIndex.++(array.sliding(3).zipWithIndex)
      .foldLeft((Double.MaxValue, 0)) { case ((minAvg, indexMin), (list, index)) =>
      val avg = list.sum.toDouble / list.size
      if (avg < minAvg)
        (avg, index)
      else
        (minAvg, indexMin)
    }._2
  }

  println(solution(Array(4, 2, 2, 5, 1, 5, 8)))
  println(solution(Array(1, 6, 3, 15, 11, 15, 18)))
}
