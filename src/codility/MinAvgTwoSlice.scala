package codility

object MinAvgTwoSlice extends App {

  def solution(array: Array[Int]): Int = {
    array.sliding(2).zipWithIndex
      .foldLeft((Integer.MAX_VALUE, 0)) { case ((minAvg, indexMin), (Array(start, end), index)) =>
      val avg = (start + end) / 2
      if (avg < minAvg)
        (avg, index)
      else
        (minAvg, indexMin)
    }._2
  }

  println(solution(Array(4, 2, 2, 5, 1, 5, 8)))
}
