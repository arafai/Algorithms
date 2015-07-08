package sorting.quicksort

object Median extends App {

  def median(arr: Array[Int], ith: Int): Int = {
    def medianRec(start: Int, end: Int, i: Int): Int = {
      if (start == end)
        return arr(start)
      val pivotIndex = partition(arr, start, end)
      val k = pivotIndex - start + 1
      if (k == i)
        arr(pivotIndex)
      else if (i < k)
        medianRec(start, pivotIndex - 1, i)
      else
        medianRec(pivotIndex + 1, end, i - k)
    }
    medianRec(0, arr.size - 1, ith)
  }

  def partition(a: Array[Int], start: Int, end: Int): Int = {
    val pivot = a(end)
    var i = start-1
    a.slice(start, end).zipWithIndex.foreach { case (elem, j) =>
      if (elem <= pivot) {
        i += 1
        swap(a, i, j)
      }
    }
    swap(a, i + 1, end)
    i + 1
  }

  def swap(ints: Array[Int], i: Int, i1: Int) = {
    val temp = ints(i)
    ints(i) = ints(i1)
    ints(i1) = temp
  }

  println(median(Array(2, 8, 7, 1, 3, 5, 6, 4), 5))


}
