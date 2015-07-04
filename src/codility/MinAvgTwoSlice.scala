package codility

//A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
// is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q)
// is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
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
