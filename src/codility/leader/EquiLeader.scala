package codility.leader

//A non-empty zero-indexed array A consisting of N integers is given.
//
//The leader of this array is the value that occurs in more than half of the elements of A.
//
//An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S]
// and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
//
//For example, given array A such that:
//
//A[0] = 4
//A[1] = 3
//A[2] = 4
//A[3] = 4
//A[4] = 4
//A[5] = 2
//
//we can find two equi leaders:
//
//0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
//2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
//


object EquiLeader extends App {
  // runs in O(n*n)
  //  def solution(a: Array[Int]): Int = {
  //    // write your code in Scala 2.10
  //    val n = a.size
  //    (0 until n - 1).map { i =>
  //      for {
  //        left <- dominator(a, 0, i)
  //        right <- dominator(a, i + 1, n - 1)
  //        if (left == right)
  //      } yield 1
  //    }.flatten.size
  //  }

  def solution(a: Array[Int]): Int = {
    val n = a.size
    var countDomLeft = 0
    dominatorWithCount(a, 0, n - 1).map { case (dom, count) =>
      (0 until n - 1).foldLeft(0) { case (acc, i) =>
        var elem = a(i)
        if (dom == elem)
          countDomLeft += 1


        // no need for countNonDomLeft - use i
        //        if ((i + 1)/2 < countDomLeft && count - countDomLeft > 0)
        if (countDomLeft > (i+1)/2 && count - countDomLeft > n - (i + 1) - (count - countDomLeft))
          acc + 1
        else acc
      }
    }.getOrElse(0)

  }


  def dominatorWithCount(a: Array[Int], start: Int, end: Int): Option[(Int, Int)] = {
    var elem = -1
    var count = 0
    (start to end).foreach { i =>
      val el = a(i)
      if (count == 0) {
        elem = el
        count += 1
      }
      else if (el == elem)
        count += 1
      else
        count -= 1
    }
    if (count > 0)
      Some(elem, a.slice(start, end + 1).count(_ == elem))
    else
      None
  }


  //solution to dominator problem
  def dominator(a: Array[Int], start: Int, end: Int): Option[Int] = {
    var elem = a(start)
    var count = 1
    (start + 1 to end).foreach { i =>
      val el = a(i)
      if (count == 0) {
        elem = el
        count += 1
      }
      else if (el == elem)
        count += 1
      else
        count -= 1
    }
    if (count > 0)
      Some(elem)
    else
      None
  }

  println(solution(Array(4, 3, 4, 4, 4, 2)))
  println(solution(Array(4, 4)))
}
