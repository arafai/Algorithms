package codility

object TapeEquilibrium extends App {

  def solution(array: Array[Int]): Int = {
    var sumHead = array.head
    var sumTail = array.tail.sum
    var diff = Math.abs(sumHead - sumTail)
    val it = array.tail.init.iterator
    while (it.hasNext && diff > 0) {
      val next = it.next()
      sumHead += next
      sumTail -= next
      val newDiff = Math.abs(sumHead - sumTail)
      if (newDiff < diff)
        diff = newDiff
    }
    diff
  }

  println(solution(Array(5)))
}
