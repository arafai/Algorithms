package binary_search

import scala.annotation.tailrec

object BinarySearchMin extends App {

  @tailrec
  def run(arr: Array[Int], start: Int, end: Int): Int = {
    if (start > end)
      return end + 1
    if (start != arr(start))
      return start
    val mid = (start + end) / 2
    if (arr(mid) > mid)
      run(arr, start, mid)
    else
      run(arr, mid + 1, end)

  }
}
