package quicksort

object Main extends App {

  val arr = Array(2, 8, 7, 1, 3, 5, 6, 4)
  quickSort(arr)
  println(arr.mkString(" "))

  def partition(arr: Array[Int], p: Int, r: Int): Int = {
    val x = arr(r)
    var i = p - 1
    (p until r).foreach { j =>
      if (arr(j) <= x) {
        i += 1
        swap(arr, i, j)
      }
    }
    swap(arr, i + 1, r)
    i + 1
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val int = arr(i)
    arr(i) = arr(j)
    arr(j) = int
  }

  def quickSort(arr: Array[Int], p: Int = 0, r: Int = arr.length - 1) {
    if (p < r) {
      val q: Int = partition(arr, p, r)
      quickSort(arr, p, q - 1)
      quickSort(arr, q + 1, r)
    }

  }
}
